create database library;
use library;
create table users(id integer primary key,name varchar(30),rollno varchar(10),password varchar(10),email varchar(30));
insert into users values(5046,'madhurya','2273A05046','5046','uma@gmail.com');
insert into users values(5002,'kavya','2273A05002','5002','kavya@gmail.com');
select *from users;
create table student_details(student_id integer ,name varchar(30),course varchar(20),branch varchar(20),primary key(student_id,name));
insert into  student_details values(1,'uma','java','cse');
insert into student_details values(2,'mouni','python','cse-ai');
select *from student_details;
create table book_details(book_id integer,bookname varchar(30),author_name varchar(30),quantity integer,primary key(book_id,bookname));
insert into book_details values(1,'java','bala subramanyam',6);
insert into book_details values(2,'python','pearson',5);
select *from book_details;
create table issue_books(book_id integer,bookname varchar(30),student_id integer,student_name varchar(30),issue_date date,due_date date,status varchar(20),
foreign key(book_id) references book_details(book_id),foreign key(student_id) references student_details(student_id));
insert into issue_books values(1,'java',1,'uma','2022-11-10','2022-11-15','pending');
insert into issue_books values(1,'java',3,'uma','2022-11-10','2022-11-15','pending');
select *from issue_books;

