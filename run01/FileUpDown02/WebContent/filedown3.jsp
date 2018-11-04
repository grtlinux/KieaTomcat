<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	/*
	 * TODO-KANG-20181103: RESULT: ERROR
	 *   심각: Servlet.service() for servlet [jsp] in context with path [] threw exception [java.lang.IllegalStateException: getOutputStream() has already been called for this response] with root cause
	 *   java.lang.IllegalStateException: getOutputStream() has already been called for this response
	 */
	
	// 다운받을 파일의 이름을 가져옴
	String fileName = request.getParameter("filename");
	fileName = new String(fileName.getBytes("8859_1"), "utf-8");
	
	// 다운받을 파일이 저장되어 있는 폴더 이름
	String saveFolder = "files";

	// Context에 대한 정보를 알아옴
	ServletContext context = getServletContext(); // 서블릿에 대한 환경정보를 가져옴
	// 실제 파일이 저장되어 있는 폴더의 경로
	String realFolder = context.getRealPath(saveFolder);
	// 다운받을 파일의 전체 경로를 filePath에 저장
	String filePath = realFolder + "/" + fileName;

	FileInputStream in = null;
	ServletOutputStream out2 = null;
	
	try{
		// 다운받을 파일을 불러옴
		File file = new File(filePath);

		// page의 ContentType등을 동적으로 바꾸기 위해 초기화시킴
		response.reset();
		response.setContentType("application/octet-stream");

		// 한글 인코딩
		String Encoding = new String(fileName.getBytes("UTF-8"), "8859_1");
		// 파일 링크를 클릭했을 때 다운로드 저장 화면이 출력되게 처리하는 부분
		response.setHeader("Content-Disposition", "attachment; filename=" + Encoding);

		// 파일의 세부 정보를 읽어오기 위해서 선언
		in = new FileInputStream(filePath);
		// 파일에서 읽어온 세부 정보를 저장하는 파일에 써주기 위해서 선언
		out2 = response.getOutputStream();

		byte b[] = new byte[4096];
		int numRead;
		// 바이트 배열 b의 0번 부터 numRead번 까지 파일에 써줌 (출력)
		while ((numRead = in.read(b, 0, b.length)) != -1) {
			out2.write(b, 0, numRead);
		}
		out2.flush();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (out2 != null) try { out2.close(); } catch (Exception e) {}
		if (in != null) try { in.close(); } catch (Exception e) {}
	}
%>
</body>
</html>

<!--
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h2> 파일 다운로드 </h2>
	<form action="FileDownloadProc.jsp" method="post">

	<table border="0" cellpadding="8" cellspacing="5">
		<tr align="center">
			<th> 파일명 : </th>
			<td> <input type="text" name="fileName"> </td>
		</tr>
		<tr align="center">
			<td colspan="2"> <input type="submit" value="다운로드"> </td>
		</tr>
	</table>
	</form>
	</center>
</body>
</html>
출처: http://kitchu.tistory.com/48 [Dream Archive]
-->
