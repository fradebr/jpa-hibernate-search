drop table if exists employee_department;
drop table if exists departments;
drop table if exists branches;
drop table if exists item;
drop table if exists detail;
drop table if exists employees;
drop table if exists make;
drop table if exists screw_dimensions;
drop table if exists screw;
drop table if exists hibernate_sequences;
drop sequence if exists hibernate_sequence;

create table departments
(
	id integer not null, 
	manager varchar(255), 
	name varchar(255), 
	primary key (id)
);
create table employee_department 
(
	department_id integer not null, 
	employee_id integer not null, 
	primary key (department_id, employee_id)
);
create table employees 
(
	employee_id integer not null, 
	active boolean not null, 
	empl_place VARCHAR(50), 
	empl_house_number VARCHAR(10), 
	empl_street VARCHAR(80), 
	empl_postal_code VARCHAR(20), 
	date_in_service date not null, 
	employee_number VARCHAR(15), 
	first_name VARCHAR(40), 
	function VARCHAR(50), 
	last_name VARCHAR(60) not null, 
	picture blob, 
	wage double not null, 
	primary key (employee_id)
);
alter table employees 
	add constraint UK_9aw59jtyajbpyr0q02h20ahql unique (employee_number);
alter table employee_department 
	add constraint FKeivrxorxedw0jroshkmeix9is 
		foreign key (employee_id) references employees;
alter table employee_department 
	add constraint FK4cbu73xwprtxd3tpcop5w9chi 
		foreign key (department_id) references departments;

