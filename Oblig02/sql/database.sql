CREATE SCHEMA IF NOT EXISTS fest;

DROP TABLE IF EXISTS fest.deltager CASCADE;
DROP TABLE IF EXISTS fest.kasserer CASCADE;

CREATE TABLE fest.deltager(
	mobil 			INTEGER 	NOT NULL,
	fornavn 		VARCHAR(40) NOT NULL,
	etternavn 		VARCHAR(40) NOT NULL,
	kjoenn 			VARCHAR(40) NOT NULL,
	betalingsstatus BOOLEAN,
	PRIMARY KEY(mobil)
);

CREATE TABLE fest.kasserer(
	deltager	INTEGER REFERENCES fest.deltager(mobil),
	admin		BOOLEAN,
	PRIMARY KEY(deltager)
);