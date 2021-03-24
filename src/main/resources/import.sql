DROP TABLE student IF EXISTS;
CREATE TABLE IF NOT EXISTS student (id BIGSERIAL, name VARCHAR(255), mark VARCHAR(255), PRIMARY KEY (id));
INSERT INTO student (id, name, mark) VALUES (1, 'Bob','1111'), (2, 'Pit','2222');