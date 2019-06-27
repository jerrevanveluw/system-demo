CREATE TABLE IF NOT EXISTS todos (id bigserial PRIMARY KEY, description varchar, due bigint);
INSERT INTO todos(description, due) VALUES ('My first to do', 3471289200000);
