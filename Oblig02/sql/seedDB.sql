CREATE SCHEMA IF NOT EXISTS fest;

DROP TABLE IF EXISTS fest.deltager CASCADE;
DROP TABLE IF EXISTS fest.kasserer CASCADE;

CREATE TABLE fest.deltager(
	mobil 			INTEGER 	NOT NULL,
	fornavn 		VARCHAR		NOT NULL,
	etternavn 		VARCHAR		NOT NULL,
	is_mann			BOOLEAN 	NOT NULL,
	har_betalt 		BOOLEAN		NOT NULL,
	er_kasserer		BOOLEAN		NOT NULL,
	PRIMARY KEY(mobil)
);

INSERT INTO fest.deltager (mobil, fornavn, etternavn, is_mann, betalingsstatus) VALUES
(45656778, 'Arne', 'Arnesen', true, null),
(90123532, 'Peder', 'Pedersen', true, false),
(54322113, 'Kari', 'Karisen', false, true);
