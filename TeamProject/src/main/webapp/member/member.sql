create table member ( 
id varchar2 (20) not null,
pass varchar2 (30) not null,
nick varchar2 (30) not null,
email varchar2 (40)not null,
constraint member_pk primary key(id)
);

select * from member;

