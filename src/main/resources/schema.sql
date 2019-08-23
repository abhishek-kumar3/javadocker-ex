CREATE DB IF NOT EXISTS DEMO;

DROP TABLE IF EXISTS EMPLOYEE;

CREATE TABLE EMPLOYEE(
	id int(11) primary key,
	first_name varchar(64) not null,
	last_name varchar(64) ,
	department varchar(64),
	designation varchar(64),
	salary int(7) 
);