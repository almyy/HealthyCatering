INSERT INTO users VALUES ('customer','asd123','kunde','kundesen','adresseveien 3','46257954','e@post.no',7046);
INSERT INTO users VALUES ('driver','asd123','sjåfør','sjåførsen','adresseveien 21', '457845512','e@post.no', 7049 );
INSERT INTO users VALUES ('admin','asd123','admin','administratorsen','adresseveien 26', '457812412','e@post.no', 7049);
INSERT INTO users VALUES ('salesman','asd123','selger','selgersen','adresseveien 23', '457845512','e@post.no', 7049);
INSERT INTO users VALUES ('chef','asd123','kokk','administratorsen','adresseveien 26', '457824512','e@post.no', 7049);
INSERT INTO users VALUES ('bedrift','asd123','bedrift','bedriftersen','adresseveien 23', '457845132','e@post.no', 7049);
 
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

INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('23:03:03','adresseveien x', 4,'salesman','customer',null,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('18:03:03','adresseveien x', 2,'salesman','bedrift',1,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('19:04:03','adresseveien xg', 1,'salesman','customer',null,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('19:09:03','adresseveien x', 0,'salesman','bedrift',1,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('19:06:03','adresseveien f', 6,'salesman','customer',null,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('11:03:03','adresseveien x', 7,'salesman','bedrift',1,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('11:02:00','adresseveien x', 4,'salesman','customer',null,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('11:03:00','adresseveien x', 1,'salesman','bedrift',1,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('12:02:00','adresseveien x', 3,'salesman','customer',null,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('12:02:01','adressev6eien y', 6,'salesman','bedrift',1,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('19:03:03','adresseveien z', 2,'salesman','customer',null,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('19:03:03','adresseveien x', 2,'salesman','bedrift',1,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('19:03:03','adresseveien x', 7,'salesman','customer',null,7046,'2013-03-28');
INSERT INTO orders (timeofdelivery,deliveryaddress,status,usernamesalesman,usernamecustomer,subscriptionid,postalcode,dates) VALUES ('19:03:03','adresseveien x', 7,'salesman','bedrift',1,7046,'2013-03-28');

INSERT INTO dishes_ordered VALUES (1,1,2);
