CREATE SCHEMA IF NOT EXISTS fest;

DROP TABLE IF EXISTS fest.deltager CASCADE;
DROP TABLE IF EXISTS fest.kasserer CASCADE;

CREATE TABLE fest.deltager(
	mobil 			INTEGER 	NOT NULL,
	fornavn 		VARCHAR		NOT NULL,
	etternavn 		VARCHAR		NOT NULL,
	er_mann			BOOLEAN 	NOT NULL,
	har_betalt 		BOOLEAN		NOT NULL,
	er_kasserer		BOOLEAN		NOT NULL,
	PRIMARY KEY(mobil)
);

INSERT INTO fest.deltager (mobil, fornavn, etternavn, er_mann, har_betalt, er_kasserer) VALUES
(45656778, 'Arne', 'Arnesen', true, true, true),
(90123532, 'Peder', 'Pedersen', true, false, false),
(54322113, 'Kari', 'Karisen', false, true, false);
