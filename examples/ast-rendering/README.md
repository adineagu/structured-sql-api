# AST rendering example (milestones 1 and 2)

This project demonstrates rendering only. It does not implement an integration strategy,
add technical columns, or execute generated artifacts.

From the repository root:

```powershell
mvn compile exec:java "-Dexec.args=examples/ast-rendering"
```

At the `sqlm>` prompt:

```text
list mappings
show mapping department_totals
apply render to mapping department_totals
apply render to mapping department_totals > totals.sql
```

`templates/render.vtl` imports the bundled `library.Query` renderer and calls
`#Render($mapping $ctx)`. Default names remain logical project references:
`TARGET.TOTALS` and `SOURCE.EMPLOYEES`. Metadata still comes from the matching files.

For declared physical names, enter `java` at the REPL and use:

```java
import org.pecheasoft.odigen.render.TransformationContext;
var ctx = new TransformationContext().withSourceNames(r -> r.getDatastore().getName()).withTargetNames(r -> r.getDatastore().getName());
System.out.println(codegen.withContext(ctx).transform("department_totals").using("render").render());
```

This emits the same transformation using `HR.EMPLOYEES` and
`REPORTING.DEPARTMENT_TOTALS`. The alias `E` is preserved. There are no built-in
layer-prefix naming conventions. `/exit` leaves Java mode; `exit` leaves the REPL.

Row limits require an explicit context choice, for example
`new TransformationContext().withLimitStyle(TransformationContext.LimitStyle.LIMIT)`.
`FETCH_FIRST` is also supported. Expressions and functions otherwise pass through;
this is not a general SQL dialect translator.

`QueryRenderingTest` checks complete expected output (normalizing whitespace),
including this project's REPL command and programmatic rendering paths.
