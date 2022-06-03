-- example sql selection

-- #1 зарплату(сумму) всех разработчиков отдельного проекта;
SELECT projects.projects_name, SUM(developer.salary) AS total_salary
FROM developer_project
INNER JOIN developer ON developer_project.developer_id = developer.id
INNER JOIN projects ON developer_project.project_id  = projects.id
WHERE projects_name = 'Green Tatooine';

--  #2 список разработчиков отдельного проекта;
SELECT projects.projects_name, developer.name
FROM developer_project
INNER JOIN developer ON developer_project.developer_id = developer.id
INNER JOIN projects ON developer_project.project_id  = projects.id
WHERE projects_name = 'Green Tatooine';

-- #3 список всех Java разработчиков;
SELECT developer.name
FROM developers_skills
INNER JOIN developer ON developers_skills.developers_id = developer.id
INNER JOIN skills ON developers_skills.skill_id  = skills.id
WHERE programming_language = 'Java';

-- #4 список всех middle разработчиков;
SELECT developer.name
FROM developers_skills
INNER JOIN developer ON developers_skills.developers_id = developer.id
INNER JOIN skills ON developers_skills.skill_id  = skills.id
WHERE skill_level = 'middle';

--#5 список проектов в следующем формате: дата создания - название проекта - количество разработчиков на этом проекте.
SELECT projects.creation_Date, projects.projects_name, COUNT(developer.id) AS total_developers
FROM developer_project
INNER JOIN developer ON developer_project.developer_id = developer.id
INNER JOIN projects ON developer_project.project_id  = projects.id
GROUP BY projects.id;