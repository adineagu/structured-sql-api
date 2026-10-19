# Structured SQL API

**Your SQL logic. Your platform rules. Generated together.**

Structured SQL API is a Java framework for turning SQL specifications and datastore
metadata into text artifacts through reusable templates. Describe a transformation
in SQL, work with its structured semantic model, and keep naming conventions,
technical fields, and integration rules in templates you control.

For data engineers and developers building repeatable generation workflows, this
separates business assignments from the code needed to implement them on a target
platform.

## One mapping, two artifacts

The [Airflow/BigQuery showcase](docs/showcase.md) follows an employee mapping from
logical SQL to a BigQuery MERGE script and an Airflow DAG:

```sql
INSERT INTO prep.employees (EMPLOYEE_ID, DEPARTMENT_ID, SALARY)
SELECT
    e.EMPLOYEE_ID AS EMPLOYEE_ID,
    e.DEPARTMENT_ID AS DEPARTMENT_ID,
    e.SALARY AS SALARY
FROM stage.employees e
```

This excerpt contains the business assignments. The complete example also declares
mapping annotations for MERGE mode and Airflow settings. Target metadata supplies
the primary key; templates supply physical naming, technical-field behavior, and
typed runtime parameters.

```text
SQL specification + datastore metadata
                  |
          Structured semantic model
                  |
          Reusable template package
                  |
     +------------+-------------------+
     |                                |
sql/employees_to_prep.sql     employees_to_prep.py
BigQuery MERGE               Airflow DAG
```

Change the business mapping to change the assignments. Change the shared template
policy to change the generation convention across mappings using that package.

## Try the example

Prerequisites: JDK 21 and Maven, with dependency access on the first build.
From the repository root:

```powershell
mvn compile exec:java "-Dexec.args=examples/airflow-bigquery-draft"
```

At the `sqlm>` prompt:

```text
apply airflow_bigquery to mapping employees_to_prep
exit
```

The package writes these files relative to the repository root:

```text
examples/airflow-bigquery-draft/generated/airflow_bigquery/employees_to_prep/
  employees_to_prep.py
  sql/employees_to_prep.sql
```

See the [complete example](examples/airflow-bigquery-draft/README.md) for inputs,
template responsibilities, generation options, and runtime requirements.

## Use the Java API

```java
var project = new Project(Path.of("examples/airflow-bigquery-draft"));
var metadata = new MetadataManager(project);
var codegen = new CodeGeneratorService(project, metadata);

codegen.generatePackage(
    "employees_to_prep",
    "airflow_bigquery",
    Path.of("target/airflow-bigquery")
);
```

Imports: `java.nio.file.Path`, `org.pecheasoft.odigen.project.Project`,
`org.pecheasoft.odigen.metadata.MetadataManager`, and
`org.pecheasoft.odigen.render.CodeGeneratorService`.

## Explore

- [Showcase: one mapping to SQL and an Airflow DAG](docs/showcase.md)
- [Template engines, metadata resolution, and generation API](TEMPLATE_ENGINES.md)
- [Structured SQL rendering and naming](examples/ast-rendering/README.md)
- [ODI mapping generation strategy](examples/odi-mapping-draft/README.md)

Template packages support Velocity, Pebble, FreeMarker, and Jinjava. Packages can
generate multiple files and declare their own engine.

## Current scope and validation

The framework generates text artifacts. Execution, deployment, credentials, and
orchestration belong to the target systems. The Airflow/BigQuery example implements
a scoped single-target upsert strategy; it is not a general SQL dialect translator.
Its generated SQL and Python are checked against regression fixtures, but have not
been runtime-tested in Airflow or BigQuery.

Run the regression suite with:

```powershell
mvn test
```
