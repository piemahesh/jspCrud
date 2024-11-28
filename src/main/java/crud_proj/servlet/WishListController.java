package crud_proj.servlet;

import java.io.IOException;
import java.sql.SQLException;

import curd_proj.dao.WishListsDao;
import curd_proj.model.User;
import curd_proj.model.WishList;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/wishList/create")
public class WishListController extends HttpServlet {

	private static final long serialVersionUID = -4283235096541994633L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String email = (String) req.getSession().getAttribute("email");
		System.out.println(email+"this is email from session");
		User user = new User(email);
		String productName = req.getParameter("productName");
		String productDetails = req.getParameter("productDetails");
		Integer count = Integer.parseInt(req.getParameter("count"));
		WishList wishList = new WishList(count, productName, productDetails);
		WishListsDao wdao = new WishListsDao(user, wishList);
		System.out.println(wishList.toString() + " .............");
		try {
			boolean isCreated = wdao.createWishLists();
			if (isCreated) {
				System.out.println("wishlists is created");
				res.sendRedirect("/crud_proj/protected/home.jsp");
			} else {
				System.out.println("not created");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
