# Complete examples

For the Excel-to-datastore and Oracle cleansing use case, start with
[workflow.md](workflow.md) and its complete public-API driver. The append example
below teaches mapping generation; a mapping is unnecessary for datastore-only
generation. Use a runtime containing the CHECK metadata fix described in
[evidence.md](evidence.md) when following the Oracle example.

## Standalone annotation-driven append package

The accompanying [training-project](training-project/) is complete: two definitions,
one mapping, a package descriptor, two entry templates, one preparation helper, and
expected artifacts. No implementation source or other repository examples are
needed. It is intentionally a narrow strategy: a single-target INSERT with a
simple outer SELECT and one root `LOAD(MODE="APPEND")` annotation. It uses
definition-declared physical names, retaining the source alias.

This small teaching package consumes only the root `LOAD` annotation. Other AST
annotations remain renderer output. It does not enforce a production write policy
for every omitted/defaulted column or every possible expression; extend validation
before broadening the sample's input scope or deploying it.

The mapping is:

```sql
@LOAD(MODE="APPEND")
INSERT INTO prep.employees (EMPLOYEE_ID, SALARY)
SELECT e.EMPLOYEE_ID AS EMPLOYEE_ID, e.SALARY AS SALARY
FROM source.employees e
```

`datastores/source/employees.sql` declares `HR.EMPLOYEES`;
`datastores/prep/employees.sql` declares `REPORTING.EMPLOYEES` and its primary key.
The SQL entry consumes `LOAD`, removes it from that render's AST, and calls the
bundled renderer. The contract entry uses the same validation helper, then reads
target column datatype, mandatory flags, and primary-key constraint metadata.
Neither annotation naming nor metadata automatically selects APPEND: the helper
explicitly enforces that policy. No technical columns or runtime inputs are needed.

From this repository with JDK 21 and Maven:

```powershell
mvn compile exec:java "-Dexec.args=docs/agents/training-project"
```

At `sqlm>`:

```text
apply append to mapping copy_employees
exit
```

Outputs appear under `docs/agents/training-project/generated/append/copy_employees/`:
`sql/copy_employees.sql` and `copy_employees.txt`. Compare with the distributed
`expected/` files (SQL comparison may normalize whitespace).
Use `apply append to mapping copy_employees into <directory>` to choose a different
project-relative directory or an absolute output directory.

For an installed distribution, launch its REPL with the training-project path;
the exact launcher is distribution-specific. The Java API alternative is in
[api.md](api.md). Its `renderPackage` method previews all files without writing.

Try these changes, one at a time:

- Change `MODE="APPEND"` to `MODE="MERGE"`: generation must fail, with no outputs
  from that failed rendering operation.
- Change a declared physical table name: both SQL and the contract should change.
- Change target SALARY's declared type: the contract should change, while SQL still
  projects the same expression. Metadata injection is not automatic type conversion.
- Remove the target SALARY definition: strict metadata resolution should fail.

## Verify the training example automatically

`VerifyTraining.java` is a standalone application check, outside SQLMorph's
implementation. In a repository checkout, run from the root (PowerShell):

```powershell
mvn compile dependency:build-classpath "-Dmdep.outputFile=target/agent-training-classpath.txt"
$trainingClasspath = 'target/classes;' + (Get-Content -Raw target/agent-training-classpath.txt)
java --class-path $trainingClasspath docs/agents/VerifyTraining.java
```

With a distribution, use its SQLMorph/dependency classpath instead and optionally
pass the training-project directory as the last argument. The checker compares
both expected artifacts, verifies repeated rendering, rejects wrong mode/extra
attributes/missing metadata, verifies file writes, and checks that a batch render
failure writes nothing. It prints the temporary directory containing its output.
It does not execute destination SQL.

## Existing Airflow/BigQuery strategy

In a full repository checkout, `examples/airflow-bigquery-draft` is a larger working
generation example, with complete inputs, Velocity package helpers, and SQL/Python
expected fixtures. Distribute that entire folder if teaching from it without source.

```powershell
mvn compile exec:java "-Dexec.args=examples/airflow-bigquery-draft"
```

```text
apply airflow_bigquery to mapping employees_to_prep
exit
```

It produces `sql/employees_to_prep.sql` and `employees_to_prep.py` inside the project's
`generated/airflow_bigquery/employees_to_prep/` directory. Root `BIGQUERY.WRITE_MODE`
must be `MERGE`; `AIRFLOW` supplies `DAG_ID`, `TASK_ID`, `CONNECTION_ID`, `LOCATION`.
These are this package's vocabulary, not framework-reserved annotations.

The preparation helper requires a single-target insert with simple outer SELECT,
rejects outer DISTINCT/grouping/HAVING and dedicated integration settings, validates
annotation attributes, and requires exactly one nonempty target primary key.
The key columns must be assigned and mandatory; a unique key is not a fallback.
Projections must alias target column names. Non-key business columns drive updates.

`prep_policy.vtl` defines LOAD_ID, UPDATE_ID, LOAD_DATE, EFFECTIVE_DATE, their
expressions, insert/update participation and typed runtime parameters. Definitions
must declare compatible technical columns; they do not supply parameter values.
`naming.vtl` owns physical naming. Both SQL and DAG consume the same preparation
policy; the original business AST is preserved.

Regression tests cover complete expected artifacts, annotation changes, composite
primary keys, missing/ambiguous primary keys, policy changes, compatible technical
columns, and rendering failures before writes. These tests establish generated text
behavior, not a successful Airflow run or BigQuery execution. Duplicate source keys,
target uniqueness, runtime bindings, scheduling and retries need platform validation.

The AST-rendering and ODI examples in the full repository provide further scope-specific
patterns; do not generalize their naming, technical columns or integration behavior
into framework defaults.
