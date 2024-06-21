/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  JGomez
 * Created: 4 jun. 2024
 */

INSERT INTO users(id,first_name,last_name,email,username,password) VALUES(1001,'Joshua','Lopez','joshua@javademo.com',null,null);
INSERT INTO users(id,first_name,last_name,email,username,password) VALUES(1002,'Raul','Suchiapa','raul@javademo.com',null,null);
INSERT INTO users(id,first_name,last_name,email,username,password) VALUES(1003,'Alicia','Mendez','alicia@javademo.com',null,null);
INSERT INTO users(id,first_name,last_name,email,username,password) VALUES(1004,'Manuel','Cabrera','manuel@javademo.com',null,null);
INSERT INTO users(id,first_name,last_name,email,username,password) VALUES(1005,'Fernando','Rodriguez','fernando@javademo.com',null,null);
INSERT INTO users(id,first_name,last_name,email,username,password) VALUES(1006,'Guadalupe','Rojas','luper@javademo.com',null,null);

INSERT INTO makers(id,name) VALUES(100,'Asus');
INSERT INTO makers(id,name) VALUES(200,'Lenovo');
INSERT INTO makers(id,name) VALUES(300,'Nokia');
INSERT INTO makers(id,name) VALUES(400,'Xiaomi');
INSERT INTO makers(id,name) VALUES(500,'GameForce');

INSERT INTO products(id,name,price,maker_id) VALUES(101,'Laptop Asus Gamer',20000.89,100);
INSERT INTO products(id,name,price,maker_id) VALUES(102,'Disco Duro Asus',3000.20,100);
INSERT INTO products(id,name,price,maker_id) VALUES(103,'Gabinete Asus',2000.10,100);
INSERT INTO products(id,name,price,maker_id) VALUES(104,'Laptop Lenovo Gamer',35000.00,200);
INSERT INTO products(id,name,price,maker_id) VALUES(105,'5300 Xpress Music',5000.89,300);
INSERT INTO products(id,name,price,maker_id) VALUES(106,'PocoPhone m5S',2800.00,400);
INSERT INTO products(id,name,price,maker_id) VALUES(107,'Monitor 24"',2800.00,500);
INSERT INTO products(id,name,price,maker_id) VALUES(108,'Laptop dynabook"',28000.00,200);