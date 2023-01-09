-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.28


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema medical
--

CREATE DATABASE IF NOT EXISTS medical;
USE medical;

--
-- Definition of table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `apodate` varchar(45) DEFAULT NULL,
  `doctor` varchar(45) DEFAULT NULL,
  `problem` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` (`id`,`name`,`email`,`apodate`,`doctor`,`problem`) VALUES 
 (1,'a','d@g.com','09/27/2013','Dr. A','as');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;


--
-- Definition of table `diagnosis`
--

DROP TABLE IF EXISTS `diagnosis`;
CREATE TABLE `diagnosis` (
  `id1` varchar(5) DEFAULT NULL,
  `allergicsym` varchar(2) DEFAULT NULL,
  `animiasys` varchar(2) DEFAULT NULL,
  `heartblocksym` varchar(2) DEFAULT NULL,
  `footposioningsys` varchar(2) DEFAULT NULL,
  `coldsym` varchar(2) DEFAULT NULL,
  `diabitiessym` varchar(2) DEFAULT NULL,
  `backpainsym` varchar(2) DEFAULT NULL,
  `brainsym` varchar(2) DEFAULT NULL,
  `diseasename` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diagnosis`
--

/*!40000 ALTER TABLE `diagnosis` DISABLE KEYS */;
INSERT INTO `diagnosis` (`id1`,`allergicsym`,`animiasys`,`heartblocksym`,`footposioningsys`,`coldsym`,`diabitiessym`,`backpainsym`,`brainsym`,`diseasename`) VALUES 
 ('1','1','0','0','0','0','0','0','0','AlergicReaction'),
 ('2','0','1','0','0','0','0','0','0','Animia'),
 ('3','0','0','1','0','0','0','0','0','Heart Block'),
 ('4','0','0','0','1','0','0','0','0','Food Posioning'),
 ('5','0','0','0','0','1','0','0','0','Cold'),
 ('6','0','0','0','0','0','1','0','0','Diabities'),
 ('7','0','0','0','0','0','0','1','0','Back Pain'),
 ('8','0','0','0','0','0','0','0','1','Brain Tumor');
/*!40000 ALTER TABLE `diagnosis` ENABLE KEYS */;


--
-- Definition of table `disagent`
--

DROP TABLE IF EXISTS `disagent`;
CREATE TABLE `disagent` (
  `int` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`int`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disagent`
--

/*!40000 ALTER TABLE `disagent` DISABLE KEYS */;
INSERT INTO `disagent` (`int`,`name`) VALUES 
 (1,'virus'),
 (2,'germs'),
 (3,'bacteria'),
 (4,'fungus'),
 (5,'microbes');
/*!40000 ALTER TABLE `disagent` ENABLE KEYS */;


--
-- Definition of table `disease`
--

DROP TABLE IF EXISTS `disease`;
CREATE TABLE `disease` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disease`
--

/*!40000 ALTER TABLE `disease` DISABLE KEYS */;
INSERT INTO `disease` (`id`,`name`) VALUES 
 (1,'Achondroplasia'),
 (2,'Acne'),
 (3,'AIDS'),
 (4,'Albinism'),
 (5,'Alcoholic hepatitis'),
 (6,'Allergy'),
 (7,'Alopecia'),
 (8,'Alzheimer\'s disease'),
 (9,'Amblyopia'),
 (10,'Amebiasis'),
 (11,'Anemia'),
 (12,'Aneurdu'),
 (13,'Anorexia'),
 (14,'Anosmia'),
 (15,'Anotia'),
 (16,'Anthrax'),
 (17,'Appendicitis'),
 (18,'Apraxia'),
 (19,'Argyria'),
 (20,'Arthritis'),
 (21,'Aseptic meningitis'),
 (22,'Asthenia'),
 (23,'Asthma'),
 (24,'Astigmatism'),
 (25,'Atherosclerosis'),
 (26,'Athetosis'),
 (27,'Atrophy'),
 (28,'Bacterial meningitis'),
 (29,'Beriberi'),
 (30,'Black Death'),
 (31,'Botulism'),
 (32,'Breast cancer'),
 (33,'Bronchitis'),
 (34,'Brucellosis'),
 (35,'Bubonic plague'),
 (36,'Bunion'),
 (37,'Calculi'),
 (38,'Campylobacter infection'),
 (39,'Cancer'),
 (40,'Candidiasis'),
 (41,'Carbon monoxide poisoning'),
 (42,'Celiacs disease'),
 (43,'Cerebral palsy'),
 (44,'Chagas disease'),
 (45,'Chalazion'),
 (46,'Chancroid'),
 (47,'Chavia'),
 (48,'Cherubism'),
 (49,'Chickenpox'),
 (50,'Chlamydia'),
 (51,'Chlamydia trachomatis'),
 (52,'Cholera'),
 (53,'Chordoma'),
 (54,'Chorea'),
 (55,'Chronic fatigue syndrome'),
 (56,'Circadian rhythm sleep disorder'),
 (57,'Coccidioidomycosis'),
 (58,'Colitis'),
 (59,'Common cold'),
 (60,'Condyloma'),
 (61,'Congestive heart disease'),
 (62,'Coronary heart disease'),
 (63,'Cowpox'),
 (64,'Cretinism'),
 (65,'Crohn Disease'),
 (66,'Dengue'),
 (67,'Diabetes mellitus'),
 (68,'Diphtheria'),
 (69,'Dehydration'),
 (70,'Ear infection'),
 (71,'Ebola'),
 (72,'Encephalitis'),
 (73,'Emphysema'),
 (74,'Erectile dysfunction'),
 (75,'Foodborne illness'),
 (76,'Gangrene'),
 (77,'Gastroenteritis'),
 (78,'Genital herpes'),
 (79,'GERD'),
 (80,'Goitre'),
 (81,'Gonorrhea'),
 (82,'Heart disease'),
 (83,'Hepatitis A'),
 (84,'Hepatitis B'),
 (85,'Hepatitis C'),
 (86,'Hepatitis D'),
 (87,'Hepatitis E'),
 (88,'Histiocytosis'),
 (89,'HIV'),
 (90,'Human papillomavirus'),
 (91,'Huntington disease'),
 (92,'Hypermetropia'),
 (93,'Hyperopia'),
 (94,'Hyperthyroidism'),
 (95,'Hypothyroid'),
 (96,'Hypotonia'),
 (97,'Impetigo'),
 (98,'Infertility'),
 (99,'Influenza'),
 (100,'Interstitial cystitis'),
 (101,'Iritis'),
 (102,'Iron-deficiency anemia'),
 (103,'Irritable bowel syndrome'),
 (104,'Ignious Syndrome'),
 (105,'Jaundice'),
 (106,'Keloids'),
 (107,'Kuru'),
 (108,'Kwashiorkor'),
 (109,'Laryngitis'),
 (110,'Lead poisoning'),
 (111,'Legionellosis'),
 (112,'Leishmaniasis'),
 (113,'Leprosy'),
 (114,'Leptospirosis'),
 (115,'Listeriosis'),
 (116,'Leukemia'),
 (117,'Lice'),
 (118,'Loiasis'),
 (119,'Lung cancer'),
 (120,'Lupus erythematosus'),
 (121,'Lyme disease'),
 (122,'Lymphogranuloma venereum'),
 (123,'Lymphoma'),
 (124,'Mad cow disease'),
 (125,'Malaria'),
 (126,'Marburg fever'),
 (127,'Measles'),
 (128,'Melanoma'),
 (129,'Melioidosis'),
 (130,'Metastatic cancer'),
 (132,'Meningitis'),
 (133,'Migraine'),
 (134,'Mononucleosis'),
 (135,'Multiple myeloma'),
 (136,'Multiple sclerosis'),
 (137,'Mumps'),
 (138,'Muscular dystrophy'),
 (139,'Myasthenia gravis'),
 (140,'Myelitis'),
 (141,'Myoclonus'),
 (142,'Myopia'),
 (143,'Myxedema'),
 (144,'Morquio Syndrome'),
 (145,'Mattticular syndrome'),
 (146,'Neoplasm'),
 (147,'Non-gonococcal urethritis'),
 (148,'Necrotizing Fasciitis'),
 (149,'Night blindness'),
 (150,'Obesity'),
 (151,'Osteoarthritis'),
 (152,'Osteoporosis'),
 (153,'Otitis'),
 (154,'Palindromic rheumatism'),
 (155,'Paratyphoid fever'),
 (156,'Parkinson disease'),
 (157,'Pelvic inflammatory disease'),
 (158,'Peritonitis'),
 (159,'Periodontal disease'),
 (160,'Pertussis'),
 (161,'Phenylketonuria'),
 (162,'Plague'),
 (163,'Poliomyelitis'),
 (164,'Porphyria'),
 (165,'Progeria'),
 (166,'Prostatitis'),
 (167,'Psittacosis'),
 (168,'Psoriasis'),
 (169,'Pubic lice'),
 (170,'Pulmonary embolism'),
 (171,'Pilia'),
 (172,'Q fever'),
 (173,'Ques fever'),
 (174,'Rabies'),
 (175,'Repetitive strain injury'),
 (176,'Rheumatic fever'),
 (177,'Rheumatic heart'),
 (178,'Rheumatism'),
 (179,'Rheumatoid arthritis'),
 (180,'Rickets'),
 (181,'Rift Valley fever'),
 (182,'Rocky Mountain spotted fever'),
 (183,'Rubella'),
 (184,'Salmonellosis'),
 (185,'Scabies'),
 (186,'Scarlet fever'),
 (187,'Sciatica'),
 (188,'Scleroderma'),
 (189,'Scrapie'),
 (190,'Scurvy'),
 (191,'Sepsis'),
 (192,'Septicemia'),
 (193,'SARS'),
 (194,'Shigellosis'),
 (195,'Shin splints'),
 (196,'Shingles'),
 (197,'Sickle-cell anemia'),
 (198,'Siderosis'),
 (199,'SIDS'),
 (200,'Silicosis'),
 (201,'Smallpox'),
 (202,'Stevens-Johnson syndrome'),
 (203,'Stomach flu'),
 (204,'Stomach ulcers'),
 (205,'Strabismus'),
 (206,'Strep throat'),
 (207,'Streptococcal infection'),
 (208,'Synovitis'),
 (209,'Syphilis'),
 (210,'Swine influenza'),
 (211,'Schizophrenia'),
 (212,'Taeniasis'),
 (213,'Tay-Sachs disease'),
 (214,'Tennis elbow'),
 (215,'Teratoma'),
 (216,'Tetanus'),
 (217,'Thalassaemia'),
 (218,'Thrush'),
 (219,'Thymoma'),
 (220,'Tinnitus'),
 (221,'Tonsillitis'),
 (222,'Tooth decay'),
 (223,'Toxic shock syndrome'),
 (224,'Trichinosis'),
 (225,'Trichomoniasis'),
 (226,'Trisomy'),
 (227,'Tuberculosis'),
 (228,'Tularemia'),
 (229,'Tungiasis'),
 (230,'Typhoid fever'),
 (231,'Typhus'),
 (232,'Tumor'),
 (233,'Ulcerative colitis'),
 (234,'Ulcers'),
 (236,'Uremia'),
 (237,'Urticaria'),
 (238,'Uveitis'),
 (239,'Varicella'),
 (240,'Varicose veins'),
 (241,'Vasovagal syncope'),
 (242,'Vitiligo'),
 (243,'Von Hippel-Lindau disease'),
 (244,'Viral fever'),
 (245,'Viral meningitis'),
 (246,'Warkany syndrome'),
 (247,'Warts'),
 (248,'Watkins'),
 (249,'Yellow fever'),
 (250,'Yersiniosis');
/*!40000 ALTER TABLE `disease` ENABLE KEYS */;


--
-- Definition of table `disprev`
--

DROP TABLE IF EXISTS `disprev`;
CREATE TABLE `disprev` (
  `int` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`int`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disprev`
--

/*!40000 ALTER TABLE `disprev` DISABLE KEYS */;
INSERT INTO `disprev` (`int`,`name`) VALUES 
 (1,'wash hands');
/*!40000 ALTER TABLE `disprev` ENABLE KEYS */;


--
-- Definition of table `extracted`
--

DROP TABLE IF EXISTS `extracted`;
CREATE TABLE `extracted` (
  `words` varchar(45) NOT NULL,
  `val` int(10) unsigned NOT NULL,
  PRIMARY KEY (`words`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `extracted`
--

/*!40000 ALTER TABLE `extracted` DISABLE KEYS */;
INSERT INTO `extracted` (`words`,`val`) VALUES 
 ('(nccam)',1),
 ('--',4),
 ('101',1),
 ('22',1),
 ('49000',1),
 ('80%',1),
 ('act',1),
 ('alternative',1),
 ('amazingly',1),
 ('american',1),
 ('bacterial',1),
 ('behavior',1),
 ('best',2),
 ('biggest',1),
 ('cant',0),
 ('catch',1),
 ('cause',1),
 ('cdc',2),
 ('center',2),
 ('classmate',1),
 ('cold',18),
 ('collectively',1),
 ('common',7),
 ('complementary',1),
 ('contagiou',1),
 ('continu',1),
 ('cure',1),
 ('day',2),
 ('die',1),
 ('dirty',1),
 ('disease',2),
 ('dont',0),
 ('doorknob',1),
 ('dry',1),
 ('echinacea',4),
 ('especially',1),
 ('estimate',1),
 ('excellent',1),
 ('family',2),
 ('faucet',1),
 ('flu',3),
 ('flu-like',1),
 ('follow',1),
 ('forget',1),
 ('frequent',3),
 ('frict',1),
 ('friend',1),
 ('germ',6),
 ('grab',1),
 ('ha',1),
 ('habit',1),
 ('hand',11),
 ('handle',1),
 ('hard',1),
 ('harmful',1),
 ('help',1),
 ('herb',1),
 ('herbal',1),
 ('household',1),
 ('illne',1),
 ('illness-cau',1),
 ('important',1),
 ('in-depth',3),
 ('infect',2),
 ('informat',3),
 ('it',0),
 ('jury',1),
 ('just',2),
 ('kid',2),
 ('know',1),
 ('learn',3),
 ('leav',1),
 ('lifestyle',1),
 ('lose',1),
 ('mak',1),
 ('meal',1),
 ('mean',1),
 ('medicine',1),
 ('member',1),
 ('miserable',1),
 ('national',1),
 ('natural',2),
 ('ne',1),
 ('new',1),
 ('nih',0),
 ('object',1),
 ('occur',1),
 ('parent',1),
 ('people',2),
 ('popular',1),
 ('potentially',1),
 ('prepar',1),
 ('prevent',13),
 ('proper',1),
 ('protect',1),
 ('public',1),
 ('respiratory',1),
 ('restroom',1),
 ('reveal',1),
 ('rid',2),
 ('rin',1),
 ('room',1),
 ('rub',1),
 ('run',1),
 ('say',1),
 ('school',4),
 ('sick',2),
 ('simple',2),
 ('single',1),
 ('skin',2),
 ('snack',1),
 ('soap',1),
 ('spread',2),
 ('stay',1),
 ('stop',2),
 ('studie',1),
 ('study',1),
 ('supplement',1),
 ('support',1),
 ('technique',1),
 ('telephone',1),
 ('th',1),
 ('that',0),
 ('thi',1),
 ('think',1),
 ('thorough',1),
 ('time',1),
 ('tip',2),
 ('toothbrushe',1),
 ('touch',1),
 ('transferr',1),
 ('transmitt',1),
 ('transportat',1),
 ('treatment',1),
 ('truth',1),
 ('upper',1),
 ('use',1),
 ('video',1),
 ('viral',1),
 ('viru',3),
 ('want',1),
 ('warm',1),
 ('wash',10),
 ('water',1),
 ('way',1),
 ('webmd',0),
 ('work',1),
 ('year',1);
/*!40000 ALTER TABLE `extracted` ENABLE KEYS */;


--
-- Definition of table `fscore`
--

DROP TABLE IF EXISTS `fscore`;
CREATE TABLE `fscore` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naive` varchar(100) DEFAULT NULL,
  `adaptive` varchar(100) DEFAULT NULL,
  `svm` varchar(100) DEFAULT NULL,
  `decision` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fscore`
--

/*!40000 ALTER TABLE `fscore` DISABLE KEYS */;
INSERT INTO `fscore` (`id`,`naive`,`adaptive`,`svm`,`decision`) VALUES 
 (1,'0.4428571428571428','0.11929824561403508','0.9666574048346762','0.9769820971867008');
/*!40000 ALTER TABLE `fscore` ENABLE KEYS */;


--
-- Definition of table `garw`
--

DROP TABLE IF EXISTS `garw`;
CREATE TABLE `garw` (
  `words` varchar(45) NOT NULL,
  `vals` int(10) unsigned NOT NULL,
  `support` varchar(45) NOT NULL,
  PRIMARY KEY (`words`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `garw`
--

/*!40000 ALTER TABLE `garw` DISABLE KEYS */;
INSERT INTO `garw` (`words`,`vals`,`support`) VALUES 
 ('cold',18,'0.12162162162162163'),
 ('common',7,'0.0472972972972973'),
 ('germ',6,'0.04054054054054054'),
 ('hand',11,'0.07432432432432433'),
 ('prevent',13,'0.08783783783783784'),
 ('wash',10,'0.06756756756756757');
/*!40000 ALTER TABLE `garw` ENABLE KEYS */;


--
-- Definition of table `medrecord`
--

DROP TABLE IF EXISTS `medrecord`;
CREATE TABLE `medrecord` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `allergies` varchar(45) DEFAULT NULL,
  `disease` varchar(45) DEFAULT NULL,
  `medicine` varchar(45) DEFAULT NULL,
  `doctor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medrecord`
--

/*!40000 ALTER TABLE `medrecord` DISABLE KEYS */;
INSERT INTO `medrecord` (`id`,`name`,`sex`,`age`,`email`,`allergies`,`disease`,`medicine`,`doctor`) VALUES 
 (1,'asas','Male','0-10','d@g.com','dsd','sds','sd','sd');
/*!40000 ALTER TABLE `medrecord` ENABLE KEYS */;


--
-- Definition of table `nlpjava`
--

DROP TABLE IF EXISTS `nlpjava`;
CREATE TABLE `nlpjava` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Query` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nlpjava`
--

/*!40000 ALTER TABLE `nlpjava` DISABLE KEYS */;
INSERT INTO `nlpjava` (`id`,`Query`) VALUES 
 (1,'i have fever'),
 (2,'i have malaria'),
 (3,'i have malaria'),
 (4,'i have malaria'),
 (5,'i have malaria'),
 (6,'i have malaria'),
 (7,'i have malaria'),
 (8,'i have malaria'),
 (9,'i have malaria'),
 (10,'i have fever'),
 (11,'i suffer from malaria'),
 (12,'i have cold'),
 (13,'i am a boy'),
 (14,'i have running nose'),
 (15,'i have cold'),
 (16,'i have malaria'),
 (17,'i have cold'),
 (18,'i have fever'),
 (19,'i have cold'),
 (20,'i have headache'),
 (21,'i have headache'),
 (22,'i have cough'),
 (23,'i have acute headache'),
 (24,'i have cold'),
 (25,'i have malaria'),
 (26,'i have malaria'),
 (27,'hello amit'),
 (28,'i have headache'),
 (29,'i have headache'),
 (30,'i have sinus'),
 (31,'i have cold'),
 (33,'cold'),
 (34,'cough'),
 (39,'sinus'),
 (40,'acne'),
 (41,'nausea'),
 (42,'vomiting'),
 (43,'i have acne'),
 (44,'cough'),
 (45,'cold'),
 (46,'cold'),
 (47,'i have cold'),
 (48,'i have sinus'),
 (49,'cold'),
 (50,'i have cold'),
 (51,'cold have i'),
 (52,'fdfd'),
 (53,'cold have'),
 (54,'i have cough'),
 (55,'nightblindness'),
 (56,'cold have i'),
 (57,'cold have i'),
 (58,'cold have i h'),
 (59,'cold'),
 (60,'cold'),
 (61,'malaria'),
 (62,'sinus'),
 (63,'i have cold'),
 (64,'i have cold'),
 (65,'i have cold'),
 (66,'i have malaria'),
 (67,'i have cold'),
 (68,'i have cold'),
 (69,'i have malaria'),
 (70,'i have malaria'),
 (71,'sinus'),
 (72,'cold'),
 (73,'malaria'),
 (74,'i have cold'),
 (75,'i have typhoid'),
 (76,'i have malaria'),
 (77,'i have sinus'),
 (78,'malaria'),
 (79,'malaria'),
 (80,'malaria'),
 (81,'sinus'),
 (82,'sinus'),
 (83,'sinus'),
 (84,'malaria'),
 (85,'malaria'),
 (86,'malaria'),
 (87,'malaria'),
 (88,'sinus'),
 (89,'malaria'),
 (90,'sinus'),
 (91,'i am suffering from tonsils'),
 (92,'migraine'),
 (93,'i have malaria'),
 (94,'malaria'),
 (95,'malaria'),
 (96,'malaria'),
 (97,'malaria'),
 (98,'sinus');
/*!40000 ALTER TABLE `nlpjava` ENABLE KEYS */;


--
-- Definition of table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `patientid` varchar(5) DEFAULT NULL,
  `name1` varchar(25) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `age` varchar(8) DEFAULT NULL,
  `contactnumber` varchar(12) DEFAULT NULL,
  `mailid` varchar(45) NOT NULL,
  `address` varchar(25) DEFAULT NULL,
  `history` varchar(25) DEFAULT NULL,
  `pass` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`mailid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` (`patientid`,`name1`,`sex`,`age`,`contactnumber`,`mailid`,`address`,`history`,`pass`) VALUES 
 ('1','Amit','Male','21-30','9321835510','a@gmail.com','sssssss','sss',NULL),
 ('3','d','Male','31-40','1234567890','d@g.com','4','4','1'),
 ('wd','ad','Male','0-10','ddd','dad','ada','ad','ad'),
 ('sd','sd','Male','0-10','dsd','sd','sd','sd','sd'),
 ('2','Siddhesh','Male','21-30','9321835511','sid@gmail.com','dsd','dsd',NULL);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;


--
-- Definition of table `precisionscore`
--

DROP TABLE IF EXISTS `precisionscore`;
CREATE TABLE `precisionscore` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naive` varchar(45) DEFAULT NULL,
  `adaptive` varchar(45) DEFAULT NULL,
  `svm` varchar(45) DEFAULT NULL,
  `decision` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `precisionscore`
--

/*!40000 ALTER TABLE `precisionscore` DISABLE KEYS */;
INSERT INTO `precisionscore` (`id`,`naive`,`adaptive`,`svm`,`decision`) VALUES 
 (1,'0.7209302325581395','0.18681318681318682','0.935969868173258','0.9695431472081218');
/*!40000 ALTER TABLE `precisionscore` ENABLE KEYS */;


--
-- Definition of table `recallscore`
--

DROP TABLE IF EXISTS `recallscore`;
CREATE TABLE `recallscore` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naive` varchar(100) DEFAULT NULL,
  `adaptive` varchar(100) DEFAULT NULL,
  `svm` varchar(100) DEFAULT NULL,
  `decision` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recallscore`
--

/*!40000 ALTER TABLE `recallscore` DISABLE KEYS */;
INSERT INTO `recallscore` (`id`,`naive`,`adaptive`,`svm`,`decision`) VALUES 
 (1,'0.31958762886597936','0.08762886597938144','0.9994254524561907','0.9845360824742269');
/*!40000 ALTER TABLE `recallscore` ENABLE KEYS */;


--
-- Definition of table `solution`
--

DROP TABLE IF EXISTS `solution`;
CREATE TABLE `solution` (
  `disease` varchar(25) DEFAULT NULL,
  `solu` varchar(200) DEFAULT NULL,
  `prevention` varchar(200) DEFAULT NULL,
  `sideeffect` varchar(200) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `solution`
--

/*!40000 ALTER TABLE `solution` DISABLE KEYS */;
INSERT INTO `solution` (`disease`,`solu`,`prevention`,`sideeffect`,`id`) VALUES 
 ('cold','take a steam of vicks!','avoid being close to people who have colds','severe effects on breathing',1),
 ('malaria','take a pill of anitibiotic','Use mosquito repellent cream','skin allergies',2),
 ('malaria','take doxycycline antibiotic','Use mosquito repellent cream','nausea (feeling sick) or diarrhoea',3),
 ('malaria','take mefloquine antibiotic','Use mosquito repellent cream','headaches or have problems with sleep',4),
 ('fever','take an aspirin','Proper disposal of waste','changes in blood clotting time',5),
 ('malaria','prevent yourself from mosquito','Use mosquito repellent cream','none',6),
 ('fever','take a pill of aspirin','Proper disposal of waste','changes in blood clotting time',7),
 ('cough','take glycodine','Wash your hands frequently','shortness of breath',8),
 ('sinus','take amoxicillin antibiotic','Use a saline spray a few times a day','A bad taste in the mouth',9),
 ('sinus','take Augmentin antibiotic','Avoid exposure to irritants such as cigarette','Mild to severe diarrhea',10),
 ('Acne','taking drugs that contain Vitamin A i.e Accutane','Keep your face clean','osteoporosis and hip fracture',11),
 ('migraine','take an antidepressant such as amitriptyline','sleep on time','Head Pain',12),
 ('migraine','take an anticonvulsant','spice up your food','Weight gain',13),
 ('migraine','take pizotefen','sleep in dark','feeling dizzy always',14),
 ('typhoid','Fluids may be given through a vein','carriers of typhoid not be allowed to work as food handlers','Swelling of part of body',15),
 ('gastro','prevent dehydration','wash hands frequently','no side effects',16),
 ('tonsils','take antibiotics','daily salt warm water gargels','none',18),
 ('tonsils','undergo surgery','daily salt warm water gargels','difficulty swallowing and a sore throat for at least a few days',19),
 ('ulcers','take pain killers','Healthy lifestyle','Stomach upset, heartburn, and nausea',20),
 ('ulcers','take Corticosteroids','Good dental hygiene','metallic taste in the mouth',21),
 ('beriberi','treatment is to replace the thiamine your body is lacking','Eating a proper diet that is rich in thiamine and other vitamins will prevent beriberi','not safe for people with liver disorder',22),
 ('diabetes','insulin','follow a healthy eating plan','Blurry vision',23),
 ('dengue','Acetaminophen','Stay in air-conditioned or well-screened housing','liver disorder',24),
 ('sars','Antibiotics to treat bacteria that cause pneumonia','Wash your hands','abdominal pain',25),
 ('sars','Antiviral medications','Wear a surgical mask','nausea, vomiting, diarrhea and headache',26),
 ('sars','High doses of steroids to reduce swelling in the lungs','Disinfect surfaces','hearth disease',27),
 ('d','a','b','c',28),
 ('o','o1','o2','o3',29);
/*!40000 ALTER TABLE `solution` ENABLE KEYS */;


--
-- Definition of table `stopwords`
--

DROP TABLE IF EXISTS `stopwords`;
CREATE TABLE `stopwords` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `wordslist` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stopwords`
--

/*!40000 ALTER TABLE `stopwords` DISABLE KEYS */;
INSERT INTO `stopwords` (`id`,`wordslist`) VALUES 
 (1,'a'),
 (2,'about'),
 (3,'above'),
 (4,'after'),
 (5,'again'),
 (6,'against'),
 (7,'all'),
 (8,'am'),
 (9,'an'),
 (10,'and'),
 (11,'any'),
 (12,'are'),
 (13,'arent'),
 (14,'as'),
 (15,'at'),
 (16,'be'),
 (17,'because'),
 (18,'been'),
 (19,'before'),
 (20,'being'),
 (21,'below'),
 (22,'between'),
 (23,'both'),
 (24,'but'),
 (25,'by'),
 (26,'cant'),
 (27,'cannot'),
 (28,'could'),
 (29,'couldnt'),
 (30,'did'),
 (31,'didnt'),
 (32,'do'),
 (33,'does'),
 (34,'doesnt'),
 (35,'doing'),
 (36,'dont'),
 (37,'down'),
 (38,'during'),
 (39,'each'),
 (40,'few'),
 (41,'for'),
 (42,'from'),
 (43,'further'),
 (44,'had'),
 (45,'hadnt'),
 (46,'has'),
 (47,'hasnt'),
 (48,'have'),
 (49,'havent'),
 (50,'having'),
 (51,'he'),
 (52,'her'),
 (53,'here'),
 (54,'heres'),
 (55,'hers'),
 (56,'herself'),
 (57,'him'),
 (58,'himself'),
 (59,'his'),
 (60,'how'),
 (61,'hows'),
 (62,'i'),
 (63,'if'),
 (64,'in'),
 (65,'into'),
 (66,'is'),
 (67,'isnt'),
 (68,'it'),
 (69,'its'),
 (70,'itself'),
 (71,'lets'),
 (72,'me'),
 (73,'more'),
 (74,'most'),
 (75,'mustnt'),
 (76,'my'),
 (77,'myself'),
 (78,'no'),
 (79,'nor'),
 (80,'not'),
 (81,'of'),
 (82,'off'),
 (83,'on'),
 (84,'once'),
 (85,'only'),
 (86,'or'),
 (87,'other'),
 (88,'ought'),
 (89,'our'),
 (90,'ours'),
 (91,'ourselves'),
 (92,'out'),
 (93,'over'),
 (94,'own'),
 (95,'same'),
 (96,'she'),
 (97,'should'),
 (98,'shouldnt'),
 (99,'so'),
 (100,'some'),
 (101,'such'),
 (102,'than'),
 (103,'that'),
 (104,'thats'),
 (105,'the'),
 (106,'their'),
 (107,'theirs'),
 (108,'them'),
 (109,'themselves'),
 (110,'then'),
 (111,'there'),
 (112,'theres'),
 (113,'these'),
 (114,'they'),
 (115,'this'),
 (116,'those'),
 (117,'through'),
 (118,'to'),
 (119,'too'),
 (120,'under'),
 (121,'until'),
 (122,'up'),
 (123,'very'),
 (124,'very'),
 (125,'was'),
 (126,'wasnt'),
 (127,'we'),
 (128,'were'),
 (129,'werent'),
 (130,'what'),
 (131,'whats'),
 (132,'when'),
 (133,'whens'),
 (134,'where'),
 (135,'wheres'),
 (136,'which'),
 (137,'while'),
 (138,'who'),
 (139,'whom'),
 (140,'why'),
 (141,'with'),
 (142,'wont'),
 (143,'would'),
 (144,'wouldnt'),
 (145,'you'),
 (146,'your'),
 (147,'yours'),
 (148,'yourself'),
 (149,'yourselves');
/*!40000 ALTER TABLE `stopwords` ENABLE KEYS */;


--
-- Definition of table `totaltrans`
--

DROP TABLE IF EXISTS `totaltrans`;
CREATE TABLE `totaltrans` (
  `tot` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `totaltrans`
--

/*!40000 ALTER TABLE `totaltrans` DISABLE KEYS */;
INSERT INTO `totaltrans` (`tot`) VALUES 
 (148);
/*!40000 ALTER TABLE `totaltrans` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
