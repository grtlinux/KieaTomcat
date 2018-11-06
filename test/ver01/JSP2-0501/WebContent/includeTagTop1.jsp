<%@ page contentType="text/html;charset=utf-8"%>
<%
	String name = request.getParameter("name");
	String param1 = request.getParameter("param1");
	String param2 = request.getParameter("param2");
	
	System.out.println(">>>>> " + param1);
%>
포함되는 페이지 includeTagTop1.jsp 입니다.<p>
<b><%=name%> 님 오셨구려..</b><p>
param1: <%=param1 %><p>
param2: <%=param2 %><p>
<hr>
