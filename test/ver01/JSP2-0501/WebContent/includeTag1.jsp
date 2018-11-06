<%@ page contentType="text/html;charset=utf-8"%>
<h1>포함하는 페이지 includeTag1.jsp 입니다.</h1>
<%
   request.setCharacterEncoding("utf-8");
%>
<hr>
<jsp:include page="includeTagTop1.jsp" flush="false">
	<jsp:param name="param1" value="value1" />
	<jsp:param name="param2" value="value2" />
</jsp:include>

includeTag1.jsp의 나머지 내용입니다.

