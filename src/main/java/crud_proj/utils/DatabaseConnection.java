package crud_proj.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	final static String USERNAME = "root";
	final static String PASSWORD = "root";
	final static String URL = "jdbc:mysql://localhost:3306/maheshDb";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
