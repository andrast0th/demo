create table if not exists user
(
    username varchar(100) not null
        primary key,
    password varchar(100) not null,
    email    varchar(50)  not null
);