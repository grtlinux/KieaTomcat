<%@ page contentType="text/html;charset=euc-kr"%>
<%
	request.setCharacterEncoding("euc-kr");
%>
<h2>Session���尴ü ����</h2>
<%
	String sports = request.getParameter("sports");
	String game = request.getParameter("game");
	String id = (String)session.getAttribute("id"); 
	String sessionId = session.getId();
	
	if(id != null){
%>
<b><%=id%></b>�� �������ּż� �����մϴ�. <br>
<%=id%> �� �����ϴ� �������� <%=sports%>�̰�, <br>
�����ϴ� ������ <%=game%> �Դϴ�.<p>
���� ���������� ���� ID : <%=sessionId%><p>

<%
	 session.invalidate();
	}else{
         out.println("�α����� �Ͻñ� �ٶ��ϴ�.");
    }
%>