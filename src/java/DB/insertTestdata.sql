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

INSERT INTO CUSTOMER VALUES ('customer');
INSERT INTO CUSTOMER VALUES ('bedrift');
INSERT INTO private VALUES ('customer');
INSERT INTO company VALUES ('bedrift');

INSERT INTO EMPLOYEE VALUES ('admin', 1);
INSERT INTO EMPLOYEE VALUES ('customer', 1);

INSERT INTO administration VALUES ('admin');

INSERT INTO worker VALUES ('driver');
INSERT INTO worker VALUES ('salesman');
INSERT INTO worker VALUES ('chef');

INSERT INTO driver VALUES ('driver');
INSERT INTO chef VALUES ('chef');
INSERT INTO salesman VALUES ('salesman');

INSERT INTO dish (dishname,dishprice) VALUES ('spaghetti',100.00);
INSERT INTO dish (dishname,dishprice) VALUES ('laks',200.75);
INSERT INTO dish (dishname,dishprice) VALUES ('biff',358.00);
INSERT INTO dish (dishname,dishprice) VALUES ('GRÆNDIS',30.00);

INSERT INTO subscriptionplan VALUES(1,(DATE(2013-02-25)),(DATE(2016-02-26)),'bedrift');

INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('23:03:03','adresseveien x', 4,'salesman','customer',null,7046,'2013-03-02', 1002);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('18:03:03','adresseveien x', 2,'salesman','bedrift',1,7046,'2013-02-02', 4894);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:04:03','adresseveien xg', 1,'salesman','customer',null,7046,'2013-03-09', 4884);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:09:03','adresseveien x', 0,'salesman','bedrift',1,7046,'2013-02-09', 4994);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:06:03','adresseveien f', 6,'salesman','customer',null,7046,'2013-03-17', 2864);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('11:03:03','adresseveien x', 7,'salesman','bedrift',1,7046,'2013-02-17', 4828);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('11:02:00','adresseveien x', 4,'salesman','customer',null,7046,'2013-03-23', 9183);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('11:03:00','adresseveien x', 1,'salesman','bedrift',1,7046,'2013-02-23', 1093);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('12:02:00','adresseveien x', 3,'salesman','customer',null,7046,'2013-03-29', 387);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('12:02:01','adresseveien y', 6,'salesman','bedrift',1,7046,'2013-02-25', 4848);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien z', 2,'salesman','customer',null,7046,'2013-03-15', 347);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 2,'salesman','bedrift',1,7046,'2013-02-15', 211);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','customer',null,7046,'2013-03-28', 98.1);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-03-02', 1350);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-03-09',2350);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-03-17', 3350);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-03-23', 3535);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-03-29', 68600);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-03-15', 600);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 7,'salesman','bedrift',1,7046,'2013-03-28', 700);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-02-02', 800);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-02-09', 900);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-02-17', 1000);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-02-23', 1100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-02-29', 1200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-02-15', 1030);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-03-02', 100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-01-09', 200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-01-17', 300);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-01-23', 400);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-01-29', 500);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-01-15', 600);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 7,'salesman','bedrift',1,7046,'2013-04-28', 700);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-05-02', 800);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-05-09', 900);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-04-17', 1000);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-06-23', 1100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-06-29', 1200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-07-15', 1030);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-07-02', 100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-09-09', 200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-09-17', 300);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-08-23', 400);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-08-29', 500);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-10-15', 600);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 7,'salesman','bedrift',1,7046,'2013-10-28', 700);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-10-02', 800);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-10-09', 900);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-11-17', 1000);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-11-23', 1100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-12-29', 1200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-12-15', 1030);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-11-02', 100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-03-09', 200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2012-03-17', 300);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-03-23', 400);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-03-29', 500);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-12-15', 600);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 7,'salesman','bedrift',1,7046,'2012-12-28', 700);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-12-02', 1000);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-12-09', 900);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-12-17', 1000);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-12-23', 1100);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2013-11-29', 1200);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates, totalPrice) VALUES ('19:03:03','adresseveien x', 5,'salesman','bedrift',1,7046,'2011-11-15', 1030);

INSERT INTO dishes_ordered VALUES (1,1,2);