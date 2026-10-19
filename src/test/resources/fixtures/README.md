# Regression fixtures

These files are test inputs, not a runnable SQLMorph application project.

- `mappings/customer-relationship.sql` exercises an annotated INSERT with ten
  assignments, a CTE, UNION ALL, joins and function calls. Names and source labels
  are fictionalized from the former mixed `project/` folder; the structure is
  retained for parser regression coverage. Its lookup functions are parsed text,
  not executable implementations.
- `templates/create_datastore.peb` checks character-length semantics, mandatory
  columns, and the column count against a small datastore constructed in the test.

Tests load these fixtures from the test classpath. Complete application examples
with metadata and templates live under `examples/`; these fixtures are excluded
from the runtime jar.
