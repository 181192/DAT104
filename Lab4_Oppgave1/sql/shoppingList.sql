CREATE SCHEMA IF NOT EXISTS shopping_list;

DROP TABLE IF EXISTS shopping_list.user CASCADE;
DROP TABLE IF EXISTS shopping_list.shopping_list CASCADE;
DROP TABLE IF EXISTS shopping_list.item CASCADE;

CREATE TABLE shopping_list.shopping_list (
  shopping_list_id SERIAL,
  description      VARCHAR,
  PRIMARY KEY (shopping_list_id)
);

CREATE TABLE shopping_list.user (
  user_id  VARCHAR(20) UNIQUE NOT NULL,
  password VARCHAR(40)        NOT NULL,
  sh_id    INTEGER REFERENCES shopping_list.shopping_list (shopping_list_id),
  PRIMARY KEY (user_id)
);

CREATE TABLE shopping_list.item (
  item_id SERIAL,
  item    CHARACTER VARYING(40) NOT NULL,
  sl_id   INTEGER REFERENCES shopping_list.shopping_list (shopping_list_id),
  PRIMARY KEY (item_id)
);