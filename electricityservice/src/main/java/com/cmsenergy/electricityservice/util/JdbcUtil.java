package com.cmsenergy.electricityservice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

	public Connection createMySqlConnection() {
		Connection Connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/util", "root", "admin");
			} catch (SQLException e) {
				System.out.println("Connection Problem");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Loaded");
			e.printStackTrace();

		}

		return Connection;
	}
}
