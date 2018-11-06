<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%
	String name = "한글";
	String nameutf8 = URLEncoder.encode(name, "utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp01.jsp</h2>
	<p>

	name = <%=name %><br>
	nameutf8 = <%=nameutf8 %><br>
	<p>

	<a href="jsp01GetResult.jsp?name=<%=name %>&nameutf8=<%=nameutf8 %>">jsp01result.jsp</a>
	<p>

	<form action="jsp01PostResult.jsp" method="post">
		<label>이름: </label>    <input type="text" name="name"><br>           <!-- 강석 -->
		<label>이메일: </label>   <input type="text" name="email"><br>          <!-- 강석@gmail.com -->
		<label>비밀번호: </label>  <input type="password" name="password"><br>  <!-- 1234567890 -->
		<input type="submit" value="Send">
	</form>
</body>
</html>


