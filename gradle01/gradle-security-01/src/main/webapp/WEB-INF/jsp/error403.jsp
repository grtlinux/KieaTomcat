<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>error 403</title>
</head>
<body>
	<h2>Error 403</h2><br>
	<p>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="LOGOUT">
	</form:form>
</body>
</html>
