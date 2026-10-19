# First ODI mapping strategy (milestone 3)

This working example implements the accepted stage-to-prep Incremental Update
case. The folder retains its original review-draft name. The strategy lives in
`templates/CreateComplexMapping.vtl`; `library.Query` renders the prepared AST.

From the repository root:

```powershell
mvn compile exec:java "-Dexec.args=examples/odi-mapping-draft"
```

At the `sqlm>` prompt:

```text
apply CreateComplexMapping to mapping employees_to_prep
apply CreateComplexMapping to mapping employees_to_prep > PR_EMPLOYEES_TI_MAP.sql
```

## Inputs and conventions

| File | Purpose |
| --- | --- |
| `mappings/employees_to_prep.sql` | Three business assignments and mapping annotations |
| `datastores/stage/employees.sql` | Source definition, project ID `stage.employees` |
| `datastores/prep/employees.sql` | Target definition, project ID `prep.employees` |
| `expected/PR_EMPLOYEES_TI_MAP.sql` | Accepted expected output used by regression tests |

The application template:

1. Requires explicit `MAPPING_PATH`, `MAPPING_NAME`, `INTEGRATION_TYPE`, and
   `UPDATE_KEY` properties. It accepts Incremental Update and checks that the
   named target key is primary or unique and its columns are assigned.
2. Prepends `LOAD_ID = GET_LOAD_ID()`, `UPDATE_ID = GET_LOAD_ID()`,
   `LOAD_DATE = SYSDATE`, and `EFFECTIVE_DATE = GET_EFFECTIVE_DATE()`.
   Those target columns must exist and must not already be assigned.
3. Renders the declared physical names `DWH_STAGE.ST_EMPLOYEES` and
   `DWH_PREP.PR_EMPLOYEES`, preserving source aliases.
4. Emits the accepted OTP wrapper: `TRUNCATE MAPPING IF EXISTS`, physical design
   `Physical`, context `GLOBAL`, and the Extract/Merge/CKM module names.

These are application-template conventions, not Java defaults. `PROPERTIES` is
consumed by the strategy; unrelated annotations are retained. `TRUNCATE MAPPING`
manages the mapping definition, not the target data table.

## Scope and validation

This first case supports one target and a simple outer SELECT. DISTINCT, grouping,
set-operation outer queries, multi-target mappings, unsupported properties, and
dedicated INSERT integration settings are rejected. There are no begin/end hooks,
table-truncation commands, or SCD behavior in this example.

The generic `ctx.prependAssignments()` helper creates new assignments and
projections with consistent positions and links. It leaves the input AST unchanged
while sharing metadata, expressions, and other query children; it is not a deep
copy. The template owns the choice of columns and expressions.

`OdiMappingStrategyTest` checks the accepted output through fluent Java and REPL
paths, repeat rendering, metadata/link preservation, and rejection cases. Output
comparison ignores comments and whitespace while retaining SQL tokens and literals.
Run the suite with `mvn test`.

The artifact is an integration-platform mapping specification. It has not been
submitted to ODI; target syntax and installed module availability still require
platform validation. Generation does not execute or deploy it.
