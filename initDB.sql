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

ALTER TABLE developer --фіксим таблицю "developer"
ADD CONSTRAINT  IF NOT EXISTS sex_enum_values --додаємо обмеження з "sex_enum_values" іменем
CHECK (sex IN ('male', 'female', 'unknown')); --перевіряємо значеня поля "sex" щоб воно було в одному з трьох ппараметрів "'male', 'female', 'unknown'"

CREATE TABLE IF NOT EXISTS projects (
    id IDENTITY PRIMARY KEY,
    projects_name VARCHAR(100) NOT NULL,
    cost BIGINT NOT NULL,
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