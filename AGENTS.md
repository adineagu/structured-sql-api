# SQLMorph guide for external coding agents

Use this guide to build transformation **application projects** with SQLMorph.
It is self-contained with respect to implementation details: agents need a SQLMorph
runtime and their application files, not the framework's Java source. The repository
also calls this framework “Structured SQL API”; Java packages still use
`org.pecheasoft.odigen`. Do not invent `sqlmorph.*` Java imports.

Read in this order:

1. [Architecture and policy boundaries](docs/agents/architecture.md)
2. [Excel descriptions to SQL-first definitions](docs/agents/datastores.md)
3. [Application workflow and executable Oracle example](docs/agents/workflow.md)
4. [AST, metadata, and annotations](docs/agents/model.md)
5. [Template and Java API reference](docs/agents/api.md)
6. [Other complete examples](docs/agents/examples.md)
7. [Validation and mistakes to avoid](docs/agents/validation.md)
8. [API limitations and evidence](docs/agents/evidence.md)

Start with `Project` → `MetadataManager` → `CodeGeneratorService`; use
`parse`, `transform(...).using(...).render()`, or `renderPackage/generatePackage`.
Do not construct parser/algebra/engine internals or bypass SQLMorph with a direct
template-engine invocation. Public Java visibility alone does not make something
the application entry point.

**SQL first:** declare types, order, `NOT NULL`, named `PRIMARY KEY`, `UNIQUE KEY`,
and `CHECK` in SQL. Use annotations only for additional, consumed generation policy
at the owning node. Never duplicate mandatory flags, positions, or whole constraint
definitions in annotations. Use a runtime containing the CHECK metadata fix;
older jars may fail even though the declaration is valid SQLMorph syntax.

Before implementing a strategy, specify its supported SQL shapes, metadata needs,
annotation vocabulary, naming rules, technical fields, and output artifacts.
Implement target policy in application templates. Fail explicitly on unsupported
input. Parse and resolve metadata, render all artifacts, compare expected output,
then validate with the target platform's tools before deployment.

Annotations have no general predefined business semantics. Their names do not
activate MERGE, SCD, orchestration, or technical-column behavior. There are legacy
`PROPERTIES.NAME` uses in model construction/formatting; see the model reference
before assuming complete annotation neutrality.

The runnable [training project](docs/agents/training-project/) accompanies this
guide. Distribute the entire `docs/agents/` directory with this entry point; its
small example does not depend on other repository examples. References to framework
tests in the evidence file are provenance for maintainers, not prerequisites for
an external agent.

See the [experiment-driven changelog](docs/agents/CHANGELOG.md) for how each
significant revision addresses an observed application-agent failure.

This guide describes the inspected snapshot, not a promise of API compatibility.
For application work, keep changes in the application project unless the user
requests a framework fix. Keep generated artifacts in a separate output folder.
