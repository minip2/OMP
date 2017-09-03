create table t97_category (
    group_val number(6) not null,
    category_val number(6) not null,
    category_name varchar2(50) not null,
    constraint categoryPK primary key (group_val, category_val)
);

insert into t97_category
values(1000, 1101, '진돗개');
insert into t97_category
values(1000, 1102, '푸들');
insert into t97_category
values(1000, 1103, '말티즈');

insert into t97_category
values(1200, 1201, '흰색');
insert into t97_category
values(1200, 1202, '갈색');
insert into t97_category
values(1200, 1203, '검정색');

insert into t97_category
values(1300, 1301, '대형');
insert into t97_category
values(1300, 1302, '중형');
insert into t97_category
values(1300, 1303, '소형');

insert into t97_category
values(1400, 1401, '한국');
insert into t97_category
values(1400, 1402, '프랑스');
insert into t97_category
values(1400, 1403, '이탈리아');

select * from t97_category;
select * from tab;
drop table t97_category;


