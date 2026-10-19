# Application-agent documentation improvements

| Significant change | Observed failure addressed |
| --- | --- |
| `AGENTS.md` now puts SQL-first modelling and the generation API before detailed references | Agents needed interactive explanations to identify the intended workflow |
| New `datastores.md`: Excel-to-SQL mapping, exact UNIQUE KEY/COMMENT syntax, column order, explicit NOT NULL, named constraints, annotation ownership | Agents could not reliably write definitions and duplicated SQL facts in mechanical field/table annotations |
| `api.md` and `architecture.md`: recommend Project → MetadataManager → CodeGeneratorService; remove lower-level construction recipes from the application path | Agents started with parser/model/engine internals instead of the published generation API |
| New `workflow.md`, Oracle fixture, and `GenerateOracle.java`: datastore-only input, parse → preview → compare → generate using concrete public calls | Agents needed guidance to connect definitions, templates and generated ETL artifacts; no dummy mapping is needed |
| Oracle templates consume meaningful column TRIM and key severity policies alongside real NOT NULL and key declarations | Annotations reflected spreadsheet cells instead of additional generation semantics |
| `model.md`: document CHECK condition access, constraint properties, key membership, nullability and annotation-retention caveats | Missing model detail encouraged recreating constraints in annotations or trusting incomplete column flags |
| `VerifyOracle.java`, expected artifacts and expanded `validation.md`: metadata assertions, bad-policy rejection and repeatable output | Agents lacked an executable way to validate definitions and template assumptions through the intended API |
| Separate runtime diagnosis in `evidence.md`, CHECK regression fixture in `oracle-project/fixtures/`, and updated Oracle salary validation | The reported CHECK failure required a runtime fix; it was not an application-template or SQL-declaration error |

Runtime follow-up: CHECK annotation transfer and null-safe semantic construction
are now fixed. Three regression tests cover parsing, template access, metadata
injection and absent annotations. The Oracle example now reads CHECK severity from
its owning constraint and generates the salary predicate validation.

Validation: 72 framework tests passed; the Oracle public-API driver and verification
checks passed, including annotated/unannotated CHECKs. Oracle database execution
and the original Excel workbooks were not tested. Use a rebuilt runtime containing
the fix; older jars remain affected.
