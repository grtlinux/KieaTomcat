<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>HelloController</title>
</head>
<body>
	<h2>HelloController: index.jsp</h2><br>
	The time on the server is ${serverTime}.
	<p>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="LOGOUT">
	</form:form>
	<p>
	
	<a href="<c:url value='/logout' />">LOGOUT</a>
</body>
</html>
