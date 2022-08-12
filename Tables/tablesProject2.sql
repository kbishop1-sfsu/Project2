--Creating new database called project2
create database project2;

--Creating user table
create table if not exists users(
	id serial primary key,
	email varchar(40) unique not null,
	username varchar(40) unique not null,
	password varchar(30) not null,
	firstName varchar(30) default null,
	lastName varchar(30) default null,
	role varchar(30) default "user",
	phoneNumber varchar(10) default null
);

--Creating restaurant table 
create table if not exists restaurants(
	id serial primary key,
	restr_name varchar(40) not null,
	locationID int,
	category varchar(40),
	website varchar(100),
	constraint fk_locationID  --fk for locations id
		foreign key(locationID)
			references locations(id)
			on delete cascade,
);

--Creating location table
create table if not exists locations(
	id serial primary key,
	street_addr varchar(60) not null,
	city varchar(60) not null,
	state varchar(20) not null,
	zip int not null
);

--Creating review table
--A user can make many reviews, review only has one user
--A restaurant can have many reviews, review only has one restaurant
create table if not exists review(
	id serial primary key,
	rating int check (0 <= rating >= 5), --rating should be between 0-5
	posted timestamp,
	description varchar(500),
	userID int,
	restID int,
	constraint fk_user_review --fk users
		foreign key(userID)
			references users(id)
			on delete cascade,
	constraint fk_rest_review --fk restaurants
		foreign key(restID)
			references restaurants(id)
			on delete cascade 
);


--Creating reservation table
create table if not exists reservations(
	id serial primary key,
	resv_date timestamp,
	status varchar(20) default "pending",
	userID int,
	restID int,
	constraint fk_user_res --fk users
		foreign key(userID)
			references users(id)
			on delete cascade,
	constraint fk_rest_res --fk restaurants
		foreign key(restID)
			references restaurants(id)
			on delete cascade
);

--Creating pages table
create table if not exists pages(
	id serial primary key,
	avg_rating float,
	restID int,
	reviewID int,
	reservationID int, 
	constraint fk_rest_pages --fk restaurants
		foreign key(restID)
			references restaurants(id)
			on delete cascade,
	constraint fk_review_pages --fk reviews
		foreign key(reviewID)
			references reviews(id)
			on delete cascade,
	constraint fk_reservation_pages --fk reservations
		foreign key(reservationID)
			references reservations(id)
			on delete cascade
);

--Creating admin table
create table if not exists admins(
	
);

















