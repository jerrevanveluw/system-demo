CREATE TABLE IF NOT EXISTS todos
(
    id          bigserial PRIMARY KEY,
    description varchar,
    due         date,
    user_name   varchar
);
INSERT INTO todos(description, due)
VALUES ('Clean Sesame Street', DATE '2079-12-31');
INSERT INTO todos(description, due, user_name)
VALUES ('Clean Ernies room', DATE '2050-03-22', 'Ernie');
