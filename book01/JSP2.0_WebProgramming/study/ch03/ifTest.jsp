<%@ page contentType="text/html;charset=euc-kr"%>
<% request.setCharacterEncoding("euc-kr");%>
<h2>If-else�� ���� - �����ϴ� �� ����</h2>

<%
   String name = request.getParameter("name");
   String color = request.getParameter("color");
   String selectColor = "";
  
   if (color.equals("blue")) {
 	   selectColor = "�Ķ���";
   } else if (color.equals("green")) {
	   selectColor = "�ʷϻ�";
    }else if (color.equals("red")){
       selectColor = "������";
   }else{
       selectColor = "��Ÿ��";
    }
%>

<%=name%>���� ������ ���� <%=selectColor%>�Դϴ�.<p>
������ ��:<br>
<img src="<%=color + ".jpg"%>" border="0">