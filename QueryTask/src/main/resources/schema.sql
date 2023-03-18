create table employees
(
   id integer not null,
   first_name varchar(255) not null, 
   last_name varchar(255) not null,
   email_address varchar(255) not null,
   primary key(id)
);

create table department
(
   d_id integer not null,
   dname varchar(255) not null, 
   primary key(d_id)
);