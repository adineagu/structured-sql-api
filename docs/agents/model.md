# AST, metadata, and annotations

The template root is `mapping` for mapping files or `datastore` for datastore files.
These are Java objects, not JSON maps. `SemanticModel.annotations()` returns a
`SemanticAnnotationSet` or null; `getClassName()` identifies a concrete node;
`toJson()` is a diagnostic representation, not a documented round-trip format.

## Common object paths

| Object | Actual methods useful to templates |
| --- | --- |
| `Datastore` | `getName()`, `getBasename()`, `getQualifier()`, `getAttributes()`, `getAttribute(name)`, `getKeys()`, `getConditions()`, `getDescription()` |
| `DatastoreAttribute` | `getName()`, `getPosition()`, `getDataType()`, `getDDLDataType()`, `getLength()`, `getPrecision()`, `getScale()`, `getIsMandatory()`, `getIsPrimaryKey()`, `getDefaultValue()`, `getFormat()`, `getScdBehavior()`, `getDescription()` |
| `InsertNode` | `getTarget()`, `getColumns()`, `getQuery()`, `getMultiInsertTargets()` |
| `DatastoreReferenceNode` | `getName()`, `getQualifier()`, `getBasename()`, `getAlias()`, `getDatastore()`, `isTarget()` |
| `SemanticAssignment` | `getName()`, `getPosition()`, `getExpression()` (a `SelectItem`), `getMetadata()` (target `DatastoreAttribute`) |
| `SelectItem` | `getExpression()` (underlying expression), `getAlias()`, `getTargetColumn()`, `getText()`, `render(names)` |
| `SemanticSimpleQueryBlock` | `getSelectList()`, `getIsDistinct()`, `getFromList()`, `getWhereList()`, `getGroupByList()`, `getHavingList()`, `getOrderByList()`, `getLimit()` |
| `SemanticSetQueryBlock` | `getDatasets()`; each entry has `getDataset()` and `getSetOperator()` |
| `SemanticNestedQueryBlock` | `getQuery()`, `getAlias()`; inspect the wrapped query |
| `JoinNode` | `getLeftTable()`, `getRightTable()`, `getLeftQuery()`, `getRightQuery()`, `getLeftJoin()`, `getRightJoin()`, `getJoinType()`, `getJoinExpression()` |
| `MultiInsertTableNode` | `getTarget()`, `getCondition()`, `getSelectList()`; select items bind through `getTargetColumn()` |
| `DatastoreKey` | `getName()`, `getKeyColumns()`, `getKeyType()`, `isPrimaryKey()`, `isAlternateKey()`, `isNonUniqueIndex()` |
| `DatastoreCondition` | `getName()`, `getCondition()` (CHECK expression text), `annotations()` |
| `DatastoreConstraint` (key/condition base) | `getType()`, `getScope()`, `isFlowControlEnabled()`, `isStaticControlEnabled()`, `isDefinedInDatabase()`, `isActive()`, `getMessage()` |
| `SemanticExpression` | `getText()`, `getTableReferences()`, `render(Function<DatastoreReferenceNode,String>)` |

Velocity bean notation `$mapping.target.datastore.attributes` invokes getters.
Annotation methods use explicit calls: `$mapping.annotations().get("LOAD")`.
Avoid assuming bean access behaves identically in every template engine.

Use `getKeys()` and each key's `getKeyColumns()` for primary/unique membership.
In the inspected parse-to-model path, `DatastoreAttribute.getIsPrimaryKey()` is
not populated from table keys. A primary key also does not set a column's
`getIsMandatory()`: declare `NOT NULL` explicitly. Do not infer that these
column flags provide a complete constraint model. See [datastores.md](datastores.md).

Assignments and projections link in both directions. Assignment metadata describes
the **target** column; it is not source-column lineage. `SelectItem.getText()` and
`render(names)` append an alias, even when it is null in the current implementation.
Use its underlying expression when emitting an alias yourself; use `library.Query`
for general query rendering.

## Metadata lookup

A SQL reference `source.employees` resolves to project ID `source.employees`, such
as `datastores/source/employees.sql`. SQL-reference matching is case-insensitive
and uses the full ID. It does not search by basename or by the table name declared
inside the definition. Ordinary `MetadataManager.findMapping/findDatastore` ID
lookups are exact and case-sensitive; do not confuse them with reference resolution.

The reference keeps its logical name and alias; `getDatastore().getName()` is the
definition-declared name. Strict resolution is the default and rejects missing
definitions and explicitly named target columns. `ALLOW_UNRESOLVED` still resolves
known metadata and rejects ambiguity or invalid definitions. With missing metadata,
`assignment.getMetadata()` is null; datatype/mandatory/key convenience getters
throw rather than inventing defaults. `getDefaultValue()` can return null.

Resolution traverses joins, nested queries, expanded CTEs, set branches, multi-insert
targets, and embedded-expression table references. It retains caller-attached
definitions. Definitions are reused within one resolution operation and reread on
later operations. No database catalog connection is implied.

## Annotation contract

```sql
@LOAD(MODE="APPEND")
INSERT INTO target.employees (EMPLOYEE_ID)
SELECT e.EMPLOYEE_ID AS EMPLOYEE_ID FROM source.employees e
```

This attaches `LOAD` to the insert. `@TAG` is also valid. Attribute values must be
quoted strings (`KEY="value"` or `KEY='value'`); do not supply unquoted booleans,
numbers, nested objects, or `@TAG()` as if this were Java annotations.
Unquoted annotation names/keys are uppercased by the lexer. String values lose
their surrounding quotes. Semantic lookup is exact and case-sensitive:

```java
var set = model.annotations();
if (set != null && set.has("LOAD")) {
    String mode = set.get("LOAD").attribute("MODE");
}
```

`SemanticAnnotationSet`: `all()`, `has(name)`, `get(name)`, `isEmpty()`,
`setAnnotations(list)`. Missing `get` returns null. `SemanticAnnotation`:
`name()`, `attributes()`, `attribute(key)`; a missing attribute returns null.
The annotation's attribute map and the set's exposed list are immutable snapshots;
replace the set list through `setAnnotations`. `get` returns the first matching
name; do not rely on duplicate annotations or duplicate keys as a policy mechanism.

Annotations can occur at supported grammar positions, including definitions,
columns, insert roots/targets, SELECT roots/items, joins and predicates. This is
not permission to place arbitrary tags anywhere in SQL. Test retention at the
exact node a strategy consumes. Reference annotations and definition annotations
are separate: `ref.annotations()` versus `ref.getDatastore().annotations()`.
Assignment annotations and `assignment.getMetadata().annotations()` likewise stay
separate; there is no merge, inheritance, or precedence rule.

Named constraints have an annotation slot before `CONSTRAINT`, not after the
expression. Both key and CHECK annotations survive public-API parsing. A CHECK
without annotations exposes an empty annotation set. `getCondition()` preserves
the CHECK predicate text, including its original identifier case; it is not a
parsed, bound or dialect-translated expression API. Older runtime jars may contain
the CHECK construction bug fixed in this snapshot; see [evidence.md](evidence.md).

**No general predefined annotation semantics:** `@AIRFLOW`, `@BIGQUERY`,
`@TECHNICAL`, and `@LOAD` do not activate framework behavior. Their vocabulary and
effects belong to the consuming template. Dedicated SQL fields such as
`getScdBehavior()` and insert `getIntegrationType()`, `getUpdateKey()`,
`getRejectLimit()`, `getRejectLimitUnit()` are separate from annotations.

**Implementation caveat:** legacy code does recognize `PROPERTIES.NAME` for join
names, predicate grouping, and some expression formatting. Therefore “annotations
are entirely uninterpreted everywhere” would be inaccurate. It provides no MERGE
or SCD semantics. Avoid repurposing that pair until the author confirms its contract.

## Expression and mutation limits

`getText()` retains logical expression text. `render(names)` replaces captured
table-name spans inside supported embedded subqueries, preserving literals,
comments, aliases, and correlated column references. It does not rewrite column
qualifiers or functions. Explicit source aliases are essential when renaming.
CTE expansion resolves dependencies and rejects cycles; recursive-query generation
is not implemented. Embedded expressions may still depend on enclosing CTE names;
the bundled renderer rejects dependencies it cannot emit.

`Datastore.getAttributes()` and `InsertNode.getColumns()` return collection copies
with shared elements. Use `setAttributes`/`setColumns` to change membership. Query
lists are live. `shallowCopy()` is not a deep copy: mutable children and annotations
may be shared. Prefer fresh parsing per independent artifact or carefully prepared
copies. `ctx.removeAnnotation` mutates its argument. `ColumnsList.annotatedWith`
does not guard null annotations, so explicit guarded filtering is safer.

`Datastore.getAttributes(String condition)` currently returns null; it is not a
working filtering API. Do not infer capabilities merely from public signatures.
