create table t97_category (
    group_val number(6),
    category_val number(6),
    category_name varchar2(50),
    constraint categoryPK primary key (group_val, category_val);
);

