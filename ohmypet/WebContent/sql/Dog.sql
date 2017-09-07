create table t97_dog(
    dog_val number(6) primary key,
    detail varchar2(4000) not null,
    dog_name varchar2(100) not null,
    category_val number(6) not null,
    origin varchar2(60) not null,
    color varchar2(60) not null,
    dog_size varchar2(20) not null,
    version number(6) default 0
);

insert into t97_dog(dog_val, detail, dog_name, category_val, origin, color, dog_size)
values(1101, '영리하고 귀소본능이 뛰어나며 주인에게 충성심이 강한 개', '진돗개', 1101, '한국',
       '갈색, 흰색, 검정색', '중형');
       
insert into t97_dog(dog_val, detail, dog_name, category_val, origin, color, dog_size)
values(1102, '영리한 푸들은 훈련을 잘 받는다.', '푸들', 1102, '프랑스',
       '흰색, 갈색, 검정색', '소형, 중형');
       
insert into t97_dog(dog_val, detail, dog_name, category_val, origin, color, dog_size)
values(1103, '오랜 역사를 가진 몰타섬의 공주', '말티즈', 1103, '이탈리아',
       '흰색', '소형');
       
insert into t97_dog(dog_val, detail, dog_name, category_val, origin, color, dog_size)
values(1104, '부드럽고 화려한 황금색 털처럼 밝은 성격의 개', '골든 리트리버', 1104, '영국',
       '황금색', '대형');

select * from t97_dog;
select * from tab;
drop table t97_dog;

select * from user_sequences;
drop sequence s_dictionary_1103;




