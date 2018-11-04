<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="java.io.*"%>
<%@ page import="java.text.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.net.*" %>
<%
	// [java] Tomcat에서 요청 인코딩을 설정하는 방법은 무엇입니까?
	// http://code.i-harness.com/ko-kr/q/68ee19
	
	
	
	
	
	String fileName = request.getParameter("filename");
	fileName = new String(fileName.getBytes("iso-8859-1"),"utf-8");
	
	request.setCharacterEncoding("utf-8");
 	
    // 파일 업로드된 경로
    String root = request.getSession().getServletContext().getRealPath("/");
    //String savePath = root + "upload";
    String savePath = root + "files";
 
    // 서버에 실제 저장된 파일명
    //String filename = "20140819151221.zip" ;
    //String filename = "[HD 720p] 레드 테일스.smi" ;
    String filename = fileName;
     
    // 실제 내보낼 파일명
    //String orgfilename = "테스트.zip" ;
    String orgfilename = fileName;
      
    InputStream in = null;
    OutputStream os = null;
    File file = null;
    boolean skip = false;
    String client = "";
 
    try{
        // 파일을 읽어 스트림에 담기
        try{
            file = new File(savePath, filename);
            in = new FileInputStream(file);
        }catch(FileNotFoundException fe){
            skip = true;
        }
         
        client = request.getHeader("User-Agent");
 
        // 파일 다운로드 헤더 지정
        response.reset() ;
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Description", "JSP Generated Data");
 
 
        if(!skip){
 
             
            // IE
            if(client.indexOf("MSIE") != -1){
                response.setHeader ("Content-Disposition", "attachment; filename="+new String(orgfilename.getBytes("KSC5601"),"ISO8859_1"));
 
            }else{
                // 한글 파일명 처리
                orgfilename = new String(orgfilename.getBytes("utf-8"),"iso-8859-1");
 
                response.setHeader("Content-Disposition", "attachment; filename=\"" + orgfilename + "\"");
                response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
            } 
             
            response.setHeader ("Content-Length", ""+file.length() );
 
            out.clear();
       
            os = response.getOutputStream();
            byte b[] = new byte[(int)file.length()];
            int leng = 0;
             
            while( (leng = in.read(b)) > 0 ){
                os.write(b,0,leng);
            }
 
        }else{
            response.setContentType("text/html;charset=UTF-8");
            out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
 
        }
         
        in.close();
        os.close();
 
    }catch(Exception e){
      e.printStackTrace();
    }
%>
