CREATE SCHEMA IF NOT EXISTS handleliste;

DROP TABLE IF EXISTS handleliste.vare;

CREATE TABLE handleliste.vare (
  item CHARACTER VARYING(40),
  PRIMARY KEY (item)
);

INSERT INTO handleliste.vare (item) VALUES ('Melk');