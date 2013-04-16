INSERT INTO users VALUES ('customer','asd123','kunde','kundesen','adresseveien 3','46257954','martinalmvik@hotmail.com',7046);
INSERT INTO users VALUES ('driver','asd123','sjåfør','sjåførsen','adresseveien 21', '457845512','b@post.no', 7049 );
INSERT INTO users VALUES ('admin','asd123','admin','administratorsen','adresseveien 26', '457812412','c@post.no', 7049);
INSERT INTO users VALUES ('salesman','asd123','selger','selgersen','adresseveien 23', '457845512','d@post.no', 7049);
INSERT INTO users VALUES ('chef','asd123','kokk','administratorsen','adresseveien 26', '457824512','e@post.no', 7049);
INSERT INTO users VALUES ('bedrift','asd123','bedrift','bedriftersen','adresseveien 23', '457845132','f@post.no', 7049);
 
INSERT INTO Roles VALUES ('admin','admin');
INSERT INTO Roles VALUES ('customer','customer');
INSERT INTO Roles VALUES ('chef','chef');
INSERT INTO Roles VALUES ('driver','driver');
INSERT INTO Roles VALUES ('salesman','salesman');

INSERT INTO users VALUES ('salesman2','asd123','selger','selgersen','adresseveien 23', '457845512','6@post.no', 7049);
INSERT INTO users VALUES ('salesman3','asd123','selger','selgersen','adresseveien 23', '457845512','7@post.no', 7049);
INSERT INTO Roles VALUES ('salesman','salesman2');
INSERT INTO Roles VALUES ('salesman','salesman3');

INSERT INTO CUSTOMER VALUES ('customer');
INSERT INTO CUSTOMER VALUES ('bedrift');
INSERT INTO private VALUES ('customer');

INSERT INTO EMPLOYEE VALUES ('admin', 1);
INSERT INTO EMPLOYEE VALUES ('customer', 1);

INSERT INTO administration VALUES ('admin');

INSERT INTO worker VALUES ('driver');
INSERT INTO worker VALUES ('salesman');
INSERT INTO worker VALUES ('chef');

INSERT INTO driver VALUES ('driver');
INSERT INTO chef VALUES ('chef');
INSERT INTO salesman VALUES ('salesman');
INSERT INTO salesman VALUES ('salesman2');
INSERT INTO salesman VALUES ('salesman3');

INSERT INTO dish (dishname,dishprice) VALUES ('spaghetti',100.00);
INSERT INTO dish (dishname,dishprice) VALUES ('laks',200.75);
INSERT INTO dish (dishname,dishprice) VALUES ('biff',358.00);
INSERT INTO dish (dishname,dishprice) VALUES ('GRÆNDIS',30.00);

INSERT INTO subscriptionplan(startdate, enddate, timeofdelivery, weekday) VALUES((DATE(2013-02-25)),(DATE(2016-02-26)), (TIME('12:45:19')), 1);

INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('23:03:03','adresseveien x', 4,'customer',null,7046,'2013-03-02', 1002);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('18:03:03','adresseveien x', 2,'bedrift',1,7046,'2013-02-02', 489);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:04:03','adresseveien xg', 1,'customer',null,7046,'2013-03-09', 488);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:09:03','adresseveien x', 0,'bedrift',1,7046,'2013-02-09', 499);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:06:03','adresseveien f', 6,'customer',null,7046,'2013-03-17', 286);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('11:03:03','adresseveien x', 7,'bedrift',1,7046,'2013-02-17', 482);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('11:03:03','adresseveien x', 7,'bedrift',1,7046,'2013-02-17', 482);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('11:03:03','adresseveien x', 7,'bedrift',1,7046,'2013-02-17', 482);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('11:03:03','adresseveien x', 7,'bedrift',1,7046,'2013-02-17', 482);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('11:03:03','adresseveien x', 7,'bedrift',1,7046,'2013-02-17', 482);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('11:02:00','adresseveien x', 4,'customer',null,7046,'2013-03-23', 918);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('11:03:00','adresseveien x', 1,'bedrift',1,7046,'2013-02-23', 1093);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('12:02:00','adresseveien x', 3,'customer',null,7046,'2013-03-29', 387);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('12:02:01','adresseveien y', 6,'bedrift',1,7046,'2013-02-25', 484);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien z', 2,'customer',null,7046,'2013-03-15', 347);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 2,'bedrift',1,7046,'2013-02-15', 211);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'customer',null,7046,'2013-03-28', 98.1);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-03-02', 135);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-03-09',235);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-03-17', 335);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-03-23', 353);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-03-29', 686);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-03-15', 600);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 7,'bedrift',1,7046,'2013-03-28', 700);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-02-02', 800);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-02-09', 900);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-02-17', 1000);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-02-23', 1100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-02-29', 1200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-02-15', 1030);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-03-02', 100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-01-09', 200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-01-17', 300);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-01-23', 400);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-01-29', 500);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-01-15', 600);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 7,'bedrift',1,7046,'2013-04-28', 700);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-05-02', 800);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-05-09', 900);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-04-17', 1000);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-06-23', 1100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-06-29', 1200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-07-15', 1030);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-07-02', 100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-09-09', 200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-09-17', 300);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-08-23', 400);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-08-29', 500);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-10-15', 600);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 7,'bedrift',1,7046,'2013-10-28', 700);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-10-02', 800);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-10-09', 900);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-11-17', 1000);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-11-23', 1100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-12-29', 1200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-12-15', 1030);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-11-02', 100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-03-09', 200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2012-03-17', 300);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-03-23', 400);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-03-29', 500);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-12-15', 600);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 7,'bedrift',1,7046,'2012-12-28', 700);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-12-02', 100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-12-09', 900);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-12-17', 1000);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-12-23', 1100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2013-11-29', 1200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'bedrift',1,7046,'2011-11-15', 1030);

INSERT INTO dishes_ordered VALUES (1,1,2);

INSERT INTO dishes_stored  VALUES (1,3,2,
                            (SELECT totalPrice from orders where orderid=3),
                            (SELECT dates from orders where orderid = 3),
                            (SELECT postalcode from orders where orderid = 3),'salesman2'); 
INSERT INTO dishes_stored  VALUES (1,4,2,
                            (SELECT totalPrice from orders where orderid=4),
                            (SELECT dates from orders where orderid = 4),
                            (SELECT postalcode from orders where orderid = 4),'salesman2'); 
INSERT INTO dishes_stored  VALUES (1,5,2,
                            (SELECT totalPrice from orders where orderid=5),
                            (SELECT dates from orders where orderid = 5),
                            (SELECT postalcode from orders where orderid = 5),'salesman2'); 
INSERT INTO dishes_stored  VALUES (1,6,2,
                            (SELECT totalPrice from orders where orderid=6),
                            (SELECT dates from orders where orderid = 6),
                            (SELECT postalcode from orders where orderid = 6),'salesman2'); 
INSERT INTO dishes_stored  VALUES (2,7,2,
                            (SELECT totalPrice from orders where orderid=7),
                            (SELECT dates from orders where orderid = 7),
                            (SELECT postalcode from orders where orderid = 7),'salesman2'); 
INSERT INTO dishes_stored  VALUES (2,8,2,
                            (SELECT totalPrice from orders where orderid=8),
                            (SELECT dates from orders where orderid = 8),
                            (SELECT postalcode from orders where orderid = 8),'salesman2'); 
INSERT INTO dishes_stored  VALUES (2,9,2,
                            (SELECT totalPrice from orders where orderid=9),
                            (SELECT dates from orders where orderid = 9),
                            (SELECT postalcode from orders where orderid = 9),'salesman2'); 
INSERT INTO dishes_stored  VALUES (2,10,2,
                            (SELECT totalPrice from orders where orderid=10),
                            (SELECT dates from orders where orderid = 10),
                            (SELECT postalcode from orders where orderid = 10),'salesman2'); 
INSERT INTO dishes_stored  VALUES (1,11,2,
                            (SELECT totalPrice from orders where orderid=11),
                            (SELECT dates from orders where orderid = 11),
                            (SELECT postalcode from orders where orderid = 11),'salesman2'); 
INSERT INTO dishes_stored  VALUES (1,12,2,
                            (SELECT totalPrice from orders where orderid=12),
                            (SELECT dates from orders where orderid = 12),
                            (SELECT postalcode from orders where orderid = 12),'salesman2'); 
INSERT INTO dishes_stored  VALUES (1,13,2,
                            (SELECT totalPrice from orders where orderid=13),
                            (SELECT dates from orders where orderid = 13),
                            (SELECT postalcode from orders where orderid = 13),'salesman2'); 
INSERT INTO dishes_stored  VALUES (2,14,2,
                            (SELECT totalPrice from orders where orderid=14),
                            (SELECT dates from orders where orderid = 14),
                            (SELECT postalcode from orders where orderid = 14),'salesman2'); 
INSERT INTO dishes_stored  VALUES (2,15,2,
                            (SELECT totalPrice from orders where orderid=15),
                            (SELECT dates from orders where orderid = 15),
                            (SELECT postalcode from orders where orderid = 15),'salesman2'); 
INSERT INTO dishes_stored  VALUES (2,16,2,
                            (SELECT totalPrice from orders where orderid=16),
                            (SELECT dates from orders where orderid = 16),
                            (SELECT postalcode from orders where orderid = 16),'salesman2'); 
INSERT INTO dishes_stored  VALUES (2,17,2,
                            (SELECT totalPrice from orders where orderid=17),
                            (SELECT dates from orders where orderid = 17),
                            (SELECT postalcode from orders where orderid = 17),'salesman2'); 
INSERT INTO dishes_stored  VALUES (2,18,2,
                            (SELECT totalPrice from orders where orderid=18),
                            (SELECT dates from orders where orderid = 18),
                            (SELECT postalcode from orders where orderid = 18),'salesman2'); 
INSERT INTO dishes_stored  VALUES (2,19,2,
                            (SELECT totalPrice from orders where orderid=19),
                            (SELECT dates from orders where orderid = 19),
                            (SELECT postalcode from orders where orderid = 19),'salesman2'); 
INSERT INTO dishes_stored  VALUES (2,20,2,
                            (SELECT totalPrice from orders where orderid=20),
                            (SELECT dates from orders where orderid = 20),
                            (SELECT postalcode from orders where orderid = 20),'salesman2'); 
INSERT INTO dishes_stored  VALUES (4,21,2,
                            (SELECT totalPrice from orders where orderid=21),
                            (SELECT dates from orders where orderid = 21),
                            (SELECT postalcode from orders where orderid = 21),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,22,2,
                            (SELECT totalPrice from orders where orderid=22),
                            (SELECT dates from orders where orderid = 22),
                            (SELECT postalcode from orders where orderid = 22),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,23,2,
                            (SELECT totalPrice from orders where orderid=23),
                            (SELECT dates from orders where orderid = 23),
                            (SELECT postalcode from orders where orderid = 23),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,24,2,
                            (SELECT totalPrice from orders where orderid=24),
                            (SELECT dates from orders where orderid = 24),
                            (SELECT postalcode from orders where orderid = 24),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,25,2,
                            (SELECT totalPrice from orders where orderid=25),
                            (SELECT dates from orders where orderid = 25),
                            (SELECT postalcode from orders where orderid = 25),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,26,2,
                            (SELECT totalPrice from orders where orderid=26),
                            (SELECT dates from orders where orderid = 26),
                            (SELECT postalcode from orders where orderid = 26),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,27,2,
                            (SELECT totalPrice from orders where orderid=27),
                            (SELECT dates from orders where orderid = 27),
                            (SELECT postalcode from orders where orderid = 27),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,28,2,
                            (SELECT totalPrice from orders where orderid=28),
                            (SELECT dates from orders where orderid = 28),
                            (SELECT postalcode from orders where orderid = 28,'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,29,2,
                            (SELECT totalPrice from orders where orderid=29),
                            (SELECT dates from orders where orderid = 29),
                            (SELECT postalcode from orders where orderid = 29),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,30,2,
                            (SELECT totalPrice from orders where orderid=30),
                            (SELECT dates from orders where orderid = 30),
                            (SELECT postalcode from orders where orderid = 30),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,31,2,
                            (SELECT totalPrice from orders where orderid=31),
                            (SELECT dates from orders where orderid = 31),
                            (SELECT postalcode from orders where orderid = 31),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,32,2,
                            (SELECT totalPrice from orders where orderid=32),
                            (SELECT dates from orders where orderid = 32),
                            (SELECT postalcode from orders where orderid = 32),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,33,2,
                            (SELECT totalPrice from orders where orderid=33),
                            (SELECT dates from orders where orderid = 33),
                            (SELECT postalcode from orders where orderid = 33),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,34,2,
                            (SELECT totalPrice from orders where orderid=34),
                            (SELECT dates from orders where orderid = 34),
                            (SELECT postalcode from orders where orderid = 34),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,35,2,
                            (SELECT totalPrice from orders where orderid=35),
                            (SELECT dates from orders where orderid = 35),
                            (SELECT postalcode from orders where orderid = 35),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,36,2,
                            (SELECT totalPrice from orders where orderid=36),
                            (SELECT dates from orders where orderid = 36),
                            (SELECT postalcode from orders where orderid = 36),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,37,2,
                            (SELECT totalPrice from orders where orderid=37),
                            (SELECT dates from orders where orderid = 37),
                            (SELECT postalcode from orders where orderid = 37),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,38,2,
                            (SELECT totalPrice from orders where orderid=38),
                            (SELECT dates from orders where orderid = 38),
                            (SELECT postalcode from orders where orderid = 38),'salesman3'); 
INSERT INTO dishes_stored  VALUES (4,39,2,
                            (SELECT totalPrice from orders where orderid=39),
                            (SELECT dates from orders where orderid = 39),
                            (SELECT postalcode from orders where orderid = 39),'salesman3'); 
INSERT INTO dishes_stored  VALUES (3,40,2,
                            (SELECT totalPrice from orders where orderid=40),
                            (SELECT dates from orders where orderid = 40),
                            (SELECT postalcode from orders where orderid = 40),'salesman3'); 
INSERT INTO dishes_stored  VALUES (3,41,2,
                            (SELECT totalPrice from orders where orderid=41),
                            (SELECT dates from orders where orderid = 41),
                            (SELECT postalcode from orders where orderid = 41),'salesman3'); 
INSERT INTO dishes_stored  VALUES (3,42,2,
                            (SELECT totalPrice from orders where orderid=42),
                            (SELECT dates from orders where orderid = 42),
                            (SELECT postalcode from orders where orderid = 42),'salesman3'); 
INSERT INTO dishes_stored  VALUES (3,43,2,
                            (SELECT totalPrice from orders where orderid=43),
                            (SELECT dates from orders where orderid = 43),
                            (SELECT postalcode from orders where orderid = 43),'salesman3'); 
INSERT INTO dishes_stored  VALUES (3,44,2,
                            (SELECT totalPrice from orders where orderid=44),
                            (SELECT dates from orders where orderid = 44),
                            (SELECT postalcode from orders where orderid = 44),'salesman3'); 
INSERT INTO dishes_stored  VALUES (3,45,2,
                            (SELECT totalPrice from orders where orderid=45),
                            (SELECT dates from orders where orderid = 45),
                            (SELECT postalcode from orders where orderid = 45),'salesman3'); 
INSERT INTO dishes_stored  VALUES (3,46,2,
                            (SELECT totalPrice from orders where orderid=46),
                            (SELECT dates from orders where orderid = 46),
                            (SELECT postalcode from orders where orderid = 46),'salesman3'); 
INSERT INTO dishes_stored  VALUES (3,47,2,
                            (SELECT totalPrice from orders where orderid=47),
                            (SELECT dates from orders where orderid = 47),
                            (SELECT postalcode from orders where orderid = 47),'salesman3'); 
INSERT INTO dishes_stored  VALUES (3,48,2,
                            (SELECT totalPrice from orders where orderid=48),
                            (SELECT dates from orders where orderid = 48),
                            (SELECT postalcode from orders where orderid = 48),'salesman3'); 
INSERT INTO dishes_stored  VALUES (3,49,2,
                            (SELECT totalPrice from orders where orderid=49),
                            (SELECT dates from orders where orderid = 49),
                            (SELECT postalcode from orders where orderid = 49),'salesman3'); 
INSERT INTO dishes_stored  VALUES (3,50,2,
                            (SELECT totalPrice from orders where orderid=50),
                            (SELECT dates from orders where orderid = 50),
                            (SELECT postalcode from orders where orderid = 50),'salesman3'); 

