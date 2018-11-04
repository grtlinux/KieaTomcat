<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.File" %>
<%@ page import="java.io.*"%>
<%@ page import="java.net.URLEncoder"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>파일다운로드</title>
<%
	/*
	 * TODO-KANG-20181103: SUCCESS
	 */

	// URL: http://lee-mandu.tistory.com/399
	String fileName = request.getParameter("filename");
	String fileDir = request.getParameter("fileDir");

	// 파일 업로드된 경로
	//String root = request.getSession().getServletContext().getRealPath("/");
	String root = getServletContext().getRealPath("/");
	//String savePath = root + "upload";
	fileDir = root + "files";
	
	//파일명 인코딩
	String UTF8FileName = new String(fileName.getBytes("8859_1"), "UTF-8");

	//실제 파일
	//String filePath = KissConstants.getServerUrl()+ "/src/main/webapp" + fileDir + "/" + fileName;
	//String filePath = fileDir + "/" + fileName;
	String filePath = fileDir + "/" + UTF8FileName;

	boolean MSIE = request.getHeader("user-agent").indexOf("MSIE") != -1;
	if (MSIE) {
		// 브라우저가 IE일 경우 저장될 파일 이름
		// 공백이 '+'로 인코딩된것을 다시 공백으로 바꿔준다.
		fileName = URLEncoder.encode(UTF8FileName, "UTF8").replaceAll("\\+", " ");
	} else {
		// 브라우저가 IE가 아닐 경우 저장될 파일 이름
		fileName = new String(UTF8FileName.getBytes("UTF-8"), "8859_1");
	}

	BufferedInputStream bis = null;
	BufferedOutputStream bos = null;
	
	try {
		File file = new File(filePath);

		out.clear();
		out = pageContext.pushBody();

		response.reset();
		//response.setContentType("application/octet-stream");
		response.setHeader("Content-Type", "application/octet-stream;");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");

		bis = new BufferedInputStream(new FileInputStream(filePath));
		bos = new BufferedOutputStream(response.getOutputStream());

		byte b[] = new byte[1024];
		int numRead;
		while ((numRead = bis.read(b, 0, b.length)) != -1) {
			bos.write(b,0,numRead);
		}
		bos.flush();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (bis != null) try { bis.close(); } catch (Exception e) {}
		if (bos != null) try { bos.close(); } catch (Exception e) {}
	}
%>
