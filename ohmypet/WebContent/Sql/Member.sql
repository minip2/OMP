create table t97_member(
	id varchar2(30) primary key,
	pw varchar2(100),
	email varchar2(200),
	name varchar2(50),
	phon_number varchar2(30),
	gender number(1) not null,
	member_level number(1) default 2,
	sign_date date default sysdate,
	store_check number(1) not null,
	address varchar2(1000),
	nick_name varchar2(50) UNique
	);
	
	drop table t97_member purge;