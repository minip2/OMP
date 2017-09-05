create table t97_video (
	no number,
	title varchar2(100) not null,
	video_org_name varchar2(300) not null,
	video_system_name varchar2(300) not null,
	video_path varchar2(300) not null,
	video_size number not null
);

create seqeunce s_video_no;


