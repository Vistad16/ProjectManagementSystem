package com.goit.javacore5dev.feature.homeWorkSelect;

import com.goit.javacore5dev.feature.storage.Storage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HomeWork {
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
    private Storage storage;

    public HomeWork(Storage storage){
        this.storage = storage;
    }

    public void totalProjectSalary(String projectName){
        try (Statement st = storage.getConnection().createStatement()){
            try (ResultSet rs = st.executeQuery(
                    "SELECT projects.projects_name, SUM(developer.salary) AS total_salary\n" +
                    "FROM developer_project\n" +
                    "INNER JOIN developer ON developer_project.developer_id = developer.id\n" +
                    "INNER JOIN projects ON developer_project.project_id = projects.id\n" +
                    "WHERE projects_name = '" + projectName +"';")){
                while (rs.next()){
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

    public void projectDevelopersList(String projectName){
        System.out.println("Project name = " + projectName + "\nDevelopers:");
        try (Statement st = storage.getConnection().createStatement()){
            try (ResultSet rs = st.executeQuery(
                    "SELECT projects.projects_name, developer.name\n" +
                            "FROM developer_project\n" +
                            "INNER JOIN developer ON developer_project.developer_id = developer.id\n" +
                            "INNER JOIN projects ON developer_project.project_id  = projects.id\n" +
                            "WHERE projects_name = '" + projectName + "';")){
                while (rs.next()){
                    String developerName = rs.getString("name");
                    System.out.println(developerName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void writesInLanguage(String languageName){
        System.out.println("Language = " + languageName + "\nDevelopers:");
        try (Statement st = storage.getConnection().createStatement()){
            try (ResultSet rs = st.executeQuery(
                    "SELECT developer.name\n" +
                            "FROM developers_skills\n" +
                            "INNER JOIN developer ON developers_skills.developers_id = developer.id\n" +
                            "INNER JOIN skills ON developers_skills.skill_id  = skills.id\n" +
                            "WHERE programming_language = '" + languageName + "';")){
                while (rs.next()){
                    String developerName = rs.getString("name");
                    System.out.println(developerName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findDevelopersLevel(String devLevel){
        System.out.println("Level = " + devLevel + "\nDevelopers:");
        try (Statement st = storage.getConnection().createStatement()){
            try (ResultSet rs = st.executeQuery(
                    "SELECT developer.name\n" +
                            "FROM developers_skills\n" +
                            "INNER JOIN developer ON developers_skills.developers_id = developer.id\n" +
                            "INNER JOIN skills ON developers_skills.skill_id  = skills.id\n" +
                            "WHERE skill_level = '" + devLevel + "';")){
                while (rs.next()){
                    String developerName = rs.getString("name");
                    System.out.println(developerName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
