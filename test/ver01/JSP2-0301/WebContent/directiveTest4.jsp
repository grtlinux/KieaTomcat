<%@ page contentType="text/html; charset=utf-8" %>
<h2>Directive 예제3</h2>
<%
	String name = "Kiea";
%>

<%@ include file="4top.jsp" %>
포함하는 페이지 Directive 예제4.jsp의 내용입니다. (<%=name %>)
<%@ include file="4bottom.jsp" %>

