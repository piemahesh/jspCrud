package crud_proj.servlet;

import java.io.IOException;
import java.sql.SQLException;

import curd_proj.dao.UserDao;
import curd_proj.dao.WishListsDao;
import curd_proj.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userLogin")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
//		user is created
		User user = new User(email, password);
		System.out.println(user.toString());
		UserDao userDao = new UserDao(user);
//		res.setHeader("Cache-Control", "na-cache,no-store");
//		res.setHeader("Expires", "0");
		try {
			boolean isUser = userDao.userLogin();
			if (isUser) {
				req.setAttribute("username", user.getEmail());
				HttpSession session = req.getSession();
				WishListsDao wishDao = new WishListsDao(user, null);
				req.setAttribute("myWishLists", wishDao.getWishLists());
				session.setAttribute("email", user.getEmail());
				req.getRequestDispatcher("/protected/home.jsp").forward(req, res);
//				res.sendRedirect("view/home.jsp");
			} else {
				res.sendRedirect("view/login.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
