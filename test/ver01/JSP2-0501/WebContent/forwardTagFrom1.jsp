<%@ page contentType="text/html;charset=utf-8"%>
<h2>포워딩하는 페이지: forwardTagFrom1.jsp</h2>
<%
   request.setCharacterEncoding("utf-8");
%>
<html>
 <body>
   forwardTagFrom1.jsp의 내용 입니다.<br>
  화면에 절대 표시 안됩니다.
	<jsp:forward page="forwardTagTo1.jsp"/>  
 </body>
</html>