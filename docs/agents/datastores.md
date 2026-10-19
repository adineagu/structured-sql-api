# From Excel descriptions to SQL-first datastore definitions

SQLMorph consumes SQL-like specification text, not workbooks. Read each Excel file
with the application's chosen spreadsheet tool, then write one `CREATE TABLE`
specification per datastore. Keep Excel files and extraction notes outside
`datastores/`. No SQLMorph Excel importer or workbook schema is published here.

## Translate meaning, not every spreadsheet cell into an annotation

| Description in Excel | SQLMorph representation |
| --- | --- |
| Table identity | File path determines project ID; `CREATE TABLE` names the physical object |
| Column name and datatype/size | Column declaration, e.g. `SALARY DECIMAL(12,2)` |
| Column sequence | Write declarations in the described order; `getPosition()` is populated sequentially |
| Mandatory / nullable | `NOT NULL` / optional `NULL`; omission means nullable |
| Primary key, including ordered members | Named table-level `CONSTRAINT ... PRIMARY KEY (...)` |
| Unique constraint | Named table-level `CONSTRAINT ... UNIQUE KEY (...)` |
| Validation predicate | Named `CONSTRAINT ... CHECK (...)`; read it through `getConditions()` |
| Human description | Supported `COMMENT 'description'` for a field |
| Trim whitespace before validation | Column annotation only if a template implements that policy |
| Severity/routing of a constraint failure | Extra annotation on the key or CHECK constraint, consumed by the template |
| Default, foreign key, unsupported datatype/detail | Record separately as an unresolved requirement; do not fabricate support |

An Excel row number is provenance, not the column's business semantics. Do not emit
`@FIELD(POSITION="3", MANDATORY="true")`: SQL already represents both facts. Keep
workbook/sheet/cell provenance in an application review manifest outside scanned
specification folders unless a template genuinely consumes it.

Resolve ambiguous names, datatype lengths, key membership and free-text validation
rules against the workbook owner. Do not guess that a blank cell means nullable,
that “identifier” means primary key, or that a repeated name denotes a constraint.
Use an explicit extraction convention for yes/no/blank cells. Compare the final
column count, declaration order, types, nullability and constraints with the source.

## Complete accepted definition

This is the runnable Oracle example's `datastores/source/employees.sql`.
The project ID is `source.employees`; its physical source is `DEMO.EMPLOYEES_RAW`.

```sql
CREATE TABLE DEMO.EMPLOYEES_RAW (
    EMPLOYEE_ID DECIMAL(10,0) NOT NULL,
    @CLEANSE(OP="TRIM")
    EMPLOYEE_NAME VARCHAR(80) NOT NULL COMMENT 'Employee display name',
    @CLEANSE(OP="TRIM")
    EMAIL VARCHAR(120),
    SALARY DECIMAL(12,2),
    @VALIDATION(SEVERITY="ERROR")
    CONSTRAINT EMPLOYEES_PK PRIMARY KEY (EMPLOYEE_ID),
    @VALIDATION(SEVERITY="WARN")
    CONSTRAINT EMPLOYEES_EMAIL_UK UNIQUE KEY (EMAIL),
    @VALIDATION(SEVERITY="ERROR")
    CONSTRAINT EMPLOYEES_SALARY_CK CHECK (SALARY >= 0)
)
```

The column annotations specify an actual cleansing operation. Key and CHECK
annotations add reporting severity; they do not redefine key members or predicates.
CHECK annotations are optional: absent annotations produce an empty semantic set.
The [small CHECK fixture](oracle-project/fixtures/with-check.sql) verifies both forms
through the public API. Older runtimes had a CHECK construction bug; use the fixed
runtime described in [evidence.md](evidence.md), keeping constraints in SQL.

Use named table-level constraints, including for single-column keys. The verified
unique syntax is **`UNIQUE KEY`**, not Oracle DDL's bare `UNIQUE`. Use **`COMMENT`**,
not an appended `COMMENT ON COLUMN` statement. SQLMorph's specification dialect
is not Oracle DDL; templates emit Oracle artifacts separately. One specification
file holds one statement, not a CREATE followed by ALTER/COMMENT commands.

Declare `NOT NULL` explicitly on primary-key columns. SQLMorph does not infer the
column mandatory flag from primary-key membership. Obtain membership from
`datastore.getKeys()` / `key.getKeyColumns()`, not column `getIsPrimaryKey()`.
Column order is the declaration order in the semantic model; do not use annotations
or the parser's `POSITION` extension to try to reorder it.

Read CHECK constraints through `datastore.getConditions()`, with `getName()`,
`getCondition()` and `annotations()` on each condition.
Keys are exposed through `getKeys()` with name, kind and members.
These lists can be null when no constraints are defined: guard with `ctx.has`.
For key metadata, this additional suffix is also verified:
`DEFINED IN DATABASE ACTIVE CONTROL STATIC MESSAGE 'key issue'`.
It exposes database-presence/active flags, static rather than flow validation, and
a message through the constraint getters. Do not duplicate these facts in
annotations or assume they execute validation. The generated example does not use
these flags. This is a tested syntax subset, not a promise that every parser
extension or Oracle DDL clause round-trips through the public model.

## Annotation design rule

For every proposed annotation, answer: what does it mean, which node owns it, which
template consumes it, what values are accepted, and what happens if it is absent
or invalid? If no consumer exists, leave it out. SQLMorph assigns no general
business meaning to your annotation names.

Use SQL for a fact when supported; attach only the remaining policy to its owner.
For example, attach `VALIDATION.SEVERITY` to a key, not a table-level annotation
containing a copied key name, list and predicate. Attach severity to a CHECK in
the same way, leaving the actual predicate in its SQL declaration.

Before template work, validate every definition with the public `codegen.parse`
path in [workflow.md](workflow.md), and inspect the resulting counts and properties.
Parsing alone does not establish that key members or CHECK identifiers are valid
columns, or that expressions are Oracle-compatible: the application must check those.
