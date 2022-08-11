--Creating new database called project2
create database project2;

--Creating user table
create table if not exists user(
	id serial primary key,
	email varchar(40) unique not null,
	password varchar(30) not null,
	firstName varchar(30) default null,
	lastName varchar(30) default null,
	role varchar(30) default "user",
	phoneNumber varchar(10) default null
);

--Creating restaurant table 
create table if not exists restaurant(
	id serial primary key,
	name varchar(40) not null,
	--fk for location id
);

--Creating location table
create table if not exists location(
	id serial primary key,
	address varchar(60) not null,
	city varchar(60) not null,
	state varchar(20) not null,
	zipCode numeric not null
);

--Creating review table
--A user can make many reviews, review only has one user
--A restaurant can have many reviews, review only has one restaurant
create table if not exists review(
	id serial primary key,
	rating numeric check (0 <= rating >= 5), --rating should be between 0-5
	description varchar(500) --is 500 big enough?
	--fk user_id
	--fk restaurant_id 
);


--Creating reservation table
create table if not exists reservation();

