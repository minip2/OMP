-- 각 게시판마다 쓸 시퀀스 추가
-- create sequence s_(게시판명)_no;
create sequence s_dictionary_no;

create table t97_comment (
    no number,
    group_val number(6),
    reg_date date default sysdate,
    content varchar2(4000),
    id varchar2(30),
    nickname varchar2(30),
    constraint commentPK primary key (no, group_val)
);

select * from t97_comment;
select * from tab;
drop table t97_comment;