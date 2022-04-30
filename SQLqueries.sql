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
	constraint uq_sm_number unique(sm_number),
	constraint uq_st unique(s_name) 
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

insert into train(t_name, from_st, to_st, startTime, endTime) values
('Bijoy Express', 7000, 7002, '09:00:00', '17:35:00'),
('Bijoy Express', 7002, 7000, '20:30:00', '05:30:00'),
('Egaro Sindur Provati', 7002, 7001, '06:30:00', '10:40:00'),
('Kishoreganj Express', 7001, 7002, '10:45:00', '15:00:00');

drop table train
Select * from train

create table coach(
	c_id int identity(10, 1),
	c_name varchar(100),
	c_fare int not null
	
	constraint pk_cid primary key(c_id),
	constraint uq_cn unique(c_name) 
);

insert into coach(c_name, c_fare) values 
('SNIGDHA', 620), 
('S_CHAIR', 480), 
('SHOVAN', 350), 
('F_CHAIR', 520), 
('AC_S', 700), 
('F_SEAT', 600) ;


drop table coach
Select * from coach


create table adminn(
	username varchar(11) not null,
	pass varchar(20) not null
	
	
	constraint pk_username primary key(username),
	constraint chck_pass check(len(pass) >= 6)	
);


insert into adminn values
('admin','admin00');

select * from adminn;



create table journey(
	j_id int identity(9000, 1),
	j_train int not null,
	j_date Date not null,
	j_coach int not null,
	j_vacancy int not null
	
	constraint pk_jid primary key(j_id),
	constraint uq_journey unique(j_train, j_date, j_coach)
);

insert into journey(j_train, j_date, j_coach, j_vacancy) values
(3000, '3/8/2022', 10, 35),
(3000, '3/8/2022', 11, 35)
;

drop table journey
Select * from journey

select * from journey join train on journey.j_train=train.t_id join coach on coach.c_id=journey.j_coach where from_st=7000 and to_st=7001 and j_date='2022-08-03'

select s_id from station where s_name='Dhaka'

select s_id from station where s_name='Chittagong'

create table ticket(
	tk_id int identity(5000, 1),
	tk_j_id int not null,
	tk_u_id int not null,
	tk_seats int not null,
	tk_fare int not null
	
	constraint pk_tkid primary key(tk_id)
);

drop table ticket
Select * from ticket




insert into ticket(tk_j_id, tk_u_id, tk_seats, tk_fare) values(9000, 10, 1, 620);

select * from ticket join journey on journey.j_id=ticket.tk_j_id

select tk_id from ticket where tk_u_id=10 Order by tk_id DESC