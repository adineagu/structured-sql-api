# Application workflow: definitions → Oracle cleansing and validation

1. Extract and review each workbook's structure using [datastores.md](datastores.md).
   Write SQL facts first; add only extra policies that the template will consume.
2. Create the application folders and all input files, then construct `Project`.
   All three folders (`datastores`, `mappings`, `templates`) must exist, even if
   `mappings` is empty. No mapping file is required for datastore-only cleansing.
3. Parse each definition through `CodeGeneratorService`; check the resulting
   metadata against Excel before writing a template. Resolve unsupported facts
   explicitly rather than bypassing the API.
4. Develop a package that receives `datastore`, iterates its columns, keys and
   CHECK conditions, validates its own supported policy, and emits target SQL.
5. Preview the package, compare fixtures, then generate through the same public
   service. Run target SQL checks separately; generation does not execute ETL.

The complete [oracle-project](oracle-project/) uses two Velocity entry templates
and shared preparation. `01_{name}_clean.sql` creates a view that trims the annotated
VARCHAR columns. `02_{name}_validate.sql` reports mandatory-column violations,
duplicate key groups and false CHECK predicates over the **cleaned** view.
Key and CHECK annotations supply severity; absence defaults to ERROR, as do
mandatory rules. No table annotation duplicates a SQL constraint.

The example assumes an existing, typed Oracle source table. It is not a loader
for untyped strings, a conversion-error quarantine, a target-table load or a
production reject-table strategy. The application chooses those policies explicitly.
It supports unquoted simple identifiers, VARCHAR TRIM, declared NOT NULL columns,
primary keys, single-column unique keys and reviewed Oracle-compatible CHECK text.
Composite unique keys fail explicitly rather than guessing their null semantics.

## Executable public API driver

[GenerateOracle.java](GenerateOracle.java) is a complete Java source-launcher program:

```java
Files.createDirectories(Path.of(args[0]).resolve("mappings"));
var project = new Project(Path.of(args[0]));
var metadata = new MetadataManager(project);
var codegen = new CodeGeneratorService(project, metadata);
for (var definition : metadata.findAllDatastores("")) {
    codegen.parse(definition); // complete-input parse through the generation API
}
var preview = codegen.renderPackage("source.employees", "oracle_validate");
preview.forEach((path, text) -> System.out.println(path + "\n" + text));
codegen.generatePackage("source.employees", "oracle_validate", Path.of(args[1]));
```

The full driver supplies imports, checks arguments and compares the preview with
the distributed expected files before writing. To adapt it, change the source ID,
package ID and application fixtures. If looping over many workbooks, enumerate
datastore IDs from `MetadataManager` and give each a distinct output subfolder;
this example's view names derive from the declared table basename.

With JDK 21 and your supplied SQLMorph runtime/dependency classpath in PowerShell:

```powershell
java --class-path $sqlMorphClasspath docs/agents/GenerateOracle.java docs/agents/oracle-project out/oracle
```

Set `$sqlMorphClasspath` to your installed distribution's classpath. A distribution
documented as a single dependencies-included jar may use that jar's absolute path;
do not assume any old jar has the same API as these examples. No framework source,
Maven build, parser invocation or direct Velocity setup is required.

For this repository's compiled snapshot, prepare that classpath with:

```powershell
mvn compile dependency:build-classpath "-Dmdep.outputFile=target/agent-training-classpath.txt"
$sqlMorphClasspath = 'target/classes;' + (Get-Content -Raw target/agent-training-classpath.txt)
java --class-path $sqlMorphClasspath docs/agents/GenerateOracle.java docs/agents/oracle-project target/oracle-training
java --class-path $sqlMorphClasspath docs/agents/VerifyOracle.java docs/agents/oracle-project
```

The equivalent REPL command is `apply oracle_validate to datastore source.employees
into <directory>`. Use the distribution's documented REPL launcher and project path.
There is no need to synthesize an INSERT mapping to generate from a datastore.

## Review generated behavior

Run clean-view creation first, then the validation SELECT. Mandatory tests operate
after TRIM, so whitespace-only names can become missing values.
CHECK validation uses `NOT (predicate)`: FALSE is a violation, while UNKNOWN does
not match the failure filter. Requiredness is handled separately by NOT NULL rules.
Single-column unique tests exclude null keys. Primary-key columns must explicitly
declare NOT NULL; their nulls are reported by mandatory tests. Duplicate counts
measure offending **groups**, not rows. The TOTAL rule reports cleaned row count.

Generation checks compare complete outputs and inspect the parsed metadata. Before
deployment, execute reviewed scripts in an isolated Oracle schema and check normal
rows, nulls, whitespace-only strings, duplicate keys and negative salaries. Oracle
runtime execution is not part of the verified fixture results. CHECK text must use
the cleaned view's column namespace and be valid Oracle syntax; SQLMorph does not
bind or translate it. The example validates all declared keys and CHECKs regardless
of their database/control flags; those flags do not automatically execute policy.
