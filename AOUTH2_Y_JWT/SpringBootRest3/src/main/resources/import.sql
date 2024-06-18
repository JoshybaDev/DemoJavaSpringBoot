/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  JGomez
 * Created: 30 may. 2024
 */

INSERT INTO users(id,first_name,last_name,email,username,password) VALUES(1,'Joshua','Lopez','joshua@javademo.com',null,null);
INSERT INTO users(id,first_name,last_name,email,username,password) VALUES(2,'Raul','Suchiapa','raul@javademo.com',null,null);
INSERT INTO users(id,first_name,last_name,email,username,password) VALUES(3,'Alicia','Mendez','alicia@javademo.com',null,null);
INSERT INTO users(id,first_name,last_name,email,username,password) VALUES(4,'Manuel','Cabrera','manuel@javademo.com',null,null);
INSERT INTO users(id,first_name,last_name,email,username,password) VALUES(5,'Fernando','Rodriguez','fernando@javademo.com',null,null);
INSERT INTO users(id,first_name,last_name,email,username,password) VALUES(6,'Joshyba','Gomez','joshyba@javademo.com','jgomez','$2a$12$sPt3w/C2QJT7VOGqT1V46uFyIapDlX.5bJ8wYaQnANjOsD7D5CHLa');


--$2a$12$sPt3w/C2QJT7VOGqT1V46uFyIapDlX.5bJ8wYaQnANjOsD7D5CHLa
--123456

INSERT INTO makers(id,name) VALUES(1,'Asus');
INSERT INTO makers(id,name) VALUES(2,'Lenovo');
INSERT INTO makers(id,name) VALUES(3,'Nokia');
INSERT INTO makers(id,name) VALUES(4,'Xiaomi');
INSERT INTO makers(id,name) VALUES(5,'GameForce');


INSERT INTO products(id,name,price,maker_id) VALUES(1,'Laptop Asus Gamer',20000.89,1);
INSERT INTO products(id,name,price,maker_id) VALUES(2,'Disco Duro Asus',3000.20,1);
INSERT INTO products(id,name,price,maker_id) VALUES(3,'Gabinete Asus',2000.10,1);
INSERT INTO products(id,name,price,maker_id) VALUES(4,'Laptop Lenovo Gamer',35000.00,2);
INSERT INTO products(id,name,price,maker_id) VALUES(5,'5300 Xpress Music',5000.89,3);
INSERT INTO products(id,name,price,maker_id) VALUES(6,'PocoPhone m5S',2800.00,4);
INSERT INTO products(id,name,price,maker_id) VALUES(7,'Monitor 24"',2800.00,5);
INSERT INTO products(id,name,price,maker_id) VALUES(8,'Laptop dynabook"',28000.00,2);