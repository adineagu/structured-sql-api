# Generation and template APIs

These are inspected public methods, not a claim that all public Java classes are
a stable supported SDK. Most application templates need only the injected AST and
`ctx`. Extra helpers must be supplied explicitly.

## Application entry points

Use `Project`, `MetadataManager`, and `CodeGeneratorService` for application work.
The executable [Oracle workflow](workflow.md) uses these APIs for datastore input,
without a mapping file or custom parser. `transform("source.employees")` accepts a
datastore ID and injects `datastore`; it is not limited to INSERT mappings.
Preview with `renderPackage`, review the text, then write with `generatePackage`.
Keep strict metadata resolution unless the strategy explicitly accepts missing data.

Parser/algebra builders, engine factories/adapters, manual template loading and
direct Velocity/Freemarker calls are lower-level mechanisms, not the recommended
application workflow. They bypass some project loading, metadata resolution or
parameter injection. Do not start there or reconstruct the generation pipeline.

## Java host

```java
import java.nio.file.Path;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.render.CodeGeneratorService;
import org.pecheasoft.odigen.render.TransformationContext;

var project = new Project(Path.of("docs/agents/training-project"));
var metadata = new MetadataManager(project);
var codegen = new CodeGeneratorService(project, metadata);
var artifacts = codegen.renderPackage("copy_employees", "append"); // no writes
codegen.generatePackage("copy_employees", "append", Path.of("target/training"));
```

Place the snippet inside a Java method or JShell session with SQLMorph and its
dependencies on the classpath. The example path is repository-relative; use your
distributed training project's location in an external application.

| API | Contract |
| --- | --- |
| `codegen.parse(String)` / `parse(ProjectObject)` | Parse a complete statement and resolve project metadata |
| `codegen.transform(sourceId).using(templateId).render()` | Return one rendered string |
| `.using(...).withModel(model)` | Use a prepared semantic model, resolving references before rendering |
| `.using(...).withParameter(name, object)` | Pass an explicit helper/strategy dependency |
| `codegen.withContext(ctx)` | Set context configuration for subsequent rendering |
| `codegen.withMetadataResolution(MetadataResolver.Mode.ALLOW_UNRESOLVED)` | Explicitly accept incomplete metadata |
| `codegen.renderPackage(sourceId, packageId)` | Return immutable ordered relative-path-to-content map |
| `codegen.generatePackage(sourceId, packageId, directory)` | Render package then write all outputs |
| `codegen.generate(sourceId, Map<String,String>, directory)` | Map relative output paths to single-template IDs, render then write |

`mapping`/`datastore` and `ctx` are reserved injected parameters. `artifactName` is
also supplied for package artifacts: the source project's basename, independent
of the SQL-declared name. MetadataManager is not implicitly injected as `metadata`.
The package API does not expose `withModel` or arbitrary parameter overloads; use
single-resource builders if those are needed. Each package artifact is rendered
independently. Do not communicate between artifacts through AST mutation.

`MetadataManager` offers `findDatastore`, `findMapping`, `findTemplate` (returning
`Optional<ProjectObject>`), corresponding `findAllDatastores/findAllMappings/
findAllTemplates(prefix)`, and `findTemplateResource("package/file.vtl")` for
explicit private-resource access. These load file objects, not semantic models.

For validation use `codegen.parse(metadata.findDatastore(id).orElseThrow())` or
`codegen.parse(sqlText)`. Do not replace this with the lower-level parser's `parse()`:
that method can accept a prefix. If a requirement cannot be met through the
generation API, report the gap; do not silently switch to an internal path.

## Context inside templates

| `TransformationContext` methods | Purpose |
| --- | --- |
| `require(boolean, message)` | Return empty string or throw `IllegalArgumentException` |
| `kind(model)` | `insert`, `simple`, `nested`, `set`, `join`, `table`; unsupported kinds throw |
| `has(list)` | Null-safe nonempty-list check |
| `validate(model)` | Validate supported bundled-renderer structure; returns empty string |
| `withSourceNames(function)`, `withTargetNames(function)` | Configure naming callbacks |
| `useDeclaredDatastoreNames()` | Use injected datastore definition names for both roles |
| `tableNames(pattern, namespaceMap, lowercaseBasename)` | Create a naming function from template-owned rules |
| `sourceName(ref)`, `targetName(ref)`, `expression(expr)` | Render names/expressions under current policy |
| `withLimitStyle(style)`, `limitClause(query)` | `UNSUPPORTED` default, `LIMIT`, or `FETCH_FIRST` |
| `hasIntegrationSettings(node)` | Check dedicated insert integration fields |
| `withIntegrationRenderer(function)`, `integration(node)` | Explicit serialization callback for those fields |
| `annotations(node)` | Serialize that node's annotations, without merging definition annotations |
| `quotedIdentifier(name)` | Double-quote identifier and escape embedded double quotes |
| `removeAnnotation(node, name)` | Mutate the node's annotation set; exact name match |
| `prependAssignments(insert, additions)` | Return prepared insert with new assignments/projections |
| `left(join)`, `right(join)`, `setParentheses(query)` | Structural helpers used by the bundled renderer |
| `copy()` | Copy context configuration; callbacks remain shared |

Configuration methods return the context. Capture their results with `#set` in
Velocity to avoid printing a Java object into generated output. Each fluent render
receives a context copy. Naming callbacks should be side-effect free.

`ctx.validate(datastore)` is **not** a datastore-definition validator: it belongs
to the query renderer and rejects that root kind. Parse a datastore through
`codegen.parse` and add strategy-specific validation in its template.

```velocity
#set($names = $ctx.tableNames('`{namespace}.{basename}`', {"source":"demo.stage", "target":"demo.prep"}, true))
#set($configured = $ctx.withSourceNames($names).withTargetNames($names))
```

The pattern must contain `{namespace}` and `{basename}` with no other braces.
Qualifier mapping uses the complete logical qualifier, case-insensitively; missing
rules throw. Quoting and namespace conventions are supplied by the template.
`quotedIdentifier` implements double quoting, not every target dialect's quoting.

`prependAssignments` delegates to `AstTransformations.prependAssignments`. It
requires a single-target insert, resolved target metadata, and explicit matching
target/projection lists. A map specifies column-to-expression text in iteration
order. The helper validates collisions and target columns, creates new assignment
and projection lists, and rebuilds positions/links. Other children and metadata
remain shared. Supplied expressions are not parsed/resolved by this helper.

## Bundled Velocity renderer

```velocity
#parse("library.Query")
#Render($mapping $ctx)
```

`Render` validates then dispatches. Composable `#Query($query $ctx)`,
`#Insert($insert $ctx)`, and single-target `#InsertTarget($insert $ctx)` require the
strategy to validate its prepared model first. `InsertTarget` emits the INSERT
header and target columns for composing a custom integration clause.

Supported: simple/FROM-less SELECT, DISTINCT, aliases, structured FROM lists,
ordinary inner/outer/cross joins, nested queries, set operations, WHERE, GROUP BY,
HAVING, ORDER BY, explicit limits, single inserts and supported multi-inserts.
Expanded CTEs render as nested queries. Unsupported shapes fail, including raw
WITH/FROM text, pivot/unpivot, unknown joins, missing projections, multi-insert
condition subqueries, and unavailable enclosing CTE dependencies.

The renderer serializes AST annotations. Output containing `@...` may be valid
SQLMorph input but invalid destination SQL. A target strategy must deliberately
consume/remove or translate annotations on a prepared model before using this
renderer for executable SQL. It does not implement annotation-driven integration.

## Engine and package configuration

Supported project engines: `velocity` (`.vm`, `.vtl`), `pebble` (`.peb`, `.pebble`),
`freemarker` (`.ftl`), `jinjava` (`.j2`, `.jinja`). Package descriptors require an
engine; legacy single files use root `config.yml` with `templateEngine: velocity`
(Pebble default on missing/invalid configuration). JTE and StringTemplate4 adapters
exist but are not selectable through these project configuration/discovery paths.

```yaml
engine: velocity
artifacts:
  - template: main.vtl
    output: "sql/{name}.sql"
  - template: contract.vtl
    output: "{name}.txt"
```

Put this in `templates/append/template.yml`. Outputs must be unique relative paths
inside the destination. `{name}` is the only output placeholder. Unknown descriptor
fields/placeholders, missing entries, nested packages and ID collisions fail.
Use literal package-local includes such as `#parse("prepare.vtl")`; local unique
stems may omit the extension. Dynamic include names are unsupported. `library.*`
remains global; packages cannot fall back to similarly named global helpers.
Project templates can explicitly override `library.Query`.

Writes use UTF-8, create parent folders, and overwrite destinations. Rendering
completes before writing starts, so rendering errors write nothing. Filesystem
writes are not transactional, and lexical path checks do not secure an output
directory with hostile links. Generate into a directory you control.
