create database railway_eservice

use railway_eservice

create table "user"(
	id int identity(10,1),
	name varchar(100) not null,
	email varchar(100) not null,
	mobile varchar(11) not null,
	pass varchar(20) not null,
	nid varchar(20) not null
	
	constraint pk_id primary key(id), 
	constraint chk_email check(email like '%_@%_.%_'),
	constraint chk_mobile check(len(mobile) = 11 and mobile like '01%'),
	constraint chk_pass check(len(pass) >= 6),
	constraint uq_mobile unique(mobile),
	constraint uq_email unique(email),
	constraint uq_nid unique(nid)
);
 drop table "user"
 
Select * from "user"
