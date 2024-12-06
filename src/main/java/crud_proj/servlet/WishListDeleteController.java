package crud_proj.servlet;

import java.io.IOException;
import java.sql.SQLException;

import curd_proj.dao.WishListsDao;
import curd_proj.model.WishList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/wishList/delete/*")
public class WishListDeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		WishList wss = new WishList();
		System.out.println("im hitted ");
		Integer wishListId = Integer.parseInt(req.getPathInfo().replace("/", ""));
		wss.setId(wishListId);
		WishListsDao wdao = new WishListsDao(wss);
		try {
			boolean isDeleted = wdao.deleteWishList();
			System.out.println(isDeleted + " ---------------------");
			if (isDeleted) {
				res.sendRedirect("/crud_proj/protected/home.jsp");
			} else {
				res.sendRedirect("view/error.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
