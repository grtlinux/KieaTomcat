<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<%!
	String FILE_PATH = "/hanwha/GIT/git/KieaTomcat/run01/FileUpDown02/WebContent";
%>

<%
	/*
	 * file upload
	 */
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
                System.out.println(">>>>> Parameter: " + fileItem.getFieldName() + "=" + fileItem.getString("euc-kr"));
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
        System.out.println("STATUS: It's not the type 'multipart/form-data'.");
    }
%>


<%
	/*
	 * file list
	 */
	File path = new File("/hanwha/GIT/git/KieaTomcat/run01/FileUpDown02/WebContent/files");
	File[] arrFiles = path.listFiles();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h3>TITLE</h3>
<hr>
<p>

<form action="/index.jsp" method="POST" enctype="multipart/form-data">
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

<table border="1" width="250">
	<tr>
		<td>파일</td>
	</tr>
<% for (int i=0;i<arrFiles.length;i++){ //배열명.length는 배열의 요소의 수를 리턴한다 %>
	<tr>
		<td><a href="files/<%=arrFiles[i].getName() %>"><%=arrFiles[i].getName() %></a></td>
	</tr>
<% } %>
</table>

</body>
</html>



