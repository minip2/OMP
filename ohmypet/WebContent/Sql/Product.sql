drop table t97_Product purge;
create sequence s_Product_no;
create table t97_Product(
				product_id varchar2(300) primary key,
				no number,
				category_val number(6) not null,
				product_name VARCHAR2(300),
				quantity NUMBER,
				price NUMBER);
				
insert into t97_Product(no,
					product_id,
					category_val,
					product_name,
					quantity,
					price)
values(t97_Product.nextval,
		'A00001',
		1000,
		'된장찌개',
		9999,
		45000);
