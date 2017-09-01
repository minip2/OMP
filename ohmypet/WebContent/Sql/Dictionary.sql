create table t97_dictionary (
    dog_val number(6),
    version varchar2(20),
    id varchar2(30),
    detail varchar2(4000),
    mod_date date default sysdate,
    nickname varchar2(30),
    constraint dictionaryPK primary key (dog_val, version)
);

insert into t97_dictionary
values