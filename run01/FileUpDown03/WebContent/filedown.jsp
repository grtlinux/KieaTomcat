<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.BufferedInputStream" %>
<%@ page import="java.io.BufferedOutputStream" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.net.URLEncoder" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>file download</title>
<%
	request.setCharacterEncoding("utf-8");

	String fileName = request.getParameter("filename");
	String fileDir = request.getParameter("filedir");

	String root = application.getRealPath("/");
	fileDir = root + "files";

	fileName = new String(fileName.getBytes("8859_1"), "utf-8");

	String filePath = fileDir + "/" + fileName;

	if (request.getHeader("user-agent").indexOf("MSIE") != -1) {
		fileName = URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", " ");
	} else {
		fileName = new String(fileName.getBytes("utf-8"), "8859_1");
	}

	BufferedInputStream bis = null;
	BufferedOutputStream bos = null;

	try {
		File file = new File(filePath);

		out.clear();
		out = pageContext.pushBody();

		response.reset();
		response.setHeader("Content-Type", "application/octet-stream;");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");

		bis = new BufferedInputStream(new FileInputStream(file));
		bos = new BufferedOutputStream(response.getOutputStream());

		byte[] buffer = new byte[1024];
		int nread;
		while ((nread = bis.read(buffer, 0, buffer.length)) != -1) {
			bos.write(buffer, 0, nread);
		}

		bos.flush();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (bis != null) try { bis.close(); } catch (IOException e) {}
		if (bos != null) try { bos.close(); } catch (IOException e) {}
	}
%>

fileName: <%=fileName %><p>
fileDir: <%=fileDir %><p>
filePath: <%=filePath %><p>









