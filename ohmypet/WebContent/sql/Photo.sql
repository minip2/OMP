create table t97_photo(
	no number primary key,
	id varchar2(30) not null,
	title varchar2(100) not null,
	password number,
	content varchar2(4000),
	dog_val number(6) ,
	category_val number(6),
	file_path varchar2(3000),
	file_org_name varchar2(3000),
	file_sys_name varchar2(3000),
	view_cnt number,
	recommend_cnt number,
	reg_date date default sysdate
);

create table t97_recommend(
	id varchar2(30) primary key,
	good_check char(1),
	no number 
);

create table t97_photo_file(
	no number,
	extension_name varchar2(10),
	file_name varchar2(200),
	file_path varchar2(1000),
	file_size number,
);

create sequence s_photo_no;

drop sequence s_photo_no;
drop table t97_photo purge;
drop table t97_photo;
drop table t97_photo_file purge;

insert into t97_photo(
	no, id, title, content, product_id, category_val, tag,
	view_cnt,recommend_cnt 
	) values (
    s_photo_no.nextval, 'aaa' , 'title', 'content', 'proId', 1234, 'tag',
    123, 123);
    
select no,name,title, content, category_val, view_cnt, recommend_cnt, reg_date
  from t97_photo,t97_member;

 update t97_photo set title = ?,
  
  
select * from t97_photo;


select no, id, title, content, file_path, dog_val, view_cnt, recommend_cnt, reg_date 
 from t97_photo 
 where no=22; 



