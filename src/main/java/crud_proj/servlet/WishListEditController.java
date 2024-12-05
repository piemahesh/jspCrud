package crud_proj.servlet;

import java.io.IOException;
import java.sql.SQLException;

import curd_proj.dao.WishListsDao;
import curd_proj.model.User;
import curd_proj.model.WishList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/wishList/update/*")
public class WishListEditController extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1096651109205905594L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		WishList wss = new WishList();
		Integer wishListId = Integer.parseInt(req.getPathInfo().replace("/", ""));
		wss.setId(wishListId);
		WishListsDao wdao = new WishListsDao(wss);
		try {
			WishList ws = wdao.getSpecificWishList();
			req.setAttribute("wishList", ws);
			req.setAttribute("id", wishListId);
			req.getRequestDispatcher("/protected/wishListsEdit.jsp").forward(req, res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.sendRedirect("view/error.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String email = (String) req.getSession().getAttribute("email");
		System.out.println(email + "this is email from session");
		User user = new User(email);
		Integer id = Integer.parseInt(req.getPathInfo().replace("/", ""));
		System.out.println(id+ " this is id ............................");
		String productName = req.getParameter("productName");
		String productDetails = req.getParameter("productDetails");
		Integer count = Integer.parseInt(req.getParameter("count"));
		WishList wishList = new WishList(count, productName, productDetails);
		wishList.setId(id);
		System.out.println(wishList.toString());
		WishListsDao wdao = new WishListsDao(user, wishList);
		System.out.println(wishList.toString() + " .............");

		try {
			boolean isUpdated = wdao.updateWishList();
			if (isUpdated) {
				req.getRequestDispatcher("/protected/home.jsp").forward(req, res);
			} else {
				res.sendRedirect(req.getContextPath()+"/view/error.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
