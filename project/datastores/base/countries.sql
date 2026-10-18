create table countries
(
    country_id char(8) not null 
   ,country_name varchar2(160)  
   ,region_id number  
   ,currency_cd varchar2(3)  
   ,business_date date not null
   ,load_date date not null
   ,constraint countries_pk primary key (country_id)
   ,constraint countries_uk unique key (country_name) 
)
