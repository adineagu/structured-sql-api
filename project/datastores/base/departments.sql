create table departments
(
    department_id number(4) not null 
   ,department_name varchar2(120) not null 
   ,manager_id number(6)  
   ,location_id number(4)  
   ,business_date date not null
   ,load_date date not null
   ,constraint departments_pk primary key (department_id)
   ,constraint departments_uk unique key (department_name) 
)