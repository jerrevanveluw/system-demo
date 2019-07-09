CREATE TABLE IF NOT EXISTS users (id bigserial PRIMARY KEY, name varchar, birthday date);
INSERT INTO users(name, birthday) VALUES ('Bert', DATE '1972-01-28');
INSERT INTO users(name, birthday) VALUES ('Ernie', DATE '1972-07-26');
