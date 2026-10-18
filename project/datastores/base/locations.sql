create table locations
(
    location_id number(4) not null 
   ,street_address varchar2(160)  
   ,postal_code varchar2(48)  
   ,city varchar2(120) not null 
   ,state_province varchar2(100)  
   ,country_id char(8)  
   ,business_date date not null
   ,load_date date not null
   ,constraint locations_pk primary key (location_id)
)