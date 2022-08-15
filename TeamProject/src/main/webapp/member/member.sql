create table member ( 
id varchar2 (20) not null,
pass varchar2 (30) not null,
nick varchar2 (30) not null,
email varchar2 (40)not null,
constraint member_pk primary key(id)
);

select * from member;
desc 

create table user1 (
userid varchar2(20) not null,
userpassword varchar2(65) not null,
useremail varchar2(50) not null,
useremailhash varchar2(65) not null,
useremailchecked varchar(y),
constraint user1_pk primary key(id)
);

