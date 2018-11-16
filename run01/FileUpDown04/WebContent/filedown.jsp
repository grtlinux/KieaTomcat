<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.BufferedInputStream" %>
<%@ page import="java.io.BufferedOutputStream" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.net.URLEncoder" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>file download</title>
<%!
	// declaration
	boolean flag = true;
	// String FILES_PATH = "/hanwha/_FILE";
	// String FILES_PATH = "_FILE";
	String message = null;
	
	public void printLog(String msg) {
		System.out.println("KANG >>>>> " + msg);
	}
%>
<%@ include file="include.jsp" %>
<%
	if (!flag) {
		System.out.println("1 >>>>> " + request.getSession().getServletContext().getRealPath("/"));
		System.out.println("2 >>>>> " + this.getServletContext().getRealPath("/"));
		System.out.println("3 >>>>> " + application.getRealPath("/"));
	}
%>
<%
	request.setCharacterEncoding("utf-8");

	//String fileDir = request.getParameter("filedir");
	String fileName = request.getParameter("filename");
	fileName = new String(fileName.getBytes("8859_1"), "utf-8");

	String filePath = FILES_PATH + "/" + fileName;
	
	String userAgent = request.getHeader("user-agent");
	String contentDisposition = null;
	if (userAgent.indexOf("MSIE 5.5") != -1) {            // less than MS IE 5.5
		fileName = URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", " ");
		contentDisposition = "filename=\"" + fileName + "\";";
	} else if (userAgent.indexOf("MSIE") != -1) {         // more than MS IE 6.x
		fileName = URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", " ");
		contentDisposition = "attachment; filename=\"" + fileName + "\";";
	} else if (userAgent.indexOf("Trident") != -1) {      // MS IE 11
		fileName = URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", " ");
		contentDisposition = "attachment; filename=\"" + fileName + "\";";
	} else {                                              // mozilla, opera and so on
		fileName = new String(fileName.getBytes("utf-8"), "8859_1");
		contentDisposition = "attachment; filename=\"" + fileName + "\";";
	}

	BufferedInputStream bis = null;
	BufferedOutputStream bos = null;

	try {
		if (flag) {
			System.out.println("############## filedown.jsp [START] ##############");
			System.out.println(">>>>> filePath: " + filePath);
			System.out.println(">>>>> userAgent: " + userAgent);
		}

		File file = new File(filePath);

		out.clear();
		out = pageContext.pushBody();

		response.reset();
		response.setHeader("Content-Type", "application/octet-stream;");
		response.setHeader("Content-Disposition", contentDisposition);

		bis = new BufferedInputStream(new FileInputStream(file));
		bos = new BufferedOutputStream(response.getOutputStream());

		byte[] buffer = new byte[1024];
		int nread;
		while ((nread = bis.read(buffer, 0, buffer.length)) != -1) {
			bos.write(buffer, 0, nread);
		}

		bos.flush();
		
		if (flag) {
			System.out.println("############## filedown.jsp [END] ##############");
		}
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (bis != null) try { bis.close(); } catch (IOException e) {}
		if (bos != null) try { bos.close(); } catch (IOException e) {}
	}
%>









