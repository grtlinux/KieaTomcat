<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%!
	// declaration
	boolean flag = true;
	public void printLog(String msg) {
		System.out.println("KANG >>>>> " + msg);
	}
%>
<%
	/*
	 * file upload
	 */
	String FILE_PATH = request.getSession().getServletContext().getRealPath("/");

	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if (isMultipart) {
		System.out.println("############## upload.jsp [START] ##############");

		File tempDir = new File(FILE_PATH + "/files/");
		File realDir = new File(FILE_PATH + "/files/");

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(100 * 1024 * 1024);   // 100 MB
		factory.setRepository(tempDir);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(15 * 1024 * 1024 * 1024);   // 15 GB
		List<FileItem> items = upload.parseRequest(request);
		System.out.println(">>>>> upload.jsp [REQUEST OK]");
		Iterator<FileItem> iter = items.iterator();
		while (iter.hasNext()) {
			FileItem fileItem = iter.next();
			if (fileItem.isFormField()) {
				// Parameter
				System.out.println(">>>>> Parameter: " + fileItem.getFieldName() + "=" + fileItem.getString("utf-8"));
			} else {
				if (fileItem.getSize() > 0) {
					String fieldName = fileItem.getFieldName();
					String fileName = fileItem.getName();
					String contentType = fileItem.getContentType();
					boolean isInMemory = fileItem.isInMemory();
					long sizeInBytes = fileItem.getSize();
					// check fileName
					int idx;
					if ((idx = fileName.lastIndexOf('\\')) < 0)
						idx = fileName.lastIndexOf('/');
					if (idx >= 0)
						fileName = fileName.substring(idx + 1);
					System.out.println(">>>>> FILE [fieldName] : " + fieldName);
					System.out.println(">>>>> FILE [fileName] : " + fileName);
					System.out.println(">>>>> FILE [contentType] : " + contentType);
					System.out.println(">>>>> FILE [isInMemory] : " + isInMemory);
					System.out.println(">>>>> FILE [sizeInBytes] : " + sizeInBytes);
					try {
						File uploadedFile = new File(realDir, fileName);
						fileItem.write(uploadedFile);
						fileItem.delete();
					} catch(IOException ex) {}
				}
			}
		}
		System.out.println("############## upload.jsp [END] ##############");
	} else {
		printLog("STATUS: It's not the type 'multipart/form-data'.");
	}
%>


<%
	/*
	 * file list
	 */
	File path = new File(FILE_PATH + "/files");
	File[] arrFiles = path.listFiles();

	if (!flag) {
		// sort by filename
		Arrays.sort(arrFiles, new Comparator<File>() {
			@Override
			public int compare(File file1, File file2) {
				//return file1.getName().compareTo(file2.getName());
				return file2.getName().compareTo(file1.getName());
			}
		});
	}

	if (flag) {
		// sort by lasttime
		Arrays.sort(arrFiles, new Comparator<File>() {
			@Override
			public int compare(File file1, File file2) {
				int ret = -1;  // 1:ASC  -1:DESC
				if (file1.lastModified() > file2.lastModified())
					return ret;
				return -ret;
			}
		});
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
</head>
<body>

<h2>[ File Upload and Download ]</h2>
<hr>
<p>

<h4>(File Upload)</h4>
<form action="index.jsp" method="POST" enctype="multipart/form-data">
	File0: <input type="file" name="file0"/><br>
	<!--
	File1: <input type="file" name="file1"/><br>
	File2: <input type="file" name="file2"/><br>
	File3: <input type="file" name="file3"/><br>
	File4: <input type="file" name="file4"/><br>
	File5: <input type="file" name="file5"/><br>
	File6: <input type="file" name="file6"/><br>
	File7: <input type="file" name="file7"/><br>
	File8: <input type="file" name="file8"/><br>
	File9: <input type="file" name="file9"/><br>
	-->
	Parameter1: <input type="text" name="param1"/><br>
	Parameter2: <input type="text" name="param2"/><br>
	Parameter3: <input type="text" name="param3"/><br>
	<input type="submit" value="Send" />
</form>
<hr>
<p>

<h4>(File Download: filedown2.jsp)</h4>
<%
	for (int i=0; i < arrFiles.length; i++){
		String filename = URLEncoder.encode(arrFiles[i].getName(), "utf-8");
		String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(arrFiles[i].lastModified()));
%>
<%=String.valueOf(i) %>) [<%=strDate %>] <a href="filedown2.jsp?filename=<%=filename %>"><%=arrFiles[i].getName() %></a><br/>
<%
	}
%>
<p>



<hr>
</body>
</html>



