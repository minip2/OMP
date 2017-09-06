
	
create table t97_notice(
	no number primary key,
	id varchar2(30) default '관리자',
	title varchar2(100),
	content varchar2(4000),
	reg_date DATE default sysdate
	);
	
create table t97_answer(
	no number primary key,
	id varchar2(30),
	title varchar2(100),
	answer_check char(1) default 1,
	answer_content varchar2(4000),
	answer_date DATE default sysdate,
	category_val varchar2(50)
	);
	
create table t97_question(
	no number primary key,
	id varchar2(30),
	title varchar2(100),
	answer_check number(1) default 0,
	question_content varchar2(4000),
	answer_content varchar2(4000) default '답변대기중입니다 빠른 시일내로 답변해드리겠습니다.',
	question_date DATE default sysdate,
	category_val varchar2(50),
	question_date_detail varchar2(100)
	);
	
	select 
	from t97_answer an, t97_question qu
	where an.
	
	
	create table t97_faq(
	no number primary key,
	id varchar2(30),
	title varchar2(100),
	content varchar2(4000),
	category_val varchar2(50),
	view_cnt number 
	);
	drop table t97_question purge;
	insert into t97_faq(no,view_cnt) values();
	select view_cnt
	 from t97_faq;
	 
	create sequence s_question_no;
	create sequence s_notice_no;
	
	drop sequence s_notice_no;
	drop table t97_notice purge;
	
	drop sequence s_question_no;
	drop table t97_question purge;

	
	select Max(no) 
	from t97_notice;
	select Max(no)  from t97_notice;
	
	
	
	
	 select  no, a.id, title, question_content, answer_content, question_date,  category_val, nick_name
	 from t97_question a, t97_member  
			 order by no desc;
	
	
	
	
insert into t97_question(no, id, title, question_content, category_val ) 
values(s_question_no.nextval, '박현준', '로그인이 안됩니다', '해결좀해봐요',3000);
select * from T97_QUESTION;
select * from T97_notice;














		 select  no, q.id, title, question_content, answer_content, question_date,  category_val, m.nick_name 
		 from t97_question q 
		inner join t97_member m 
		 on q.id = m.id
		 order by no desc; 


	
	select e.last_name,
	       e.department_id,
	       d.department_name
	  from employees e 
	  inner join departments d
	  on e.department_id = d.department_id;
	  
	  select e.last_name, j.job_title, j.min_salary,j.max_salary
	from employees e inner join jobs j
	on e.job_id = j.job_id;
	
	
		 select  no, q.id, title, question_content, answer_content, question_date,  category_val, nick_name 
		 from t97_question q
		 inner join t97_member m 
		 on q.id=m.id 
		 order by no desc; 
	
	
	
