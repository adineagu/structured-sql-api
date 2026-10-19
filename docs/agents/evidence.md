# Evidence and author clarification

This guide was prepared from the repository snapshot inspected on 2026-10-19.
“Documented” means existing README/template documentation described it;
“implementation-confirmed” means the actual Java/template path was inspected.
“Inferred” statements describe intent rather than a guaranteed feature.
The paths below are maintainer audit pointers; reading source is not required to
use the rest of the guide.

## CHECK metadata fix

The earlier review reproduced a runtime defect: the CHECK parser omitted
constraint annotations and semantic condition construction assumed a non-null
annotation collection. Both are fixed in this snapshot. Annotated CHECKs now
preserve their annotations; unannotated CHECKs expose an empty set. Condition text,
names and other constraint properties remain intact.

`CheckConstraintTest` covers public parsing, datastore-template rendering, mapping
metadata resolution, and caller-prepared conditions with absent annotations.
[VerifyOracle.java](VerifyOracle.java) verifies the public application path and the
[small CHECK fixture](oracle-project/fixtures/with-check.sql). The Oracle package now
generates its salary CHECK validation from a real SQL constraint and consumes the
constraint's severity annotation. No internal application workaround is required.

Use a jar built from this fixed snapshot: an older runtime remains affected even
if its documentation or application templates are updated. No new public API or
predefined annotation meaning was introduced.

`mvn -o -DskipTests package` rebuilt `lib/sqlmorph.jar` after the regression run.
Both `GenerateOracle.java` and `VerifyOracle.java` also passed using that jar alone
on their classpath, including the salary CHECK and annotation retention.

## Remaining application API limitations

| Finding | Observed result / application consequence |
| --- | --- |
| Primary-key column convenience flag is not populated | A parsed primary key appears in `getKeys()` but column `getIsPrimaryKey()` stays false. Use the published constraint objects as the authoritative membership model. |
| Primary key does not infer NOT NULL metadata | Omission of `NOT NULL` leaves the column nullable in the semantic model. Explicit declarations are necessary; the example rejects missing requiredness. |
| SQL DEFAULT declarations are unavailable in this definition grammar | The public parse probe rejects `ID DECIMAL(10,0) DEFAULT 0`, despite the existence of `getDefaultValue()`. Do not claim parsed defaults or invent a default-value annotation contract. Escalate a real default requirement. |
| Excel import is outside the available API | No workbook-import API is present in the inspected project. Read workbooks with application tooling, review facts, and write SQL specifications before invoking SQLMorph. |

The runnable Oracle package covers TRIM, NOT NULL, primary/unique and CHECK
validation. No experiment workbooks were supplied for this review, so the
extraction procedure is illustrated with representative reviewed facts, not tested
against those original files. Source jars already present under `lib/` are not
assumed to match the freshly compiled snapshot.

| Topic | Implementation evidence | Regression evidence |
| --- | --- | --- |
| Project IDs/discovery, engine selection, package resources | `project/ProjectScanner`, `template/TemplatePackage`, `TemplateEngineFacadeFactory` | `TemplatePackageTest`, `TemplateIntegrationTest` |
| Generation bindings, context, prepared models and writes | `render/CodeGeneratorService`, `TemplateBuilder` | `SemanticGenerationTest`, `BigQueryGenerationTest` |
| Metadata lookup and assignment binding | `metadata/MetadataManager`, `MetadataResolver`, `SemanticAssignment` | `MetadataResolutionTest` |
| Annotation data API, exact lookup/nulls | `sql/api/ast/SemanticAnnotation`, `SemanticAnnotationSet` | Template and semantic generation tests; training project |
| CHECK metadata and annotations, with or without annotations | CHECK branch in `sql/parse/SQLAnalyzer`, `sql/api/ast/impl/DatastoreCondition` | `CheckConstraintTest`, `VerifyOracle.java` |
| Legacy `PROPERTIES.NAME` exception | `sql/util/annotation/Annotated`, `SemanticModelBuilder` join/filter handling, `SQLExpressionFormatter` | Source-inspected; a universal neutrality guarantee is not tested |
| Structured query rendering and explicit context policy | `render/TransformationContext`, resource `template/Query.vtl` | `QueryRenderingTest`, `TemplateNamingTest` |
| Embedded table spans, aliases, CTE boundaries | `sql/api/ast/impl/Expression`, parser embedded-reference handling | `EmbeddedExpressionTest`, `QueryRenderingTest` |
| Prepared assignments and ODI strategy | `sql/api/transform/AstTransformations`, ODI example templates | `OdiMappingStrategyTest` |
| Shared MERGE/DAG policy and primary-key selection | Airflow/BigQuery example `prepare.vtl`, `prep_policy.vtl`, `merge.vtl`, `dag.vtl` | `BigQueryGenerationTest` |

Java paths above are relative to `src/main/java/org/pecheasoft/odigen/`; test classes
are in `src/test/java/org/pecheasoft/odigen/`. Existing documented contracts appear
in `README.md`, `TEMPLATE_ENGINES.md`, and example READMEs.

## Questions for the project author

These do not block the narrow training example; do not invent answers in a new strategy.

- Which exact runtime artifact/version was used in the successful experiment?
  Ensure external agents receive a rebuilt runtime containing the CHECK fix.

- Which versioned runtime/distribution and subset of public Java APIs should
  external agents treat as stable? The Maven coordinates currently identify a
  `sqlparser:1.0-SNAPSHOT`, while the documentation uses multiple product names.
- Is legacy `PROPERTIES.NAME` behavior an intended supported exception to annotation
  neutrality, or compatibility behavior to retire? Which annotation placements and
  round-trip guarantees are officially supported?
- Should duplicate annotation names/keys be rejected, and are any names reserved
  beyond the legacy uses? Current first-match lookup is not a complete policy contract.
- Which dialects and constructs are officially supported for parsing versus
  bundled rendering? There is no universal target-dialect guarantee here.
- Are example strategy constraints product commitments or illustrative policies?
  What target versions and real execution results can be published for ODI,
  Airflow and BigQuery?
- What distribution launcher, dependency/classpath instructions, and licensing
  terms should accompany a source-free agent training bundle?

## Validation record

Executed against this snapshot:

- `mvn -o test`: **72 tests passed**, zero failures, errors or skips (including
  three new CHECK regression tests).
- `VerifyTraining.java` using compiled project classes and the Maven dependency
  classpath: **passed** expected SQL/contract comparisons, repeatability, invalid
  mode/extra attribute rejection, missing definition/target-column rejection,
  package file writes, and no writes after a batch rendering failure.
- `GenerateOracle.java`: complete expected SQL comparisons and preview-to-file
  equality passed using `Project`, `MetadataManager`, and `CodeGeneratorService`.
- `VerifyOracle.java`: column order/type/nullability/description, SQL key membership,
  key/column annotation retention, constraint SQL extension fields, policy failure
  cases and repeatability passed. Annotated and unannotated CHECK construction,
  policy retention and generated CHECK SQL passed. DEFAULT rejection remains a
  separately verified limitation.

The original documentation review passed 69 tests but those did not cover CHECK
construction. The fixed snapshot adds regression coverage and passes all 72.

The training fixture derives its renderer/metadata/package usage from the existing
tests and was additionally verified through the public generation API. SQL fixture
comparison removes whitespace; contract comparison removes blank lines and trims
line edges. This is sufficient for these simple fixtures, not a general SQL or
Python equivalence test.

Generated-text checks do not establish target database/orchestrator execution.
No target credentials or services are part of this task. The runtime fix changes
CHECK annotation transfer and null handling; application templates continue using
the existing public generation API.
