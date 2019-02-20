/*1) Drop the existing database and create a new one*/
/*2) Run the application via STS*/
/*3) Inside terminal run this file only after running the application*/
/*	 3.1) cd into project directory*/
/*	 3.2) Type command: mysql -u username -p database_name < mysqlqrms.sql*/

use qrmsdb;

/*insert data into deoartment table*/
insert into department values("CS","Computer Department");
insert into department values("MH","Mechanical Department");
insert into department values("EN","EnTC Department");
insert into department values("IT","IT Department");
insert into department values("CV","Civil Department");

/*create admin*/
insert into user values('admin',1,'adminpccoe@gmail.com','Admin','Admin','admin');

/*insert values in role table*/
insert into role values(1,'ADMIN');
insert into role values(2,'FACULTY');
insert into role values(3,'STUDENT');

/*insert values in user_role table*/
insert into user_role values('admin',1);


/*
update student_acad set agg_marks=80,division="B",rollno="BECOB210",semester=8,shift=1,year=4,dept_id="CS" where user_name="bharatik";
insert into course(course_id,course_name,course_sem,course_year,course_type,dept_id) values("MLCSBE","Machine Learning",8,"BE","E","CS");
insert into course(course_id,course_name,course_sem,course_year,course_type,dept_id) values("DMCSBE","Data Mining",8,"BE","E","CS");
insert into course(course_id,course_name,course_sem,course_year,course_type,dept_id) values("SCCSBE","Soft Computing",8,"BE","E","CS");
insert into course(course_id,course_name,course_sem,course_year,course_type,dept_id) values("CCCSBE","Cloud Computing",8,"BE","E","CS");
*/

/*For updating student acad details (change username)
update student_acad set agg_marks=80,division="B",rollno="BECOB210",semester=8,shift=1,year='BE',dept_id="CS" where user_name="bharatik";
*/
