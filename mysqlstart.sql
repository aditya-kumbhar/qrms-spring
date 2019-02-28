/*1) Drop the existing database and create a new one*/
/*2) Run the application via STS*/
/*3) Inside terminal run this file only after running the application*/
/*	 3.1) cd into project directory*/
/*	 3.2) Type command: mysql -u username -p database_name < mysqlqrms.sql*/

use qrmsdb;

/*insert values in role table*/
insert into role values(1,'ADMIN');
insert into role values(2,'FACULTY');
insert into role values(3,'STUDENT');


/*insert values in users table*/
/*ADMIN*/
insert into user values('admin',1,'adminpccoe@gmail.com','Admin','Admin','admin');

/*STUDENT*/
insert into user values('stud1',1,'stud1@gmail.com','Student','Student','student');
insert into user values('stud2',1,'stud2@gmail.com','Student','Student','student');
insert into user values('stud3',1,'stud3@gmail.com','Student','Student','student');
insert into user values('stud4',1,'stud4@gmail.com','Student','Student','student');
insert into user values('stud5',1,'stud5@gmail.com','Student','Student','student');
insert into user values('stud6',1,'stud6@gmail.com','Student','Student','student');

/*FACULTY*/
insert into user values('fac1',1,'fac1@gmail.com','Faculty','Faculty','faculty');
insert into user values('fac2',1,'fac2@gmail.com','Faculty','Faculty','faculty');
insert into user values('fac3',1,'fac3@gmail.com','Faculty','Faculty','faculty');
insert into user values('fac4',1,'fac4@gmail.com','Faculty','Faculty','faculty');
insert into user values('fac5',1,'fac5@gmail.com','Faculty','Faculty','faculty');
insert into user values('fac6',1,'fac6@gmail.com','Faculty','Faculty','faculty');


/*insert values in user_role table*/
insert into user_role values('admin',1);
insert into user_role values('fac1',2),('fac2',2),('fac3',2),('fac4',2),('fac5',2),('fac6',2);
insert into user_role values('stud1',3),('stud2',3),('stud3',3),('stud4',3),('stud5',3),('stud6',3);


/*insert values in department table*/
INSERT INTO `department` VALUES ('CS','Computer Department'),('MH','Mechanical Department'),('EN','EnTC Department'),('IT','IT Department'),('CV','Civil Department');


/*insert values in course table*/
INSERT INTO `course` VALUES ('410252',3,'Elective 3',8,'E','BE',1,3,0,'CS'),('410253',3,'Elective 4',8,'E','BE',1,3,0,'CS');


/*insert values in electives table*/
INSERT INTO `electives` VALUES ('410252A','Adv Digital Signal Processing','410252'),('410252B','Compilers','410252'),('410252C','ERTOS','410252'),('410252D','SCOA','410252'),('410253A','Software Defined Networks','410253'),('410253B','Human Computer Interface','410253'),('410253C','Cloud Computing','410253'),('410253D','Open Elective','410253');

/*insert values in student_acad*/
insert into student_acad(user_name) values('stud1');
insert into student_acad(user_name) values('stud2');
insert into student_acad(user_name) values('stud3');
insert into student_acad(user_name) values('stud4');
insert into student_acad(user_name) values('stud5');
insert into student_acad(user_name) values('stud6');

/*update student_acad table*/
update student_acad set agg_marks=80,division="B",rollno="BECOB210",semester=8,shift=1,year="BE",dept_id="CS" where user_name="stud1";
update student_acad set agg_marks=85,division="B",rollno="BECOB211",semester=8,shift=1,year="BE",dept_id="CS" where user_name="stud2";
update student_acad set agg_marks=90,division="B",rollno="BECOB212",semester=8,shift=1,year="BE",dept_id="CS" where user_name="stud3";
update student_acad set agg_marks=95,division="B",rollno="BECOB213",semester=8,shift=1,year="BE",dept_id="CS" where user_name="stud4";
update student_acad set agg_marks=100,division="B",rollno="BECOB214",semester=8,shift=1,year="BE",dept_id="CS" where user_name="stud5";
update student_acad set agg_marks=75,division="B",rollno="BECOB215",semester=8,shift=1,year="BE",dept_id="CS" where user_name="stud6";