@BIGQUERY(
    WRITE_MODE="MERGE"
)
@AIRFLOW(
    DAG_ID="employees_to_prep",
    TASK_ID="merge_employees",
    CONNECTION_ID="google_cloud_default",
    LOCATION="EU"
)
INSERT INTO prep.employees (
    EMPLOYEE_ID,
    DEPARTMENT_ID,
    SALARY
)
SELECT
    e.EMPLOYEE_ID AS EMPLOYEE_ID,
    e.DEPARTMENT_ID AS DEPARTMENT_ID,
    e.SALARY AS SALARY
FROM stage.employees e
