<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
	<title>세션 사용 예제</title>
</head>
<body>
<%
	String id = "hongkd";
	String passwd = "1234";

	session.setAttribute("id", id);
	session.setAttribute("passwd", passwd);
%>
세션에 id 와 passwd 속성을 설정하였습니다.<br>

<input type="button" value="세션의 설정된 속성확인" onclick="javascript:window.location='viewSession.jsp'">
</body>
</html>