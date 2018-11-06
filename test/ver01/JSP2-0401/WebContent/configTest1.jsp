<%@ page contentType="text/html;charset=utf-8" %>
<%
	String name = config.getServletName();
	String path = config.getServletContext().getContextPath();
%>

<h2>Inner Object: config</h2>
name: <%=name %><p>
path: <%=path %><p>



