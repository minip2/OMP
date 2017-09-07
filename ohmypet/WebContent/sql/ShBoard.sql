drop table t97_ShBoard purge;
create sequence s_ShBoard_no;
create table t97_ShBoard(
			product_id varchar2(300),
			no number primary key,
			id VARCHAR2(30),
			title VARCHAR2(1000),
			product_detail VARCHAR2(4000),
			sales_amount number default 0,
			price number,
			photo_path VARCHAR2(1000),
			sname VARCHAR2(1000),
			dname VARCHAR2(1000),
			reg_date date default sysdate);
			
insert into t97_ShBoard(product_id,
					no,
					id,
					title,
					product_detail,
					sales_amount,
					photo_path)
values('A00002',
		s_ShBoard_no.nextval,
		'freeer2',
		'찌개 팝니다',
		'사실 안팔아요',
		0,
		'data/2.jpg');
		
		select	*
		from	t97_ShBoard;