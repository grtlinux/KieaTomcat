<%@page import="java.io.File"%>
 <%@page import="java.io.*"%>
 <%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
 <title>Insert title here</title>
 </head>
 <body>

 <% 
  // �ٿ���� ������ �̸��� ������
  String fileName = request.getParameter("fileName");
  // �ٿ���� ������ ����Ǿ� �ִ� ���� �̸�
  String saveFolder = "File";
  
  // Context�� ���� ������ �˾ƿ�
  ServletContext context = getServletContext(); // ������ ���� ȯ�������� ������
  
  // ���� ������ ����Ǿ� �ִ� ������ ���
  String realFolder = context.getRealPath(saveFolder);
  // �ٿ���� ������ ��ü ��θ� filePath�� ����
  String filePath = realFolder + "\\" + fileName;
  
  try{
   // �ٿ���� ������ �ҷ���
   File file = new File(filePath);
   byte b[] = new byte[4096];
   
   // page�� ContentType���� �������� �ٲٱ� ���� �ʱ�ȭ��Ŵ
   response.reset();
   response.setContentType("application/octet-stream");
   
   // �ѱ� ���ڵ�
   String Encoding = new String(fileName.getBytes("UTF-8"), "8859_1");
   // ���� ��ũ�� Ŭ������ �� �ٿ�ε� ���� ȭ���� ��µǰ� ó���ϴ� �κ�
   response.setHeader("Content-Disposition", "attachment; filename = " + Encoding);
  
   // ������ ���� ������ �о���� ���ؼ� ����
   FileInputStream in = new FileInputStream(filePath);
  
   // ���Ͽ��� �о�� ���� ������ �����ϴ� ���Ͽ� ���ֱ� ���ؼ� ����
   ServletOutputStream out2 = response.getOutputStream();
   
   int numRead;
   // ����Ʈ �迭 b�� 0�� ���� numRead�� ���� ���Ͽ� ���� (���)
   while((numRead = in.read(b, 0, b.length)) != -1){
    out2.write(b, 0, numRead);
   }
   
   out2.flush();
   out2.close();
   in.close();
   
  } catch(Exception e){
  }
 %>
 </body>
 </html>

��ó: http://kitchu.tistory.com/48 [Dream Archive]


<%@page import="java.io.File"%>
 <%@page import="java.util.Enumeration"%>
 <%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
 <%@page import="com.oreilly.servlet.MultipartRequest"%>
 <%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
 <title>Insert title here</title>
 </head>
 <body>
 <center>
 <h2> ���� �ٿ�ε� </h2>
 <form action = "FileDownloadProc.jsp" method = "post">
 
 <table border = "0" cellpadding="8" cellspacing="5">

 <tr align = "center">
  <th> ���ϸ� : </th>
  <td> <input type = "text" name = "fileName"> </td>
 </tr>
 
 <tr align = "center">
  <td colspan = "2"> <input type = "submit" value = "�ٿ�ε�"> </td>
 </tr>
 </table>
 </form>

 </center>
 </body>
 </html>


��ó: http://kitchu.tistory.com/48 [Dream Archive]