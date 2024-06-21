/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  JGomez
 * Created: 4 jun. 2024
 */

 create table makers (
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table products (
        id bigint not null,
        name varchar(255),
        price numeric(38,2),
        maker_id bigint not null,
        primary key (id)
    );

    create table roles (
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table users (
        id bigint not null,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (id)
    );

    create table users_roles (
        user_id bigint not null,
        roles_id bigint not null,
        primary key (user_id, roles_id)
    );

    create sequence makers_seq start with 1 increment by 50;

    create sequence products_seq start with 1 increment by 50;

    create sequence roles_seq start with 1 increment by 50;

    create sequence users_seq start with 1 increment by 50;

    alter table if exists products
       add constraint FKs7l3dekstaaaupqaomma16f2
       foreign key (maker_id)
       references makers;

    alter table if exists users_roles
       add constraint FKa62j07k5mhgifpp955h37ponj
       foreign key (roles_id)
       references roles;

    alter table if exists users_roles
       add constraint FK2o0jvgh89lemvvo17cbqvdxaa
       foreign key (user_id)
       references users;
