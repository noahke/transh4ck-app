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
	name varchar(200) NOT NULL,
	location varchar(200) NOT NULL	
);

CREATE TABLE events (
	id bigserial PRIMARY KEY,
	name varchar(200) NOT NULL,
	eventDate date NOT NULL,
	location varchar(200) NOT NULL,
	summary text NOT NULL
);

CREATE TABLE organizationEvents (
	id bigserial PRIMARY KEY,
	eventsId integer references events(id),
	organizationId integer references organizations(id)
);

CREATE TABLE institutionEvents (
	id bigserial PRIMARY KEY,
	eventsId integer references events(id),
	institutionId integer references institutions(id)
);

CREATE TABLE organizationUsers (
	id bigserial PRIMARY KEY,
	userId integer references users(id),
	organizationId integer references organizations(id)
);

CREATE TABLE tags (
	id bigserial PRIMARY KEY,
	tagName varchar(200) NOT NULL	
);

CREATE TABLE eventTags (
	id bigserial PRIMARY KEY,
	eventId integer references events(id),
	tagId integer references tags(id)
);

CREATE TABLE organizationTags (
	id bigserial PRIMARY KEY,
	organizationId integer references organizations(id),
	tagId integer references tags(id)
);
