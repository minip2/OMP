create table t97_group (
    group_val number(6) primary key,
    group_name varchar2(50) not null
);

insert into t97_group (group_val, group_name)
values (1000, 'dictionary_category');
insert into t97_group (group_val, group_name)
values (2000, 'photo_category');
insert into t97_group (group_val, group_name)
values (3000, 'freeboard_category');
insert into t97_group (group_val, group_name)
values (4000, 'store_category');
insert into t97_group (group_val, group_name)
values (5000, 'css_category');

insert into t97_group (group_val, group_name)
values (1200, '색상');
insert into t97_group (group_val, group_name)
values (1300, '크기');
insert into t97_group (group_val, group_name)
values (1400, '원산지');

select * from t97_group;
select * from tab;
drop table t97_group;

