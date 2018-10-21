use regulation_system;


DROP TABLE IF EXISTS `regulation`;
create table regulation
(
	id int primary key auto_increment,
    heading varchar(100),
    regulation text
);

DROP TABLE IF EXISTS `feedback`;
create table feedback(
	id int primary key auto_increment,
    feedback text,
    user_id int references users(id)
);

DROP TABLE IF EXISTS `department`;
create table department(

	id int primary key auto_increment,
    dept_name varchar(200)
);

DROP TABLE IF EXISTS `users`;
create table users(
	id int primary key auto_increment,
    dept_id int references detartment (id),
    mail_id varchar(100),
    pass varchar(100)
)



insert into `department` values(null, "Accounts");
insert into `department` values(null, "Sales");
insert into `department` values(null, "IT");

insert into `users` values(null, 1,"d@g.com","123");
insert into `users` values(null, 2,"m@g.com","123");