<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ page errorPage="error.jsp"%>
<html>
  <body>
   <% 
      Date date = new Date();
      SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
      String strdate = simpleDate.format(date);
   %>
   보통의 JSP 페이지의 형태입니다.<br>
   오늘 날짜는 <%=strdat %> 입니다.
  </body>
</html>

