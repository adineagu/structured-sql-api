# Architecture and design boundaries

**Documented and implementation-confirmed behavior:** SQLMorph turns one SQL
specification plus datastore definition files into text through templates. It does
not run the generated transformation or provision its destination.

```text
Excel descriptions -> reviewed SQL definitions + additional policy annotations
                                        |
             Project + MetadataManager + CodeGeneratorService
                                        |
                parse / transform / renderPackage / generatePackage
                                        |
                  template + resolved AST + ctx -> artifacts
```

There are two representations. The parser algebra represents parsed syntax; the
semantic AST exposes datastores, assignments, query blocks, relations, and expression
text for generation. Semantic expressions are not a complete expression rewrite API.
These are conceptual layers; applications use `CodeGeneratorService`, which handles
parsing and project metadata. Do not build the parser-to-model pipeline yourself.

An application has `datastores/`, `mappings/`, and `templates/`. All three folders
must exist, even when empty. A file
`datastores/source/employees.sql` has project ID `source.employees`. Discovery is a
snapshot: recreate `Project` after adding files. Discovered contents are loaded
from disk; keep only specification files in datastore and mapping folders because
their discovery is not filtered by SQL extension.

Each specification is one complete statement. Project generation rejects extra
statements and trailing tokens. A folder with `template.yml` is a template package;
its dotted folder path is its public ID. Its helper files are private resources.

| Framework responsibility | Application strategy responsibility |
| --- | --- |
| Parse supported input syntax | Select supported business and target-platform scope |
| Build an AST and inject definition metadata | Interpret annotation values and reject invalid combinations |
| Provide naming callbacks and rendering helpers | Define schemas, case, quoting, and physical naming |
| Render supported SQL structure | Select MERGE, append, history, or other write behavior |
| Render and write text artifacts | Add technical columns and runtime parameter bindings |
| Validate renderer-supported shapes | Validate target syntax, data behavior, execution and deployment |

The bundled Velocity `library.Query` renderer preserves business structure using
explicit context rules. It is not an integration strategy or universal SQL dialect
translator. Functions and most expression syntax pass through.

**Inferred design intention:** the separation above makes transformation business
logic reusable while platform conventions change in templates. This follows the
README and implemented strategy examples; it does not imply an enforced plugin
interface, optimizer, universal lineage model, or support for arbitrary SQL.

Prefer a shared preparation/policy helper consumed by all artifacts. In the existing
Airflow/BigQuery strategy, the same technical-field and parameter policy drives SQL
and the DAG. A datastore definition describes structure; it does not automatically
supply orchestration settings or runtime values.
