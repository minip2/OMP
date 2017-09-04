create table t97_member(
	id varchar2(30) primary key,
	password varchar2(100),
	email varchar2(200),
	name varchar2(50),
	phon_number varchar2(30),
	gender number(1) not null,
	member_level number(1) default 2,
	sign_date date default sysdate,
	store_check number(1) not null,
	address varchar2(1000),
	nick_name varchar2(50)
	);
	
	create table t97_login(
	memberstatus number(1) default 0,
	id varchar2(30),
	pw varchar2(100)
	);
	
	drop table t97_member purge;
	drop table t97_login purge;
	
	insert into tb_board(no) values(1);
	insert into T97_MEMBER (id, password, email, name, phon_number, gender, store_check, address,nick_name)
	values('hyun','1234','qwe','hyunjoon','010421', '0', '0', 'seoul','현준');
	insert into T97_MEMBER (id, password, email, name, phon_number, gender, store_check, address,nick_name)
	values('aa','12','qwe','joon','010421', '0', '0', 'seoul','박현');
	insert into T97_MEMBER (id, password, email, name, phon_number, gender, store_check, address,nick_name)
	values('bb','34','qwe','hyun','010421', '0', '0', 'seoul','박준');
	select * from T97_MEMBER;