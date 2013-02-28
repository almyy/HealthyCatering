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
DROP TABLE Users;
DROP TABLE roles;
DROP TABLE postalArea;


CREATE TABLE PostalArea(
    postalCode INTEGER,
    postalArea VARCHAR(30) NOT NULL,
    CONSTRAINT postalArea_pk PRIMARY KEY(postalCode)
);
CREATE TABLE ROLES(
    roleName VARCHAR(20),
    CONSTRAINT roles_pk PRIMARY KEY(roleName)
);
CREATE TABLE users(
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    namee VARCHAR(40),
    address VARCHAR(40) NOT NULL,
    postalCode INTEGER,
    roleName VARCHAR(20),
    CONSTRAINT users_pk PRIMARY KEY(username),
    CONSTRAINT users_fk1 FOREIGN KEY(postalCode) REFERENCES postalArea(postalCode),
    CONSTRAINT users_fk2 FOREIGN KEY(roleName) REFERENCES roles(roleName)
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
    orderId INTEGER NOT NULL,
    timeOfDelivery INT NOT NULL,
    deliveryAddress VARCHAR (50),
    status VARCHAR(15),
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