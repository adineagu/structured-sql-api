# Validation workflow and common mistakes

For workbook-derived definitions, first compare column counts/order, datatypes,
nullability and named constraints with the workbook. Use SQL facts directly, then
inspect `codegen.parse(...)` metadata. Do not add annotations until their consumer
and extra meaning are defined. See [datastores.md](datastores.md) and the executable
[workflow](workflow.md); they cover datastore-only generation through the public API.

1. Write a strategy contract: accepted SQL shapes, exact annotation vocabulary,
   metadata requirements, naming rules, target dialect, runtime inputs and outputs.
2. Create complete datastore/mapping fixtures. Parse through project generation
   with strict resolution; check target assignment/projection order and metadata.
3. Render in memory with `renderPackage` or `.render()`. Treat unresolved template
   expressions, Java object strings, missing clauses and unexpected annotations as
   failures. The template engine completing successfully is insufficient.
4. Compare all outputs with reviewed expected files. Normalize whitespace only
   when it is insignificant; do not normalize away literals, aliases, ordering,
   operators or Python indentation. Re-render the same prepared model to detect
   accidental mutation and non-determinism.
5. Exercise meaningful failures: missing definition/column, wrong annotation value,
   unknown attribute, unsupported query shape, missing key, nullable key, naming
   rule gaps, incompatible technical fields and unsafe output paths. Fresh output
   directories distinguish old artifacts from writes made by the current run.
6. Validate with destination tools: parse/lint SQL for its dialect, compile Python,
   load a DAG in the intended Airflow/provider version, check deployment parameters,
   and dry-run/execute against isolated representative data where supported.
7. Check semantics: duplicates and nulls in match keys, insert/update column policy,
   mandatory/default columns, retries/idempotency, parameter types, time zones and
   permissions. Record which checks actually ran and which require a target runtime.

`ctx.validate` only checks the bundled renderer's supported AST forms; it is not
database type checking or SQL execution. Successful source parsing does not prove
target SQL validity. SQLMorph annotations/integration extensions may need translation
before any destination tool can parse the artifact.

| Mistake or anti-pattern | Better approach |
| --- | --- |
| Encode mandatory flags, positions, primary/unique/check definitions in annotations | Use column declarations, NOT NULL and named SQL constraints; put only extra consumed policy on their annotations |
| Copy every spreadsheet property into a field annotation | Keep only additional consumed policy; retain provenance in an extraction manifest |
| Start with parser/algebra/engine internals because they are public Java classes | Use CodeGeneratorService's parse/render/generate path |
| Create a dummy mapping for source-datastore validation | Apply a datastore template directly to its project ID |
| Call ctx.validate on a datastore | Parse with codegen, then perform datastore strategy checks in its template |
| Assume primary keys imply mandatory column metadata or populate the column PK flag | Declare NOT NULL explicitly and inspect datastore.keys for membership |
| Treat grammar acceptance or a getter's existence as proof of end-to-end support | Run the exact public API path; reproduce failures separately |
| Assume `@MERGE` or `getScdBehavior()` implements a strategy | Explicitly implement and validate the target behavior in templates |
| Add platform prefixes, DAG settings or business policy to framework code | Keep the application convention in shared template policy |
| Infer annotation precedence across mapping and metadata | Read both scopes and define conflict handling explicitly |
| Use `getAttributes("condition")` as a filter | It is unimplemented; iterate and filter with null guards |
| Blindly use `annotatedWith` on nullable annotation sets | Guard `annotations()` before querying |
| Guess template APIs from a similarly named framework | Use the exact methods and imports in this reference |
| Assume every mapping root/query/FROM child is simple | Dispatch by supported node kind or reject unsupported forms |
| String-replace every table name in SQL | Use context names and naming-aware expressions; preserve aliases |
| Treat target metadata as source lineage or implicit type conversion | Resolve target structure and implement conversions explicitly |
| Rename unaliased sources or rewrite qualifiers incidentally | Supply explicit source aliases |
| Emit `SelectItem.render(...)` and append another alias | Render its underlying expression or use the bundled renderer |
| Mutate a shallow copy expecting isolation | Fresh parse or copy the mutable portions deliberately |
| Change getter-returned collection membership expecting persistence | Use setters; verify links after assignment rewrites |
| Modify business AST while rendering the first of several outputs | Prepare independently or return a new model; test repeatability |
| Repeat technical-field policy independently in SQL and orchestration | Share expressions, insert/update flags and parameter types |
| Use unique-key names as implicit MERGE keys | Select actual key metadata according to an explicit strategy |
| Leave old generated files after a failed render and call it success | Validate in a fresh output directory; report failure distinctly |
| Assume a successful regression fixture proves deployment | Validate in the target runtime and document the remaining gap |

For framework maintainers, run `mvn test` (or `mvn -o test` when dependencies are
cached). External agents do not need implementation tests: use application fixtures,
the installed runtime, expected artifacts, and target-platform validators. Do not
introduce framework changes simply to make an unsupported strategy appear to pass.
