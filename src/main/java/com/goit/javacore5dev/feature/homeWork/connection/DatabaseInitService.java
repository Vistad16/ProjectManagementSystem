package com.goit.javacore5dev.feature.homeWork.connection;

import org.flywaydb.core.Flyway;

public class DatabaseInitService {
	public void initDb() {
		Flyway flyway = Flyway
				.configure()
				.dataSource(Prefs.DB_JDBC_CONNECTION_URL, Prefs.DB_USER, Prefs.DB_PASS)
				.load();

		flyway.migrate();
	}
}
