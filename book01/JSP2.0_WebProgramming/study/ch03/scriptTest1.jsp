<%@ page contentType="text/html;charset=euc-kr"%>
<html>
  <head><title>JSP��ũ��Ʈ ����</title></head>
  <body>
    <h2>JSP��ũ��Ʈ ����</h2>
    <%!
 	  String declaration = "���� �����Դϴ�";
    %>
    <%!
 	  public String declarationMethod(){
 	    return declaration;
 	  }
    %>
    <%
 	  String scriptlet = "��ũ��Ʈ�� ����";
      String comment = "�ּ��� ����";
 	  out.println("���尴ü�� �̿��� ���� ��� : " + declaration + "<p>");
    %>

    ���� ����ϱ�(����) : <%=declaration%><p>
    ���� ����ϱ�(�޼ҵ�) : <%=declarationMethod()%><p>
    ��ũ��Ʈ�� ����ϱ� : <%=scriptlet%><p>
   <!--JSP���� ����ϴ� HTML�ּ��κ�-->
   <!-- HTML�ּ� :  <%=comment%> --><p>
   <%-- JSP �ּ� : <%=comment%> --%>
   <%  /* �ڹ��ּ� 
    (������ �ּ�)
     */  
   %> 
   <%// �ڹ��ּ�(���� �ּ�)%>
  </body>
</html>



