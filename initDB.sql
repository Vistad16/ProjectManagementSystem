CREATE TABLE IF NOT EXISTS developer (
    id IDENTITY PRIMARY KEY,
    company_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    sex VARCHAR(50) NOT NULL,
    salary BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS skills (
    id IDENTITY PRIMARY KEY,
    programming_language VARCHAR(50) NOT NULL,
    skill_level VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS developers_skills (
    developers_id BIGINT NOT NULL,
    skill_id BIGINT NOT NULL,
    PRIMARY KEY (developers_id, skill_id),
FOREIGN KEY (developers_id) REFERENCES developer(id),
FOREIGN KEY (skill_id) REFERENCES skills(id)
);

ALTER TABLE developer
ADD CONSTRAINT  IF NOT EXISTS sex_enum_values
CHECK (sex IN ('male', 'female', 'unknown'));

CREATE TABLE IF NOT EXISTS projects (
    id IDENTITY PRIMARY KEY,
    projects_name VARCHAR(100) NOT NULL,
    cost BIGINT NOT NULL,
    creation_Date DATE,
    description VARCHAR(350)
);

CREATE TABLE IF NOT EXISTS developer_project (
    developer_id BIGINT NOT NULL,
    project_id BIGINT NOT NULL,
    PRIMARY KEY (developer_id, project_id),
FOREIGN KEY (developer_id) REFERENCES developer(id),
FOREIGN KEY (project_id) REFERENCES projects(id)
);

CREATE TABLE IF NOT EXISTS customers (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    Country VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS customers_projects (
    customer_id BIGINT NOT NULL,
    projects_id BIGINT NOT NULL,
    PRIMARY KEY (customer_id, projects_id),
FOREIGN KEY (customer_id) REFERENCES customers(id),
FOREIGN KEY (projects_id) REFERENCES projects(id)
);

CREATE TABLE IF NOT EXISTS companies (
    id IDENTITY PRIMARY KEY,
    company_name VARCHAR(100) NOT NULL,
    specialization VARCHAR(150)
);

ALTER TABLE developer
ADD CONSTRAINT  IF NOT EXISTS developer_companies_id_fk
FOREIGN KEY (company_id) REFERENCES companies(id);

CREATE TABLE IF NOT EXISTS company_customer (
    customer_id BIGINT NOT NULL,
    company_id BIGINT NOT NULL,
    PRIMARY KEY (customer_id, company_id),
FOREIGN KEY (customer_id) REFERENCES customers(id),
FOREIGN KEY (company_id) REFERENCES companies(id)
);

--added
INSERT INTO companies (company_name, specialization) VALUES
('SW', 'Building droids'),
('LOTR', 'Peace in Middle earth'),
('Dune', 'Spice for people');

INSERT INTO skills (programming_language, skill_level) VALUES
('Ruby', 'junior'),
('Ruby',  'middle'),
('Ruby',  'senior'),
('C++', 'junior'),
('C++',  'middle'),
('C++',  'senior'),
('Java', 'junior'),
('Java',  'middle'),
('Java',  'senior'),
('python',  'junior'),
('python',  'middle'),
('python',  'senior');

INSERT INTO developer (company_id, name, age, sex, salary) VALUES
(1, 'HK-47', 1, 'unknown', 10000),
(1, 'C3PO', 20, 'unknown', 20),
(2, 'Hurin Thalion', 143, 'male', 6700),
(2, 'Morwen Eledhwen', 121, 'female', 5200),
(3, 'Alia Atreides', 25, 'female', 7000),
(3, 'Frank Herbert', 50, 'male', 12500);

INSERT INTO customers (name, Country) VALUES
('Qui-Gon Jinn', 'Tatooine'),
('Anarion', 'Gondor'),
('Assan Tariq', 'Arrakis');

INSERT INTO projects (projects_name, cost, creation_Date, description) VALUES
('Green Tatooine', 32000000, '2014-03-16', 'Tree gardening'),
('Palpatine LLC', 1000000, '2022-05-31', 'The color of the lightsaber'),
('Imladris', 800000, '1986-12-15', 'Vegan food and music'),
('Sauron and Maiar', 444000, '1991-05-16', 'Business management tips'),
('Spice spice', 12000000, '2012-12-12', 'Spice for everyone'),
('Harkonen air force', 76000000000, '2000-07-20', 'Democracy and service to the people'),
('Ungoliant', 55000, '2007-10-08', 'Insect control'),
('Shire Resort', 20000000, '1834-04-03', 'Outdoor houses by the lake');

INSERT INTO developers_skills (developers_id, skill_id) VALUES
(1, 5),
(2, 8),
(3, 12),
(4, 2),
(5, 7),
(6, 6),
(6, 9),
(6, 12);

INSERT INTO developer_project (developer_id, project_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(4, 7),
(3, 8);

INSERT INTO customers_projects (customer_id, projects_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(2, 7),
(2, 8);

INSERT INTO company_customer (customer_id, company_id) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO developer (company_id, name, age, sex, salary) VALUES
(1, 'Chack Norris', 100, 'male', 7777777);

INSERT INTO developers_skills (developers_id, skill_id) VALUES
(7, 3),
(7, 6),
(7, 9),
(7, 12);

INSERT INTO developer_project (developer_id, project_id) VALUES
(7, 1),
(7, 2),
(7, 4),
(7, 7);

--ALTER TABLE projects
--ADD creation_Date DATE;
--
--UPDATE projects
--SET creation_Date = 2022-05-16
--WHERE id = 1;
--
--UPDATE projects SET creation_Date = '2014-03-16' WHERE id = 1;
--UPDATE projects SET creation_Date = '2022-05-31' WHERE id = 2;
--UPDATE projects SET creation_Date = '1986-12-15' WHERE id = 3;
--UPDATE projects SET creation_Date = '1991-05-16' WHERE id = 4;
--UPDATE projects SET creation_Date = '2012-12-12' WHERE id = 5;
--UPDATE projects SET creation_Date = '2000-07-20' WHERE id = 6;
--UPDATE projects SET creation_Date = '2007-10-08' WHERE id = 7;
--UPDATE projects SET creation_Date = '1834-04-03' WHERE id = 8;
