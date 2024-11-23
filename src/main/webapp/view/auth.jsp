<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	application.setAttribute("name", request.getAttribute("username"));
	// 	String obj = (String) request.getSession().getAttribute("email");
	if (session.getAttribute("email") == null) {
		response.sendRedirect(pageContext.getServletContext().getContextPath() + "/view/login.jsp");
		out.print("hello");
// 		request.getRequestDispatcher("/view/login.jsp").forward(request, response);
		out.print(request.getContextPath());
		response.sendRedirect("/view/login.jsp");
		// 		return;
	}
	%>
	<%=session.getAttribute("email")%>
	<p>im auth page</p>
</body>
</html>