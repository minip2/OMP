create table t97_dictionary(
    dog_val number(6) primary key,
    version varchar2(20) primary key,
    id varchar2(30),
    detail varchar2(4000),
    mod_date date
);