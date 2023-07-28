# CAREFUL! RESETS DB!
drop database iulia;
create database iulia;

create table iulia.user
(
    username varchar(100) not null
        primary key,
    password varchar(100) not null,
    email    varchar(50)  not null
);

create table iulia.role
(
    role_name varchar(50) not null
        primary key
);

create table iulia.user_role
(
    user_username  varchar(100) not null,
    role_role_name varchar(50)  not null,
    primary key (user_username, role_role_name),
    constraint user_role_role_role_name_fk
        foreign key (role_role_name) references iulia.role (role_name),
    constraint user_role_user_username_fk
        foreign key (user_username) references iulia.user (username)
);

# non hashed pass: admin
INSERT INTO iulia.user (username, password, email) VALUES ('admin', '$2a$10$Eu.SE9Gx7WuftsxRFgFMOu0Qy7mCBeADWlx4RJWn1SDcVGT0i.CiK', 'admin@demo.com');

# non hashed pass: user
INSERT INTO iulia.user (username, password, email) VALUES ('user', '$2a$10$xuCg1NUzWbe2DwglWBmZKuYPmiLhz3pZyZGnFhpYKW/ik/P6ZNJqe', 'user@demo.com');

# add all possible roles
INSERT INTO iulia.role (role_name) VALUES ('ADMIN');
INSERT INTO iulia.role (role_name) VALUES ('USER');

# add roles tp users
INSERT INTO iulia.user_role (user_username, role_role_name) VALUES ('admin', 'ADMIN');
INSERT INTO iulia.user_role (user_username, role_role_name) VALUES ('admin', 'USER');
INSERT INTO iulia.user_role (user_username, role_role_name) VALUES ('user', 'USER');