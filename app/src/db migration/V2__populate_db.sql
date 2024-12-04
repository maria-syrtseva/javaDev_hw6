INSERT INTO client (NAME) VALUES
('Client A'),
('Client B'),
('Client C'),
('Client D'),
('Client E');

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
('Fiona', '1985-12-10', 'Senior', 5500),
('Charlie', '1995-11-05', 'Junior', 900),
('Diana', '1988-07-30', 'Middle', 3000),
('Larisa', '1979-03-12', 'Trainee', 600),
('Frank', '1982-09-25', 'Senior', 6500),
('Ferit', '1998-01-17', 'Junior', 1200),
('Boris', '1993-12-07', 'Middle', 2800),
('Viktor', '1987-05-12', 'Senior', 5500),
('Jack', '1996-10-10', 'Junior', 1500),
('Melanie', '2000-03-19', 'Trainee', 600);

-- project_worker
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
(1, 1), (1, 3), (1, 5),
(2, 2), (2, 4),
(3, 6),
(4, 7), (4, 8), (4, 9),
(5, 10), (5, 1),
(6, 2), (6, 3), (6, 5),
(7, 6), (7, 7),
(8, 8), (8, 9), (8, 10),
(9, 1), (9, 2), (9, 3),
(10, 4), (10, 5);