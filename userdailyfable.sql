CREATE TABLE IF NOT EXISTS users
(
    id       bigserial PRIMARY KEY,
    name     varchar,
    birthday date,
    color    varchar
);
INSERT INTO users(name, birthday, color)
VALUES ('Mr Owl', DATE '1981-07-18', 'blue');
