package com.goit.javacore5dev.feature.homeWork.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goit.javacore5dev.feature.homeWork.connection.Storage;
import com.goit.javacore5dev.feature.homeWork.model.entity.Developer;

public class DeveloperDaoService {
	private PreparedStatement insertSt;
	private PreparedStatement selectByIdSt;
	private PreparedStatement updateByIdSt;
	private PreparedStatement deleteByIdSt;
	private PreparedStatement getAllSt;

	public DeveloperDaoService(Storage storage) {
		Connection conn = storage.getConnection();

		try {
			insertSt = conn.prepareStatement("INSERT INTO developer (company_id, name, age, sex, salary) VALUES(?, ?, ?, ?, ?)");
			selectByIdSt = conn.prepareStatement("SELECT * FROM developer WHERE id = ?");
			updateByIdSt = conn.prepareStatement("UPDATE developer SET company_id = ?, name = ?, age = ?, sex = ?, salary = ? WHERE id = ?");
			deleteByIdSt = conn.prepareStatement("DELETE FROM developer WHERE id = ?");
			getAllSt = conn.prepareStatement("SELECT * FROM developer");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Developer> getAll() {
		try (ResultSet rs = getAllSt.executeQuery()) {
			List<Developer> result = new ArrayList<>();
			while (rs.next()) {
				Developer developer = new Developer();
				developer.setId(rs.getInt("id"));
				developer.setCompany_id(rs.getInt("company_id"));
				developer.setName(rs.getString("name"));
				developer.setAge(rs.getInt("age"));
				developer.setSex(Developer.Sex.valueOf(rs.getString("sex")));
				developer.setSalary(rs.getInt("salary"));
				result.add(developer);
			}
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void listAll() {
		try (ResultSet rs = getAllSt.executeQuery()) {
			List<Developer> result = new ArrayList<>();
			while (rs.next()) {
				Developer developer = new Developer();
				developer.setId(rs.getInt("id"));
				developer.setCompany_id(rs.getInt("company_id"));
				developer.setName(rs.getString("name"));
				developer.setAge(rs.getInt("age"));
				developer.setSex(Developer.Sex.valueOf(rs.getString("sex")));
				developer.setSalary(rs.getInt("salary"));
				System.out.println(developer);
				result.add(developer);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void createNewDev(Developer developer) {
		try {
			insertSt.setInt(1, developer.getCompany_id());
			insertSt.setString(2, developer.getName());
			insertSt.setInt(3, developer.getAge());
			insertSt.setString(4, developer.getSex().toString());
			insertSt.setInt(5, developer.getSalary());
			insertSt.executeUpdate();
			System.out.println("Developer created!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void printDeveloperInfo(int id) {
		try {
			selectByIdSt.setLong(1, id);
			try (ResultSet rs = selectByIdSt.executeQuery()) {
				if (rs.next()) {
					Developer developer = new Developer();
					developer.setId(id);
					developer.setCompany_id(rs.getInt("company_id"));
					developer.setName(rs.getString("name"));
					developer.setAge(rs.getInt("age"));
					developer.setSex(Developer.Sex.valueOf(rs.getString("sex")));
					developer.setSalary(rs.getInt("salary"));
					System.out.println("Info for developer with id = " + id + "\n" + developer);
				} else {
					System.out.println("Developer with id = " + id + " not found!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateDeveloper(int id, Developer developer) {
		try {
			selectByIdSt.setLong(1, id);
			try (ResultSet rs = selectByIdSt.executeQuery()) {
				if (rs.next()) {
					updateByIdSt.setInt(1, developer.getCompany_id());
					updateByIdSt.setString(2, developer.getName());
					updateByIdSt.setInt(3, developer.getAge());
					updateByIdSt.setString(4, developer.getSex().toString());
					updateByIdSt.setInt(5, developer.getSalary());
					updateByIdSt.setInt(6, id);
					updateByIdSt.executeUpdate();
					System.out.println("Developer update!");
				} else {
					System.out.println("Developer with id = " + id + " not found!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteDeveloperById(int id) {
		try {
			selectByIdSt.setLong(1, id);
			try (ResultSet rs = selectByIdSt.executeQuery()) {
				if (rs.next()) {
					try {
						deleteByIdSt.setLong(1, id);
						deleteByIdSt.executeUpdate();
						System.out.println("Developer with id " + id + " was deleted");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Developer with id = " + id + " not found for deleting!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
