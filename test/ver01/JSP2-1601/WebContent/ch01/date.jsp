<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<html>
<body>
	<%
		Date nowDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formatDate = dateFormat.format(nowDate);
	%>
	일반적인 JSP 페이지의 형태로 아래와 같이 현재 날짜를 제공합니다.<br>
	현재 날짜는 <%= formatDate%> 입니다.
</body>
</html>

