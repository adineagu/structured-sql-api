"""Hand-authored acceptance draft for Airflow 3; not deployed or runtime-tested."""

from pathlib import Path

from airflow.sdk import DAG, Param
from airflow.providers.google.cloud.operators.bigquery import BigQueryInsertJobOperator
from pendulum import datetime


with DAG(
    dag_id="employees_to_prep",
    start_date=datetime(2026, 1, 1, tz="UTC"),
    schedule=None,
    catchup=False,
    max_active_runs=1,
    template_searchpath=[str(Path(__file__).resolve().parent / "sql")],
    params={
        "load_id": Param(type="string", minLength=1, maxLength=128),
        "effective_date": Param(type="string", format="date"),
    },
    tags=["generated", "bigquery"],
) as dag:
    merge_employees = BigQueryInsertJobOperator(
        task_id="merge_employees",
        gcp_conn_id="google_cloud_default",
        project_id="example-project",
        location="EU",
        deferrable=False,
        configuration={
            "query": {
                "query": "{% include 'employees_to_prep.sql' %}",
                "useLegacySql": False,
                "parameterMode": "NAMED",
                "queryParameters": [
                    {
                        "name": "load_id",
                        "parameterType": {"type": "STRING"},
                        "parameterValue": {"value": "{{ params.load_id }}"},
                    },
                    {
                        "name": "effective_date",
                        "parameterType": {"type": "DATE"},
                        "parameterValue": {"value": "{{ params.effective_date }}"},
                    },
                ],
            }
        },
    )
