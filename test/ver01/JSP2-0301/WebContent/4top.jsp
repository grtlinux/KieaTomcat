<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%
	Date date = new Date();
%>

<html>
<body>
top.jsp입니다.<p>
<%=date.toLocaleString() %>: <%=name %>
<hr>


