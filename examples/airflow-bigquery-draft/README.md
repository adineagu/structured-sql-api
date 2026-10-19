# Airflow and BigQuery generation example

This example generates a BigQuery MERGE script and an Airflow 3 DAG that submits
it. Business assignments come from `mappings/employees_to_prep.sql`; resolved
source/target definitions supply columns and the primary key. A shared prep-layer
template supplies technical-field values and write behavior.

## Generate the two files

From the repository root:

```powershell
mvn compile exec:java "-Dexec.args=examples/airflow-bigquery-draft"
```

At the `sqlm>` prompt:

```text
list templates
show template airflow_bigquery
apply airflow_bigquery to mapping employees_to_prep
```

The tool lists `airflow_bigquery` as one logical template. Its helpers are private
files inside `templates/airflow_bigquery/`, not individual template choices.
The package descriptor `template.yml` declares its engine and two artifacts:

```yaml
engine: velocity
artifacts:
  - template: merge.vtl
    output: "sql/{name}.sql"
  - template: dag.vtl
    output: "{name}.py"
```

No `config.yml` is needed for this example. The tool initializes Velocity for this
package when it is used. Other packages in the same project can declare a different
engine. Project-level engine configuration remains available for legacy single-file
templates only.

`{name}` is the mapping's project basename (`employees_to_prep` here). This same
name is supplied to the DAG template for its SQL include, independently of DAG_ID.
The command writes both artifacts under
`generated/airflow_bigquery/employees_to_prep/` within the application project.
To select another directory relative to that project:

```text
apply airflow_bigquery to mapping employees_to_prep into generated/my_example
```

For programmatic preview or generation, enter `java` and execute:

```java
var artifacts = codegen.renderPackage("employees_to_prep", "airflow_bigquery");
System.out.println(artifacts.get("sql/employees_to_prep.sql"));
codegen.generatePackage("employees_to_prep", "airflow_bigquery", java.nio.file.Path.of("target/airflow-bigquery"));
```

Use `/exit` to leave Java mode. Java API paths are relative to the process working
directory; REPL `into` paths are relative to the application project. Both artifacts
are rendered before files are written. Existing files are overwritten; filesystem
write failures can still leave a partial set. Generation does not deploy or execute.
`expected/` contains the accepted hand-authored fixtures. Tests compare generated
SQL and Python with these fixtures, ignoring SQL layout and Python blank lines.
The Python task variable is `task`; its Airflow task ID comes from the annotation.
No Airflow/BigQuery runtime validation has been performed.

## Package files and responsibilities

| Template | Responsibility |
| --- | --- |
| `naming.vtl` | Project, namespace map, lowercase table names and BigQuery quoting |
| `prep_policy.vtl` | Prep-layer technical-field expressions, runtime inputs and insert/update rules |
| `prepare.vtl` | Validate the supported mapping and derive keys, assignments and parameters |
| `merge.vtl` | Render the business SELECT through `library.Query` and compose the MERGE |
| `dag.vtl` | Emit Airflow submission code and typed query parameter bindings |
| `render_business.vtl` | Render just the business SELECT for inspection |

Naming policy stays in the technical template; no table definition declares an
individual physical name. Logical `stage.employees` becomes
`example-project.stage.employees`. Change `bigqueryProject` and the namespace map
in `naming.vtl` for your environment. The same project is used for job submission.
Unknown qualifiers fail rather than falling back to an inferred name.

Definitions are framework metadata, not BigQuery provisioning DDL. Tables must
already exist. This strategy checks VARCHAR metadata for string load IDs, DATE
for effective dates and TIMESTAMP for insert timestamps. It does not translate
arbitrary Oracle expressions or create tables. Source technical values are not copied.

## Annotation contract

- Mapping `@BIGQUERY`: `WRITE_MODE="MERGE"`. The match columns come from the
  target datastore's built-in `CONSTRAINT ... PRIMARY KEY (...)` declaration,
  not an annotation. Exactly one non-empty primary key is required; unique keys
  are not used as a fallback. Key columns must be assigned and non-null.
- Mapping `@AIRFLOW`: `DAG_ID`, `TASK_ID`, `CONNECTION_ID`, and `LOCATION`.

Datastore definitions carry no runtime bindings or technical write annotations.
`prep_policy.vtl` applies when the INSERT target's logical qualifier is `prep`.
It requires the four technical columns to be declared with compatible types;
missing columns are not silently added. The policy is shared across prep targets:

| Target column | Value | Insert | Update |
| --- | --- | --- | --- |
| LOAD_ID | @load_id (STRING) | Yes | No |
| UPDATE_ID | @load_id (STRING) | Yes | Yes |
| LOAD_DATE | CURRENT_TIMESTAMP() | Yes | No |
| EFFECTIVE_DATE | @effective_date (DATE) | Yes | Yes |

Both SQL and DAG parameter declarations derive from this template policy. No
source datastore annotation controls target-write behavior. Technical columns must
not also be assigned in business SQL; mapping-specific overrides are not implemented.
Unknown mapping properties and conflicting parameter types fail explicitly.

This strategy supports a single target and a simple, non-distinct, ungrouped outer
SELECT with projections explicitly aliased to target column names. Non-key business
columns update on matches; every business assignment inserts. There must be at
least one updated column. Unsupported query structures and dedicated integration
fields are rejected. This is a deliberately scoped strategy, not a general SQL
function or dialect translator.

## Resulting behavior

EMPLOYEE_ID is the match key. New rows receive the business values and four
technical values. Matching rows update DEPARTMENT_ID, SALARY, UPDATE_ID and
EFFECTIVE_DATE; LOAD_ID and LOAD_DATE are preserved. Matching rows update even if
business values have not changed. Missing source rows do not delete targets.
This is an upsert, not SCD2 or source-delta extraction.

Both source and target must contain at most one row per EMPLOYEE_ID. The metadata
key describes this contract but the generator does not enforce it at runtime or
choose a duplicate winner. See [BigQuery MERGE semantics](https://docs.cloud.google.com/bigquery/docs/reference/standard-sql/dml-syntax#merge_statement).

## Runtime inputs

The DAG requires Airflow 3 and its Google provider. It has one synchronous
BigQueryInsertJobOperator, no schedule, no catchup and one active run at a time.
Supply parameters when triggering it:

```json
{"load_id": "employees-2026-10-19-001", "effective_date": "2026-10-19"}
```

Load IDs are caller-supplied strings. Airflow must allow trigger configuration to
override Params (`core.dag_run_conf_overrides_params`). SQL values are passed as
typed BigQuery parameters, not interpolated SQL. Keep the generated SQL beside the
DAG in `sql/`. Credentials, permissions, dataset locations and deployment are external.

See [Airflow BigQuery operators](https://airflow.apache.org/docs/apache-airflow-providers-google/stable/operators/cloud/bigquery.html),
[Airflow Params](https://airflow.apache.org/docs/apache-airflow/stable/core-concepts/params.html)
and [BigQuery parameters](https://docs.cloud.google.com/bigquery/docs/parameterized-queries).

Run `mvn test` for regression checks, including artifact output, layer-policy changes,
repeat rendering, annotation changes and batch-generation error handling.

