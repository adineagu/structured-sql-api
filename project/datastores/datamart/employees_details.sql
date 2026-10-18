create table empployees_details
(
   employee_id	number(6) not null,
   job_id	varchar2(10) not null,
   manager_id	number(6),
   department_id	number(4),
   location_id	number(4),
   country_id	char(8),
   first_name	varchar2(20),
   last_name	varchar2(25) not null,
   salary	number(8,2),
   salary_euro	number(8,2),
   commission_pct	number(2,2),
   department_name	varchar2(120) not null,
   job_title	varchar2(140) not null,
   address	varchar2(612),
   city	varchar2(120) not null,
   state_province	varchar2(100),
   country_name	varchar2(160),
   region_name	varchar2(100),
   business_date	date not null,
   load_date	date not null,
   constraint EMPLOYEES_DETAILS_pk primary key (employee_id)
)
