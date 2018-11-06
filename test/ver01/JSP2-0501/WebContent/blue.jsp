<%@ page contentType="text/html;charset=utf-8"%>
<%
   String name = request.getParameter("name");
   String selectedColor = request.getParameter("selectedColor");
   
   String selectedColorJsp = selectedColor + ".jsp";
%>
<h2>포워딩되는 페이지 - <%=selectedColorJsp %></h2>
<b><%=name%></b>님의 좋아하는 색은 "<%=selectedColor%>"이고
자기탐구와 내적성장을 상징하는 색입니다.<br>
<img src="<%=selectedColor+".jpg"%>" border="0" width="70" height="30">


