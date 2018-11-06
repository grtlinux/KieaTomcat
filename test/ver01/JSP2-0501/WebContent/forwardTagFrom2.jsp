<%@ page contentType="text/html;charset=utf-8"%>
<h2>포워딩하는 페이지: forwardTagFrom2.jsp</h2>
<%
   request.setCharacterEncoding("utf-8");

   String name = request.getParameter("name");
   String selectedColor = request.getParameter("color");
   
   System.out.println(">>>>> " + name);
   System.out.println(">>>>> " + selectedColor);
   
   String selectedColorJsp = selectedColor + ".jsp";
%>
<jsp:forward page="<%=selectedColorJsp %>">
    <jsp:param name="selectedColor" value="<%=selectedColor%>"/>
	<jsp:param name="name" value="<%=name%>"/>
</jsp:forward>



