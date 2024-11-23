package crud_proj.utils;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/protected/*")
public class RouteProtection implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) res;

		// Retrieve the session, do not create a new one if it doesn't exist
		HttpSession session = httpRequest.getSession(false);

		// Check if the user is authenticated (based on session attribute)
		if (session == null || session.getAttribute("email") == null) {
			// Redirect unauthenticated user to login page
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/view/login.jsp");
			return; // Stop further processing
		}

		// Continue the chain if user is authenticated
		chain.doFilter(req, res);

	}

}
