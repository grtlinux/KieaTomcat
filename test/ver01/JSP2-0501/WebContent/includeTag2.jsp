<%@ page contentType="text/html;charset=utf-8"%>
<h2>includeTag2.jsp페이지 입니다</h2>
<%
   request.setCharacterEncoding("utf-8");
   String siteName1 = request.getParameter("siteName1");
%>
<hr>
 <jsp:include page="includeTagTop2.jsp" flush="false">
    <jsp:param name="siteName" value="<%=siteName1%>"/>
</jsp:include>

 includeTag2.jsp페이지의 나머지 내용입니다.<p>
 
 