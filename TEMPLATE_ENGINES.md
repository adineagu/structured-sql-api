# Template engines and generation API

Each folder template package declares its own engine in `template.yml`:

```yaml
engine: velocity
artifacts:
  - template: main.vtl
    output: "{name}.sql"
```

Packages can use different engines within the same application project. Engines
are initialized lazily when used, with independent package resources and the
appropriate framework libraries. Package engine values are case-insensitive and
required; missing or unsupported values fail when that package is used.

Legacy single-file templates select their fallback engine through `config.yml`
at the application project root:

```yaml
templateEngine: pebble
```

| Engine | Configuration value | File extensions |
| --- | --- | --- |
| Pebble (default) | `PEBBLE` | `.peb`, `.pebble` |
| FreeMarker | `FREEMARKER` | `.ftl` |
| Apache Velocity | `VELOCITY` | `.vm`, `.vtl` |
| Jinjava | `JINJAVA` | `.j2`, `.jinja` |

`ProjectConfigLoader` implements a minimal `templateEngine:` reader, not a full
YAML parser. Missing or invalid configuration falls back to Pebble for legacy
single-file discovery/rendering. Package descriptors use YAML parsing and never
fall back to this project setting. Projects containing only packages can omit
`config.yml` entirely.

JTE and StringTemplate4 adapters and examples also exist in the repository. They
can be instantiated directly, but are not selectable through project configuration
or template-extension discovery. They are not covered by the supported-engine
integration tests.

## Project workflow

Place specification files under `datastores/` or `mappings/` and templates under
`templates/`. Relative paths become dotted IDs with their extension removed:
`templates/datastore/create_datastore.peb` becomes `datastore.create_datastore`.
Project construction takes a discovery snapshot; recreate the project after adding
files. Contents of discovered files are read when loaded. Datastore and mapping
directories should contain only specification files: scanning does not filter them
by extension.

```java
var project = new Project(Path.of("project"));
var metadata = new MetadataManager(project);
var codegen = new CodeGeneratorService(project, metadata);
String artifact = codegen.transform("base.employees")
    .using("datastore.create_datastore")
    .render();
```

The REPL equivalent, with optional file output, is:

```text
apply datastore.create_datastore to datastore base.employees > output.sql
```

Each file is parsed as one complete specification. Multiple statements or trailing
tokens are rejected by generation entry points. The lower-level
`SQLStatementParser.parse()` retains its prefix-parsing behavior; use
`parseSingleStatementScript()` when completeness is required.

The template receives a semantic Java object named `datastore` or `mapping`.
Factory-created project engines preload companion templates by dotted ID. Includes
use those IDs, for example `{% include 'shared.columns' %}` in Pebble or
`<#include 'shared.columns'>` in FreeMarker. Constructing an adapter directly requires
calling `loadTemplates()` for its dependencies.

## Prepared ASTs and strategy parameters

```java
var model = codegen.parse(metadata.findMapping("otp.analytic.ad_address_ti_map").orElseThrow());
// Manipulate concrete model objects here.
String artifact = codegen.transform("otp.analytic.ad_address_ti_map")
    .using("integration.history")
    .withModel(model)
    .withParameter("metadata", metadata)
    .render();
```

`withModel()` bypasses reparsing. Other strategy helpers are explicit parameters.
Project-based rendering resolves the references in a prepared model too, retaining
definitions already attached by the caller.

## File metadata injection

Project-based `CodeGeneratorService.parse()`, fluent rendering, and REPL `apply`
inject parsed datastore definitions into source and target AST references. For example:

```text
SQL reference:      crm.customer
Definition file:   datastores/crm/customer.sql
Definition SQL:    CREATE TABLE physical_customer (...)
```

Lookup uses the complete project identifier, case-insensitively, to accommodate
the SQL lexer's identifier normalization. There is no basename fallback or search
by the table name declared inside the file. Colliding identifiers (including paths
such as `crm.customer.sql` and `crm/customer.sql`) are rejected as ambiguous.

The reference retains its SQL name and alias. `reference.getDatastore()` provides
the structured definition, including columns, keys, and table/column annotations.
Business annotations and definition annotations remain separate; neither overrides
the other. Target assignments resolve their column metadata through their target
reference, so existing assignments and expression links remain intact after injection.
Multi-insert select items expose their binding through `getTargetColumn()`.

Strict mode is the default: absent definitions or explicitly named target columns
cause an error identifying the specification and reference. A strategy that
deliberately accepts incomplete metadata can opt in:

```java
codegen.withMetadataResolution(MetadataResolver.Mode.ALLOW_UNRESOLVED);
```

That mode still enriches known references and rejects ambiguous or invalid definitions.
For unresolved assignments, `getMetadata()` returns null and metadata-dependent
convenience properties throw an explanatory `IllegalStateException`. No column defaults
are invented. Existing example mappings with bare names and no matching root-level
definition files therefore need their references/definitions aligned, or this explicit
mode. The low-level `SQLStatementParser` and `SemanticModelBuilder` remain usable
without a project and do not perform file lookup.

Definitions are parsed once per resolution operation; subsequent operations reread
files. FROM subqueries, expanded CTEs, set branches, joins, and multi-insert targets
are traversed. Aliases and CTE names are not treated as definition-file references.
This is table metadata injection and target-column binding, not source-column lineage.
Embedded scalar, EXISTS, IN, and quantified-comparison subqueries also expose their
table references for injection, as described below.

## Table names inside expressions

Expressions expose `getTableReferences()` for embedded-query tables. Each reference
has its logical name, optional alias, and injected datastore definition. CTE names
in the current scope are excluded from file lookup. CTE references are kept as query
names, not renamed or expanded by expression rendering; the enclosing strategy must
retain or emit their definitions if it uses those expressions.

`getText()` remains the logical expression. `render(names)` returns a separate string
with only parsed table-name spans replaced. Supply a Java naming function as a
template parameter; the function belongs to the generation strategy. For example,
if the declared table name is the desired target name:

```java
Function<DatastoreReferenceNode, String> names = ref -> ref.getDatastore().getName();
String artifact = codegen.transform("mapping.id").using("template.id")
    .withParameter("names", names).render();
```

In Pebble, render a select item's underlying expression with:

```twig
{{ selItem.expression.render(names) }} AS {{ selItem.alias }}
```

The same method is available on other semantic expressions, including filter items.
Pebble emits plain artifact text with HTML escaping disabled, so SQL operators and
quoted identifiers are preserved.

Parsed embedded queries retain their original text, including comments and clauses,
instead of reconstructing every expression type. Replacement positions are captured
against that exact text. Literals and correlated column references are not replaced.
For example, `base.employees e` can become `HR.EMPLOYEES e` while `e.employee_id`
and `dept.manager_id` remain unchanged.

An unaliased table can be renamed when no column qualifier depends on its old name.
If a matching qualifier is present, rendering refuses the rename and requests an
explicit alias. This check is conservative across nested scopes; use explicit aliases
to avoid ambiguity. Expression rendering does not rewrite column qualifiers or
translate functions, and it accepts the expression syntax supported by the parser.

The semantic model retains HAVING, ORDER BY (including direction and null ordering),
and the row-count expression in `getLimit()`. Templates choose how to express those
concepts on the target platform. Dedicated insert integration parameters are exposed
through `getIntegrationType()`, `getUpdateKey()`, `getRejectLimit()`, and
`getRejectLimitUnit()`. They remain separate from annotations; no precedence or
target-specific integration behavior is imposed.

WITH definitions are expanded using dependency resolution in their declaring scope,
including forward dependencies. Reference aliases are retained. Cycles fail with an
explicit diagnostic; recursive-query generation is not implemented by this expansion.

## Annotation and mutation contracts

```java
var annotations = column.annotations();
if (annotations != null && annotations.has("PROPERTIES")) {
    String semantics = annotations.get("PROPERTIES").attribute("CHAR_LENGTH_SEMANTIC");
}
```

The lexer uppercases unquoted identifiers, including annotation names and keys;
quoted string values are exposed without their surrounding quotes. Semantic
annotation lookup itself is exact and case-sensitive. Absent annotations can be null.

`Datastore.getAttributes()` and `InsertNode.getColumns()` return collection copies
containing the same element objects. Use setters to change collection membership.
Query-block lists are live. `shallowCopy()` shares mutable child lists and objects;
copy the portions a strategy needs to modify independently. Semantic expressions
contain formatted text; use the algebra model for structural expression rewrites.

## Examples and validation

The project Pebble datastore template and resource `create_datastore` examples for
the four selectable engines are exercised against the current model by
`TemplateIntegrationTest`. Jinjava's example emits a basic CREATE TABLE; the others
emit the existing stage datastore pattern.

Velocity's `Query.vtl` is now a business-independent AST renderer, bundled as
`library.Query`. The other `Query.*` engine versions remain legacy fragments and
have not yet been aligned with this contract. None is an SCD or delta strategy.

## Rendering contract (milestones 1 and 2)

Project-based rendering injects the source AST (`mapping` or `datastore`) and `ctx`,
a `TransformationContext`. These names are reserved. Configure the context through
`codegen.withContext(ctx)`. Each fluent rendering receives a configuration copy;
the callbacks are shared and should be side-effect free. REPL `apply` gets a fresh
default context. Direct facade callers supply `ctx` explicitly.

Context configuration consists of `withSourceNames(...)`, `withTargetNames(...)`,
`withLimitStyle(...)`, and optional `withIntegrationRenderer(...)`. Naming defaults
to the logical AST reference name. Embedded expression tables use the source rule.
Source aliases and column qualifiers are preserved, not translated. For outer
unaliased sources whose names change, provide an alias before rendering.

Velocity facades created through the factory preload the renderer:

```velocity
#parse("library.Query")
#Render($mapping $ctx)
```

`Render` validates the AST, then dispatches to `Insert` or `Query`. The composable
macros `#Query($query $ctx)` and `#Insert($insert $ctx)` require callers to validate
first (`$ctx.validate($mapping)`). The renderer does not execute SQL, interpret
business annotations, add columns, select knowledge modules, or infer layer names.
Project templates can explicitly override the bundled `library.Query` ID.

Supported structures include simple and FROM-less SELECT, DISTINCT, projection
aliases, structured FROM lists, ordinary inner/outer/cross joins, nested queries,
set operations, WHERE/GROUP BY/HAVING/ORDER BY, single inserts, and conditional or
unconditional multi-insert targets. Expressions use the naming-aware render method.
AST annotations are serialized without merging in annotations from metadata files.
Expanded CTEs render as nested queries.

Limits require `LimitStyle.LIMIT` or `LimitStyle.FETCH_FIRST`; the default rejects
limits instead of guessing a dialect. Existing explicit integration fields require
an integration-rendering callback; no integration behavior is selected by the
framework. Integration annotations remain annotations and do not trigger it.

Unsupported/incomplete structures fail explicitly: raw WITH/FROM text, pivot/unpivot,
unrecognized joins, missing projections, subqueries in multi-insert conditions, and
expressions depending on enclosing CTE definitions that this renderer does not emit.
Expressions with a complete local WITH clause can remain intact. This renderer does
not translate expression functions or guarantee support for every parser construct.

See `examples/ast-rendering/README.md` for a runnable Velocity application project,
REPL commands, and logical-versus-physical naming examples. `QueryRenderingTest`
checks complete expected output, plus explicit failure cases and context behavior.

Run regression checks with `mvn test`. The framework generates text artifacts;
execution, deployment, and orchestration remain the responsibility of target systems.

## First application strategy (milestone 3)

`examples/odi-mapping-draft` contains the accepted single-target OTP stage-to-prep
Incremental Update strategy. Its `CreateComplexMapping.vtl` owns the technical
columns, mapping properties, integration clause, and knowledge-module wrapper.
See its README for commands and explicit scope restrictions.

General helpers exposed through `ctx` include `require(condition, message)`,
`quotedIdentifier(name)`, `removeAnnotation(node, name)`,
`useDeclaredDatastoreNames()`, and `prependAssignments(insert, map)`.
`hasIntegrationSettings(node)` checks dedicated integration fields. The naming
helper configures the current render context; removing an annotation changes the
supplied node. Prepare a copy first when the original must remain unchanged.

`prependAssignments` delegates to `AstTransformations`. For a single-target insert
with resolved target metadata and explicit matching target/projection lists, it
creates new assignment/projection lists in map iteration order. It validates new
columns, expressions, and collisions, preserves original metadata and annotations,
and rebuilds positions and bidirectional links. Other query children and metadata
are shared, so this is not a deep-copy API. New expression strings are supplied by
the caller; this helper does not parse or resolve references inside them.

The renderer exposes `#InsertTarget($insert $ctx)` for the single-target INSERT
header and assignment list. A strategy can validate a prepared AST, emit root
annotations, compose that header with its own integration clause, then call
`#Query($insert.query $ctx)`. Target-specific policy remains in the strategy.

## Naming rules defined in templates

Velocity can construct a naming callback without Java lambdas:

```velocity
#set($namespaces = {"stage": "example-project.stage", "prep": "example-project.prep"})
#set($names = $ctx.tableNames('`{namespace}.{basename}`', $namespaces, true))
#set($configured = $ctx.withSourceNames($names).withTargetNames($names))
```

The generic callback factory accepts a pattern containing `{namespace}` and
`{basename}`, a map from the complete logical qualifier to physical namespace,
and an explicit lowercase-basename flag. Qualifiers match case-insensitively;
unmapped qualifiers and invalid patterns fail. The map is copied when the rule is
created. Quoting, project/dataset conventions, and case policy belong to the
template, not the Java helper. This is a declarative naming-rule factory, not an
arbitrary Velocity-function interpreter. Existing Java Function callbacks remain
available for more complex rules. Normal source-alias validation still applies.

`examples/airflow-bigquery-draft/templates/airflow_bigquery/naming.vtl` is a shared rule example;
`render_business.vtl` exercises it independently of the MERGE strategy.

## Multiple generated artifacts

`CodeGeneratorService.generate(source, artifacts, directory)` accepts a map of
relative output paths to template IDs. It renders every artifact before writing
any, creates parent directories, and writes UTF-8 files, overwriting destinations.
It rejects absolute paths, lexical directory escapes and duplicate normalized
destinations. Rendering failures produce no files; writes are not transactional.
Use an output directory whose contents and links you control.

The Airflow/BigQuery example uses `merge.vtl` and `dag.vtl` with shared `prepare.vtl`
and `naming.vtl`. A shared `prep_policy.vtl` defines technical expressions, runtime
bindings and insert/update behavior; the target datastore's primary-key metadata
drives MERGE matching. Datastore definitions do not configure runtime inputs.
Java does not implement these policies.
The example README includes preview and two-file generation commands. Regression
fixtures check generated SQL and Python, not execution on the target platforms.

## Folder template packages

A subfolder under `templates/` with `template.yml` is a logical template package.
Its public ID is the folder's dotted project path, for example `airflow_bigquery`.
Folders without a descriptor retain legacy single-file discovery. Package internals
are excluded from listings and completion. Nested packages and public ID collisions
are rejected. `show template <id>` displays the descriptor.

```yaml
engine: velocity
artifacts:
  - template: merge.vtl
    output: "sql/{name}.sql"
  - template: dag.vtl
    output: "{name}.py"
```

The descriptor requires `engine` and a non-empty list of template/output pairs. `{name}` is the
source object's project basename, also injected as `artifactName`. Output paths
must be relative, stay inside the output folder and be unique after normalization.
Unknown descriptor fields/placeholders and missing entry templates fail explicitly.

Packages use their own declared engine, independently of project configuration.
Literal Velocity parse/include,
FreeMarker include/import, and Pebble/Jinjava include/extends/import/from resource
names are qualified to the package root when loaded. Use canonical engine syntax
and literal local names; dynamic include names are unsupported. Extensions may be
omitted when the local stem is unique. Framework `library.*` references remain
global. Package helpers cannot fall back to similarly named global templates.
These rules do not change legacy single-file include behavior.

`codegen.renderPackage(source, packageId)` returns an ordered map of relative paths
to rendered contents. `generatePackage(source, packageId, directory)` renders all
outputs, then writes them. Single-file `.using(id).render()` remains unchanged;
explicit private-resource access uses `.using("package/file.vtl")` for debugging.

REPL `apply <package> to mapping <id>` writes artifacts to
`<project>/generated/<package>/<source>/`. Optional `into <directory>` selects a
project-relative directory (or an absolute directory). Single-file apply continues
printing text and using shell-style `>` redirection. Package execution reports its
output directory; redirecting that report does not redirect its artifact files.
