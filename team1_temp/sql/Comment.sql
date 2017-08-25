create sequence s_DictionComment_no;
-- 각 게시판마다 쓸 시퀀스 추가

create table t97_dictionary_comment (
    no number primary key,    
    reg_date date,
    content varchar2(4000),
    id varchar2(30),
    category_group number(6)
);