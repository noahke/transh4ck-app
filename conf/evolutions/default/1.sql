# --- !Ups

CREATE TABLE users (
	id bigserial PRIMARY KEY,
	email varchar(200) NOT NULL UNIQUE,
	pswhsh text NOT NULL,
	bio text,
	contact text,
	contactable boolean,
	avatarUrl varchar(200)
);

CREATE TABLE institutions (
	id bigserial PRIMARY KEY,
	name varchar(200) NOT NULL UNIQUE,
	contact varchar(200),
	location varchar(200) NOT NULL,
	url varchar(200) NOT NULL,
	imageUrl varchar(200)
);

CREATE TABLE organizations (
	id bigserial PRIMARY KEY,
	name varchar(200) NOT NULL,
	owner integer references users(id),
	contact text NOT NULL,
	summary text NOT NULL,
	institution integer references institutions(id),
	imageUrl varchar(200)
);

CREATE TABLE events (
	id bigserial PRIMARY KEY,
	name varchar(200) NOT NULL,
	eventDate date NOT NULL,
	location varchar(200) NOT NULL,
	summary text NOT NULL,
	org integer references organizations(id),
	imageUrl varchar(200)
);

CREATE TABLE organizationUsers (
	id bigserial PRIMARY KEY,
	userId integer references users(id),
	organizationId integer references organizations(id)
);


# --- !Downs

DROP TABLE if exists organizationUsers()

DROP TABLE if exists events;

DROP TABLE if exists organizations;

DROP TABLE if exists institutions;

DROP TABLE if exists users;
