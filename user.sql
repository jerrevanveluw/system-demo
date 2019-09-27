CREATE TABLE IF NOT EXISTS users
(
    id       bigserial PRIMARY KEY,
    name     varchar,
    birthday date,
    color    varchar
);
INSERT INTO users(name, birthday, color)
VALUES ('Bert', DATE '1972-01-28', 'yellow');
INSERT INTO users(name, birthday, color)
VALUES ('Ernie', DATE '1972-07-26', 'orange');
INSERT INTO users(name, birthday, color)
VALUES ('Pino', DATE '2000-3-08', 'blue');
