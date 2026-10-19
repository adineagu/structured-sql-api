# Structured SQL API

**Your SQL logic. Your platform rules. Generated together.**

Turn SQL specifications and datastore metadata into implementation artifacts with
reusable templates. Keep transformation logic readable, centralize naming and
integration conventions, and generate SQL and supporting files from the same
specification.

[Explore on GitHub](https://github.com/adineagu/structured-sql-api)
 · [See the complete example](https://github.com/adineagu/structured-sql-api/blob/HEAD/docs/showcase.md)

## Write the transformation. Reuse the implementation rules.

Data pipelines often repeat the same work: physical table names, technical fields,
upsert conventions, and orchestration setup. When those rules are copied into
every pipeline, a convention change becomes a maintenance task across many files.

Structured SQL API gives those rules a reusable home. SQL describes the business
assignments, datastore definitions provide metadata, and templates turn the
structured model into artifacts for a particular platform.

## One employee mapping. A MERGE script and a DAG.

Start with a readable mapping between logical tables:

```sql
INSERT INTO prep.employees (EMPLOYEE_ID, DEPARTMENT_ID, SALARY)
SELECT
    e.EMPLOYEE_ID AS EMPLOYEE_ID,
    e.DEPARTMENT_ID AS DEPARTMENT_ID,
    e.SALARY AS SALARY
FROM stage.employees e
```

This is the business portion of the example; the complete specification also
includes generation settings as annotations.

Apply the Airflow/BigQuery template package and generate two files:

- **BigQuery MERGE SQL**, with matching driven by the target primary key and
  technical-field behavior defined in a shared template policy.
- **An Airflow DAG**, which submits the SQL with typed runtime parameters.

The mapping supplies the business assignments. Metadata supplies the key.
Templates supply naming, write rules, and orchestration code.

## Make conventions reusable

Keep physical naming rules and technical-field expressions in shared templates.
Reuse them across mappings, inspect the structured model through the Java API,
and package related outputs together. Template packages can use Velocity, Pebble,
FreeMarker, or Jinjava.

The repository also includes structured SQL rendering and an ODI mapping strategy.

## Developing SQL Morph with AI coding agents

I develop SQL Morph with AI coding agents, using application feedback to improve
both the framework and the guidance that agents need to use it.

In a practical experiment, a separate Codex agent worked in an application project
**without access to SQL Morph's implementation source code**. It turned Excel
datastore descriptions into SQL specifications, added annotations, developed Oracle
cleansing and constraint-validation templates, and generated code. The experiment
succeeded with interactive guidance, revealing gaps in the documentation.

That feedback led to a clearer public-API workflow, executable training examples,
and a stronger SQL-first modelling rule: declare structure and constraints in SQL,
then use annotations for additional template policy. It also exposed a runtime
bug in CHECK-constraint metadata construction. We fixed the bug and added
regression tests for CHECKs with and without annotations.

The aim is to make each application experiment improve the next agent's starting
point. The Oracle training example is checked against expected generated artifacts;
execution in an Oracle database remains a separate validation step.

[Read the coding-agent guide](https://github.com/adineagu/structured-sql-api/blob/HEAD/AGENTS.md)
 · [Explore the Oracle training workflow](https://github.com/adineagu/structured-sql-api/blob/HEAD/docs/agents/workflow.md)

## Try it from the repository

With JDK 21 and Maven, run this from a local checkout:

```powershell
mvn compile exec:java "-Dexec.args=examples/airflow-bigquery-draft"
```

Then enter:

```text
apply airflow_bigquery to mapping employees_to_prep
```

The example generates files locally. It does not deploy or execute them. Generated
SQL and Python are covered by regression fixtures; Airflow and BigQuery runtime
validation has not been performed. The example is a scoped upsert strategy rather
than a general dialect translator.

[Read the walkthrough](https://github.com/adineagu/structured-sql-api/blob/HEAD/docs/showcase.md)
 · [Explore the source](https://github.com/adineagu/structured-sql-api)
