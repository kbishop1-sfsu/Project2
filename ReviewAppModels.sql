CREATE database review_app;



drop table if exists reservations;

drop table if exists reviews;
drop table if exists pages;

drop table if exists admins;
drop table if exists users cascade;

drop table if exists restaurants cascade;
drop table if exists locations;



create table if not exists locations(
	id serial primary key,
	street_addr varchar(50) not null unique,
	city varchar(50) not null,
	state varchar (20) not null,
	zip int not null check(zip > 9999) --check that the zip is at least 5 digits
	);


create table if not exists restaurants(
	id serial primary key,
	restr_name varchar(50) not null,
	loc int default 0 unique,
	category varchar(20),
	website varchar(50),--default google result of search
	avg_rating float default 0.0,
	constraint fk_loc
		foreign key(loc)
			references locations(id)
				--on delete cascade
		
);

create table if not exists users(
	id serial primary key,
	firstname varchar(30) not null,
	lastname varchar(30) not null,
	email varchar(30) not null unique,
	username varchar(30) not null unique,
	_password varchar(30) not null
);


create table if not exists admins(
	id serial primary key,
	firstname varchar(30) not null,
	lastname varchar(30) not null,
	email varchar(30) not null unique,
	username varchar(30) not null unique,
	_password varchar(30) not null,
	restr_id int default 0,
	constraint fk_assoc_restr
		foreign key(restr_id)
			references restaurants(id)
				--on delete cascade
		
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
				--on delete cascade
);


create table if not exists reservations(
	id serial primary key,
	resv_date timestamp not null,
	--status varchar(20) default 'pending',doesnt need to resolved
	num_of_ppl int default 2 check(num_of_ppl<=10),
	restr_id int not null,
	user_id int not null,
	constraint fk_restr_resv
		foreign key (restr_id)
			references restaurants(id),
				--on delete cascade,
	constraint fk_user_resv
		foreign key (user_id)
			references users(id)
				--on delete cascade
);

	