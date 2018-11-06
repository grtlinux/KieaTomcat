<%@ page contentType="text/html;charset=utf-8"%>
<h2>포워딩되는 페이지: forwardTagTo1.jsp</h2>
<%
   String id = request.getParameter("id");
   String password = request.getParameter("password");
%>
 <b><%=id%></b>님의<p>
패스워드는 <b><%=password%></b>입니다.
