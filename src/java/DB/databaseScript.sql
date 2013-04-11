DROP TABLE dishes_stored; 
DROP TABLE dishes_ordered;
DROP TABLE private;
DROP TABLE orders;
DROP TABLE subscriptionplan;
DROP TABLE CUSTOMER;
DROP TABLE dish;
DROP TABLE salesman;
DROP TABLE chef;
DROP TABLE driver;
DROP TABLE worker;
DROP TABLE administration;
DROP TABLE employee;
DROP TABLE roles;
DROP TABLE users;
DROP TABLE postal_no;
DROP TABLE munincipial_no;
DROP TABLE county_no;
DROP TABLE message;

CREATE TABLE county_no (
    id SMALLINT,
    county_name VARCHAR(100) NOT NULL,
    CONSTRAINT county_no_pk PRIMARY KEY (id)
);

CREATE TABLE munincipial_no (
    id SMALLINT,
    county_id SMALLINT NOT NULL,
    munincipial_name VARCHAR(100) NOT NULL,
    CONSTRAINT munincipial_no_pk PRIMARY KEY (id),
    CONSTRAINT munincipial_no_fk FOREIGN KEY (county_id) REFERENCES county_no (id)
); 

CREATE TABLE postal_no (
    zip SMALLINT,
    place VARCHAR(100) NOT NULL,
    munincipial_id SMALLINT NOT NULL,
    CONSTRAINT postal_no_pk PRIMARY KEY (zip),
    CONSTRAINT postal_no_fk FOREIGN KEY (munincipial_id) REFERENCES munincipial_no (id)
);

CREATE TABLE users(
    username VARCHAR(20) NOT NULL,
    password VARCHAR(40) NOT NULL,
    firstname VARCHAR(40),
    surname VARCHAR(40),
    address VARCHAR(40) NOT NULL,
    mobileNr VARCHAR(20),
    email VARCHAR(40) NOT NULL UNIQUE,
    postalCode SMALLINT,
    CONSTRAINT users_pk PRIMARY KEY(username),
    CONSTRAINT users_fk1 FOREIGN KEY(postalCode) REFERENCES postal_no(zip)
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
CREATE TABLE Subscriptionplan(
    subscriptionId INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    startDate date,
    endDate date,
    timeofdelivery time,
    weekday varchar(20),
    CONSTRAINT subscriptionplan_pk PRIMARY KEY(subscriptionId)
); 
CREATE TABLE orders(
    orderId INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    timeOfDelivery time,
    deliveryAddress VARCHAR (50),
    status INTEGER,
    userNameSalesman VARCHAR(20),
    userNameCustomer VARCHAR(20),
    subscriptionId INTEGER,
    postalCode SMALLINT,
    dates date,
    totalPrice DECIMAL,
    CONSTRAINT orders_pk PRIMARY KEY(orderId),
    CONSTRAINT orders_fk1 FOREIGN KEY(userNameSalesman) REFERENCES Salesman(username),
    CONSTRAINT orders_fk2 FOREIGN KEY(userNameCustomer) REFERENCES Customer(username),
    CONSTRAINT orders_fk3 FOREIGN KEY(subscriptionId) REFERENCES Subscriptionplan(subscriptionid),
    CONSTRAINT orders_fk4 FOREIGN KEY(postalCode) REFERENCES postal_no(zip)
);
CREATE TABLE dish(
    dishId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    dishName VARCHAR(50) NOT NULL,
    dishPrice DECIMAL NOT NULL,
    CONSTRAINT dish_pk PRIMARY KEY(dishId)
);
CREATE TABLE dishes_ordered(
    dishId INTEGER NOT NULL,
    orderId INTEGER NOT NULL,
    dishCount INTEGER NOT NULL,
    CONSTRAINT dishes_ordered_fk FOREIGN KEY(orderId) REFERENCES orders(orderID),
    CONSTRAINT dishes_ordered_fk2 FOREIGN KEY(dishId) REFERENCES dish(dishId),
    CONSTRAINT dishes_ordered_pk PRIMARY KEY(orderId,dishId)
);
CREATE TABLE dishes_stored(
    dishId INTEGER NOT NULL,
    orderId INTEGER NOT NULL,
    dishCount INTEGER NOT NULL,
    totalPrice decimal, 
    dates date,
    postalcode SMALLINT,
    salesmanusername VARCHAR(40),
    CONSTRAINT dishes_stored_fk1 FOREIGN KEY(dishId) REFERENCES dish(dishId),
    CONSTRAINT dishes_stored_fk2 FOREIGN KEY(orderId) REFERENCES orders(orderId),
    CONSTRAINT dishes_stores_pk PRIMARY KEY(orderId,dishId)
);

CREATE TABLE message(
    messageId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    message VARCHAR(100),
    CONSTRAINT message_pk PRIMARY KEY(messageId)
);