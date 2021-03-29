DROP TABLE students IF EXISTS;
CREATE TABLE IF NOT EXISTS students (id BIGSERIAL, name VARCHAR(255), age int, PRIMARY KEY (id));
INSERT INTO students (id, name, age) VALUES (1, 'Bob', 23), (2, 'Pit', 43);