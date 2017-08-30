
	
create table t97_notice(
	no number primary key,
	id varchar2(30),
	title varchar2(100),
	content varchar2(4000),
	reg_date DATE
	);
	
create table t97_answer(
	no number primary key,
	id varchar2(30),
	title varchar2(100),
	answer_content varchar2(4000),
	answer_date DATE,
	category_val varchar2(50)
	);
	
create table t97_question(
	no number primary key,
	id varchar2(30),
	title varchar2(100),
	answer_check char(1),
	question_content varchar2(4000),
	question_date DATE,
	category_val varchar2(50)
	);
	
	create table t97_faq(
	no number primary key,
	id varchar2(30),
	title varchar2(100),
	content varchar2(4000),
	category_val varchar2(50),
	view_cnt number 
	);
	
	insert into t97_faq(no,view_cnt) values();
	select view_cnt
	 from t97_faq;
	