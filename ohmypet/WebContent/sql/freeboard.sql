create table t97_freeboard (
  no number primary key, --글번호
  id varchar2(30) not null, --id 
  title varchar2(100) not null, --제목
  category_val int not null, -- 카테고리
  content varchar2(4000), -- 내용
  pw varchar2(40), -- 비밀번호 
  comment_bool char(1), -- 댓글허용체크 
  public_bool char(1), -- 공개체크 
  tag varchar2(550), --태그 
  view_num number, -- 조회수 
  recommend number, --추천수 
  reg_date date default sysdate, -- 날짜
  file_path  VARCHAR2(1000) -- 파일첨부경로 
);

create sequence s_freeboard_no; 

select s_board_no.nextval 
  from dual;
  
select * from t97_freeboard;


drop table t97_freeboard;

select no, title, id, reg_date from t97_board;

create table t97_freeboard_file(
  file_no number primary key,
  no number(6) not null,
  file_size number,
  file_org_name varchar2(100),
  file_system_name varchar2(100),
  file_path  VARCHAR2(100)  
);

create sequence s_freeboard_file_no; 
  
select * from t97_freeboard_file;
  