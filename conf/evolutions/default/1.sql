# --- !Ups

CREATE TABLE users (
	id bigserial PRIMARY KEY,
	email varchar(200) NOT NULL UNIQUE,
	pswhsh text NOT NULL,
	bio text,
	contact text,
	contactable boolean
);

CREATE TABLE organizations (
	id bigserial PRIMARY KEY,
	name varchar(200) NOT NULL,
	owner integer references users(id),
	contact text NOT NULL,
	summary text NOT NULL
);

CREATE TABLE institutions (
	id bigserial PRIMARY KEY,
	name varchar(200) NOT NULL UNIQUE,
	location varchar(200) NOT NULL,
	url varchar(200) NOT NULL
);

CREATE TABLE events (
	id bigserial PRIMARY KEY,
	name varchar(200) NOT NULL,
	eventDate date NOT NULL,
	location varchar(200) NOT NULL,
	summary text NOT NULL,
	institution integer references institutions(id)
);

CREATE TABLE organizationInstitutions (
	id bigserial PRIMARY KEY,
	organizationId integer references organizations(id) NOT NULL,
	institutionsId integer references institutions(id) NOT NULL
);

CREATE TABLE organizationEvents (
	id bigserial PRIMARY KEY,
	eventsId integer references events(id) NOT NULL,
	organizationId integer references organizations(id) NOT NULL
);

CREATE TABLE organizationUsers (
	id bigserial PRIMARY KEY,
	userId integer references users(id) NOT NULL,
	organizationId integer references organizations(id) NOT NULL
);

CREATE TABLE tags (
	id bigserial PRIMARY KEY,
	tagName varchar(200) NOT NULL	
);

CREATE TABLE eventTags (
	id bigserial PRIMARY KEY,
	eventId integer references events(id) NOT NULL,
	tagId integer references tags(id) NOT NULL
);

CREATE TABLE organizationTags (
	id bigserial PRIMARY KEY,
	organizationId integer references organizations(id) NOT NULL,
	tagId integer references tags(id) NOT NULL
);

# --- !Downs

DROP TABLE organizationTags;

DROP TABLE eventTags;

DROP TABLE tags;

DROP TABLE organizationUsers;

DROP TABLE organizationEvents;

DROP TABLE organizationInstitutions;

DROP TABLE events;

DROP TABLE institutions;

DROP TABLE organizations;

DROP TABLE users;
