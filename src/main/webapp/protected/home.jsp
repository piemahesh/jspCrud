<%@page import="crud_proj.utils.TimeStampConverter"%>
<%@page import="curd_proj.model.WishList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.servletContext.contextPath}/assets/css/style.css" rel="stylesheet">
</head>
<body>


	<%=session.getAttribute("email")%>
	<h1>
		<%-- 		welcome page <span>${request.getAttribute("username")}</span> --%>
		${username}
	</h1>


	<a href="${pageContext.servletContext.contextPath}/protected/about.jsp">about
		page </a>
	<a
		href="${pageContext.servletContext.contextPath}/protected/contact.jsp">contact
		page </a>
	<a
		href="${pageContext.servletContext.contextPath}/protected/wishlists.jsp">add
		wishlist </a>
	<%="<br/>"%>
	<main class="container">
		<%
		List<WishList> obj1 = (List<WishList>) request.getAttribute("myWishLists");
		if(obj1 != null){
			for (WishList ws : obj1) {
				out.print("<div class='card'>");
				out.print("<p>");
				out.print("productName: ");
				out.print(ws.getProductName());
				out.print("</p>");
				out.print("<p>");
				out.print("productDetail: ");
				out.print(ws.getProductDetails());
				out.print("</p>");
				out.print("<p>");
				out.print("dateTime: ");
				out.print(new TimeStampConverter(ws.getEndDate()).getIndianDate());
				out.print("</p>");
				out.print("<p>");
				out.print("count: ");
				out.print(ws.getCount());
				out.print("</p>");
				out.print("</div>");
			}
		}
		else{
			out.print("no more wishLists");
		}
		%>
	</main>

</body>
</html>