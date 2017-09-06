drop table t97_buyer purge;

create table t97_buyer(
			no number,
			product_id varchar2(300),
			id VARCHAR2(30),
			buys_amount NUMBER,
			buy_no varchar2(300) primary key,
			buy_date date default sysdate,
			name VARCHAR2(50),
			phon_number VARCHAR2(30),
			email VARCHAR2(200),
			address VARCHAR2(1000)
			);
			
insert into t97_buyer(no,
					product_id,
					id,
					buys_amount,
					buy_no,
					name,
					phon_number ,
					email,
					address)
					
values(1,
		'A00001',
		'freerer3',
		10,
		'B00001',
		'이호경',
		'01099218745',
		'freerer2@gmail.com',
		'집');