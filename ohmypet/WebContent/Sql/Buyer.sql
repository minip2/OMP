create buyer(
			product_id varchar2(300) primary key,
			category_val number(6) not null,
			product_name VARCHAR2(300),
			photo_path VARCHAR2(1000),
			quantity NUMBER,
			sales_amount NUMBER,
			save_amount NUMBER,
			price NUMBER);
				
insert into Product(product_id,
					category_val,
					product_name,
					photo_path,
					quantity,
					sales_amount,
					price)
values(A00001,
		1000,
		'된장찌개',
		'data/1.jpg',
		9999,
		0,
		45000);