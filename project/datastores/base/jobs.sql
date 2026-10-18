
create datastore jobs
(
    job_id varchar2(40) not null 
   ,job_title varchar2(140) not null 
   ,min_salary number(6)  
   ,max_salary number(6)  
   ,business_date date not null
   ,load_date date not null
   ,constraint jobs_pk primary key (job_id)
)