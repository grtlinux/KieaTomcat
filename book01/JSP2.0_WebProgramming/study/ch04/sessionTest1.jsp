<%@ page contentType="text/html;charset=euc-kr"%>
<%
	request.setCharacterEncoding("euc-kr");
%>
<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");

    session.setAttribute("id",id);
	session.setMaxInactiveInterval(60*2);
%>
<h2>Session���尴ü ����</h2>
<FORM METHOD="post" ACTION="sessionTest2.jsp">
    �� ���� �����ϴ� �������� �����ϼ���. �� <br>
	<INPUT TYPE="radio" NAME="sports" VALUE="�±ǵ�">�±ǵ�
	<INPUT TYPE="radio" NAME="sports" VALUE="����">����
	<INPUT TYPE="radio" NAME="sports" VALUE="���η�����">���η�����
	<INPUT TYPE="radio" NAME="sports" VALUE="����������">����������<p>

	�� ���� �����ϴ� ������ �����ϼ���. �� <br>
	<SELECT NAME="game">
	  <OPTION VALUE="��Ÿũ">��Ÿũ(������ ����)</OPTION>
	  <OPTION VALUE="WOW">WOW</OPTION>
	  <OPTION VALUE="������">������</OPTION>
	</SELECT>
	<INPUT TYPE="submit" VALUE="����">
</FORM>