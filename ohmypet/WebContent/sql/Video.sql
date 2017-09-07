create table t97_video (
	no number,
	title varchar2(100) not null,
	video_org_name varchar2(300) not null,
	video_system_name varchar2(300) not null,
	video_path varchar2(300) not null,
	video_size number not null,
	nick_name varchar2(30) not null
);

create sequence s_video_no;

select * from t97_video;
select * from tab;
drop table t97_video;

select * from user_sequences;
drop sequence s_video_no;

select *
  from t97_video
 order by no desc;

	select *
	  from t97_video
	 order by no desc ;