CREATE TABLE IF NOT EXISTS todos (id bigserial PRIMARY KEY, description varchar, due bigint);
INSERT INTO todos(description, due) VALUES ('Clean Sesame Street', 3471289200);
