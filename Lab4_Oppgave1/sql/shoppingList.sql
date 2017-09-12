CREATE SCHEMA IF NOT EXISTS shopping_list;

DROP TABLE IF EXISTS shopping_list.user;
DROP TABLE IF EXISTS shopping_list.shopping_list;
DROP TABLE IF EXISTS shopping_list.item;

CREATE TABLE shopping_list.user (
  user_id  SERIAL      NOT NULL,
  name     VARCHAR(20) NOT NULL,
  password VARCHAR(40) NOT NULL,
  PRIMARY KEY (user_id)
);

CREATE TABLE shopping_list.shopping_list (
  shopping_list_id SERIAL NOT NULL,
  user_id          INTEGER REFERENCES shopping_list.user (user_id),
  description      VARCHAR,
  PRIMARY KEY (shopping_list_id)
);

CREATE TABLE shopping_list.item (
  item_id SERIAL                NOT NULL,
  item    CHARACTER VARYING(40) NOT NULL,
  sl_id   INTEGER REFERENCES shopping_list.shopping_list (shopping_list_id),
  PRIMARY KEY (item)
);

