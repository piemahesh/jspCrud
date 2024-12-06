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

	public WishListsDao(WishList ws) {
		this.wishLists = ws;
	}

	public WishListsDao(User user, WishList wishLists) {
		this.user = user;
		this.wishLists = wishLists;
	}

	public WishListsDao(User user) {
		this.user = user;
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
		List<WishList> myWishList = new ArrayList<>();
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

	public WishList getSpecificWishList() throws SQLException {
		String query = "select * from wishlists where id=?";
		PreparedStatement ps = cursor.prepareStatement(query);
		ps.setInt(1, wishLists.getId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			WishList ws = new WishList();
			ws.setProductName(rs.getString("productName"));
			ws.setProductDetails(rs.getString("productDetails"));
			ws.setCount(rs.getInt("count"));
			ws.setEndDate(rs.getString("endDate"));
			return ws;
		}
		return null;

	}

	public boolean updateWishList() throws SQLException {
		String query = "update wishlists set productName=?, productDetails = ?, count = ?  where id = ?";
		PreparedStatement ps = cursor.prepareStatement(query);
		ps.setString(1, wishLists.getProductName());
		ps.setString(2, wishLists.getProductDetails());
		ps.setInt(3, wishLists.getCount());
		ps.setInt(4, wishLists.getId());
		int rows = ps.executeUpdate();
		if (rows > 0) {
			return true;
		}
		return false;
	}

	public boolean deleteWishList() throws SQLException {
		String query = "delete from wishlists where id = ?";
		PreparedStatement ps = cursor.prepareStatement(query);
		ps.setInt(1, wishLists.getId());
		int rows = ps.executeUpdate();
		if (rows > 0) {
			return true;
		}
		return false;
	}

}
