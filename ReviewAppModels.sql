CREATE database review_app;



drop table if exists reservations;

drop table if exists reviews;
drop table if exists pages;

drop table if exists admins;
drop table if exists users cascade;

drop table if exists restaurants;
drop table if exists locations;



create table if not exists locations(
	id serial primary key,
	street_addr varchar(50) not null,
	city varchar(50) not null,
	state varchar (20) not null,
	zip int not null check(zip > 9999) --check that the zip is at least 5 digits
	);


create table if not exists restaurants(
	id serial primary key,
	restr_name varchar(50) not null,
	loc int default 0 unique,
	category varchar(20),
	--phone int,--check that phone is 10  digits
	website varchar(50),--default google result of search
	constraint fk_loc
		foreign key(loc)
			references locations(id)
		
);

create table if not exists users(
	id serial primary key,
	firstname varchar(30) not null,
	lastname varchar(30) not null,
	email varchar(30) not null unique,
	username varchar(30) not null unique,
	_password varchar(30) not null
);

create table if not exists pages(
	id serial primary key,
	avg_rating float default 0.0,
	--list of reviews
	--list of reservations?
	restr_id int default 0 unique,
	constraint fk_restr
		foreign key(restr_id)
			references restaurants(id)
	
);


create table if not exists admins(
	id serial primary key,
	firstname varchar(30) not null,
	lastname varchar(30) not null,
	email varchar(30) not null unique,
	username varchar(30) not null unique,
	_password varchar(30) not null,
	page_id int default 0,
	constraint fk_restr_page
		foreign key(page_id)
			references pages(id)
		
);






create table if not exists reviews(
	id serial primary key,
	posted timestamp default current_timestamp,
	rating int not null check(rating<=5),--check that rating is btw 0 and 5
	descr varchar(200),
	user_id int not null,
	constraint fk_user
		foreign key (user_id)
			references users(id)
);


create table if not exists reservations(
	id serial primary key,
	resv_date timestamp not null,
	status varchar(20) default 'pending',
	restr_id int not null,
	user_id int not null,
	constraint fk_restr_resv
		foreign key (restr_id)
			references restaurants(id),
	constraint fk_user_resv
		foreign key (user_id)
			references users(id)
);

	