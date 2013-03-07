DROP TABLE dishes_ordered;
DROP TABLE private;
DROP TABLE orders;
DROP TABLE subscriptionplan;
DROP TABLE company;
DROP TABLE CUSTOMER;
DROP TABLE dish_menu;
DROP TABLE menu;
DROP TABLE dish;
DROP TABLE salesman;
DROP TABLE chef;
DROP TABLE driver;
DROP TABLE worker;
DROP TABLE administration;
DROP TABLE employee;
DROP TABLE roles;
DROP TABLE users;
DROP TABLE postalArea;


CREATE TABLE PostalArea(
    postalCode INTEGER,
    postalArea VARCHAR(30) NOT NULL,
    CONSTRAINT postalArea_pk PRIMARY KEY(postalCode)
);
CREATE TABLE users(
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    firstname VARCHAR(40),
    surname VARCHAR(40),
    address VARCHAR(40) NOT NULL,
    moblieNr INTEGER,
    postalCode INTEGER,
    CONSTRAINT users_pk PRIMARY KEY(username),
    CONSTRAINT users_fk1 FOREIGN KEY(postalCode) REFERENCES postalArea(postalCode)
);
CREATE TABLE ROLES(
    roleName VARCHAR(20),
    username VARCHAR(20),
    CONSTRAINT roles_fk FOREIGN KEY(username) REFERENCES users(username),
    CONSTRAINT roles_pk PRIMARY KEY(username,roleName)
);
CREATE TABLE EMPLOYEE(
    username VARCHAR(20) NOT NULL,
    employee_nr INTEGER NOT NULL,
    CONSTRAINT employee_fk FOREIGN KEY(username) REFERENCES users(username),
    CONSTRAINT employee_pk PRIMARY KEY(username)
);
CREATE TABLE worker(
    username VARCHAR(20) NOT NULL,
    CONSTRAINT worker_fk FOREIGN KEY(username) REFERENCES users(username),
    CONSTRAINT worker_pk PRIMARY KEY(username)
);

CREATE TABLE Driver(
    username VARCHAR(20) NOT NULL,
    CONSTRAINT driver_fk FOREIGN KEY(username) REFERENCES users(username),
    CONSTRAINT driver_pk PRIMARY KEY(username)
);

CREATE TABLE Salesman(
    username VARCHAR(20) NOT NULL,
    CONSTRAINT salesman_fk FOREIGN KEY(username) REFERENCES users(username),
    CONSTRAINT salesman_pk PRIMARY KEY(username)
);

CREATE TABLE chef(
    username VARCHAR(20) NOT NULL,
    CONSTRAINT chef_fk FOREIGN KEY(username) REFERENCES users(username),
    CONSTRAINT chef_pk PRIMARY KEY(username)
);

CREATE TABLE administration(
    username VARCHAR(20) NOT NULL,
    CONSTRAINT administration_fk FOREIGN KEY(username) REFERENCES users(username),
    CONSTRAINT administration_pk PRIMARY KEY(username)
);
CREATE TABLE CUSTOMER(
    username VARCHAR(20) NOT NULL,
    CONSTRAINT customer_fk FOREIGN KEY(username) REFERENCES users(username),
    CONSTRAINT customer_pk PRIMARY KEY(username)
);
CREATE TABLE private(
    username VARCHAR(20) NOT NULL,
    CONSTRAINT private_fk FOREIGN KEY(username) REFERENCES users(username),
    CONSTRAINT private_pk PRIMARY KEY(username)
);
CREATE TABLE company(
    username VARCHAR(20) NOT NULL,
    CONSTRAINT company_fk FOREIGN KEY(username) REFERENCES users(username),
    CONSTRAINT company_pk PRIMARY KEY(username)
);
CREATE TABLE Subscriptionplan(
    subscriptionId INTEGER not null,
    startDate date,
    endDate date,
    companyUserName VarCHAR(20),
    CONSTRAINT subscriptionplan_pk PRIMARY KEY(subscriptionId),
    CONSTRAINT subscriptionplan_fk1 FOREIGN KEY(companyUserName) REFERENCES company(UserName)
); 
CREATE TABLE orders(
    orderId INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    timeOfDelivery INTEGER NOT NULL,
    deliveryAddress VARCHAR (50),
    status INTEGER,
    dates date,
    userNameSalesman VARCHAR(20),
    userNameCustomer VARCHAR(20),
    subscriptionId INTEGER,
    postalCode INTEGER,
    CONSTRAINT orders_pk PRIMARY KEY(orderId),
    CONSTRAINT orders_fk1 FOREIGN KEY(userNameSalesman) REFERENCES Salesman(username),
    CONSTRAINT orders_fk2 FOREIGN KEY(userNameCustomer) REFERENCES Customer(username),
    CONSTRAINT orders_fk3 FOREIGN KEY(subscriptionId) REFERENCES Subscriptionplan(subscriptionid),
    CONSTRAINT orders_fk4 FOREIGN KEY(postalcode) REFERENCES postalArea(postalCode)
);
CREATE TABLE dish(
    dishId INTEGER NOT NULL,
    dishName VARCHAR(50) NOT NULL,
    CONSTRAINT dish_pk PRIMARY KEY(dishId)
);
CREATE TABLE menu(
    menuId INTEGER NOT NULL,
    menuName VARCHAR(30),
    CONSTRAINT menu_pk PRIMARY KEY(menuID)
);
CREATE TABLE dish_menu (
    dishId INTEGER NOT NULL,
    menuId INTEGER NOT NULL,
    CONSTRAINT dish_menu_fk1 FOREIGN KEY(dishId) REFERENCES dish(dishId),
    CONSTRAINT dish_menu_fk2 FOREIGN KEY(menuId) REFERENCES menu(menuId),
    CONSTRAINT dish_menu_pk PRIMARY KEY(dishId,menuId)
);
CREATE TABLE dishes_ordered(
    dishId INTEGER NOT NULL,
    menuId INTEGER NOT NULL,
    orderId INTEGER NOT NULL,
    dishCount INTEGER NOT NULL,
    CONSTRAINT dishes_ordered_fk1 FOREIGN KEY(dishId,menuId) REFERENCES dish_menu(dishId,menuId),
    CONSTRAINT dishes_ordered_fk2 FOREIGN KEY(orderId) REFERENCES orders(orderID),
    CONSTRAINT dishes_ordered_pk PRIMARY KEY(orderId,dishId,menuId)
);

INSERT INTO postalArea VALUES (7046,'Trondheim');
INSERT INTO postalArea VALUES (7049,'Trondheim');
INSERT INTO postalArea VALUES (7052,'Trondheim');
INSERT INTO postalArea VALUES (7036,'Trondheim');

INSERT INTO users VALUES ('customer','asd123','kunde','kundesen','adresseveien 3',46257954,7046);
INSERT INTO users VALUES ('driver','asd123','sjåfør','sjåførsen','adresseveien 21', 457845512, 7049 );
INSERT INTO users VALUES ('admin','asd123','admin','administratorsen','adresseveien 26', 457812412, 7049);
INSERT INTO users VALUES ('salesman','asd123','selger','selgersen','adresseveien 23', 457845512, 7049);
INSERT INTO users VALUES ('chef','asd123','kokk','administratorsen','adresseveien 26', 457824512, 7049);
INSERT INTO users VALUES ('bedrift','asd123','bedrift','bedriftersen','adresseveien 23', 457845132, 7049);
 
INSERT INTO Roles VALUES ('admin','admin');
INSERT INTO Roles VALUES ('customer','customer');
INSERT INTO Roles VALUES ('worker','chef');

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

INSERT INTO dish VALUES (1,'spaghetti');
INSERT INTO dish VALUES (2,'laks');
INSERT INTO dish VALUES (3, 'biff');
INSERT INTO dish VALUES (4, 'GRÆNDIS');

INSERT INTO menu VALUES (1,'privat');
INSERT INTO menu VALUES (2,'bedrift');

INSERT INTO dish_menu VALUES (1,1);
INSERT INTO dish_menu VALUES (2,1);
INSERT INTO dish_menu VALUES (4,1);

INSERT INTO subscriptionplan VALUES(1,(DATE(2013-02-25)),(DATE(2016-02-26)),'bedrift');

INSERT INTO orders (timeofdelivery,deliveryaddress,status,dates,usernamesalesman,usernamecustomer,subscriptionid,postalcode) VALUES (19,'adresseveien x', 0,(DATE(2013-02-28)),'salesman','customer',null,7046);
INSERT INTO orders (timeofdelivery,deliveryaddress,status,dates,usernamesalesman,usernamecustomer,subscriptionid,postalcode) VALUES (19,'adresseveien x', 1,(DATE(2013-02-28)),'salesman','bedrift',1,7046);

INSERT INTO dishes_ordered VALUES (1,1,1,2);