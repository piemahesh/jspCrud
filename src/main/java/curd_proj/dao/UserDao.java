package curd_proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crud_proj.utils.DatabaseConnection;
import curd_proj.model.User;

public class UserDao {

	Connection cursor = DatabaseConnection.getConnection();
	User user;

	public UserDao(User user) {
		this.user = user;
	}

	public boolean checkUser() throws SQLException {
		String query = "select email from users where email = ?";
		PreparedStatement ps = cursor.prepareStatement(query);
		ps.setString(1, user.getEmail());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			return true;
		}
		return false;
	}

	public boolean createUser() throws SQLException {

		boolean isExistingUser = checkUser();
		if (!isExistingUser) {
			String query = "insert into users(username,password,email) values(?,?,?)";
			PreparedStatement ps = cursor.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("successfully created");
				return true;
			} else {
				System.out.println("user not created");
			}
		} else {
			System.out.println("user already present");
			return false;
		}
		return false;
	}

	public boolean userLogin() throws SQLException {
		String query = "select email,password from users where email=? and password=?";
		PreparedStatement ps = cursor.prepareStatement(query);
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			return true;
		}
		return false;
	}

}
