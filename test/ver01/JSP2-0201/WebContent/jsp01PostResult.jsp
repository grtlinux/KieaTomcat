<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp01PostResult.jsp(POST)</h2>
	<p>

	name = <%=name %><br>
	email = <%=email %><br>
	password = <%=password %><br>
	<p>

</body>
</html>


