package curd_proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import crud_proj.utils.DatabaseConnection;
import curd_proj.model.User;
import curd_proj.model.WishList;

public class WishListsDao {

	Connection cursor = DatabaseConnection.getConnection();
	User user;
	WishList wishLists;

	public WishListsDao(User user, WishList wishLists) {
		this.user = user;
		this.wishLists = wishLists;
	}

	public boolean createWishLists() throws SQLException {

		String query = "insert into wishlists(email,productName,productDetails,count,endDate) values(?,?,?,?,?)";
		PreparedStatement ps = cursor.prepareStatement(query);
		ps.setString(1, user.getEmail());
		ps.setString(2, wishLists.getProductName());
		ps.setString(3, wishLists.getProductDetails());
		ps.setInt(4, wishLists.getCount());
		ps.setString(5, new Timestamp(System.currentTimeMillis()).toString());
		int rows = ps.executeUpdate();
		if (rows > 0) {
			return true;
		}
		return false;
	}

	public List<WishList> getWishLists() throws SQLException {
		String query = " select * from wishlists where email = ?";
		PreparedStatement ps = cursor.prepareStatement(query);
		ps.setString(1, user.getEmail());
		ResultSet rs = ps.executeQuery();
		List<WishList> myWishList = new ArrayList<WishList>();
		while (rs.next()) {
			WishList ws = new WishList();
			ws.setProductName(rs.getString("productName"));
			ws.setProductDetails(rs.getString("productDetails"));
			ws.setId(rs.getInt("id"));
			ws.setCount(rs.getInt("count"));
			ws.setEndDate(rs.getString("endDate"));
			myWishList.add(ws);
//			System.out.println(ws.toString());
		}
		if (myWishList.size() > 0) {
			return myWishList;
		}
		return null;
	}
}
