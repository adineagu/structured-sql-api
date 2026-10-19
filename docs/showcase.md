# One mapping to BigQuery SQL and an Airflow DAG

This walkthrough uses the repository's fictional employee example. It generates
two related artifacts from one mapping, with reusable templates owning platform
conventions. All paths below are relative to the repository root unless noted.

## 1. Describe the business assignments

The complete input is
[`employees_to_prep.sql`](../examples/airflow-bigquery-draft/mappings/employees_to_prep.sql):

```sql
@BIGQUERY(
    WRITE_MODE="MERGE"
)
@AIRFLOW(
    DAG_ID="employees_to_prep",
    TASK_ID="merge_employees",
    CONNECTION_ID="google_cloud_default",
    LOCATION="EU"
)
INSERT INTO prep.employees (
    EMPLOYEE_ID,
    DEPARTMENT_ID,
    SALARY
)
SELECT
    e.EMPLOYEE_ID AS EMPLOYEE_ID,
    e.DEPARTMENT_ID AS DEPARTMENT_ID,
    e.SALARY AS SALARY
FROM stage.employees e
```

The logical table names identify datastore definitions in the example project.
The assignments describe which business values move to the target. Annotations
provide the generation settings this particular strategy expects.

## 2. Supply metadata and reusable policy

The [source definition](../examples/airflow-bigquery-draft/datastores/stage/employees.sql)
and [target definition](../examples/airflow-bigquery-draft/datastores/prep/employees.sql)
provide columns and types. The target declares `EMPLOYEE_ID` as its primary key
and includes `LOAD_ID`, `UPDATE_ID`, `LOAD_DATE`, and `EFFECTIVE_DATE`.

The template package separates responsibilities:

| Input | What it controls |
| --- | --- |
| Mapping SQL | Business assignments and mapping-level settings |
| Target datastore metadata | Match key and available target columns |
| `naming.vtl` | Physical project/dataset names and quoting |
| `prep_policy.vtl` | Technical values, typed runtime inputs, and insert/update rules |
| `merge.vtl` and `dag.vtl` | SQL and Python artifact structure |

These are explicit template rules. The framework does not infer an upsert strategy
from an ordinary INSERT. The package interprets the settings and composes the output.

Its [descriptor](../examples/airflow-bigquery-draft/templates/airflow_bigquery/template.yml)
declares both artifacts:

```yaml
engine: velocity
artifacts:
  - template: merge.vtl
    output: "sql/{name}.sql"
  - template: dag.vtl
    output: "{name}.py"
```

## 3. Generate both files

With JDK 21 and Maven, launch the example from the repository root:

```powershell
mvn compile exec:java "-Dexec.args=examples/airflow-bigquery-draft"
```

At the `sqlm>` prompt:

```text
show template airflow_bigquery
apply airflow_bigquery to mapping employees_to_prep
exit
```

Look under:

```text
examples/airflow-bigquery-draft/generated/airflow_bigquery/employees_to_prep/
  employees_to_prep.py
  sql/employees_to_prep.sql
```

Both artifacts are rendered before writing begins. Repeating the command overwrites
the destination files.

## 4. Inspect the result

The SQL uses the target key to match rows. This excerpt shows the generated MERGE
through its update branch; the full file also includes the insert branch:

```sql
MERGE `example-project.prep.employees` AS T
USING (
    SELECT
        e.EMPLOYEE_ID AS EMPLOYEE_ID,
        e.DEPARTMENT_ID AS DEPARTMENT_ID,
        e.SALARY AS SALARY
    FROM `example-project.stage.employees` e
) AS S
ON T.EMPLOYEE_ID = S.EMPLOYEE_ID
WHEN MATCHED THEN
    UPDATE SET
        DEPARTMENT_ID = S.DEPARTMENT_ID,
        SALARY = S.SALARY,
        UPDATE_ID = @load_id,
        EFFECTIVE_DATE = @effective_date
```

New rows receive business values and all four technical values. Matches update
business non-key values, `UPDATE_ID`, and `EFFECTIVE_DATE`, preserving the original
`LOAD_ID` and `LOAD_DATE`. Missing source rows do not delete targets.

The generated DAG submits the corresponding SQL file and binds `load_id` as STRING
and `effective_date` as DATE. The policy supplies both the SQL parameter expressions
and the DAG parameter declarations. SQL values are passed as typed parameters.

For full reference outputs, see the hand-authored acceptance fixtures for
[MERGE SQL](../examples/airflow-bigquery-draft/expected/sql/employees_to_prep.sql)
and the [Airflow DAG](../examples/airflow-bigquery-draft/expected/employees_to_prep.py).
Regression tests compare generated output to those fixtures, allowing layout
differences and the documented Python task-variable normalization.

## 5. See where reuse pays off

Change `bigqueryProject` and the namespace map in `naming.vtl`, then regenerate to
change physical naming. Change a technical-field expression in `prep_policy.vtl`
to change the shared write policy. Business assignments remain in the mapping.

To verify the example and package behavior locally:

```powershell
mvn "-Dtest=BigQueryGenerationTest,TemplatePackageTest" test
```

This validates generated artifacts, not execution on target platforms. The example
requires existing BigQuery tables and unique employee IDs in source and target;
generation does not enforce runtime uniqueness. Airflow/BigQuery deployment and
runtime validation have not been performed.

See the [example README](../examples/airflow-bigquery-draft/README.md) for supported
query shapes, runtime configuration, and deployment requirements, or the
[generation API documentation](../TEMPLATE_ENGINES.md) to build another strategy.
