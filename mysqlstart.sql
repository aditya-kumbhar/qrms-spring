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
insert into user values("stud1",1,"stud1@gmail.com","Student1","Student1","student");
insert into user values("stud2",1,"stud2@gmail.com","Student2","Student2","student");
insert into user values("stud3",1,"stud3@gmail.com","Student3","Student3","student");
insert into user values("stud4",1,"stud4@gmail.com","Student4","Student4","student");
insert into user values("stud5",1,"stud5@gmail.com","Student5","Student5","student");
insert into user values("stud6",1,"stud6@gmail.com","Student6","Student6","student");
insert into user values("stud7",1,"stud7@gmail.com","Student7","Student7","student");
insert into user values("stud8",1,"stud8@gmail.com","Student8","Student8","student");
insert into user values("stud9",1,"stud9@gmail.com","Student9","Student9","student");
insert into user values("stud10",1,"stud10@gmail.com","Student10","Student10","student");
insert into user values("stud11",1,"stud11@gmail.com","Student11","Student11","student");
insert into user values("stud12",1,"stud12@gmail.com","Student12","Student12","student");
insert into user values("stud13",1,"stud13@gmail.com","Student13","Student13","student");
insert into user values("stud14",1,"stud14@gmail.com","Student14","Student14","student");
insert into user values("stud15",1,"stud15@gmail.com","Student15","Student15","student");
insert into user values("stud16",1,"stud16@gmail.com","Student16","Student16","student");
insert into user values("stud17",1,"stud17@gmail.com","Student17","Student17","student");
insert into user values("stud18",1,"stud18@gmail.com","Student18","Student18","student");
insert into user values("stud19",1,"stud19@gmail.com","Student19","Student19","student");
insert into user values("stud20",1,"stud20@gmail.com","Student20","Student20","student");
insert into user values("stud21",1,"stud21@gmail.com","Student21","Student21","student");
insert into user values("stud22",1,"stud22@gmail.com","Student22","Student22","student");
insert into user values("stud23",1,"stud23@gmail.com","Student23","Student23","student");
insert into user values("stud24",1,"stud24@gmail.com","Student24","Student24","student");
insert into user values("stud25",1,"stud25@gmail.com","Student25","Student25","student");
insert into user values("stud26",1,"stud26@gmail.com","Student26","Student26","student");
insert into user values("stud27",1,"stud27@gmail.com","Student27","Student27","student");
insert into user values("stud28",1,"stud28@gmail.com","Student28","Student28","student");
insert into user values("stud29",1,"stud29@gmail.com","Student29","Student29","student");
insert into user values("stud30",1,"stud30@gmail.com","Student30","Student30","student");
insert into user values("stud31",1,"stud31@gmail.com","Student31","Student31","student");
insert into user values("stud32",1,"stud32@gmail.com","Student32","Student32","student");
insert into user values("stud33",1,"stud33@gmail.com","Student33","Student33","student");
insert into user values("stud34",1,"stud34@gmail.com","Student34","Student34","student");
insert into user values("stud35",1,"stud35@gmail.com","Student35","Student35","student");
insert into user values("stud36",1,"stud36@gmail.com","Student36","Student36","student");
insert into user values("stud37",1,"stud37@gmail.com","Student37","Student37","student");
insert into user values("stud38",1,"stud38@gmail.com","Student38","Student38","student");
insert into user values("stud39",1,"stud39@gmail.com","Student39","Student39","student");
insert into user values("stud40",1,"stud40@gmail.com","Student40","Student40","student");
insert into user values("stud41",1,"stud41@gmail.com","Student41","Student41","student");
insert into user values("stud42",1,"stud42@gmail.com","Student42","Student42","student");
insert into user values("stud43",1,"stud43@gmail.com","Student43","Student43","student");
insert into user values("stud44",1,"stud44@gmail.com","Student44","Student44","student");
insert into user values("stud45",1,"stud45@gmail.com","Student45","Student45","student");
insert into user values("stud46",1,"stud46@gmail.com","Student46","Student46","student");
insert into user values("stud47",1,"stud47@gmail.com","Student47","Student47","student");
insert into user values("stud48",1,"stud48@gmail.com","Student48","Student48","student");
insert into user values("stud49",1,"stud49@gmail.com","Student49","Student49","student");
insert into user values("stud50",1,"stud50@gmail.com","Student50","Student50","student");
insert into user values("stud51",1,"stud51@gmail.com","Student51","Student51","student");
insert into user values("stud52",1,"stud52@gmail.com","Student52","Student52","student");
insert into user values("stud53",1,"stud53@gmail.com","Student53","Student53","student");
insert into user values("stud54",1,"stud54@gmail.com","Student54","Student54","student");
insert into user values("stud55",1,"stud55@gmail.com","Student55","Student55","student");
insert into user values("stud56",1,"stud56@gmail.com","Student56","Student56","student");
insert into user values("stud57",1,"stud57@gmail.com","Student57","Student57","student");
insert into user values("stud58",1,"stud58@gmail.com","Student58","Student58","student");
insert into user values("stud59",1,"stud59@gmail.com","Student59","Student59","student");
insert into user values("stud60",1,"stud60@gmail.com","Student60","Student60","student");
insert into user values("stud61",1,"stud61@gmail.com","Student61","Student61","student");
insert into user values("stud62",1,"stud62@gmail.com","Student62","Student62","student");
insert into user values("stud63",1,"stud63@gmail.com","Student63","Student63","student");
insert into user values("stud64",1,"stud64@gmail.com","Student64","Student64","student");
insert into user values("stud65",1,"stud65@gmail.com","Student65","Student65","student");
insert into user values("stud66",1,"stud66@gmail.com","Student66","Student66","student");
insert into user values("stud67",1,"stud67@gmail.com","Student67","Student67","student");
insert into user values("stud68",1,"stud68@gmail.com","Student68","Student68","student");
insert into user values("stud69",1,"stud69@gmail.com","Student69","Student69","student");
insert into user values("stud70",1,"stud70@gmail.com","Student70","Student70","student");
insert into user values("stud71",1,"stud71@gmail.com","Student71","Student71","student");
insert into user values("stud72",1,"stud72@gmail.com","Student72","Student72","student");
insert into user values("stud73",1,"stud73@gmail.com","Student73","Student73","student");
insert into user values("stud74",1,"stud74@gmail.com","Student74","Student74","student");
insert into user values("stud75",1,"stud75@gmail.com","Student75","Student75","student");
insert into user values("stud76",1,"stud76@gmail.com","Student76","Student76","student");
insert into user values("stud77",1,"stud77@gmail.com","Student77","Student77","student");
insert into user values("stud78",1,"stud78@gmail.com","Student78","Student78","student");
insert into user values("stud79",1,"stud79@gmail.com","Student79","Student79","student");
insert into user values("stud80",1,"stud80@gmail.com","Student80","Student80","student");
insert into user values("stud81",1,"stud81@gmail.com","Student81","Student81","student");
insert into user values("stud82",1,"stud82@gmail.com","Student82","Student82","student");
insert into user values("stud83",1,"stud83@gmail.com","Student83","Student83","student");
insert into user values("stud84",1,"stud84@gmail.com","Student84","Student84","student");
insert into user values("stud85",1,"stud85@gmail.com","Student85","Student85","student");
insert into user values("stud86",1,"stud86@gmail.com","Student86","Student86","student");
insert into user values("stud87",1,"stud87@gmail.com","Student87","Student87","student");
insert into user values("stud88",1,"stud88@gmail.com","Student88","Student88","student");
insert into user values("stud89",1,"stud89@gmail.com","Student89","Student89","student");
insert into user values("stud90",1,"stud90@gmail.com","Student90","Student90","student");
insert into user values("stud91",1,"stud91@gmail.com","Student91","Student91","student");
insert into user values("stud92",1,"stud92@gmail.com","Student92","Student92","student");
insert into user values("stud93",1,"stud93@gmail.com","Student93","Student93","student");
insert into user values("stud94",1,"stud94@gmail.com","Student94","Student94","student");
insert into user values("stud95",1,"stud95@gmail.com","Student95","Student95","student");
insert into user values("stud96",1,"stud96@gmail.com","Student96","Student96","student");
insert into user values("stud97",1,"stud97@gmail.com","Student97","Student97","student");
insert into user values("stud98",1,"stud98@gmail.com","Student98","Student98","student");
insert into user values("stud99",1,"stud99@gmail.com","Student99","Student99","student");
insert into user values("stud100",1,"stud100@gmail.com","Student100","Student100","student");
insert into user values("stud101",1,"stud101@gmail.com","Student101","Student101","student");
insert into user values("stud102",1,"stud102@gmail.com","Student102","Student102","student");
insert into user values("stud103",1,"stud103@gmail.com","Student103","Student103","student");
insert into user values("stud104",1,"stud104@gmail.com","Student104","Student104","student");
insert into user values("stud105",1,"stud105@gmail.com","Student105","Student105","student");
insert into user values("stud106",1,"stud106@gmail.com","Student106","Student106","student");
insert into user values("stud107",1,"stud107@gmail.com","Student107","Student107","student");
insert into user values("stud108",1,"stud108@gmail.com","Student108","Student108","student");
insert into user values("stud109",1,"stud109@gmail.com","Student109","Student109","student");
insert into user values("stud110",1,"stud110@gmail.com","Student110","Student110","student");
insert into user values("stud111",1,"stud111@gmail.com","Student111","Student111","student");
insert into user values("stud112",1,"stud112@gmail.com","Student112","Student112","student");
insert into user values("stud113",1,"stud113@gmail.com","Student113","Student113","student");
insert into user values("stud114",1,"stud114@gmail.com","Student114","Student114","student");
insert into user values("stud115",1,"stud115@gmail.com","Student115","Student115","student");
insert into user values("stud116",1,"stud116@gmail.com","Student116","Student116","student");
insert into user values("stud117",1,"stud117@gmail.com","Student117","Student117","student");
insert into user values("stud118",1,"stud118@gmail.com","Student118","Student118","student");
insert into user values("stud119",1,"stud119@gmail.com","Student119","Student119","student");
insert into user values("stud120",1,"stud120@gmail.com","Student120","Student120","student");
insert into user values("stud121",1,"stud121@gmail.com","Student121","Student121","student");
insert into user values("stud122",1,"stud122@gmail.com","Student122","Student122","student");
insert into user values("stud123",1,"stud123@gmail.com","Student123","Student123","student");
insert into user values("stud124",1,"stud124@gmail.com","Student124","Student124","student");
insert into user values("stud125",1,"stud125@gmail.com","Student125","Student125","student");
insert into user values("stud126",1,"stud126@gmail.com","Student126","Student126","student");
insert into user values("stud127",1,"stud127@gmail.com","Student127","Student127","student");
insert into user values("stud128",1,"stud128@gmail.com","Student128","Student128","student");
insert into user values("stud129",1,"stud129@gmail.com","Student129","Student129","student");
insert into user values("stud130",1,"stud130@gmail.com","Student130","Student130","student");
insert into user values("stud131",1,"stud131@gmail.com","Student131","Student131","student");
insert into user values("stud132",1,"stud132@gmail.com","Student132","Student132","student");
insert into user values("stud133",1,"stud133@gmail.com","Student133","Student133","student");
insert into user values("stud134",1,"stud134@gmail.com","Student134","Student134","student");
insert into user values("stud135",1,"stud135@gmail.com","Student135","Student135","student");
insert into user values("stud136",1,"stud136@gmail.com","Student136","Student136","student");
insert into user values("stud137",1,"stud137@gmail.com","Student137","Student137","student");
insert into user values("stud138",1,"stud138@gmail.com","Student138","Student138","student");
insert into user values("stud139",1,"stud139@gmail.com","Student139","Student139","student");
insert into user values("stud140",1,"stud140@gmail.com","Student140","Student140","student");
insert into user values("stud141",1,"stud141@gmail.com","Student141","Student141","student");
insert into user values("stud142",1,"stud142@gmail.com","Student142","Student142","student");
insert into user values("stud143",1,"stud143@gmail.com","Student143","Student143","student");
insert into user values("stud144",1,"stud144@gmail.com","Student144","Student144","student");
insert into user values("stud145",1,"stud145@gmail.com","Student145","Student145","student");
insert into user values("stud146",1,"stud146@gmail.com","Student146","Student146","student");
insert into user values("stud147",1,"stud147@gmail.com","Student147","Student147","student");
insert into user values("stud148",1,"stud148@gmail.com","Student148","Student148","student");
insert into user values("stud149",1,"stud149@gmail.com","Student149","Student149","student");
insert into user values("stud150",1,"stud150@gmail.com","Student150","Student150","student");
insert into user values("stud151",1,"stud151@gmail.com","Student151","Student151","student");
insert into user values("stud152",1,"stud152@gmail.com","Student152","Student152","student");
insert into user values("stud153",1,"stud153@gmail.com","Student153","Student153","student");
insert into user values("stud154",1,"stud154@gmail.com","Student154","Student154","student");
insert into user values("stud155",1,"stud155@gmail.com","Student155","Student155","student");
insert into user values("stud156",1,"stud156@gmail.com","Student156","Student156","student");
insert into user values("stud157",1,"stud157@gmail.com","Student157","Student157","student");
insert into user values("stud158",1,"stud158@gmail.com","Student158","Student158","student");
insert into user values("stud159",1,"stud159@gmail.com","Student159","Student159","student");
insert into user values("stud160",1,"stud160@gmail.com","Student160","Student160","student");
insert into user values("stud161",1,"stud161@gmail.com","Student161","Student161","student");
insert into user values("stud162",1,"stud162@gmail.com","Student162","Student162","student");
insert into user values("stud163",1,"stud163@gmail.com","Student163","Student163","student");
insert into user values("stud164",1,"stud164@gmail.com","Student164","Student164","student");
insert into user values("stud165",1,"stud165@gmail.com","Student165","Student165","student");
insert into user values("stud166",1,"stud166@gmail.com","Student166","Student166","student");
insert into user values("stud167",1,"stud167@gmail.com","Student167","Student167","student");
insert into user values("stud168",1,"stud168@gmail.com","Student168","Student168","student");
insert into user values("stud169",1,"stud169@gmail.com","Student169","Student169","student");
insert into user values("stud170",1,"stud170@gmail.com","Student170","Student170","student");
insert into user values("stud171",1,"stud171@gmail.com","Student171","Student171","student");
insert into user values("stud172",1,"stud172@gmail.com","Student172","Student172","student");
insert into user values("stud173",1,"stud173@gmail.com","Student173","Student173","student");
insert into user values("stud174",1,"stud174@gmail.com","Student174","Student174","student");
insert into user values("stud175",1,"stud175@gmail.com","Student175","Student175","student");
insert into user values("stud176",1,"stud176@gmail.com","Student176","Student176","student");
insert into user values("stud177",1,"stud177@gmail.com","Student177","Student177","student");
insert into user values("stud178",1,"stud178@gmail.com","Student178","Student178","student");
insert into user values("stud179",1,"stud179@gmail.com","Student179","Student179","student");
insert into user values("stud180",1,"stud180@gmail.com","Student180","Student180","student");
insert into user values("stud181",1,"stud181@gmail.com","Student181","Student181","student");
insert into user values("stud182",1,"stud182@gmail.com","Student182","Student182","student");
insert into user values("stud183",1,"stud183@gmail.com","Student183","Student183","student");
insert into user values("stud184",1,"stud184@gmail.com","Student184","Student184","student");
insert into user values("stud185",1,"stud185@gmail.com","Student185","Student185","student");
insert into user values("stud186",1,"stud186@gmail.com","Student186","Student186","student");
insert into user values("stud187",1,"stud187@gmail.com","Student187","Student187","student");
insert into user values("stud188",1,"stud188@gmail.com","Student188","Student188","student");
insert into user values("stud189",1,"stud189@gmail.com","Student189","Student189","student");
insert into user values("stud190",1,"stud190@gmail.com","Student190","Student190","student");
insert into user values("stud191",1,"stud191@gmail.com","Student191","Student191","student");
insert into user values("stud192",1,"stud192@gmail.com","Student192","Student192","student");
insert into user values("stud193",1,"stud193@gmail.com","Student193","Student193","student");
insert into user values("stud194",1,"stud194@gmail.com","Student194","Student194","student");
insert into user values("stud195",1,"stud195@gmail.com","Student195","Student195","student");
insert into user values("stud196",1,"stud196@gmail.com","Student196","Student196","student");
insert into user values("stud197",1,"stud197@gmail.com","Student197","Student197","student");
insert into user values("stud198",1,"stud198@gmail.com","Student198","Student198","student");
insert into user values("stud199",1,"stud199@gmail.com","Student199","Student199","student");
insert into user values("stud200",1,"stud200@gmail.com","Student200","Student200","student");
insert into user values("stud201",1,"stud201@gmail.com","Student201","Student201","student");
insert into user values("stud202",1,"stud202@gmail.com","Student202","Student202","student");
insert into user values("stud203",1,"stud203@gmail.com","Student203","Student203","student");
insert into user values("stud204",1,"stud204@gmail.com","Student204","Student204","student");
insert into user values("stud205",1,"stud205@gmail.com","Student205","Student205","student");
insert into user values("stud206",1,"stud206@gmail.com","Student206","Student206","student");
insert into user values("stud207",1,"stud207@gmail.com","Student207","Student207","student");
insert into user values("stud208",1,"stud208@gmail.com","Student208","Student208","student");
insert into user values("stud209",1,"stud209@gmail.com","Student209","Student209","student");
insert into user values("stud210",1,"stud210@gmail.com","Student210","Student210","student");
insert into user values("stud211",1,"stud211@gmail.com","Student211","Student211","student");
insert into user values("stud212",1,"stud212@gmail.com","Student212","Student212","student");
insert into user values("stud213",1,"stud213@gmail.com","Student213","Student213","student");
insert into user values("stud214",1,"stud214@gmail.com","Student214","Student214","student");
insert into user values("stud215",1,"stud215@gmail.com","Student215","Student215","student");
insert into user values("stud216",1,"stud216@gmail.com","Student216","Student216","student");
insert into user values("stud217",1,"stud217@gmail.com","Student217","Student217","student");
insert into user values("stud218",1,"stud218@gmail.com","Student218","Student218","student");
insert into user values("stud219",1,"stud219@gmail.com","Student219","Student219","student");
insert into user values("stud220",1,"stud220@gmail.com","Student220","Student220","student");
insert into user values("stud221",1,"stud221@gmail.com","Student221","Student221","student");
insert into user values("stud222",1,"stud222@gmail.com","Student222","Student222","student");
insert into user values("stud223",1,"stud223@gmail.com","Student223","Student223","student");
insert into user values("stud224",1,"stud224@gmail.com","Student224","Student224","student");
insert into user values("stud225",1,"stud225@gmail.com","Student225","Student225","student");
insert into user values("stud226",1,"stud226@gmail.com","Student226","Student226","student");
insert into user values("stud227",1,"stud227@gmail.com","Student227","Student227","student");
insert into user values("stud228",1,"stud228@gmail.com","Student228","Student228","student");
insert into user values("stud229",1,"stud229@gmail.com","Student229","Student229","student");
insert into user values("stud230",1,"stud230@gmail.com","Student230","Student230","student");
insert into user values("stud231",1,"stud231@gmail.com","Student231","Student231","student");
insert into user values("stud232",1,"stud232@gmail.com","Student232","Student232","student");
insert into user values("stud233",1,"stud233@gmail.com","Student233","Student233","student");
insert into user values("stud234",1,"stud234@gmail.com","Student234","Student234","student");
insert into user values("stud235",1,"stud235@gmail.com","Student235","Student235","student");
insert into user values("stud236",1,"stud236@gmail.com","Student236","Student236","student");
insert into user values("stud237",1,"stud237@gmail.com","Student237","Student237","student");
insert into user values("stud238",1,"stud238@gmail.com","Student238","Student238","student");
insert into user values("stud239",1,"stud239@gmail.com","Student239","Student239","student");
insert into user values("stud240",1,"stud240@gmail.com","Student240","Student240","student");

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
/*ME sem3*/
INSERT INTO `course` VALUES ('610101',4,'Advanced Storeage Systems and Infrastructure Management',3,'R','ME',1,4,0,'CO');
INSERT INTO `course` VALUES ('610102',4,'Advanced Unix Programming',3,'R','ME',1,4,0,'CO');
INSERT INTO `course` VALUES ('610103',5,'Elective 3',3,'E','ME',1,5,0,'CO');

/*ME sem2*/
INSERT INTO `course` VALUES ('510107',4,'Operating System Design',2,'R','ME',1,4,0,'CO');
INSERT INTO `course` VALUES ('510108',4,'Software Design and Architecture',2,'R','ME',1,4,0,'CO');
INSERT INTO `course` VALUES ('510109',4,'Advanced Computer Networks',2,'R','ME',1,4,0,'CO');
INSERT INTO `course` VALUES ('510110',5,'Elective 2',2,'E','ME',1,5,0,'CO');
INSERT INTO `course` VALUES ('510111',4,'LP-2',2,'R','ME',0,4,0,'CO');

/*ME sem1*/
INSERT INTO `course` VALUES ('510101',4,'Applied Algorithms',1,'R','ME',1,4,0,'CO');
INSERT INTO `course` VALUES ('510102',4,'High Performance Databases',1,'R','ME',1,4,0,'CO');
INSERT INTO `course` VALUES ('510103',4,'Advanced Computer Architecture',1,'R','ME',1,4,0,'CO');
INSERT INTO `course` VALUES ('510104',4,'Research Methodolody',1,'R','ME',1,4,0,'CO');
INSERT INTO `course` VALUES ('510105',5,'Elective 1',1,'E','ME',1,5,0,'CO');
INSERT INTO `course` VALUES ('510106',4,'LP1',1,'R','ME',0,4,0,'CO');

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
/*ME sem3 elective3*/
INSERT INTO `electives` VALUES ('610103A','Network Security','610103');
INSERT INTO `electives` VALUES ('610103B','Cloud Computing','610103');
INSERT INTO `electives` VALUES ('610103C','Computer Vision and Pattern Recognition','610103');
INSERT INTO `electives` VALUES ('610103D','Soft Computing','610103');
INSERT INTO `electives` VALUES ('610103E','Open Elective','610103');

/*ME sem2 elective2*/
INSERT INTO `electives` VALUES ('510110A','Business Intelligence and Data Mining','510110');
INSERT INTO `electives` VALUES ('510110B','Usability Engineering','510110');
INSERT INTO `electives` VALUES ('510110C','Advanced Compiler Design','510110');
INSERT INTO `electives` VALUES ('510110D','Embedded System Design','510110');
INSERT INTO `electives` VALUES ('510110E','Open Elective','510110');

/*ME sem1 elective1*/
INSERT INTO `electives` VALUES ('510105A','Intelligent Systems','510105');
INSERT INTO `electives` VALUES ('510105B','IR and Web Mining','510105');
INSERT INTO `electives` VALUES ('510105C','Machine Learning and Translation','510105');
INSERT INTO `electives` VALUES ('510105D','Real Time Systems','510105');
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
insert into student_acad values("stud1",79.5,"101",8,1,"BE","CO","BECOA","stud1");
insert into student_acad values("stud2",55.09,"102",8,1,"BE","CO","BECOA","stud2");
insert into student_acad values("stud3",77.28,"103",8,1,"BE","CO","BECOA","stud3");
insert into student_acad values("stud4",76.99,"104",8,1,"BE","CO","BECOA","stud4");
insert into student_acad values("stud5",73.96,"105",8,1,"BE","CO","BECOA","stud5");
insert into student_acad values("stud6",51.43,"106",8,1,"BE","CO","BECOA","stud6");
insert into student_acad values("stud7",54.08,"107",8,1,"BE","CO","BECOA","stud7");
insert into student_acad values("stud8",53.35,"108",8,1,"BE","CO","BECOA","stud8");
insert into student_acad values("stud9",97.47,"109",8,1,"BE","CO","BECOA","stud9");
insert into student_acad values("stud10",60.14,"110",8,1,"BE","CO","BECOA","stud10");
insert into student_acad values("stud11",98.59,"111",8,1,"BE","CO","BECOA","stud11");
insert into student_acad values("stud12",63.89,"112",8,1,"BE","CO","BECOA","stud12");
insert into student_acad values("stud13",78.8,"113",8,1,"BE","CO","BECOA","stud13");
insert into student_acad values("stud14",53.21,"114",8,1,"BE","CO","BECOA","stud14");
insert into student_acad values("stud15",56.8,"115",8,1,"BE","CO","BECOA","stud15");
insert into student_acad values("stud16",86.8,"116",8,1,"BE","CO","BECOA","stud16");
insert into student_acad values("stud17",57.05,"117",8,1,"BE","CO","BECOA","stud17");
insert into student_acad values("stud18",73.85,"118",8,1,"BE","CO","BECOA","stud18");
insert into student_acad values("stud19",72.59,"119",8,1,"BE","CO","BECOA","stud19");
insert into student_acad values("stud20",53.31,"120",8,1,"BE","CO","BECOA","stud20");
insert into student_acad values("stud21",97.76,"121",8,1,"BE","CO","BECOA","stud21");
insert into student_acad values("stud22",72.83,"122",8,1,"BE","CO","BECOA","stud22");
insert into student_acad values("stud23",89.19,"123",8,1,"BE","CO","BECOA","stud23");
insert into student_acad values("stud24",86.13,"124",8,1,"BE","CO","BECOA","stud24");
insert into student_acad values("stud25",56.63,"125",8,1,"BE","CO","BECOA","stud25");
insert into student_acad values("stud26",97.3,"126",8,1,"BE","CO","BECOA","stud26");
insert into student_acad values("stud27",70.2,"127",8,1,"BE","CO","BECOA","stud27");
insert into student_acad values("stud28",53.85,"128",8,1,"BE","CO","BECOA","stud28");
insert into student_acad values("stud29",97.92,"129",8,1,"BE","CO","BECOA","stud29");
insert into student_acad values("stud30",73.45,"130",8,1,"BE","CO","BECOA","stud30");
insert into student_acad values("stud31",93.21,"131",8,1,"BE","CO","BECOA","stud31");
insert into student_acad values("stud32",72.61,"132",8,1,"BE","CO","BECOA","stud32");
insert into student_acad values("stud33",68.23,"133",8,1,"BE","CO","BECOA","stud33");
insert into student_acad values("stud34",51.9,"134",8,1,"BE","CO","BECOA","stud34");
insert into student_acad values("stud35",97.21,"135",8,1,"BE","CO","BECOA","stud35");
insert into student_acad values("stud36",98.94,"136",8,1,"BE","CO","BECOA","stud36");
insert into student_acad values("stud37",67.27,"137",8,1,"BE","CO","BECOA","stud37");
insert into student_acad values("stud38",62.07,"138",8,1,"BE","CO","BECOA","stud38");
insert into student_acad values("stud39",93.63,"139",8,1,"BE","CO","BECOA","stud39");
insert into student_acad values("stud40",91.79,"140",8,1,"BE","CO","BECOA","stud40");
insert into student_acad values("stud41",67.4,"141",8,1,"BE","CO","BECOA","stud41");
insert into student_acad values("stud42",67.68,"142",8,1,"BE","CO","BECOA","stud42");
insert into student_acad values("stud43",75.81,"143",8,1,"BE","CO","BECOA","stud43");
insert into student_acad values("stud44",56.68,"144",8,1,"BE","CO","BECOA","stud44");
insert into student_acad values("stud45",89.63,"145",8,1,"BE","CO","BECOA","stud45");
insert into student_acad values("stud46",79.77,"146",8,1,"BE","CO","BECOA","stud46");
insert into student_acad values("stud47",73.46,"147",8,1,"BE","CO","BECOA","stud47");
insert into student_acad values("stud48",69.98,"148",8,1,"BE","CO","BECOA","stud48");
insert into student_acad values("stud49",67.26,"149",8,1,"BE","CO","BECOA","stud49");
insert into student_acad values("stud50",92.33,"150",8,1,"BE","CO","BECOA","stud50");
insert into student_acad values("stud51",64.59,"151",8,1,"BE","CO","BECOA","stud51");
insert into student_acad values("stud52",59.3,"152",8,1,"BE","CO","BECOA","stud52");
insert into student_acad values("stud53",72.44,"153",8,1,"BE","CO","BECOA","stud53");
insert into student_acad values("stud54",64.44,"154",8,1,"BE","CO","BECOA","stud54");
insert into student_acad values("stud55",88.17,"155",8,1,"BE","CO","BECOA","stud55");
insert into student_acad values("stud56",83.74,"156",8,1,"BE","CO","BECOA","stud56");
insert into student_acad values("stud57",54.45,"157",8,1,"BE","CO","BECOA","stud57");
insert into student_acad values("stud58",77.82,"158",8,1,"BE","CO","BECOA","stud58");
insert into student_acad values("stud59",66.96,"159",8,1,"BE","CO","BECOA","stud59");
insert into student_acad values("stud60",74.87,"160",8,1,"BE","CO","BECOA","stud60");
insert into student_acad values("stud61",89.68,"161",8,1,"BE","CO","BECOA","stud61");
insert into student_acad values("stud62",67.41,"162",8,1,"BE","CO","BECOA","stud62");
insert into student_acad values("stud63",78.63,"163",8,1,"BE","CO","BECOA","stud63");
insert into student_acad values("stud64",58.25,"164",8,1,"BE","CO","BECOA","stud64");
insert into student_acad values("stud65",98.54,"165",8,1,"BE","CO","BECOA","stud65");
insert into student_acad values("stud66",74.89,"166",8,1,"BE","CO","BECOA","stud66");
insert into student_acad values("stud67",60.68,"167",8,1,"BE","CO","BECOA","stud67");
insert into student_acad values("stud68",53.96,"168",8,1,"BE","CO","BECOA","stud68");
insert into student_acad values("stud69",55.47,"169",8,1,"BE","CO","BECOA","stud69");
insert into student_acad values("stud70",59.49,"170",8,1,"BE","CO","BECOA","stud70");
insert into student_acad values("stud71",62.42,"171",8,1,"BE","CO","BECOA","stud71");
insert into student_acad values("stud72",63.43,"172",8,1,"BE","CO","BECOA","stud72");
insert into student_acad values("stud73",57.87,"173",8,1,"BE","CO","BECOA","stud73");
insert into student_acad values("stud74",80.19,"174",8,1,"BE","CO","BECOA","stud74");
insert into student_acad values("stud75",56.63,"175",8,1,"BE","CO","BECOA","stud75");
insert into student_acad values("stud76",70.52,"176",8,1,"BE","CO","BECOA","stud76");
insert into student_acad values("stud77",90.1,"177",8,1,"BE","CO","BECOA","stud77");
insert into student_acad values("stud78",60.41,"178",8,1,"BE","CO","BECOA","stud78");
insert into student_acad values("stud79",72.62,"179",8,1,"BE","CO","BECOA","stud79");
insert into student_acad values("stud80",68.29,"180",8,1,"BE","CO","BECOA","stud80");
insert into student_acad values("stud81",97.56,"201",8,2,"BE","CO","BECOB","stud81");
insert into student_acad values("stud82",85.67,"202",8,2,"BE","CO","BECOB","stud82");
insert into student_acad values("stud83",56.24,"203",8,2,"BE","CO","BECOB","stud83");
insert into student_acad values("stud84",74.09,"204",8,2,"BE","CO","BECOB","stud84");
insert into student_acad values("stud85",78.81,"205",8,2,"BE","CO","BECOB","stud85");
insert into student_acad values("stud86",77.61,"206",8,2,"BE","CO","BECOB","stud86");
insert into student_acad values("stud87",92.34,"207",8,2,"BE","CO","BECOB","stud87");
insert into student_acad values("stud88",80.59,"208",8,2,"BE","CO","BECOB","stud88");
insert into student_acad values("stud89",88.19,"209",8,2,"BE","CO","BECOB","stud89");
insert into student_acad values("stud90",99.1,"210",8,2,"BE","CO","BECOB","stud90");
insert into student_acad values("stud91",97.63,"211",8,2,"BE","CO","BECOB","stud91");
insert into student_acad values("stud92",98.21,"212",8,2,"BE","CO","BECOB","stud92");
insert into student_acad values("stud93",72.35,"213",8,2,"BE","CO","BECOB","stud93");
insert into student_acad values("stud94",65.12,"214",8,2,"BE","CO","BECOB","stud94");
insert into student_acad values("stud95",96.13,"215",8,2,"BE","CO","BECOB","stud95");
insert into student_acad values("stud96",87.13,"216",8,2,"BE","CO","BECOB","stud96");
insert into student_acad values("stud97",75.23,"217",8,2,"BE","CO","BECOB","stud97");
insert into student_acad values("stud98",74.62,"218",8,2,"BE","CO","BECOB","stud98");
insert into student_acad values("stud99",71.18,"219",8,2,"BE","CO","BECOB","stud99");
insert into student_acad values("stud100",63.18,"220",8,2,"BE","CO","BECOB","stud100");
insert into student_acad values("stud101",63.42,"221",8,2,"BE","CO","BECOB","stud101");
insert into student_acad values("stud102",64.89,"222",8,2,"BE","CO","BECOB","stud102");
insert into student_acad values("stud103",50.48,"223",8,2,"BE","CO","BECOB","stud103");
insert into student_acad values("stud104",82.86,"224",8,2,"BE","CO","BECOB","stud104");
insert into student_acad values("stud105",52.52,"225",8,2,"BE","CO","BECOB","stud105");
insert into student_acad values("stud106",79.22,"226",8,2,"BE","CO","BECOB","stud106");
insert into student_acad values("stud107",82.47,"227",8,2,"BE","CO","BECOB","stud107");
insert into student_acad values("stud108",66.56,"228",8,2,"BE","CO","BECOB","stud108");
insert into student_acad values("stud109",83.39,"229",8,2,"BE","CO","BECOB","stud109");
insert into student_acad values("stud110",78.4,"230",8,2,"BE","CO","BECOB","stud110");
insert into student_acad values("stud111",55.71,"231",8,2,"BE","CO","BECOB","stud111");
insert into student_acad values("stud112",83.61,"232",8,2,"BE","CO","BECOB","stud112");
insert into student_acad values("stud113",55.07,"233",8,2,"BE","CO","BECOB","stud113");
insert into student_acad values("stud114",95.49,"234",8,2,"BE","CO","BECOB","stud114");
insert into student_acad values("stud115",73.36,"235",8,2,"BE","CO","BECOB","stud115");
insert into student_acad values("stud116",71.11,"236",8,2,"BE","CO","BECOB","stud116");
insert into student_acad values("stud117",95.97,"237",8,2,"BE","CO","BECOB","stud117");
insert into student_acad values("stud118",78.83,"238",8,2,"BE","CO","BECOB","stud118");
insert into student_acad values("stud119",94.77,"239",8,2,"BE","CO","BECOB","stud119");
insert into student_acad values("stud120",64.53,"240",8,2,"BE","CO","BECOB","stud120");
insert into student_acad values("stud121",76.65,"241",8,2,"BE","CO","BECOB","stud121");
insert into student_acad values("stud122",98.72,"242",8,2,"BE","CO","BECOB","stud122");
insert into student_acad values("stud123",72.29,"243",8,2,"BE","CO","BECOB","stud123");
insert into student_acad values("stud124",95.01,"244",8,2,"BE","CO","BECOB","stud124");
insert into student_acad values("stud125",82.26,"245",8,2,"BE","CO","BECOB","stud125");
insert into student_acad values("stud126",89.41,"246",8,2,"BE","CO","BECOB","stud126");
insert into student_acad values("stud127",84.67,"247",8,2,"BE","CO","BECOB","stud127");
insert into student_acad values("stud128",63.1,"248",8,2,"BE","CO","BECOB","stud128");
insert into student_acad values("stud129",83.02,"249",8,2,"BE","CO","BECOB","stud129");
insert into student_acad values("stud130",64.42,"250",8,2,"BE","CO","BECOB","stud130");
insert into student_acad values("stud131",64.45,"251",8,2,"BE","CO","BECOB","stud131");
insert into student_acad values("stud132",53.62,"252",8,2,"BE","CO","BECOB","stud132");
insert into student_acad values("stud133",78.53,"253",8,2,"BE","CO","BECOB","stud133");
insert into student_acad values("stud134",73.48,"254",8,2,"BE","CO","BECOB","stud134");
insert into student_acad values("stud135",53.36,"255",8,2,"BE","CO","BECOB","stud135");
insert into student_acad values("stud136",88.74,"256",8,2,"BE","CO","BECOB","stud136");
insert into student_acad values("stud137",54.21,"257",8,2,"BE","CO","BECOB","stud137");
insert into student_acad values("stud138",65.85,"258",8,2,"BE","CO","BECOB","stud138");
insert into student_acad values("stud139",66.81,"259",8,2,"BE","CO","BECOB","stud139");
insert into student_acad values("stud140",67.17,"260",8,2,"BE","CO","BECOB","stud140");
insert into student_acad values("stud141",74.9,"261",8,2,"BE","CO","BECOB","stud141");
insert into student_acad values("stud142",62.52,"262",8,2,"BE","CO","BECOB","stud142");
insert into student_acad values("stud143",70.79,"263",8,2,"BE","CO","BECOB","stud143");
insert into student_acad values("stud144",62.93,"264",8,2,"BE","CO","BECOB","stud144");
insert into student_acad values("stud145",58.69,"265",8,2,"BE","CO","BECOB","stud145");
insert into student_acad values("stud146",79.8,"266",8,2,"BE","CO","BECOB","stud146");
insert into student_acad values("stud147",86.4,"267",8,2,"BE","CO","BECOB","stud147");
insert into student_acad values("stud148",95.54,"268",8,2,"BE","CO","BECOB","stud148");
insert into student_acad values("stud149",82.34,"269",8,2,"BE","CO","BECOB","stud149");
insert into student_acad values("stud150",86.0,"270",8,2,"BE","CO","BECOB","stud150");
insert into student_acad values("stud151",70.18,"271",8,2,"BE","CO","BECOB","stud151");
insert into student_acad values("stud152",62.42,"272",8,2,"BE","CO","BECOB","stud152");
insert into student_acad values("stud153",69.91,"273",8,2,"BE","CO","BECOB","stud153");
insert into student_acad values("stud154",69.46,"274",8,2,"BE","CO","BECOB","stud154");
insert into student_acad values("stud155",65.21,"275",8,2,"BE","CO","BECOB","stud155");
insert into student_acad values("stud156",76.08,"276",8,2,"BE","CO","BECOB","stud156");
insert into student_acad values("stud157",71.16,"277",8,2,"BE","CO","BECOB","stud157");
insert into student_acad values("stud158",93.6,"278",8,2,"BE","CO","BECOB","stud158");
insert into student_acad values("stud159",85.18,"279",8,2,"BE","CO","BECOB","stud159");
insert into student_acad values("stud160",58.48,"280",8,2,"BE","CO","BECOB","stud160");
insert into student_acad values("stud161",74.43,"301",8,2,"BE","CO","BECOC","stud161");
insert into student_acad values("stud162",70.77,"302",8,2,"BE","CO","BECOC","stud162");
insert into student_acad values("stud163",72.96,"303",8,2,"BE","CO","BECOC","stud163");
insert into student_acad values("stud164",76.25,"304",8,2,"BE","CO","BECOC","stud164");
insert into student_acad values("stud165",82.65,"305",8,2,"BE","CO","BECOC","stud165");
insert into student_acad values("stud166",87.16,"306",8,2,"BE","CO","BECOC","stud166");
insert into student_acad values("stud167",79.11,"307",8,2,"BE","CO","BECOC","stud167");
insert into student_acad values("stud168",76.41,"308",8,2,"BE","CO","BECOC","stud168");
insert into student_acad values("stud169",94.24,"309",8,2,"BE","CO","BECOC","stud169");
insert into student_acad values("stud170",88.4,"310",8,2,"BE","CO","BECOC","stud170");
insert into student_acad values("stud171",82.13,"311",8,2,"BE","CO","BECOC","stud171");
insert into student_acad values("stud172",63.34,"312",8,2,"BE","CO","BECOC","stud172");
insert into student_acad values("stud173",62.14,"313",8,2,"BE","CO","BECOC","stud173");
insert into student_acad values("stud174",91.82,"314",8,2,"BE","CO","BECOC","stud174");
insert into student_acad values("stud175",52.81,"315",8,2,"BE","CO","BECOC","stud175");
insert into student_acad values("stud176",57.72,"316",8,2,"BE","CO","BECOC","stud176");
insert into student_acad values("stud177",61.1,"317",8,2,"BE","CO","BECOC","stud177");
insert into student_acad values("stud178",71.11,"318",8,2,"BE","CO","BECOC","stud178");
insert into student_acad values("stud179",57.72,"319",8,2,"BE","CO","BECOC","stud179");
insert into student_acad values("stud180",90.83,"320",8,2,"BE","CO","BECOC","stud180");
insert into student_acad values("stud181",79.1,"321",8,2,"BE","CO","BECOC","stud181");
insert into student_acad values("stud182",74.57,"322",8,2,"BE","CO","BECOC","stud182");
insert into student_acad values("stud183",88.81,"323",8,2,"BE","CO","BECOC","stud183");
insert into student_acad values("stud184",76.95,"324",8,2,"BE","CO","BECOC","stud184");
insert into student_acad values("stud185",77.05,"325",8,2,"BE","CO","BECOC","stud185");
insert into student_acad values("stud186",68.34,"326",8,2,"BE","CO","BECOC","stud186");
insert into student_acad values("stud187",85.42,"327",8,2,"BE","CO","BECOC","stud187");
insert into student_acad values("stud188",92.54,"328",8,2,"BE","CO","BECOC","stud188");
insert into student_acad values("stud189",62.57,"329",8,2,"BE","CO","BECOC","stud189");
insert into student_acad values("stud190",92.66,"330",8,2,"BE","CO","BECOC","stud190");
insert into student_acad values("stud191",95.1,"331",8,2,"BE","CO","BECOC","stud191");
insert into student_acad values("stud192",85.53,"332",8,2,"BE","CO","BECOC","stud192");
insert into student_acad values("stud193",63.91,"333",8,2,"BE","CO","BECOC","stud193");
insert into student_acad values("stud194",88.24,"334",8,2,"BE","CO","BECOC","stud194");
insert into student_acad values("stud195",94.0,"335",8,2,"BE","CO","BECOC","stud195");
insert into student_acad values("stud196",79.91,"336",8,2,"BE","CO","BECOC","stud196");
insert into student_acad values("stud197",52.94,"337",8,2,"BE","CO","BECOC","stud197");
insert into student_acad values("stud198",59.2,"338",8,2,"BE","CO","BECOC","stud198");
insert into student_acad values("stud199",89.32,"339",8,2,"BE","CO","BECOC","stud199");
insert into student_acad values("stud200",55.89,"340",8,2,"BE","CO","BECOC","stud200");
insert into student_acad values("stud201",74.84,"341",8,2,"BE","CO","BECOC","stud201");
insert into student_acad values("stud202",58.67,"342",8,2,"BE","CO","BECOC","stud202");
insert into student_acad values("stud203",75.6,"343",8,2,"BE","CO","BECOC","stud203");
insert into student_acad values("stud204",55.6,"344",8,2,"BE","CO","BECOC","stud204");
insert into student_acad values("stud205",60.64,"345",8,2,"BE","CO","BECOC","stud205");
insert into student_acad values("stud206",92.82,"346",8,2,"BE","CO","BECOC","stud206");
insert into student_acad values("stud207",57.55,"347",8,2,"BE","CO","BECOC","stud207");
insert into student_acad values("stud208",80.99,"348",8,2,"BE","CO","BECOC","stud208");
insert into student_acad values("stud209",64.42,"349",8,2,"BE","CO","BECOC","stud209");
insert into student_acad values("stud210",76.29,"350",8,2,"BE","CO","BECOC","stud210");
insert into student_acad values("stud211",87.9,"351",8,2,"BE","CO","BECOC","stud211");
insert into student_acad values("stud212",55.81,"352",8,2,"BE","CO","BECOC","stud212");
insert into student_acad values("stud213",97.38,"353",8,2,"BE","CO","BECOC","stud213");
insert into student_acad values("stud214",67.67,"354",8,2,"BE","CO","BECOC","stud214");
insert into student_acad values("stud215",69.69,"355",8,2,"BE","CO","BECOC","stud215");
insert into student_acad values("stud216",55.68,"356",8,2,"BE","CO","BECOC","stud216");
insert into student_acad values("stud217",58.26,"357",8,2,"BE","CO","BECOC","stud217");
insert into student_acad values("stud218",98.66,"358",8,2,"BE","CO","BECOC","stud218");
insert into student_acad values("stud219",70.66,"359",8,2,"BE","CO","BECOC","stud219");
insert into student_acad values("stud220",60.04,"360",8,2,"BE","CO","BECOC","stud220");
insert into student_acad values("stud221",54.62,"361",8,2,"BE","CO","BECOC","stud221");
insert into student_acad values("stud222",89.45,"362",8,2,"BE","CO","BECOC","stud222");
insert into student_acad values("stud223",81.04,"363",8,2,"BE","CO","BECOC","stud223");
insert into student_acad values("stud224",75.95,"364",8,2,"BE","CO","BECOC","stud224");
insert into student_acad values("stud225",68.5,"365",8,2,"BE","CO","BECOC","stud225");
insert into student_acad values("stud226",81.31,"366",8,2,"BE","CO","BECOC","stud226");
insert into student_acad values("stud227",52.98,"367",8,2,"BE","CO","BECOC","stud227");
insert into student_acad values("stud228",93.14,"368",8,2,"BE","CO","BECOC","stud228");
insert into student_acad values("stud229",75.31,"369",8,2,"BE","CO","BECOC","stud229");
insert into student_acad values("stud230",86.6,"370",8,2,"BE","CO","BECOC","stud230");
insert into student_acad values("stud231",97.66,"371",8,2,"BE","CO","BECOC","stud231");
insert into student_acad values("stud232",90.14,"372",8,2,"BE","CO","BECOC","stud232");
insert into student_acad values("stud233",50.75,"373",8,2,"BE","CO","BECOC","stud233");
insert into student_acad values("stud234",69.14,"374",8,2,"BE","CO","BECOC","stud234");
insert into student_acad values("stud235",76.27,"375",8,2,"BE","CO","BECOC","stud235");
insert into student_acad values("stud236",65.79,"376",8,2,"BE","CO","BECOC","stud236");
insert into student_acad values("stud237",84.86,"377",8,2,"BE","CO","BECOC","stud237");
insert into student_acad values("stud238",92.94,"378",8,2,"BE","CO","BECOC","stud238");
insert into student_acad values("stud239",52.07,"379",8,2,"BE","CO","BECOC","stud239");
insert into student_acad values("stud240",64.68,"380",8,2,"BE","CO","BECOC","stud240");


/*FACULTY_ACAD TABLE*/
insert into faculty_acad values('fac1','Professor','PHD',20,'CO','fac1');
insert into faculty_acad values('fac2','Professor','PHD',18.4,'CO','fac2');
insert into faculty_acad values('fac3','Professor','PHD',18.4,'CO','fac3');
insert into faculty_acad values('fac4','Professor','PHD',20,'CO','fac4');
insert into faculty_acad values('fac5','Associate Professor','PHD',15,'CO','fac5');
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

/*FACULTY_PREF TABLE*/
/*fac prefs for 36 facs*/
/*
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

/* Required for accepting preference for COMP dept, even semester*/
/*INSERT INTO open_faculty_prefs values('CO',0,1);*/
	
