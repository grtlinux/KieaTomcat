<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<%
	request.setCharacterEncoding("utf-8");

	String nameutf8 = request.getParameter("nameutf8");
	String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp01GetResult.jsp(GET)</h2>
	<p>

	nameutf8 = <%=nameutf8 %>
	<p>

	name = <%=name %>
	<p>

<%
	nameutf8 = new String(nameutf8.getBytes("8859_1"), "utf-8");
	name = new String(name.getBytes("8859_1"), "utf-8");
%>
	nameutf8 = <%=nameutf8 %>
	<p>

	name = <%=name %>
	<p>

</body>
</html>


