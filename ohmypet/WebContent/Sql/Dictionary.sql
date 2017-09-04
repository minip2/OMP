create table t97_dictionary (
    dog_val number(6) not null,
    version number(6) default 0,
    id varchar2(30) not null,
    detail varchar2(4000),
    mod_date date default sysdate,
    nickname varchar2(30) not null,
    constraint dictionaryPK primary key (dog_val, version)
);

insert into t97_dictionary(dog_val, id, detail, nickname)
values(1101, 'administor', '영리하고 귀소본능이 뛰어나며 주인에게 충성심이 강한 개', '관리자');

insert into t97_dictionary(dog_val, id, detail, nickname)
values(1102, 'administor', '영리한 푸들은 훈련을 잘 받는다.', '관리자');

insert into t97_dictionary(dog_val, id, detail, nickname)
values(1103, 'administor', '오랜 역사를 가진 몰타섬의 공주', '관리자');

select * from t97_dictionary;
select * from tab;
drop table t97_dictionary;

select *
  from (select *
          from t97_dictionary
         where dog_val = 1103
         order by version desc) a
 where rownum = 1;
 
 
 select dog_val, version, id, detail, mod_date, nickname
from t97_dictionary 
where dog_val = 1102 
and version = 21; 