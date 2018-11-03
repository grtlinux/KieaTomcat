<%@ page contentType="text/html; charset=utf-8"
	import="java.util.Date"
	session="true"
	buffer="8kb"
	autoFlush="true"
	isThreadSafe="true"
%>
<h2>Directive 예제2-import, session, buffer, autoFlush, isTheadSafe 속성사용</h2>
<%
	Date date = new Date();
%>
현재의 날짜와 시간은 <%=date.toLocaleString()%> 입니다.

