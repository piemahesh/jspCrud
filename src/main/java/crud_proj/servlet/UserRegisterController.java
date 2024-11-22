package crud_proj.servlet;

import java.io.IOException;
import java.sql.SQLException;

import curd_proj.dao.UserDao;
import curd_proj.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userRegister")
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 8262504390830169626L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String username = req.getParameter("username");
		User user = new User(email, username, password);
		UserDao userDao = new UserDao(user);
		try {
			boolean isCreated = userDao.createUser();
			if (isCreated) {
				res.sendRedirect("view/login.jsp");
			} else {
				res.sendRedirect("view/register.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
