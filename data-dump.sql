-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: qrmsdb
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `course_id` varchar(255) NOT NULL,
  `course_credits` int(11) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `course_sem` int(11) DEFAULT NULL,
  `course_type` char(1) DEFAULT NULL,
  `course_year` varchar(255) DEFAULT NULL,
  `elective_id` varchar(255) DEFAULT NULL,
  `is_theory` int(11) DEFAULT NULL,
  `no_of_hours` int(11) DEFAULT NULL,
  `stud_allocation_flag` int(11) DEFAULT NULL,
  `dept_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FKq35kfet2x1flha9h3pxai43hw` (`dept_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('410252',3,'Elective 3',8,'E','BE',1,3,0,'CS'),('410253',3,'Elective 4',8,'E','BE',1,3,0,'CS');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_prerequisite`
--

DROP TABLE IF EXISTS `course_prerequisite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_prerequisite` (
  `course_id` varchar(255) NOT NULL,
  `prereq_courseid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_prerequisite`
--

LOCK TABLES `course_prerequisite` WRITE;
/*!40000 ALTER TABLE `course_prerequisite` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_prerequisite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `dept_id` varchar(255) NOT NULL,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('CS','Computer Department'),('MH','Mechanical Department'),('EN','EnTC Department'),('IT','IT Department'),('CV','Civil Department');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `electives`
--

DROP TABLE IF EXISTS `electives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `electives` (
  `elective_course_id` varchar(255) NOT NULL,
  `elective_name` varchar(255) DEFAULT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`elective_course_id`),
  KEY `FKsv0774m02dvgu99mo1rsqsucb` (`course_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `electives`
--

LOCK TABLES `electives` WRITE;
/*!40000 ALTER TABLE `electives` DISABLE KEYS */;
INSERT INTO `electives` VALUES ('410252A','Adv Digital Signal Processing','410252'),('410252B','Compilers','410252'),('410252C','ERTOS','410252'),('410252D','SCOA','410252'),('410253A','Software Defined Networks','410253'),('410253B','Human Computer Interface','410253'),('410253C','Cloud Computing','410253'),('410253D','Open Elective','410253');
/*!40000 ALTER TABLE `electives` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_acad`
--

DROP TABLE IF EXISTS `faculty_acad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty_acad` (
  `user_name` varchar(255) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `years_of_experience` int(11) DEFAULT NULL,
  `dept_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`),
  KEY `FK94icf6l4yec73egtcamgw5m17` (`dept_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_acad`
--

LOCK TABLES `faculty_acad` WRITE;
/*!40000 ALTER TABLE `faculty_acad` DISABLE KEYS */;
/*!40000 ALTER TABLE `faculty_acad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_course_history`
--

DROP TABLE IF EXISTS `faculty_course_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty_course_history` (
  `id` int(11) NOT NULL,
  `course_experience` int(11) DEFAULT NULL,
  `course_taught` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKipqs7rh3e0x361k2my9hp1jf4` (`course_taught`),
  KEY `FK61n0mbw2ra094w345mf5yhq3t` (`user_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_course_history`
--

LOCK TABLES `faculty_course_history` WRITE;
/*!40000 ALTER TABLE `faculty_course_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `faculty_course_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_pref`
--

DROP TABLE IF EXISTS `faculty_pref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty_pref` (
  `user_name` varchar(255) NOT NULL,
  `pref1` varchar(255) DEFAULT NULL,
  `pref2` varchar(255) DEFAULT NULL,
  `pref3` varchar(255) DEFAULT NULL,
  `pref4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`),
  KEY `FK117wp8wl6o84uxiwwqy5sk9th` (`pref1`),
  KEY `FKjo6bmu4mik0yiq2si1r3f4wt7` (`pref2`),
  KEY `FKq3sj3i8lxcnj7w2m6g65c08f6` (`pref3`),
  KEY `FKq33b2jwtwktpiidps9ia3vjai` (`pref4`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_pref`
--

LOCK TABLES `faculty_pref` WRITE;
/*!40000 ALTER TABLE `faculty_pref` DISABLE KEYS */;
/*!40000 ALTER TABLE `faculty_pref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (48),(48),(48);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_token`
--

DROP TABLE IF EXISTS `password_reset_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `password_reset_token` (
  `id` bigint(20) NOT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5lwtbncug84d4ero33v3cfxvl` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_token`
--

LOCK TABLES `password_reset_token` WRITE;
/*!40000 ALTER TABLE `password_reset_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_reset_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'FACULTY'),(3,'STUDENT');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_acad`
--

DROP TABLE IF EXISTS `student_acad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_acad` (
  `user_name` varchar(255) NOT NULL,
  `academic_year` varchar(255) DEFAULT NULL,
  `agg_marks` float DEFAULT NULL,
  `division` varchar(255) DEFAULT NULL,
  `rollno` varchar(255) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `shift` int(11) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `dept_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`),
  KEY `FKp7oxob7rewbaaw92t3ih00r7y` (`dept_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_acad`
--

LOCK TABLES `student_acad` WRITE;
/*!40000 ALTER TABLE `student_acad` DISABLE KEYS */;
INSERT INTO `student_acad` VALUES ('stud1s',NULL,8,'B','BECOB201',8,1,'BE','CS'),('stud2s',NULL,9,'B','BECOB202',8,1,'BE','CS'),('stud3s',NULL,8.2,'B','BECOB203',8,1,'BE','CS'),('stud4s',NULL,8.5,'B','BECOB204',8,1,'BE','CS'),('bharatik',NULL,8.5,'B','BECOB210',8,2,'BE','CS'),('stud5s',NULL,6.5,'B','BECOB205',8,1,'BE','CS');
/*!40000 ALTER TABLE `student_acad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_alloc_course`
--

DROP TABLE IF EXISTS `student_alloc_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_alloc_course` (
  `user_name` varchar(255) NOT NULL,
  `pref_no` int(11) DEFAULT NULL,
  `course_id` varchar(255) NOT NULL,
  `elective_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`,`course_id`),
  KEY `FKpcg57y2kv98ter16yje3dt9ag` (`course_id`),
  KEY `FKftdm1fvamc3ln6hviuxpsn0o1` (`elective_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_alloc_course`
--

LOCK TABLES `student_alloc_course` WRITE;
/*!40000 ALTER TABLE `student_alloc_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_alloc_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_elective_vacancy_pref_counts`
--

DROP TABLE IF EXISTS `student_elective_vacancy_pref_counts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_elective_vacancy_pref_counts` (
  `elective_id` varchar(255) NOT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  `pref_count` int(11) DEFAULT NULL,
  `vacancy_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`elective_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_elective_vacancy_pref_counts`
--

LOCK TABLES `student_elective_vacancy_pref_counts` WRITE;
/*!40000 ALTER TABLE `student_elective_vacancy_pref_counts` DISABLE KEYS */;
INSERT INTO `student_elective_vacancy_pref_counts` VALUES ('410252A','410252',3,80),('410252B','410252',0,80),('410252C','410252',0,80),('410252D','410252',0,80),('410253A','410253',0,80),('410253B','410253',0,80),('410253C','410253',0,80),('410253D','410253',0,80);
/*!40000 ALTER TABLE `student_elective_vacancy_pref_counts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_pref`
--

DROP TABLE IF EXISTS `student_pref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_pref` (
  `user_name` varchar(255) NOT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  `pref_no` int(11) DEFAULT NULL,
  `pref` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`),
  KEY `FK2wyems8osq2hh242i38kk274x` (`pref`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_pref`
--

LOCK TABLES `student_pref` WRITE;
/*!40000 ALTER TABLE `student_pref` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_pref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_name` varchar(255) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin',1,'adminpccoe@gmail.com','Admin','Admin','admin'),('stud1s',1,'stud1@stud.com','stud1','stud','$2a$10$VMAzFERfgOZrEiTtRaDUIu40wWME4NmdmiHyN3PYDqCxvud9C2LXK'),('stud2s',1,'stud2@stud.com','stud2','stud','$2a$10$rQpdGZQPM9XhyPE94bQv8OlFl4xZAYFWaXvARbEuGzmZ1WqLxN3Va'),('stud3s',1,'stud3@stud.com','stud3','stud','$2a$10$nYOcDuX4rb1qkvo/Wq58WOL3D0zvApxYVxZAo5IHboQLYDIKOeDcS'),('stud4s',1,'stud4@stud.com','stud4','stud','$2a$10$FWtAKZSYjTrVxfgXziMTXu6S0kRotWJvKnlE8Ycub8hWJBZ/XzmiS'),('bharatik',1,'bmk15897@gmail.com','bharati','kulkarni','$2a$10$1xZafqXE70GS7tgTmeFyTufBf92hogrSz979BuyAUlWOboskAOP7i'),('stud5s',1,'stud5@stud.com','stud5','stud','$2a$10$h9HhEM2DsZmYWbQTbin2c.caifZH5BqpHSTz7E8PVGs726ru.cBvO');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_name` varchar(255) NOT NULL,
  `roles_role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_name`,`roles_role_id`),
  KEY `FK5scdquo6f12cpstqai86x4biw` (`roles_role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('admin',1),('bharatik',3),('stud1s',3),('stud2s',3),('stud3s',3),('stud4s',3),('stud5s',3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-25 22:39:08
