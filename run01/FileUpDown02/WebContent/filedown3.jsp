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
  // 다운받을 파일의 이름을 가져옴
  String fileName = request.getParameter("fileName");
  // 다운받을 파일이 저장되어 있는 폴더 이름
  String saveFolder = "File";
  
  // Context에 대한 정보를 알아옴
  ServletContext context = getServletContext(); // 서블릿에 대한 환경정보를 가져옴
  
  // 실제 파일이 저장되어 있는 폴더의 경로
  String realFolder = context.getRealPath(saveFolder);
  // 다운받을 파일의 전체 경로를 filePath에 저장
  String filePath = realFolder + "\\" + fileName;
  
  try{
   // 다운받을 파일을 불러옴
   File file = new File(filePath);
   byte b[] = new byte[4096];
   
   // page의 ContentType등을 동적으로 바꾸기 위해 초기화시킴
   response.reset();
   response.setContentType("application/octet-stream");
   
   // 한글 인코딩
   String Encoding = new String(fileName.getBytes("UTF-8"), "8859_1");
   // 파일 링크를 클릭했을 때 다운로드 저장 화면이 출력되게 처리하는 부분
   response.setHeader("Content-Disposition", "attachment; filename = " + Encoding);
  
   // 파일의 세부 정보를 읽어오기 위해서 선언
   FileInputStream in = new FileInputStream(filePath);
  
   // 파일에서 읽어온 세부 정보를 저장하는 파일에 써주기 위해서 선언
   ServletOutputStream out2 = response.getOutputStream();
   
   int numRead;
   // 바이트 배열 b의 0번 부터 numRead번 까지 파일에 써줌 (출력)
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

출처: http://kitchu.tistory.com/48 [Dream Archive]


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
 <h2> 파일 다운로드 </h2>
 <form action = "FileDownloadProc.jsp" method = "post">
 
 <table border = "0" cellpadding="8" cellspacing="5">

 <tr align = "center">
  <th> 파일명 : </th>
  <td> <input type = "text" name = "fileName"> </td>
 </tr>
 
 <tr align = "center">
  <td colspan = "2"> <input type = "submit" value = "다운로드"> </td>
 </tr>
 </table>
 </form>

 </center>
 </body>
 </html>


출처: http://kitchu.tistory.com/48 [Dream Archive]