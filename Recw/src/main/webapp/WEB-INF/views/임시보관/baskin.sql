CREATE TABLE BOARD (
	board_num	number(10)	NOT NULL,
	mem_num	number(10)	NOT NULL,
	board_title	varchar2(50)	NOT NULL,
	nickname	varchar2(30)	NOT NULL,
	board_category	number(2)	NOT NULL,
	board_content	clob	NOT NULL,
	board_date	date	NOT NULL,
	board_count	number(10) DEFAULT 0	NULL,
	board_like	number(10) DEFAULT 0	NULL	
);
   
create sequence board_seq
  START WITH 1
  INCREMENT BY 1
  MAXVALUE 999999999
  MINVALUE 1
  NOCYCLE;
  
  DROP SEQUENCE seq_board;
desc board;
drop table board;