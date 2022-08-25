package com.goit.javacore5dev.feature.homeWork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.goit.javacore5dev.feature.homeWork.connection.Storage;

public class HomeWork {
	private PreparedStatement totalProjectSalaryNew;

	public static final String GREEN_TATOOINE = "Green Tatooine";
	public static final String PALPATINE_LLC = "Palpatine LLC";
	public static final String IMLADRIS = "Imladris";
	public static final String SAURON_AND_MAIAR = "Sauron and Maiar";
	public static final String SPICE_SPICE = "Spice spice";
	public static final String HARKONEN_AIR_FORCE = "Harkonen air force";
	public static final String UNGOLIANT = "Ungoliant";
	public static final String SHIRE_RESORT = "Shire Resort";
	public static final String JAVA = "Java";
	public static final String RUBY = "Ruby";
	public static final String C_PLUS_PLUS = "C++";
	public static final String PYTHON = "python";
	public static final String JUNIOR = "junior";
	public static final String MIDDLE = "middle";
	public static final String SENIOR = "senior";

	private PreparedStatement getTotalProjectSalarySt;
	private PreparedStatement projectDevelopersListSt;
	private PreparedStatement selectDevelopersByLanguageSt;
	private PreparedStatement findDevelopersLevelSt;
	private PreparedStatement numberOfDevelopersOnProjectsSt;

	public HomeWork(Storage storage) {
		Connection conn = storage.getConnection();

		try {
			getTotalProjectSalarySt = conn.prepareStatement(
					"SELECT projects.projects_name, SUM(developer.salary) AS total_salary " +
							"FROM developer_project " +
							"INNER JOIN developer ON developer_project.developer_id = developer.id " +
							"INNER JOIN projects ON developer_project.project_id = projects.id " +
							"WHERE projects_name = ?");

			projectDevelopersListSt = conn.prepareStatement(
					"SELECT projects.projects_name, developer.name " +
							"FROM developer_project " +
							"INNER JOIN developer ON developer_project.developer_id = developer.id " +
							"INNER JOIN projects ON developer_project.project_id  = projects.id " +
							"WHERE projects_name = ?");

			selectDevelopersByLanguageSt = conn.prepareStatement(
					"SELECT developer.name " +
							"FROM developers_skills " +
							"INNER JOIN developer ON developers_skills.developers_id = developer.id " +
							"INNER JOIN skills ON developers_skills.skill_id  = skills.id " +
							"WHERE programming_language = ?");

			findDevelopersLevelSt = conn.prepareStatement(
					"SELECT developer.name " +
							"FROM developers_skills " +
							"INNER JOIN developer ON developers_skills.developers_id = developer.id " +
							"INNER JOIN skills ON developers_skills.skill_id  = skills.id " +
							"WHERE skill_level = ?");

			numberOfDevelopersOnProjectsSt = conn.prepareStatement(
					"SELECT projects.creation_Date, projects.projects_name, COUNT(developer.id) AS total_developers " +
							"FROM developer_project " +
							"INNER JOIN developer ON developer_project.developer_id = developer.id " +
							"INNER JOIN projects ON developer_project.project_id  = projects.id " +
							"GROUP BY projects.id;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getTotalProjectSalaryByName(String projectName) {
		try {
			getTotalProjectSalarySt.setString(1, projectName);
			try (ResultSet rs = getTotalProjectSalarySt.executeQuery()) {
				while (rs.next()) {
					String projects_name = rs.getString("projects_name");
					String totalSalary = rs.getString("total_salary");
					System.out.println("Project name = " + projects_name);
					System.out.println("Total salary = " + totalSalary);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void projectDevelopersList(String projectName) {
		System.out.println("Project name = " + projectName + "\nDevelopers:");
		try {
			projectDevelopersListSt.setString(1, projectName);
			try (ResultSet rs = projectDevelopersListSt.executeQuery()) {
				while (rs.next()) {
					String developerName = rs.getString("name");
					System.out.println(developerName);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void writesInLanguage(String languageName) {
		System.out.println("Language = " + languageName + "\nDevelopers:");
		try {
			selectDevelopersByLanguageSt.setString(1, languageName);
			try (ResultSet rs = selectDevelopersByLanguageSt.executeQuery()) {
				while (rs.next()) {
					String developerName = rs.getString("name");
					System.out.println(developerName);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void findDevelopersLevel(String devLevel) {
		System.out.println("Level = " + devLevel + "\nDevelopers:");
		try {
			findDevelopersLevelSt.setString(1, devLevel);
			try (ResultSet rs = findDevelopersLevelSt.executeQuery()) {
				while (rs.next()) {
					String developerName = rs.getString("name");
					System.out.println(developerName);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void NumberOfDevelopersOnProjects() {
		System.out.println("Number of developers on projects:");
		try (ResultSet rs = numberOfDevelopersOnProjectsSt.executeQuery()) {
			while (rs.next()) {
				String date = rs.getString("creation_Date");
				String projectsName = rs.getString("projects_name");
				int totalDevelopers = rs.getInt("total_developers");
				System.out.println(date + " " + projectsName + " " + totalDevelopers);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
