# Logical template packages

`airflow_bigquery/` is one logical template. Its `template.yml` descriptor declares
`engine: velocity` and SQL/DAG outputs. No project-level engine setting is needed.
The tool lists and applies the package by folder name; the
Velocity files inside it are implementation details.

`prepare.vtl` reads business assignments and target primary-key metadata;
`prep_policy.vtl` holds shared target-write policy; `naming.vtl` defines physical
naming. `merge.vtl` and `dag.vtl` are the two artifact entry points.

Literal includes such as #parse("prepare") resolve from the package root, with
an optional file extension. `library.Query` still references the framework renderer.
No global helper aliases are installed. `render_business.vtl` remains an internal
SELECT-rendering demonstration, not a separately listed application template.
See the parent README for commands.
