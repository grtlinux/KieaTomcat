<%@ page contentType="text/html;charset=euc-kr"
         import="java.util.Date"
		 session="true"
		 buffer="8kb"
		 autoFlush="true"
		 isThreadSafe="true"
%>
<h2>Directive ����2 - import, session, buffer, autoFlush, isThreadSafe �Ӽ�</h2>
<%
    Date date = new Date();
	//DateŬ������ ���� ��¥�� �ð��� ���� ������ 
	//�� �ʿ䰡 ������ ���ȴ�.
%>

������ ��¥�� �ð��� <%=date.toLocaleString()%> �Դϴ�. 