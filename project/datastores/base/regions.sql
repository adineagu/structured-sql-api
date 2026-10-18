create table regions
(
    region_id number not null 
   ,region_name varchar2(100)  
   ,business_date date not null
   ,load_date date not null
   ,constraint regions_pk primary key (region_id)
   ,constraint regions_uk unique key (region_name) 
)