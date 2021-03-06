package com.goit.javacore5dev.feature.homeWork;

import com.goit.javacore5dev.feature.storage.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PersonCrudService {
    private PreparedStatement insertSt;
    private PreparedStatement selectByIdSt;
    private PreparedStatement updateByIdSt;
    private PreparedStatement deleteByIdSt;
    private PreparedStatement dropAllObjects;

    public PersonCrudService(Storage storage) {
        Connection conn = storage.getConnection();

        try {
            insertSt = conn.prepareStatement(
                    "INSERT INTO developer (company_id, name, age, sex, salary) VALUES(?, ?, ?, ?, ?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            selectByIdSt = conn.prepareStatement("SELECT * FROM developer WHERE id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            updateByIdSt = conn.prepareStatement("UPDATE developer SET salary = ? WHERE id = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            deleteByIdSt = conn.prepareStatement("DELETE FROM developer WHERE id = ?");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            dropAllObjects = conn.prepareStatement("DROP ALL OBJECTS");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createNewDev(int company_id, String name, int age, String sex, int salary) {
        try {
            insertSt.setInt(1, company_id);
            insertSt.setString(2, name);
            insertSt.setInt(3, age);
            insertSt.setString(4, sex);
            insertSt.setInt(5, salary);
            System.out.print("Create new Dev = ");
            return insertSt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean printDeveloperInfo(long id) {
        try {
            selectByIdSt.setLong(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        try (ResultSet rs = selectByIdSt.executeQuery()) {
            if (!rs.next()) {
                System.out.println("Developer with id = " + id + " not found!");
                return false;
            }

            int company_id = rs.getInt("company_id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String sex = rs.getString("sex");
            int salary = rs.getInt("salary");
            System.out.println(
                    "Developer info with id = " + id
                            + "\nName = " + name
                            + "\nAge = " + age
                            + "\nSex = " + sex
                            + "\nSalary = " + salary
                            + "\nCompany id = " + company_id
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDeveloperSalary(long id, int salary) {
        try {
            updateByIdSt.setInt(1, salary);
            updateByIdSt.setLong(2, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        try {
            updateByIdSt.setInt(1, salary);
            updateByIdSt.setLong(2, id);
            System.out.print("Update salary = ");
            return updateByIdSt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDeveloper(long id) {
        try {
            deleteByIdSt.setLong(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        try {
            deleteByIdSt.setLong(1, id);
            System.out.print("Developer with id " + id + " was deleted = ");
            return deleteByIdSt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void exterminatus(){
        Scanner confirmationExterminatus = new Scanner(System.in);
        System.out.print("CONFIRM ORDER: ");
        String order = confirmationExterminatus.nextLine().toUpperCase();
        if (order.equals("EXTERMINATUS")) {
            try {
                System.err.print("EXTERMINATUS ");
                point();
                System.err.println("\nINITIATED!");
                sleep(2);
                int x = 5;
                while (x != -1) {
                    System.err.println(x);
                    sleep(1);
                    x--;
                }
                dropAllObjects.executeUpdate();
                System.err.print("EXTERMINATUS STATUS ");
                point();
                System.err.println("\nTRUE!");
                sleep(2);
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("EXTERMINATUS STATUS ");
                point();
                System.err.println("\nFALSE!");
                sleep(2);
            }
        } else {
            System.err.print("ORDER NOT CONFIRMED");
            point();
            System.err.println("\nORDER CANCELED!");
            sleep(2);
        }
    }

    private void point() {
        int b = 0;
        while (b != 3){
            System.err.print(".");
            sleep(1);
            b++;
        }
    }

    private void sleep(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
