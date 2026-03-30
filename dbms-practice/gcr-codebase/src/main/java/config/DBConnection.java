package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/clinic";
	private static final String USER = "root";
	private static final String PASSWORD = "arpit";
	private static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Database Connected Successfully");
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL JDBC Driver not found!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Connection failed!");
			e.printStackTrace();
		}
		return connection;
	}

	public void closeConnection() {
		try {
			if (connection != null && connection.isClosed()) {
				connection.close();
				System.out.println("Connection closed");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error closing connection");
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Connection conn = DBConnection.getConnection();
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Connection closed.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}