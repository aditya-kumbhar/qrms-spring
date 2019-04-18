/*1) Drop the existing database and create a new one*/
/*2) Run the application via STS*/
/*3) Inside terminal run this file only after running the application*/
/*	 3.1) cd into project directory*/
/*	 3.2) Type command: mysql -u root -p qrmsdb < mysqlstart.sql*/

use qrmsdb;

/*ROLE TABLE*/
insert into role values(1,'ADMIN');
insert into role values(2,'FACULTY');
insert into role values(3,'STUDENT');

/*USER TABLE*/
/*ADMIN*/
insert into user values('admin',1,'adminpccoe@gmail.com','Admin','Admin','admin');

/*STUDENT*/
insert into user values('stud1',1,'stud1@gmail.com','Student','Student','student');
insert into user values('stud2',1,'stud2@gmail.com','Student','Student','student');
insert into user values('stud3',1,'stud3@gmail.com','Student','Student','student');
insert into user values('stud4',1,'stud4@gmail.com','Student','Student','student');
insert into user values('stud5',1,'stud5@gmail.com','Student','Student','student');
insert into user values('stud6',1,'stud6@gmail.com','Student','Student','student');
insert into user values('stud7',1,'stud7@gmail.com','Student','Student','student');
insert into user values('stud8',1,'stud8@gmail.com','Student','Student','student');
insert into user values('stud9',1,'stud9@gmail.com','Student','Student','student');
insert into user values('stud10',1,'stud10@gmail.com','Student','Student','student');
insert into user values('stud11',1,'stud11@gmail.com','Student','Student','student');
insert into user values('stud12',1,'stud12@gmail.com','Student','Student','student');
insert into user values('stud13',1,'stud13@gmail.com','Student','Student','student');
insert into user values('stud14',1,'stud14@gmail.com','Student','Student','student');
insert into user values('stud15',1,'stud15@gmail.com','Student','Student','student');
insert into user values('stud16',1,'stud16@gmail.com','Student','Student','student');
insert into user values('stud17',1,'stud17@gmail.com','Student','Student','student');
insert into user values('stud18',1,'stud18@gmail.com','Student','Student','student');
insert into user values('stud19',1,'stud19@gmail.com','Student','Student','student');
insert into user values('stud20',1,'stud20@gmail.com','Student','Student','student');
insert into user values('stud21',1,'stud21@gmail.com','Student','Student','student');
insert into user values('stud22',1,'stud22@gmail.com','Student','Student','student');
insert into user values('stud23',1,'stud23@gmail.com','Student','Student','student');
insert into user values('stud24',1,'stud24@gmail.com','Student','Student','student');
insert into user values('stud25',1,'stud25@gmail.com','Student','Student','student');
insert into user values('stud26',1,'stud26@gmail.com','Student','Student','student');
insert into user values('stud27',1,'stud27@gmail.com','Student','Student','student');
insert into user values('stud28',1,'stud28@gmail.com','Student','Student','student');
insert into user values('stud29',1,'stud29@gmail.com','Student','Student','student');
insert into user values('stud30',1,'stud30@gmail.com','Student','Student','student');
insert into user values('stud31',1,'stud31@gmail.com','Student','Student','student');
insert into user values('stud32',1,'stud32@gmail.com','Student','Student','student');
insert into user values('stud33',1,'stud33@gmail.com','Student','Student','student');
insert into user values('stud34',1,'stud34@gmail.com','Student','Student','student');
insert into user values('stud35',1,'stud35@gmail.com','Student','Student','student');
insert into user values('stud36',1,'stud36@gmail.com','Student','Student','student');

/*FACULTY*/
insert into user values('fac1',1,'fac1@gmail.com','Rajeswari','Kannan','faculty');
insert into user values('fac2',1,'fac2@gmail.com','Anuradha','Thakare','faculty');
insert into user values('fac3',1,'fac3@gmail.com','Swati','Shinde','faculty');
insert into user values('fac4',1,'fac4@gmail.com','Pravin','Futane','faculty');
insert into user values('fac5',1,'fac5@gmail.com','Sonali','Patil','faculty');
insert into user values('fac6',1,'fac6@gmail.com','Govinda','Sambare','faculty');
insert into user values('fac7',1,'fac7@gmail.com','Reena','Kharat','faculty');
insert into user values('fac8',1,'fac8@gmail.com','Sonal','Gore','faculty');
insert into user values('fac9',1,'fac9@gmail.com','Mahalakshmi','Bodireddy','faculty');
insert into user values('fac10',1,'fac10@gmail.com','Sushma','Vispute','faculty');
insert into user values('fac11',1,'fac11@gmail.com','Shailaja','Pede','faculty');
insert into user values('fac12',1,'fac12@gmail.com','Anand','Birajdar','faculty');
insert into user values('fac13',1,'fac13@gmail.com','Rahul','Patil','faculty');
insert into user values('fac14',1,'fac14@gmail.com','Priya','Surana','faculty');
insert into user values('fac15',1,'fac15@gmail.com','Alaka','Londhe','faculty');
insert into user values('fac16',1,'fac16@gmail.com','Harshada','Mhaske','faculty');
insert into user values('fac17',1,'fac17@gmail.com','Atul','Pawar','faculty');
insert into user values('fac18',1,'fac18@gmail.com','Shrikant','Kokate','faculty');
insert into user values('fac19',1,'fac19@gmail.com','Shailesh','Hule','faculty');
insert into user values('fac20',1,'fac20@gmail.com','Snatwana','Gudadhe','faculty');
insert into user values('fac21',1,'fac21@gmail.com','Pallavi','Dhade','faculty');
insert into user values('fac22',1,'fac22@gmail.com','Rahul','Pitale','faculty');
insert into user values('fac23',1,'fac23@gmail.com','Sagar','Salunke','faculty');
insert into user values('fac24',1,'fac24@gmail.com','Rajesh','Lomate','faculty');
insert into user values('fac25',1,'fac25@gmail.com','Kapil','Tajane','faculty');
insert into user values('fac26',1,'fac26@gmail.com','Namrata','Gawande','faculty');
insert into user values('fac27',1,'fac27@gmail.com','Meghana','Lokhande','faculty');
insert into user values('fac28',1,'fac28@gmail.com','Archana','Kadam','faculty');
insert into user values('fac29',1,'fac29@gmail.com','Smita','Khairnar','faculty');
insert into user values('fac30',1,'fac30@gmail.com','Ketan','Desale','faculty');
insert into user values('fac31',1,'fac31@gmail.com','Madhura','Kalbhor','faculty');
insert into user values('fac32',1,'fac32@gmail.com','Swati','Chandurkar','faculty');
insert into user values('fac33',1,'fac33@gmail.com','Priya','Ithape','faculty');
insert into user values('fac34',1,'fac34@gmail.com','Sudeep','Thapade','faculty');
insert into user values('fac35',1,'fac35@gmail.com','Deepa','Abin','faculty');
insert into user values('fac36',1,'fac36@gmail.com','Ganesh','Deshmukh','faculty');



/*USER_ROLE TABLE*/
/*admin*/
insert into user_role values('admin',1);

/*faculties*/
insert into user_role values('fac1',2),('fac2',2),('fac3',2),('fac4',2),('fac5',2),('fac6',2);
insert into user_role values('fac7',2),('fac8',2),('fac9',2),('fac10',2),('fac11',2),('fac12',2);
insert into user_role values('fac13',2),('fac14',2),('fac15',2),('fac16',2),('fac17',2),('fac18',2);
insert into user_role values('fac19',2),('fac20',2),('fac21',2),('fac22',2),('fac23',2),('fac24',2);
insert into user_role values('fac25',2),('fac26',2),('fac27',2),('fac28',2),('fac29',2),('fac30',2);
insert into user_role values('fac31',2),('fac32',2),('fac33',2),('fac34',2),('fac35',2),('fac36',2);
insert into user_role values('fac37',2),('fac38',2),('fac39',2),('fac40',2),('fac41',2),('fac42',2);
insert into user_role values('fac43',2),('fac44',2),('fac45',2),('fac46',2),('fac47',2),('fac48',2);

/*students*/
insert into user_role values('stud1',3),('stud2',3),('stud3',3),('stud4',3),('stud5',3),('stud6',3);
insert into user_role values('stud7',3),('stud8',3),('stud9',3),('stud10',3),('stud11',3),('stud12',3);
insert into user_role values('stud13',3),('stud14',3),('stud15',3),('stud16',3),('stud17',3),('stud18',3);
insert into user_role values('stud19',3),('stud20',3),('stud21',3),('stud22',3),('stud23',3),('stud24',3);
insert into user_role values('stud25',3),('stud26',3),('stud27',3),('stud28',3),('stud29',3),('stud30',3);
insert into user_role values('stud31',3),('stud32',3),('stud33',3),('stud34',3),('stud35',3),('stud36',3);



/*DEPARTMENT TABLE*/
INSERT INTO `department` VALUES ('CO','Computer Department'),('ME','Mechanical Department'),('EN','EnTC Department'),('IT','IT Department'),('CI','Civil Department');



/*COURSE TABLE*/
/*BE sem2*/
INSERT INTO `course` VALUES ('410250',3,'Machine Learning',8,'R','BE',1,3,0,'CO');
INSERT INTO `course` VALUES ('410251',3,'Information and Cyber Security',8,'R','BE',1,3,0,'CO');
INSERT INTO `course` VALUES ('410252',3,'Elective 3',8,'E','BE',1,3,0,'CO');
INSERT INTO `course` VALUES ('410253',3,'Elective 4	',8,'E','BE',1,3,0,'CO');
-- INSERT INTO `course` VALUES ('410254',2,'Laboratory Practice 3',8,'R','BE',0,4,0,'CO');
-- INSERT INTO `course` VALUES ('410255',2,'Laboratory Practice 4',8,'E','BE',0,4,0,'CO');
INSERT INTO `course` VALUES ('410254A',1,'LP3-Machine Learning',8,'R','BE',0,2,0,'CO');
INSERT INTO `course` VALUES ('410254B',1,'LP3-Information and Cyber Security',8,'R','BE',0,2,0,'CO');
INSERT INTO `course` VALUES ('410255A',1,'LP4-Elective 3',8,'E','BE',0,2,0,'CO');
INSERT INTO `course` VALUES ('410255B',1,'LP4-Elective 4',8,'E','BE',0,2,0,'CO');

/*BE sem1*/
INSERT INTO `course` VALUES ('410241',4,'High Performance Computing',7,'R','BE',1,4,0,'CO');
INSERT INTO `course` VALUES ('410242',3,'Artificial Intelligence and Robotics',7,'R','BE',1,3,0,'CO');
INSERT INTO `course` VALUES ('410243',3,'Data Analytics',7,'R','BE',1,3,0,'CO');
INSERT INTO `course` VALUES ('410244',3,'Elective 1',7,'E','BE',1,3,0,'CO');
INSERT INTO `course` VALUES ('410245',3,'Elective 2',7,'E','BE',1,3,0,'CO');
-- INSERT INTO `course` VALUES ('410246',2,'Laboratory Practice 1',7,'R','BE',0,4,0,'CO');
-- INSERT INTO `course` VALUES ('410247',2,'Laboratory Practice 2',7,'E','BE',0,4,0,'CO');
INSERT INTO `course` VALUES ('410246A',1,'LP1-Data Analytics',7,'R','BE',0,2,0,'CO');
INSERT INTO `course` VALUES ('410246B',1,'LP1-Artificial Intelligence and Robotics',7,'R','BE',0,2,0,'CO');
INSERT INTO `course` VALUES ('410247A',1,'LP2-Elective 1',7,'E','BE',0,2,0,'CO');
INSERT INTO `course` VALUES ('410247B',1,'LP2-Elective 2',7,'E','BE',0,2,0,'CO');


/*TE sem2*/
INSERT INTO `course` VALUES ('310250',4,'Design and Analysis of Algorithms',6,'R','TE',1,4,0,'CO');
INSERT INTO `course` VALUES ('310251',4,'System Programming and Operating System',6,'R','TE',1,4,0,'CO');
INSERT INTO `course` VALUES ('310252',4,'Embedded Systems and Internet of Things',6,'R','TE',1,4,0,'CO');
INSERT INTO `course` VALUES ('310253',3,'Software Modeling and Design',6,'R','TE',1,3,0,'CO');
INSERT INTO `course` VALUES ('310254',3,'Web Technology',6,'R','TE',1,3,0,'CO');
INSERT INTO `course` VALUES ('310256',1,'Web TEchnology Lab',6,'R','TE',0,2,0,'CO');
INSERT INTO `course` VALUES ('310257',2,'SPOS Lab',6,'R','TE',0,4,0,'CO');
INSERT INTO `course` VALUES ('310258',1,'ESIOT Lab',5,'6','TE',0,2,0,'CO');

/*TE sem1*/
INSERT INTO `course` VALUES ('310241',3,'Theory of Computation',5,'R','TE',1,3,0,'CO');
INSERT INTO `course` VALUES ('310242',3,'Database Management System',5,'R','TE',1,3,0,'CO');
INSERT INTO `course` VALUES ('310243',3,'Software Engineering and Project Management',5,'R','TE',1,3,0,'CO');
INSERT INTO `course` VALUES ('310244',3,'Information Systems and Engineering Economics',5,'R','TE',1,3,0,'CO');
INSERT INTO `course` VALUES ('310245',4,'Computer Networks',5,'R','TE',1,4,0,'CO');
INSERT INTO `course` VALUES ('310246',4,'Skill Development Lab',5,'R','TE',0,4,0,'CO');
INSERT INTO `course` VALUES ('310246A',0,'Skill Development Lab (Tut)',5,'R','TE',1,2,0,'CO');
INSERT INTO `course` VALUES ('310247',2,'DBMS Lab',5,'R','TE',0,4,0,'CO');
INSERT INTO `course` VALUES ('310248',1,'CN Lab',5,'R','TE',0,2,0,'CO');

/*SE sem2*/
INSERT INTO `course` VALUES ('207003',5,'Engineering Mathematics 3',4,'R','SE',1,5,0,'CO');
INSERT INTO `course` VALUES ('210251',4,'Computer Graphics',4,'R','SE',1,4,0,'CO');
INSERT INTO `course` VALUES ('210252',4,'Advanced Data Structures',4,'R','SE',1,4,0,'CO');
INSERT INTO `course` VALUES ('210253',4,'Microprocessor',4,'R','SE',1,4,0,'CO');
INSERT INTO `course` VALUES ('210254',3,'Principles of Programming Language',4,'R','SE',1,3,0,'CO');
INSERT INTO `course` VALUES ('210255',1,'CG Lab',4,'R','SE',0,2,0,'CO');
INSERT INTO `course` VALUES ('210256',2,'ADSL Lab',4,'R','SE',0,4,0,'CO');
INSERT INTO `course` VALUES ('210257',2,'MP Lab',4,'R','SE',0,4,0,'CO');

/*SE sem1*/
INSERT INTO `course` VALUES ('210241',4,'Discrete Mathematics',3,'R','SE',1,4,0,'CO');
INSERT INTO `course` VALUES ('210242',4,'Digital Electronics and Logic Design',3,'R','SE',1,4,0,'CO');
INSERT INTO `course` VALUES ('210243',4,'Data Structures and Algorithms',3,'R','SE',1,4,0,'CO');
INSERT INTO `course` VALUES ('210244',4,'Computer Organization and Architecture',3,'R','SE',1,4,0,'CO');
INSERT INTO `course` VALUES ('210245',4,'Object Oriented Programming',3,'R','SE',1,4,0,'CO');
INSERT INTO `course` VALUES ('210246',1,'DELD Lab',3,'R','SE',0,2,0,'CO');
INSERT INTO `course` VALUES ('210247',2,'DSA Lab',3,'R','SE',0,4,0,'CO');
INSERT INTO `course` VALUES ('210248',1,'OOP Lab',3,'R','SE',0,2,0,'CO');
INSERT INTO `course` VALUES ('210249',1,'Soft Skills',3,'R','SE',0,2,0,'CO');


/*ELECTIVES TABLE*/
/*BE sem2 elective4*/
INSERT INTO `electives` VALUES ('410253A','Software Defined Networks','410253');
INSERT INTO `electives` VALUES ('410253B','Human Computer Interface','410253');
INSERT INTO `electives` VALUES ('410253C','Cloud Computing','410253');
INSERT INTO `electives` VALUES ('410253D','Open Elective','410253');

/*BE sem2 elective3*/
INSERT INTO `electives` VALUES ('410252A','Adv Digital Signal Processing','410252');
INSERT INTO `electives` VALUES ('410252B','Compilers','410252');
INSERT INTO `electives` VALUES('410252C','Embedded and Real time Operating System','410252');
INSERT INTO `electives` VALUES ('410252D','Soft Computing and Optimization Algorithms','410252');

/*BE sem1 elective2*/
INSERT INTO `electives` VALUES ('410245A','Distributed Systems','410245');
INSERT INTO `electives` VALUES ('410245B','Software Testing and Quality Assurance','410245');
INSERT INTO `electives` VALUES ('410245C','Operations Research','410245');
INSERT INTO `electives` VALUES ('410245D','Mobile Communication','410245');

/*BE sem1 elective1*/
INSERT INTO `electives` VALUES ('410244A','Digital Signal Processing','410244');
INSERT INTO `electives` VALUES ('410244B','Software Architecture and Design','410244');
INSERT INTO `electives` VALUES ('410244C','Pervasive and Ubiquitous Computing','410244');
INSERT INTO `electives` VALUES ('410244D','Data Mining and Warehousing','410244');


/*BE sem2 elective_batches -- will be populated during student allocation*/

-- SCOA(1), Compilers(1), ERTOS(1)
INSERT INTO `elective_batches` VALUES('BECOEL3-A','410252B','BE','CO');
INSERT INTO `elective_batches` VALUES('BECOEL3-B','410252C','BE','CO');
INSERT INTO `elective_batches` VALUES('BECOEL3-C','410252D','BE','CO');

-- HCI(2), CC(1)
INSERT INTO `elective_batches` VALUES('BECOEL4-A','410253B','BE','CO');
INSERT INTO `elective_batches` VALUES('BECOEL4-B','410253B','BE','CO');
INSERT INTO `elective_batches` VALUES('BECOEL4-C','410253C','BE','CO');

/*BE sem1 elective_batches*/
-- STQA(3)
INSERT INTO `elective_batches` VALUES('BECOEL1-A','410245B','BE','CO');
INSERT INTO `elective_batches` VALUES('BECOEL1-B','410245B','BE','CO');
INSERT INTO `elective_batches` VALUES('BECOEL1-C','410245B','BE','CO');
-- DMW(3)
INSERT INTO `elective_batches` VALUES('BECOEL2-A','410244D','BE','CO');
INSERT INTO `elective_batches` VALUES('BECOEL2-B','410244D','BE','CO');
INSERT INTO `elective_batches` VALUES('BECOEL2-C','410244D','BE','CO');



/*COURSE_PREREQUISITES TABLE*/
/*BE sem2*/
INSERT into course_prerequisites values ('410250',0,-1,'207003','NA');
INSERT into course_prerequisites values ('410251',0,-1,'310245','NA');
INSERT into course_prerequisites values ('410252A',1,-1,'410244A','NA');
INSERT into course_prerequisites values ('410252B',0,0,'310241','310251');
INSERT into course_prerequisites values ('410252C',0,-1,'310251','NA');
INSERT into course_prerequisites values ('410252D',0,-1,'310250','NA');
INSERT into course_prerequisites values ('410253A',0,-1,'310245','NA');
INSERT into course_prerequisites values ('410253B',0,-1,'210251','NA');
INSERT into course_prerequisites values ('410253C',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('410253D',-1,-1,'NA','NA');

/*BE sem1*/
INSERT into course_prerequisites values ('410241',0,0,'210253','210244');
INSERT into course_prerequisites values ('410242',0,-1,'210254','NA');
INSERT into course_prerequisites values ('410243',0,-1,'310242','NA');
INSERT into course_prerequisites values ('410244A',0,-1,'207003','NA');
INSERT into course_prerequisites values ('410244B',0,-1,'310243','NA');
INSERT into course_prerequisites values ('410244C',0,-1,'310245','NA');
INSERT into course_prerequisites values ('410244D',0,0,'310242','310244');
INSERT into course_prerequisites values ('410245A',0,0,'310254','210254');
INSERT into course_prerequisites values ('410245B',0,0,'310243','310263');
INSERT into course_prerequisites values ('421245C',0,0,'210241','310243');
INSERT into course_prerequisites values ('410245D',0,-1,'310245','NA');

/*TE sem2*/
INSERT into course_prerequisites values ('310250',0,0,'210243','210252');
INSERT into course_prerequisites values ('310251',0,0,'210243','210252');
INSERT into course_prerequisites values ('310252',0,-1,'310245','NA');
INSERT into course_prerequisites values ('310253',0,-1,'310243','NA');
INSERT into course_prerequisites values ('310254',0,0,'310245','310242');

/*TE sem1*/
INSERT into course_prerequisites values ('310241',0,0,'210241','210254');
INSERT into course_prerequisites values ('310242',0,0,'210243','210252');
INSERT into course_prerequisites values ('310243',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('310244',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('310245',0,-1,'210244','NA');

/*SE sem2*/
INSERT into course_prerequisites values ('207003',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('210251',0,-1,'210243','NA');
INSERT into course_prerequisites values ('210252',0,-1,'210243','NA');
INSERT into course_prerequisites values ('210253',0,-1,'210242','NA');
INSERT into course_prerequisites values ('210254',0,0,'210243','210245');

/*SE sem1*/
INSERT into course_prerequisites values ('210241',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('210242',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('210243',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('210244',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('210245',-1,-1,'NA','NA');



/*companion_course(id,course_id,companion_course) TABLE (ID,Course, Practical)*/
/*BE sem2*/
INSERT into companion_course(id,course_id,companion_course) values  (1,'410250','410254A');
INSERT into companion_course(id,course_id,companion_course) values (2,'410251','410254B');
INSERT into companion_course(id,course_id,companion_course) values (3,'410252A','410255A');
INSERT into companion_course(id,course_id,companion_course) values (4,'410252B','410255A');
INSERT into companion_course(id,course_id,companion_course) values (5,'410252C','410255A');
INSERT into companion_course(id,course_id,companion_course) values (6,'410252D','410255A');
INSERT into companion_course(id,course_id,companion_course) values (7,'410253A','410255B');
INSERT into companion_course(id,course_id,companion_course) values (8,'410253B','410255B');
INSERT into companion_course(id,course_id,companion_course) values (9,'410253C','410255B');
INSERT into companion_course(id,course_id,companion_course) values (10,'410253D','410255B');

/*BE sem1*/
INSERT into companion_course(id,course_id,companion_course) values (12,'410242','410246A');
INSERT into companion_course(id,course_id,companion_course) values (13,'410243','410246B');
INSERT into companion_course(id,course_id,companion_course) values (14,'410244A','410247A');
INSERT into companion_course(id,course_id,companion_course) values (15,'410244B','410247A');
INSERT into companion_course(id,course_id,companion_course) values (16,'410244C','410247A');
INSERT into companion_course(id,course_id,companion_course) values (17,'410244D','410247A');
INSERT into companion_course(id,course_id,companion_course) values (18,'410245A','410247B');
INSERT into companion_course(id,course_id,companion_course) values (19,'410245B','410247B');
INSERT into companion_course(id,course_id,companion_course) values (20,'421245C','410247B');
INSERT into companion_course(id,course_id,companion_course) values (21,'410245D','410247B');

/*TE sem2*/
INSERT into companion_course(id,course_id,companion_course) values (22,'310251','310257');
INSERT into companion_course(id,course_id,companion_course) values (23,'310252','310258');
INSERT into companion_course(id,course_id,companion_course) values (24,'310254','310256');
-- INSERT into companion_course(id,course_id,companion_course) values (25,'310257','310251');
-- INSERT into companion_course(id,course_id,companion_course) values (26,'310258','310252');
-- INSERT into companion_course(id,course_id,companion_course) values (27,'310256','310254');

/*TE sem1*/
INSERT into companion_course(id,course_id,companion_course) values (28,'310242','310247');
INSERT into companion_course(id,course_id,companion_course) values (29,'310245','310248');
-- INSERT into companion_course(id,course_id,companion_course) values (30,'310247','310242');
-- INSERT into companion_course(id,course_id,companion_course) values (31,'310248','310245');

/*SE sem2*/
INSERT into companion_course(id,course_id,companion_course) values (32,'210251','210255');
INSERT into companion_course(id,course_id,companion_course) values (33,'210252','210256');
INSERT into companion_course(id,course_id,companion_course) values (34,'210253','210257');
-- INSERT into companion_course(id,course_id,companion_course) values (35,'210255','210251');
-- INSERT into companion_course(id,course_id,companion_course) values (36,'210256','210252');
-- INSERT into companion_course(id,course_id,companion_course) values (37,'210257','210253');


/*SE sem1*/
INSERT into companion_course(id,course_id,companion_course) values (38,'210242','210246');
INSERT into companion_course(id,course_id,companion_course) values (39,'210243','210247');
INSERT into companion_course(id,course_id,companion_course) values (40,'210245','210248');
-- INSERT into companion_course(id,course_id,companion_course) values (41,'210246','210242');
-- INSERT into companion_course(id,course_id,companion_course) values (42,'210247','210243');
-- INSERT into companion_course(id,course_id,companion_course) values (43,'210248','210245');



/*STUDENT_ACAD TABLE*/
insert into student_acad values("stud1",80,"201",8,1,"BE","CO","BECOB","stud1");
insert into student_acad values("stud2",85,"202",8,1,"BE","CO","BECOB","stud2");
insert into student_acad values("stud3",90,"203",8,1,"BE","CO","BECOB","stud3");
insert into student_acad values("stud4",95,"204",8,1,"BE","CO","BECOB","stud4");
insert into student_acad values("stud5",70,"205",8,1,"BE","CO","BECOB","stud5");
insert into student_acad values("stud6",75,"206",8,1,"BE","CO","BECOB","stud6");
insert into student_acad values("stud7",65,"207",8,1,"BE","CO","BECOB","stud7");
insert into student_acad values("stud8",85,"208",8,1,"BE","CO","BECOB","stud8");
insert into student_acad values("stud9",90,"209",8,1,"BE","CO","BECOB","stud9");
insert into student_acad values("stud10",95,"210",8,1,"BE","CO","BECOB","stud10");
insert into student_acad values("stud11",70,"211",8,1,"BE","CO","BECOB","stud11");
insert into student_acad values("stud12",75,"212",8,1,"BE","CO","BECOB","stud12");
insert into student_acad values("stud13",80,"213",8,1,"BE","CO","BECOB","stud13");
insert into student_acad values("stud14",85,"214",8,1,"BE","CO","BECOB","stud14");
insert into student_acad values("stud15",90,"215",8,1,"BE","CO","BECOB","stud15");
insert into student_acad values("stud16",95,"216",8,1,"BE","CO","BECOB","stud16");
insert into student_acad values("stud17",70,"217",8,1,"BE","CO","BECOB","stud17");
insert into student_acad values("stud18",75,"218",8,1,"BE","CO","BECOB","stud18");
insert into student_acad values("stud19",80,"219",8,1,"BE","CO","BECOB","stud19");
insert into student_acad values("stud20",85,"220",8,1,"BE","CO","BECOB","stud20");
insert into student_acad values("stud21",90,"221",8,1,"BE","CO","BECOB","stud21");
insert into student_acad values("stud22",95,"222",8,1,"BE","CO","BECOB","stud22");
insert into student_acad values("stud23",70,"223",8,1,"BE","CO","BECOB","stud23");
insert into student_acad values("stud24",75,"224",8,1,"BE","CO","BECOB","stud24");
insert into student_acad values("stud25",80,"225",8,1,"BE","CO","BECOB","stud25");
insert into student_acad values("stud26",85,"226",8,1,"BE","CO","BECOB","stud26");
insert into student_acad values("stud27",90,"227",8,1,"BE","CO","BECOB","stud27");
insert into student_acad values("stud28",95,"228",8,1,"BE","CO","BECOB","stud28");
insert into student_acad values("stud29",70,"229",8,1,"BE","CO","BECOB","stud29");
insert into student_acad values("stud30",75,"230",8,1,"BE","CO","BECOB","stud30");
insert into student_acad values("stud31",80,"231",8,1,"BE","CO","BECOB","stud31");
insert into student_acad values("stud32",85,"232",8,1,"BE","CO","BECOB","stud32");
insert into student_acad values("stud33",90,"233",8,1,"BE","CO","BECOB","stud33");
insert into student_acad values("stud34",95,"234",8,1,"BE","CO","BECOB","stud34");
insert into student_acad values("stud35",70,"235",8,1,"BE","CO","BECOB","stud35");
insert into student_acad values("stud36",75,"236",8,1,"BE","CO","BECOB","stud36");



/*FACULTY_ACAD TABLE*/
insert into faculty_acad values('fac1','Professor','PHD',20,'CO');
insert into faculty_acad values('fac2','Professor','PHD',18.4,'CO');
insert into faculty_acad values('fac3','Professor','PHD',18.4,'CO');
insert into faculty_acad values('fac4','Professor','PHD',20,'CO');
insert into faculty_acad values('fac5','Associate Professor','PHD',15,'CO');
insert into faculty_acad values('fac6','Associate Professor','ME',25,'CO');
insert into faculty_acad values('fac7','Assistant Professor','MTECH',15.5,'CO');
insert into faculty_acad values('fac8','Assistant Professor','ME',13,'CO');
insert into faculty_acad values('fac9','Assistant Professor','ME',15,'CO');
insert into faculty_acad values('fac10','Assistant Professor','ME',14,'CO');
insert into faculty_acad values('fac11','Assistant Professor','ME',13,'CO');
insert into faculty_acad values('fac12','Assistant Professor','BE',11,'CO');
insert into faculty_acad values('fac13','Assistant Professor','ME',12.2,'CO');
insert into faculty_acad values('fac14','Assistant Professor','ME',13,'CO');
insert into faculty_acad values('fac15','Assistant Professor','ME',14.8,'CO');
insert into faculty_acad values('fac16','Assistant Professor','ME',12,'CO');
insert into faculty_acad values('fac17','Assistant Professor','ME',8.6,'CO');
insert into faculty_acad values('fac18','Assistant Professor','ME',12,'CO');
insert into faculty_acad values('fac19','Assistant Professor','ME',10.5,'CO');
insert into faculty_acad values('fac20','Assistant Professor','ME',10,'CO');
insert into faculty_acad values('fac21','Assistant Professor','ME',10,'CO');
insert into faculty_acad values('fac22','Assistant Professor','ME',5.5,'CO');
insert into faculty_acad values('fac23','Assistant Professor','ME',7.11,'CO');
insert into faculty_acad values('fac24','Assistant Professor','ME',7.6,'CO');
insert into faculty_acad values('fac25','Assistant Professor','ME',5.4,'CO');
insert into faculty_acad values('fac26','Assistant Professor','MTECH',7.5,'CO');
insert into faculty_acad values('fac27','Assistant Professor','MTECH',10,'CO');
insert into faculty_acad values('fac28','Assistant Professor','ME',13,'CO');
insert into faculty_acad values('fac29','Assistant Professor','ME',9,'CO');
insert into faculty_acad values('fac30','Assistant Professor','ME',5.2,'CO');
insert into faculty_acad values('fac31','Assistant Professor','ME',3.4,'CO');
insert into faculty_acad values('fac32','Assistant Professor','MTECH',11.6,'CO');
insert into faculty_acad values('fac33','Assistant Professor','ME',5,'CO');
insert into faculty_acad values('fac34','Professor','PHD',14.7,'CO');
insert into faculty_acad values('fac35','Assistant Professor','ME',14,'CO');
insert into faculty_acad values('fac36','Assistant Professor','ME',6.5,'CO');

/*DESIGNATION_TO_HOURS TABLE*/
insert into designation_to_hours values("Professor",10,8);
insert into designation_to_hours values("Associate Professor",14,12);
insert into designation_to_hours values("Assistant Professor",18,16);



/*DIVISIONS TABLE*/
insert into divisions values('BECOA','A',4,'BE','CO');
insert into divisions values('BECOB','B',4,'BE','CO');
insert into divisions values('BECOC','C',4,'BE','CO');
insert into divisions values('TECOA','A',4,'TE','CO');
insert into divisions values('TECOB','B',4,'TE','CO');
insert into divisions values('TECOC','C',4,'TE','CO');
insert into divisions values('SECOA','A',4,'SE','CO');
insert into divisions values('SECOB','B',4,'SE','CO');
insert into divisions values('SECOC','C',4,'SE','CO');

/*Resource Table*/

insert into resource values('CO101',80,"","101","Classroom","CO","fac1");
insert into resource values('CO111',80,"","111","Classroom","CO","fac1");
insert into resource values('CO201',80,"","201","Classroom","CO","fac1");
insert into resource values('CO202',80,"","202","Classroom","CO","fac1");
insert into resource values('CO203',80,"","203","Classroom","CO","fac1");
insert into resource values('CO204',80,"","204","Classroom","CO","fac1");
insert into resource values('CO205A',25,"",'205A',"Lab","CO","fac2");
insert into resource values('CO205B',25,"",'205B',"Lab","CO","fac3");
insert into resource values('CO205C',25,"",'205C',"Lab","CO","fac4");
insert into resource values('CO206',25,"",'206',"Lab","CO","fac5");
insert into resource values('CO207',25,"",'207',"Lab","CO","fac6");
insert into resource values('CO210',25,"",'210',"Lab","CO","fac7");
insert into resource values('CO212A',25,"",'212A',"Lab","CO","fac8");
insert into resource values('CO212B',25,"",'212B',"Lab","CO","fac9");
insert into resource values('CO212C',25,"",'212C',"Lab","CO","fac10");
insert into resource values('CO112A',25,"",'112A',"Lab","CO","fac11");
insert into resource values('CO112B',25,"",'112B',"Lab","CO","fac12");
insert into resource values('CO112C',25,"",'112C',"Lab","CO","fac13");
insert into resource values('CO007',25,"",'007',"Lab","CO","fac14");


-- fac prefs for 36 facs
INSERT INTO faculty_pref values(0,8,'410250',null,1,2,1,'fac1','BE');
INSERT INTO faculty_pref values(1,5,null,'410252B',6,6,6,'fac1','BE');
INSERT INTO faculty_pref values(2,7,'310251',null,2,4,5,'fac1','TE');
INSERT INTO faculty_pref values(3,4,'310253',null,4,4,2,'fac1','TE');
INSERT INTO faculty_pref values(4,5,'210251',null,3,8,6,'fac1','SE');
INSERT INTO faculty_pref values(5,4,'210253',null,5,1,7,'fac1','SE');
INSERT INTO faculty_pref values(6,3,null,'410253C',3,7,7,'fac2','BE');
INSERT INTO faculty_pref values(7,3,null,'410252B',5,2,7,'fac2','BE');
INSERT INTO faculty_pref values(8,2,'310253',null,2,7,3,'fac2','TE');
INSERT INTO faculty_pref values(9,2,'310254',null,4,8,8,'fac2','TE');
INSERT INTO faculty_pref values(10,8,'210254',null,6,3,3,'fac2','SE');
INSERT INTO faculty_pref values(11,2,'210251',null,1,6,6,'fac2','SE');
INSERT INTO faculty_pref values(12,5,null,'410253C',2,4,5,'fac3','BE');
INSERT INTO faculty_pref values(13,5,'410251',null,6,3,5,'fac3','BE');
INSERT INTO faculty_pref values(14,5,'310254',null,5,4,2,'fac3','TE');
INSERT INTO faculty_pref values(15,5,'310253',null,4,0,6,'fac3','TE');
INSERT INTO faculty_pref values(16,5,'210251',null,3,2,2,'fac3','SE');
INSERT INTO faculty_pref values(17,5,'210254',null,1,2,7,'fac3','SE');
INSERT INTO faculty_pref values(18,0,'410251',null,1,2,3,'fac4','BE');
INSERT INTO faculty_pref values(19,6,null,'410253C',4,6,6,'fac4','BE');
INSERT INTO faculty_pref values(20,6,'310254',null,2,8,6,'fac4','TE');
INSERT INTO faculty_pref values(21,4,'310250',null,3,3,0,'fac4','TE');
INSERT INTO faculty_pref values(22,7,'210251',null,6,8,2,'fac4','SE');
INSERT INTO faculty_pref values(23,2,'210254',null,5,7,8,'fac4','SE');
INSERT INTO faculty_pref values(24,3,null,'410253B',5,1,0,'fac5','BE');
INSERT INTO faculty_pref values(25,2,null,'410252B',1,8,4,'fac5','BE');
INSERT INTO faculty_pref values(26,5,'310250',null,3,3,2,'fac5','TE');
INSERT INTO faculty_pref values(27,4,'310253',null,6,7,5,'fac5','TE');
INSERT INTO faculty_pref values(28,6,'210251',null,2,4,7,'fac5','SE');
INSERT INTO faculty_pref values(29,3,'210254',null,4,8,7,'fac5','SE');
INSERT INTO faculty_pref values(30,7,null,'410252D',5,1,1,'fac6','BE');
INSERT INTO faculty_pref values(31,0,null,'410252B',1,1,4,'fac6','BE');
INSERT INTO faculty_pref values(32,7,'310254',null,3,0,6,'fac6','TE');
INSERT INTO faculty_pref values(33,5,'310251',null,4,8,1,'fac6','TE');
INSERT INTO faculty_pref values(34,1,'210254',null,2,4,5,'fac6','SE');
INSERT INTO faculty_pref values(35,0,'210253',null,6,3,2,'fac6','SE');
INSERT INTO faculty_pref values(36,2,'410250',null,4,5,1,'fac7','BE');
INSERT INTO faculty_pref values(37,2,null,'410253C',5,0,6,'fac7','BE');
INSERT INTO faculty_pref values(38,6,'310254',null,1,6,1,'fac7','TE');
INSERT INTO faculty_pref values(39,5,'310250',null,2,5,4,'fac7','TE');
INSERT INTO faculty_pref values(40,7,'210254',null,3,5,0,'fac7','SE');
INSERT INTO faculty_pref values(41,0,'210253',null,6,8,0,'fac7','SE');
INSERT INTO faculty_pref values(42,5,'410251',null,1,2,4,'fac8','BE');
INSERT INTO faculty_pref values(43,2,'410250',null,5,3,8,'fac8','BE');
INSERT INTO faculty_pref values(44,1,'310251',null,3,6,8,'fac8','TE');
INSERT INTO faculty_pref values(45,0,'310250',null,2,4,6,'fac8','TE');
INSERT INTO faculty_pref values(46,4,'210253',null,4,0,3,'fac8','SE');
INSERT INTO faculty_pref values(47,1,'210251',null,6,0,4,'fac8','SE');
INSERT INTO faculty_pref values(48,3,null,'410253C',6,4,6,'fac9','BE');
INSERT INTO faculty_pref values(49,6,null,'410252D',1,3,6,'fac9','BE');
INSERT INTO faculty_pref values(50,6,'310253',null,2,8,8,'fac9','TE');
INSERT INTO faculty_pref values(51,6,'310250',null,3,0,1,'fac9','TE');
INSERT INTO faculty_pref values(52,4,'210253',null,5,6,2,'fac9','SE');
INSERT INTO faculty_pref values(53,6,'210251',null,4,7,0,'fac9','SE');
INSERT INTO faculty_pref values(54,8,null,'410253C',2,3,2,'fac10','BE');
INSERT INTO faculty_pref values(55,5,'410251',null,3,2,7,'fac10','BE');
INSERT INTO faculty_pref values(56,2,'310251',null,4,7,4,'fac10','TE');
INSERT INTO faculty_pref values(57,4,'310250',null,1,1,2,'fac10','TE');
INSERT INTO faculty_pref values(58,4,'210254',null,5,2,2,'fac10','SE');
INSERT INTO faculty_pref values(59,7,'210253',null,6,2,7,'fac10','SE');
INSERT INTO faculty_pref values(60,3,'410251',null,4,3,7,'fac11','BE');
INSERT INTO faculty_pref values(61,5,'410250',null,3,6,3,'fac11','BE');
INSERT INTO faculty_pref values(62,1,'310250',null,6,2,3,'fac11','TE');
INSERT INTO faculty_pref values(63,3,'310253',null,2,5,8,'fac11','TE');
INSERT INTO faculty_pref values(64,7,'210254',null,5,1,6,'fac11','SE');
INSERT INTO faculty_pref values(65,0,'210251',null,1,3,8,'fac11','SE');
INSERT INTO faculty_pref values(66,0,'410251',null,2,6,5,'fac12','BE');
INSERT INTO faculty_pref values(67,4,null,'410253B',4,2,4,'fac12','BE');
INSERT INTO faculty_pref values(68,2,'310253',null,3,6,2,'fac12','TE');
INSERT INTO faculty_pref values(69,1,'310251',null,6,1,2,'fac12','TE');
INSERT INTO faculty_pref values(70,5,'210253',null,5,4,6,'fac12','SE');
INSERT INTO faculty_pref values(71,8,'210251',null,1,7,1,'fac12','SE');
INSERT INTO faculty_pref values(72,1,null,'410252D',6,0,1,'fac13','BE');
INSERT INTO faculty_pref values(73,5,null,'410253B',4,8,1,'fac13','BE');
INSERT INTO faculty_pref values(74,8,'310253',null,3,0,0,'fac13','TE');
INSERT INTO faculty_pref values(75,5,'310250',null,1,2,6,'fac13','TE');
INSERT INTO faculty_pref values(76,8,'210251',null,2,7,8,'fac13','SE');
INSERT INTO faculty_pref values(77,7,'210254',null,5,1,7,'fac13','SE');
INSERT INTO faculty_pref values(78,7,'410251',null,3,6,8,'fac14','BE');
INSERT INTO faculty_pref values(79,2,null,'410252D',2,0,1,'fac14','BE');
INSERT INTO faculty_pref values(80,4,'310251',null,1,5,8,'fac14','TE');
INSERT INTO faculty_pref values(81,6,'310254',null,5,8,0,'fac14','TE');
INSERT INTO faculty_pref values(82,4,'210254',null,6,5,3,'fac14','SE');
INSERT INTO faculty_pref values(83,1,'210253',null,4,0,4,'fac14','SE');
INSERT INTO faculty_pref values(84,0,null,'410253B',6,0,5,'fac15','BE');
INSERT INTO faculty_pref values(85,0,null,'410252B',1,4,6,'fac15','BE');
INSERT INTO faculty_pref values(86,6,'310251',null,2,2,4,'fac15','TE');
INSERT INTO faculty_pref values(87,6,'310250',null,5,2,3,'fac15','TE');
INSERT INTO faculty_pref values(88,5,'210254',null,3,8,2,'fac15','SE');
INSERT INTO faculty_pref values(89,8,'210253',null,4,3,1,'fac15','SE');
INSERT INTO faculty_pref values(90,0,'410251',null,1,4,2,'fac16','BE');
INSERT INTO faculty_pref values(91,6,null,'410252D',4,8,8,'fac16','BE');
INSERT INTO faculty_pref values(92,1,'310251',null,5,3,6,'fac16','TE');
INSERT INTO faculty_pref values(93,4,'310254',null,3,0,1,'fac16','TE');
INSERT INTO faculty_pref values(94,2,'210254',null,2,8,0,'fac16','SE');
INSERT INTO faculty_pref values(95,3,'210251',null,6,1,0,'fac16','SE');
INSERT INTO faculty_pref values(96,8,null,'410252D',3,1,7,'fac17','BE');
INSERT INTO faculty_pref values(97,7,'410251',null,5,1,2,'fac17','BE');
INSERT INTO faculty_pref values(98,0,'310251',null,1,4,6,'fac17','TE');
INSERT INTO faculty_pref values(99,5,'310254',null,4,5,0,'fac17','TE');
INSERT INTO faculty_pref values(100,4,'210251',null,6,6,3,'fac17','SE');
INSERT INTO faculty_pref values(101,6,'210253',null,2,1,3,'fac17','SE');
INSERT INTO faculty_pref values(102,7,null,'410252B',1,2,3,'fac18','BE');
INSERT INTO faculty_pref values(103,0,'410250',null,2,4,2,'fac18','BE');
INSERT INTO faculty_pref values(104,2,'310250',null,6,4,8,'fac18','TE');
INSERT INTO faculty_pref values(105,4,'310251',null,4,2,7,'fac18','TE');
INSERT INTO faculty_pref values(106,3,'210251',null,3,2,7,'fac18','SE');
INSERT INTO faculty_pref values(107,0,'210253',null,5,4,0,'fac18','SE');
INSERT INTO faculty_pref values(108,5,null,'410253C',4,2,1,'fac19','BE');
INSERT INTO faculty_pref values(109,4,'410251',null,3,3,5,'fac19','BE');
INSERT INTO faculty_pref values(110,6,'310250',null,2,8,8,'fac19','TE');
INSERT INTO faculty_pref values(111,3,'310253',null,5,3,4,'fac19','TE');
INSERT INTO faculty_pref values(112,7,'210251',null,6,7,5,'fac19','SE');
INSERT INTO faculty_pref values(113,8,'210253',null,1,7,0,'fac19','SE');
INSERT INTO faculty_pref values(114,7,'410251',null,2,2,8,'fac20','BE');
INSERT INTO faculty_pref values(115,8,'410250',null,1,6,6,'fac20','BE');
INSERT INTO faculty_pref values(116,1,'310253',null,3,0,4,'fac20','TE');
INSERT INTO faculty_pref values(117,8,'310251',null,4,2,2,'fac20','TE');
INSERT INTO faculty_pref values(118,3,'210254',null,5,2,4,'fac20','SE');
INSERT INTO faculty_pref values(119,6,'210251',null,6,5,3,'fac20','SE');
INSERT INTO faculty_pref values(120,5,null,'410253C',1,1,4,'fac21','BE');
INSERT INTO faculty_pref values(121,8,null,'410252B',4,7,2,'fac21','BE');
INSERT INTO faculty_pref values(122,8,'310251',null,2,7,6,'fac21','TE');
INSERT INTO faculty_pref values(123,7,'310250',null,6,1,3,'fac21','TE');
INSERT INTO faculty_pref values(124,2,'210254',null,5,8,7,'fac21','SE');
INSERT INTO faculty_pref values(125,7,'210253',null,3,1,8,'fac21','SE');
INSERT INTO faculty_pref values(126,4,'410250',null,1,6,8,'fac22','BE');
INSERT INTO faculty_pref values(127,7,'410251',null,3,4,4,'fac22','BE');
INSERT INTO faculty_pref values(128,1,'310253',null,4,3,1,'fac22','TE');
INSERT INTO faculty_pref values(129,5,'310254',null,5,2,7,'fac22','TE');
INSERT INTO faculty_pref values(130,4,'210254',null,2,1,1,'fac22','SE');
INSERT INTO faculty_pref values(131,2,'210251',null,6,5,8,'fac22','SE');
INSERT INTO faculty_pref values(132,0,'410251',null,2,4,1,'fac23','BE');
INSERT INTO faculty_pref values(133,3,null,'410252B',3,4,2,'fac23','BE');
INSERT INTO faculty_pref values(134,8,'310253',null,1,2,0,'fac23','TE');
INSERT INTO faculty_pref values(135,6,'310254',null,6,3,2,'fac23','TE');
INSERT INTO faculty_pref values(136,1,'210254',null,5,7,8,'fac23','SE');
INSERT INTO faculty_pref values(137,7,'210251',null,4,0,4,'fac23','SE');
INSERT INTO faculty_pref values(138,2,null,'410253C',2,4,2,'fac24','BE');
INSERT INTO faculty_pref values(139,3,null,'410253B',1,7,3,'fac24','BE');
INSERT INTO faculty_pref values(140,3,'310251',null,4,0,2,'fac24','TE');
INSERT INTO faculty_pref values(141,6,'310253',null,5,8,0,'fac24','TE');
INSERT INTO faculty_pref values(142,6,'210253',null,6,4,0,'fac24','SE');
INSERT INTO faculty_pref values(143,3,'210254',null,3,6,8,'fac24','SE');
INSERT INTO faculty_pref values(144,3,'410250',null,5,4,2,'fac25','BE');
INSERT INTO faculty_pref values(145,7,null,'410253B',4,8,3,'fac25','BE');
INSERT INTO faculty_pref values(146,0,'310250',null,3,5,4,'fac25','TE');
INSERT INTO faculty_pref values(147,3,'310254',null,1,7,5,'fac25','TE');
INSERT INTO faculty_pref values(148,8,'210251',null,6,0,3,'fac25','SE');
INSERT INTO faculty_pref values(149,7,'210253',null,2,0,3,'fac25','SE');
INSERT INTO faculty_pref values(150,3,null,'410253C',6,8,8,'fac26','BE');
INSERT INTO faculty_pref values(151,5,'410250',null,4,2,7,'fac26','BE');
INSERT INTO faculty_pref values(152,7,'310254',null,3,7,5,'fac26','TE');
INSERT INTO faculty_pref values(153,2,'310251',null,1,4,1,'fac26','TE');
INSERT INTO faculty_pref values(154,8,'210253',null,2,7,2,'fac26','SE');
INSERT INTO faculty_pref values(155,5,'210251',null,5,6,1,'fac26','SE');
INSERT INTO faculty_pref values(156,8,null,'410252B',4,6,0,'fac27','BE');
INSERT INTO faculty_pref values(157,1,null,'410252D',5,6,1,'fac27','BE');
INSERT INTO faculty_pref values(158,2,'310250',null,6,0,4,'fac27','TE');
INSERT INTO faculty_pref values(159,7,'310253',null,3,7,1,'fac27','TE');
INSERT INTO faculty_pref values(160,4,'210253',null,1,0,7,'fac27','SE');
INSERT INTO faculty_pref values(161,5,'210254',null,2,4,5,'fac27','SE');
INSERT INTO faculty_pref values(162,5,null,'410252B',4,7,8,'fac28','BE');
INSERT INTO faculty_pref values(163,2,null,'410252D',1,7,7,'fac28','BE');
INSERT INTO faculty_pref values(164,1,'310251',null,3,3,1,'fac28','TE');
INSERT INTO faculty_pref values(165,4,'310250',null,5,3,8,'fac28','TE');
INSERT INTO faculty_pref values(166,1,'210254',null,6,0,0,'fac28','SE');
INSERT INTO faculty_pref values(167,8,'210253',null,2,8,3,'fac28','SE');
INSERT INTO faculty_pref values(168,7,'410251',null,6,1,5,'fac29','BE');
INSERT INTO faculty_pref values(169,7,'410250',null,3,7,1,'fac29','BE');
INSERT INTO faculty_pref values(170,0,'310250',null,1,5,7,'fac29','TE');
INSERT INTO faculty_pref values(171,8,'310253',null,5,2,2,'fac29','TE');
INSERT INTO faculty_pref values(172,2,'210254',null,4,2,2,'fac29','SE');
INSERT INTO faculty_pref values(173,4,'210251',null,2,1,1,'fac29','SE');
INSERT INTO faculty_pref values(174,4,'410250',null,6,5,6,'fac30','BE');
INSERT INTO faculty_pref values(175,6,null,'410252B',2,7,2,'fac30','BE');
INSERT INTO faculty_pref values(176,8,'310254',null,5,2,7,'fac30','TE');
INSERT INTO faculty_pref values(177,6,'310251',null,4,8,5,'fac30','TE');
INSERT INTO faculty_pref values(178,2,'210251',null,1,8,0,'fac30','SE');
INSERT INTO faculty_pref values(179,1,'210254',null,3,6,6,'fac30','SE');
INSERT INTO faculty_pref values(180,3,'410251',null,4,6,3,'fac31','BE');
INSERT INTO faculty_pref values(181,1,null,'410252B',5,5,4,'fac31','BE');
INSERT INTO faculty_pref values(182,8,'310254',null,3,8,1,'fac31','TE');
INSERT INTO faculty_pref values(183,7,'310250',null,6,2,7,'fac31','TE');
INSERT INTO faculty_pref values(184,1,'210251',null,2,6,6,'fac31','SE');
INSERT INTO faculty_pref values(185,4,'210254',null,1,5,2,'fac31','SE');
INSERT INTO faculty_pref values(186,6,'410251',null,5,7,8,'fac32','BE');
INSERT INTO faculty_pref values(187,8,null,'410252D',3,0,7,'fac32','BE');
INSERT INTO faculty_pref values(188,5,'310250',null,1,4,3,'fac32','TE');
INSERT INTO faculty_pref values(189,6,'310251',null,6,6,3,'fac32','TE');
INSERT INTO faculty_pref values(190,6,'210251',null,2,0,1,'fac32','SE');
INSERT INTO faculty_pref values(191,2,'210253',null,4,6,8,'fac32','SE');
INSERT INTO faculty_pref values(192,3,null,'410253C',3,6,5,'fac33','BE');
INSERT INTO faculty_pref values(193,4,null,'410252D',2,1,2,'fac33','BE');
INSERT INTO faculty_pref values(194,6,'310254',null,6,6,6,'fac33','TE');
INSERT INTO faculty_pref values(195,6,'310250',null,1,0,1,'fac33','TE');
INSERT INTO faculty_pref values(196,1,'210253',null,4,8,0,'fac33','SE');
INSERT INTO faculty_pref values(197,6,'210254',null,5,2,3,'fac33','SE');
INSERT INTO faculty_pref values(198,7,null,'410253B',5,0,1,'fac34','BE');
INSERT INTO faculty_pref values(199,3,'410251',null,4,7,5,'fac34','BE');
INSERT INTO faculty_pref values(200,3,'310250',null,3,0,7,'fac34','TE');
INSERT INTO faculty_pref values(201,3,'310251',null,1,0,0,'fac34','TE');
INSERT INTO faculty_pref values(202,2,'210251',null,6,8,1,'fac34','SE');
INSERT INTO faculty_pref values(203,2,'210254',null,2,4,3,'fac34','SE');
INSERT INTO faculty_pref values(204,6,'410250',null,2,5,5,'fac35','BE');
INSERT INTO faculty_pref values(205,7,null,'410252D',5,6,8,'fac35','BE');
INSERT INTO faculty_pref values(206,3,'310250',null,4,8,1,'fac35','TE');
INSERT INTO faculty_pref values(207,5,'310251',null,3,0,4,'fac35','TE');
INSERT INTO faculty_pref values(208,6,'210254',null,6,0,0,'fac35','SE');
INSERT INTO faculty_pref values(209,3,'210251',null,1,6,3,'fac35','SE');
INSERT INTO faculty_pref values(210,4,null,'410252B',5,3,7,'fac36','BE');
INSERT INTO faculty_pref values(211,7,null,'410253B',1,2,8,'fac36','BE');
INSERT INTO faculty_pref values(212,6,'310254',null,4,3,3,'fac36','TE');
INSERT INTO faculty_pref values(213,8,'310253',null,3,2,2,'fac36','TE');
INSERT INTO faculty_pref values(214,5,'210254',null,6,5,5,'fac36','SE');
INSERT INTO faculty_pref values(215,8,'210253',null,2,4,6,'fac36','SE');
