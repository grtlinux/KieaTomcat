<%@ page contentType="text/html; charset=utf-8" %>
<% 
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="simpleBean" class="ch08.simpleBean.SimpleBean" />
<jsp:setProperty name="simpleBean" property="msg" />

<html>
<body>

<h1>간단한 자바빈 프로그래밍</h1>
<br>
메시지: <jsp:getProperty name="simpleBean" property="msg" />
</body>
</html>

