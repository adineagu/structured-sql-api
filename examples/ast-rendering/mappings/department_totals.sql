INSERT INTO target.totals (department_id, total_salary)
SELECT e.department_id AS department_id, SUM(e.salary) AS total_salary
FROM source.employees e
GROUP BY e.department_id
HAVING SUM(e.salary) > 0
ORDER BY e.department_id
