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

/*FACULTY*/
insert into user values('fac1',1,'fac1@gmail.com','Rajeswari','Kannan','faculty');
insert into user values('fac2',1,'fac2@gmail.com','Anuradha','Thakare','faculty');
insert into user values('fac3',1,'fac351@gmail.com','Swati','Shinde','faculty');
insert into user values('fac4',1,'fac4@gmail.com','Anagha','Chaudhari','faculty');
insert into user values('fac5',1,'fac5@gmail.com','Janhavi','Gudsoorkar','faculty');
insert into user values('fac6',1,'fac6@gmail.com','Govinda','Sambare','faculty');
insert into user values('fac7',1,'fac7@gmail.com','Reena','Kharat','faculty');
insert into user values('fac8',1,'fac8@gmail.com','Sonal','Gore','faculty');
insert into user values('fac9',1,'fac9@gmail.com','Mahalakshmi','Bodireddy','faculty');
insert into user values('fac10',1,'fac10@gmail.com','Sushma','Vispute','faculty');
insert into user values('fac11',1,'fac11@gmail.com','Shailaja','Pede','faculty');
insert into user values('fac12',1,'fac12@gmail.com','Anand','Birajdar','faculty');
insert into user values('fac13',1,'fac13@gmail.com','Rahul','Patil','faculty');
insert into user values('fac14',1,'fac14@gmail.com','Priya','Surana','faculty');
insert into user values('fac15',1,'fac15@gmail.com','Alka','Londhe','faculty');
insert into user values('fac16',1,'fac16@gmail.com','Harshada','Mhaske','faculty');
insert into user values('fac17',1,'fac17@gmail.com','Atul','Pawar','faculty');
insert into user values('fac18',1,'fac18@gmail.com','Shrikant','Kokate','faculty');
insert into user values('fac19',1,'fac19@gmail.com','Shailesh','Hule','faculty');
insert into user values('fac20',1,'fac20@gmail.com','Santwana','Gudadhe','faculty');
insert into user values('fac21',1,'fac21@gmail.com','Pallavi','Dhade','faculty');
insert into user values('fac22',1,'fac22@gmail.com','Rahul','Pitale','faculty');
insert into user values('fac23',1,'fac23@gmail.com','Sagar','Salunke','faculty');
insert into user values('fac24',1,'fac24@gmail.com','Rajesh','Lomte','faculty');
insert into user values('fac25',1,'fac25@gmail.com','Kapil','Tajane','faculty');
insert into user values('fac26',1,'fac26@gmail.com','Namrata','Gawande','faculty');
insert into user values('fac27',1,'fac27@gmail.com','Meghana','Lokhande','faculty');
insert into user values('fac28',1,'fac28@gmail.com','Archana','Kadam','faculty');
insert into user values('fac29',1,'fac29@gmail.com','Smita','Khairnar','faculty');
insert into user values('fac30',1,'fac30@gmail.com','Ketan','Desale','faculty');
insert into user values('fac31',1,'fac31@gmail.com','Madhura','Kalbhor','faculty');
insert into user values('fac32',1,'fac32@gmail.com','Swati','Chandurkar','faculty');
insert into user values('fac33',1,'fac33@gmail.com','Priya','Ithape','faculty');
insert into user values('fac34',1,'fac34@gmail.com','Sudeep','Thepade','faculty');
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


/*DEPARTMENT TABLE*/
INSERT INTO `department` VALUES ('CO','Computer Department'),('ME','Mechanical Department'),('EN','EnTC Department'),('IT','IT Department'),('CI','Civil Department');

/*COURSE TABLE*/
/*ME sem3*/
INSERT INTO `course` VALUES ('610101',4,'Fault Tolerant Systems',3,'R','ME2',1,4,0,'CO');
INSERT INTO `course` VALUES ('610102',4,'Information Retrieval',3,'R','ME2',1,4,0,'CO');
INSERT INTO `course` VALUES ('610103',5,'Elective 3',3,'E','ME2',1,5,0,'CO');

/*ME sem2*/
INSERT INTO `course` VALUES ('510108',4,'Operations Research',2,'R','ME1',1,4,0,'CO');
INSERT INTO `course` VALUES ('510109',4,'System Simulation and Modeling',2,'R','ME1',1,5,0,'CO');
INSERT INTO `course` VALUES ('510110',4,'Machine Learning',2,'R','ME1',1,4,0,'CO');
INSERT INTO `course` VALUES ('510111',5,'Elective 2',2,'E','ME1',1,5,0,'CO');


INSERT INTO `course` VALUES ('510113',4,'LP-2',2,'R','ME1',0,4,0,'CO');


/*ME sem1*/
INSERT INTO `course` VALUES ('510101',4,'Research Methodology',1,'R','ME1',1,5,0,'CO');
INSERT INTO `course` VALUES ('510102',4,'Bio-Inspired Optimization Algorithms',1,'R','ME1',1,5,0,'CO');
INSERT INTO `course` VALUES ('510103',4,'Software Development and Version Control',1,'R','ME1',1,5,0,'CO');
INSERT INTO `course` VALUES ('510104',4,'Embedded and Real Time Operating Systems',1,'R','ME1',1,5,0,'CO');
INSERT INTO `course` VALUES ('510105',5,'Elective 1',1,'E','ME1',1,6,0,'CO');

INSERT INTO `course` VALUES ('510106A',4,'LP1-Research Methodology',1,'R','ME1',0,2,0,'CO');
INSERT INTO `course` VALUES ('510106B',4,'LP1-Bio-Inspired Optimization Algorithms',1,'R','ME1',0,2,0,'CO');
INSERT INTO `course` VALUES ('510106C',4,'LP1-Software Development and Version Control',1,'R','ME1',0,2,0,'CO');
INSERT INTO `course` VALUES ('510106D',4,'LP1-Research Methodology',1,'R','ME1',0,2,0,'CO');

/*BE sem2*/
INSERT INTO `course` VALUES ('410250',3,'Machine Learning',8,'R','BE',1,3,0,'CO');
INSERT INTO `course` VALUES ('410251',3,'Information and Cyber Security',8,'R','BE',1,3,0,'CO');
INSERT INTO `course` VALUES ('410252',3,'Elective 3',8,'E','BE',1,3,0,'CO');
INSERT INTO `course` VALUES ('410253',3,'Elective 4',8,'E','BE',1,3,0,'CO');
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
INSERT INTO `course` VALUES ('310258',1,'ESIOT Lab',5,'R','TE',0,2,0,'CO');

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
/*ME sem3 elective3*/
INSERT INTO `electives` VALUES ('610103A','Cloud Security','610103');
INSERT INTO `electives` VALUES ('610103B','Speech Signal Processing','610103');
INSERT INTO `electives` VALUES ('610103C','Mobile Ad-hoc Networks','610103');
INSERT INTO `electives` VALUES ('610103D','Pattern Recognition','610103');
INSERT INTO `electives` VALUES ('610103E','Open Elective','610103');

/*ME sem2 elective2*/
INSERT INTO `electives` VALUES ('510111A','Image Processing','510111');
INSERT INTO `electives` VALUES ('510111B','Web Mining','510111');
INSERT INTO `electives` VALUES ('510111C','Pervasive and Ubiquitous Computing','510111');
INSERT INTO `electives` VALUES ('510111D','Network Security','510111');
INSERT INTO `electives` VALUES ('510111E','Open Elective','510111');

/*ME sem1 elective1*/
INSERT INTO `electives` VALUES ('510105A','Advanced Digital Signal Processing','510105');
INSERT INTO `electives` VALUES ('510105B','Data Mining','510105');
INSERT INTO `electives` VALUES ('510105C','Network Design and Analysis','510105');
INSERT INTO `electives` VALUES ('510105D','Data Algorithms','510105');
INSERT INTO `electives` VALUES ('510105E','Open Elective','510105');

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
/*INSERT INTO `elective_batches` VALUES('410252B-1','410252B','BE','CO');
INSERT INTO `elective_batches` VALUES('410252C-1','410252C','BE','CO');
INSERT INTO `elective_batches` VALUES('410252D-1','410252D','BE','CO');

-- HCI(2), CC(1)
INSERT INTO `elective_batches` VALUES('410253B-1','410253B','BE','CO');
INSERT INTO `elective_batches` VALUES('410253B-2','410253B','BE','CO');
INSERT INTO `elective_batches` VALUES('410253C-1','410253C','BE','CO');
*/
/*BE sem1 elective_batches*/
-- STQA(3)
/*
INSERT INTO `elective_batches` VALUES('410245B-1','410245B','BE','CO');
INSERT INTO `elective_batches` VALUES('410245B-2','410245B','BE','CO');
INSERT INTO `elective_batches` VALUES('410245B-3','410245B','BE','CO');

-- DMW(3)
INSERT INTO `elective_batches` VALUES('410244D-1','410244D','BE','CO');
INSERT INTO `elective_batches` VALUES('410244D-2','410244D','BE','CO');
INSERT INTO `elective_batches` VALUES('410244D-3','410244D','BE','CO');
*/


/*COURSE_PREREQUISITES TABLE*/
/*ME sem3*/
INSERT into course_prerequisites values ('610101',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('610102',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('610103A',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('610103B',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('610103C',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('610103D',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('610103E',-1,-1,'NA','NA');

/*ME sem2*/
INSERT into course_prerequisites values ('510107',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510108',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510109',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510110A',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510110B',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510110C',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510110D',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510110E',-1,-1,'NA','NA');

/*ME sem1*/
INSERT into course_prerequisites values ('510101',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510102',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510103',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510104',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510105A',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510105B',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510105C',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510105D',-1,-1,'NA','NA');
INSERT into course_prerequisites values ('510105E',-1,-1,'NA','NA');

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
INSERT into course_prerequisites values ('410245B',0,0,'310243','310253');
INSERT into course_prerequisites values ('410245C',0,0,'210241','310243');
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



/*ME1 sem1*/
INSERT into companion_course(id,course_id,companion_course) values  (44,'510101','510106A');
INSERT into companion_course(id,course_id,companion_course) values (45,'510102','510106B');
INSERT into companion_course(id,course_id,companion_course) values (46,'510103','510106C');
INSERT into companion_course(id,course_id,companion_course) values (47,'510104','510106D');

/*BE sem2*/
INSERT into companion_course(id,course_id,companion_course) values  (1,'410250','410254A');
INSERT into companion_course(id,course_id,companion_course) values (2,'410251','410254B');
/*INSERT into companion_course(id,course_id,companion_course) values (3,'410252A','410255A');
INSERT into companion_course(id,course_id,companion_course) values (4,'410252B','410255A');
INSERT into companion_course(id,course_id,companion_course) values (5,'410252C','410255A');
INSERT into companion_course(id,course_id,companion_course) values (6,'410252D','410255A');
INSERT into companion_course(id,course_id,companion_course) values (7,'410253A','410255B');
INSERT into companion_course(id,course_id,companion_course) values (8,'410253B','410255B');
INSERT into companion_course(id,course_id,companion_course) values (9,'410253C','410255B');
INSERT into companion_course(id,course_id,companion_course) values (10,'410253D','410255B');
*/
INSERT into companion_course(id,course_id,companion_course) values (10,'410253','410255B');
INSERT into companion_course(id,course_id,companion_course) values (11,'410252','410255A');

/*BE sem1*/
INSERT into companion_course(id,course_id,companion_course) values (12,'410242','410246A');

INSERT into companion_course(id,course_id,companion_course) values (13,'410243','410246B');
INSERT into companion_course(id,course_id,companion_course) values (14,'410244A','410247A');
INSERT into companion_course(id,course_id,companion_course) values (15,'410244B','410247A');
INSERT into companion_course(id,course_id,companion_course) values (16,'410244C','410247A');
INSERT into companion_course(id,course_id,companion_course) values (17,'410244D','410247A');
INSERT into companion_course(id,course_id,companion_course) values (18,'410245A','410247B');
INSERT into companion_course(id,course_id,companion_course) values (19,'410245B','410247B');
INSERT into companion_course(id,course_id,companion_course) values (20,'410245C','410247B');
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


/*FACULTY_ACAD TABLE*/
insert into faculty_acad values('fac1','Professor','PHD',20,'CO','fac1');
insert into faculty_acad values('fac2','Professor','PHD',18.4,'CO','fac2');
insert into faculty_acad values('fac3','Professor','PHD',18.4,'CO','fac3');
insert into faculty_acad values('fac4','Assistant Professor','ME',8,'CO','fac4');
insert into faculty_acad values('fac5','Assistant Professor','ME',0,'CO','fac5');
insert into faculty_acad values('fac6','Associate Professor','ME',25,'CO','fac6');
insert into faculty_acad values('fac7','Assistant Professor','MTECH',15.5,'CO','fac7');
insert into faculty_acad values('fac8','Assistant Professor','ME',13,'CO','fac8');
insert into faculty_acad values('fac9','Assistant Professor','ME',15,'CO','fac9');
insert into faculty_acad values('fac10','Assistant Professor','ME',14,'CO','fac10');
insert into faculty_acad values('fac11','Assistant Professor','ME',13,'CO','fac11');
insert into faculty_acad values('fac12','Assistant Professor','BE',11,'CO','fac12');
insert into faculty_acad values('fac13','Assistant Professor','ME',12.2,'CO','fac13');
insert into faculty_acad values('fac14','Assistant Professor','ME',13,'CO','fac14');
insert into faculty_acad values('fac15','Assistant Professor','ME',14.8,'CO','fac15');
insert into faculty_acad values('fac16','Assistant Professor','ME',12,'CO','fac16');
insert into faculty_acad values('fac17','Assistant Professor','ME',8.6,'CO','fac17');
insert into faculty_acad values('fac18','Assistant Professor','ME',12,'CO','fac18');
insert into faculty_acad values('fac19','Assistant Professor','ME',10.5,'CO','fac19');
insert into faculty_acad values('fac20','Assistant Professor','ME',10,'CO','fac20');
insert into faculty_acad values('fac21','Assistant Professor','ME',10,'CO','fac21');
insert into faculty_acad values('fac22','Assistant Professor','ME',5.5,'CO','fac22');
insert into faculty_acad values('fac23','Assistant Professor','ME',7.11,'CO','fac23');
insert into faculty_acad values('fac24','Assistant Professor','ME',7.6,'CO','fac24');
insert into faculty_acad values('fac25','Assistant Professor','ME',5.4,'CO','fac25');
insert into faculty_acad values('fac26','Assistant Professor','MTECH',7.5,'CO','fac26');
insert into faculty_acad values('fac27','Assistant Professor','MTECH',10,'CO','fac27');
insert into faculty_acad values('fac28','Assistant Professor','ME',13,'CO','fac28');
insert into faculty_acad values('fac29','Assistant Professor','ME',9,'CO','fac29');
insert into faculty_acad values('fac30','Assistant Professor','ME',5.2,'CO','fac30');
insert into faculty_acad values('fac31','Assistant Professor','ME',3.4,'CO','fac31');
insert into faculty_acad values('fac32','Assistant Professor','MTECH',11.6,'CO','fac32');
insert into faculty_acad values('fac33','Assistant Professor','ME',5,'CO','fac33');
insert into faculty_acad values('fac34','Professor','PHD',14.7,'CO','fac34');
insert into faculty_acad values('fac35','Assistant Professor','ME',14,'CO','fac35');
insert into faculty_acad values('fac36','Assistant Professor','ME',6.5,'CO','fac36');

/*DESIGNATION_TO_HOURS TABLE*/
insert into designation_to_hours values("Professor",10,8);
insert into designation_to_hours values("Associate Professor",14,12);
insert into designation_to_hours values("Assistant Professor",18,16);

/*DIVISIONS TABLE*/
insert into divisions values('ME2COA','A',1,'ME2','CO');
insert into divisions values('ME1COA','A',1,'ME1','CO');
insert into divisions values('BECOA','A',4,'BE','CO');
insert into divisions values('BECOB','B',4,'BE','CO');
insert into divisions values('BECOC','C',4,'BE','CO');
insert into divisions values('TECOA','A',4,'TE','CO');
insert into divisions values('TECOB','B',4,'TE','CO');
insert into divisions values('TECOC','C',4,'TE','CO');
insert into divisions values('SECOA','A',4,'SE','CO');
insert into divisions values('SECOB','B',4,'SE','CO');
insert into divisions values('SECOC','C',4,'SE','CO');

/*RESOURCE TABLE*/
insert into resource values('CO101',80,"","101","Classroom","CO","fac1");
insert into resource values('CO111',80,"","111","Classroom","CO","fac1");
insert into resource values('CO201',80,"","201","Classroom","CO","fac1");
insert into resource values('CO202',80,"","202","Classroom","CO","fac1");
insert into resource values('CO202A',80,"",'202A',"Classroom","CO","fac1");
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
