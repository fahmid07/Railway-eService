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

create table station(
	s_id int identity(7000, 1),
	s_name varchar(256) not null,
	s_master varchar(100) not null,
	sm_number varchar(11) not null
	
	constraint pk_sid primary key(s_id),
	constraint chk_sm_number check(len(sm_number) = 11 and sm_number like '01%'),
	constraint uq_sm_number unique(sm_number) 
);
drop table station
Select * from station

insert into station(s_name, s_master, sm_number) values
('Chittagong', 'Rafiq Uddin', '01876096638');

insert into station(s_name, s_master, sm_number) values
('Dhaka', 'Mushfiq Rahman', '01876096658'),
('Kishoreganj', 'Fahad Hossain', '01876096698');

create table train(
	t_id int identity(3000, 1),
	t_name varchar(256) not null,
	from_st int not null,
	to_st int not null,
	startTime time,
	endTime time
	
	constraint pk_tid primary key(t_id)
);

insert into train(t_name, from_st, to_st, startTime, endTime) values
('Subarna Express', 7000, 7001, '07:00:00', '12:20:00');

insert into train(t_name, from_st, to_st, startTime, endTime) values
('Chattala', 7000, 7001, '08:30:00', '15:50:00'),
('Shonar Bangla', 7000, 7001, '17:00:00', '22:10:00'),
('Turna Express', 7000, 7001, '23:00:00', '05:15:00');

insert into train(t_name, from_st, to_st, startTime, endTime) values
('Shonar Bangla', 7000, 7001, '07:00:00', '12:15:00'),
('Mohanagar Provati', 7001, 7000, '07:45:00', '14:00:00'),
('Shubarna Express', 7001, 7000, '16:30:00', '21:50:00'),
('Turna Express', 7001, 7000, '23:30:00', '06:20:00');

drop table train
Select * from train
