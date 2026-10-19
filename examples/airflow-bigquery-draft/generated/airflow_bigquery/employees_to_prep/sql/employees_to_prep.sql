


























































-- Generated BigQuery MERGE; execution belongs to the target platform.
MERGE `example-project.prep.employees` AS T
USING (

SELECT 
 E.EMPLOYEE_ID AS EMPLOYEE_ID
,  E.DEPARTMENT_ID AS DEPARTMENT_ID
,  E.SALARY AS SALARY
FROM

 `example-project.stage.employees` E

) AS S
ON  T.EMPLOYEE_ID = S.EMPLOYEE_ID

WHEN MATCHED THEN
    UPDATE SET
        DEPARTMENT_ID = S.DEPARTMENT_ID,

        SALARY = S.SALARY,

        UPDATE_ID = @load_id,

        EFFECTIVE_DATE = @effective_date

WHEN NOT MATCHED THEN
    INSERT (LOAD_ID, UPDATE_ID, LOAD_DATE, EFFECTIVE_DATE, EMPLOYEE_ID, DEPARTMENT_ID, SALARY)
    VALUES (@load_id, @load_id, CURRENT_TIMESTAMP(), @effective_date, S.EMPLOYEE_ID, S.DEPARTMENT_ID, S.SALARY);
