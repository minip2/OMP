create table t97_category_group (
    category_group number(6) primary key,
    category_group_name varchar2(50),
);

insert into t97_category_group (category_group, category_group_name)
values (1000, 'dictionary_category');
insert into t97_category_group (category_group, category_group_name)
values (2000, 'photo_category');
insert into t97_category_group (category_group, category_group_name)
values (3000, 'freeboard_category');
insert into t97_category_group (category_group, category_group_name)
values (4000, 'store_category');
insert into t97_category_group (category_group, category_group_name)
values (5000, 'css_category');
