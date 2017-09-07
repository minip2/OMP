create table t97_dictionary (
    dog_val number(6) not null,
    version number(6) default 0,
    id varchar2(30) not null,
    detail varchar2(4000),
    mod_date date default sysdate,
    nick_name varchar2(30) not null,
    constraint dictionaryPK primary key (dog_val, version)
);

insert into t97_dictionary(dog_val, id, detail, nick_name)
values(1101, 'admin', '영리하고 귀소본능이 뛰어나며 주인에게 충성심이 강한 개', 'admin');

insert into t97_dictionary(dog_val, id, detail, nick_name)
values(1102, 'admin', '영리한 푸들은 훈련을 잘 받는다.', 'admin');

insert into t97_dictionary(dog_val, id, detail, nick_name)
values(1103, 'admin', '오랜 역사를 가진 몰타섬의 공주', 'admin');

insert into t97_dictionary(dog_val, id, detail, nick_name)
values(1104, 'admin', '부드럽고 화려한 황금색 털처럼 밝은 성격의 개', 'admin');

select * from t97_dictionary;
select * from tab;
drop table t97_dictionary;

select *
  from (select *
          from t97_dictionary
         where dog_val = 1103
         order by version desc) a
 where rownum = 1;
 
 
 select dog_val, version, id, detail, mod_date, nick_name
from t97_dictionary 
where dog_val = 1102 
and version = 21; 