
create table employees
(
    employee_id number(6) not null 
   ,first_name varchar2(20)  
   ,last_name varchar2(25) not null 
   ,email varchar2(25) not null 
   ,phone_number varchar2(20)  
   ,hire_date date(7) not null 
   ,job_id varchar2(10) not null 
   ,salary number(8,2)  
   ,commission_pct number(2,2)  
   ,manager_id number(6)  
   ,department_id number(4)  
   ,business_date date not null
   ,load_date date not null
   ,constraint employees_pk primary key (employee_id)
   ,constraint employees_uk unique key (email) 
)