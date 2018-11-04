<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>

<%!
	/**
	* String UnEscape 처리
	* 
	* @param src
	* @return
	*/
	public String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(src
							.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(src
							.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}
		
	/**
	* String Escape 처리
	* @param src
	* @return
	*/
	public String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j)
					|| Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256) {
				tmp.append("%");
				if (j < 16)
					tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}

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
        System.out.println("STATUS: It's not the type 'multipart/form-data'.");
    }
%>


<%
	/*
	 * file list
	 */
	File path = new File("/hanwha/GIT/git/KieaTomcat/run01/FileUpDown02/WebContent/files");
	File[] arrFiles = path.listFiles();
	String[] files = new String[arrFiles.length];
	for (int i=0; i < arrFiles.length; i++) {
		files[i] = StringEscapeUtils.escapeHtml(arrFiles[i].getName());
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

<h4>(File Download)</h4>
<% for (int i=0; i < files.length; i++){ %>
<%=String.valueOf(i) %>) <a href="files/<%=files[i] %>"><%=arrFiles[i].getName() %></a><br/>
<% } %>
<p>
<h4>(File Download)</h4>
<% for (int i=0; i < files.length; i++){ %>
<%=String.valueOf(i) %>) <a href="files/<%=arrFiles[i].getName() %>"><%=arrFiles[i].getName() %></a><br/>
<% } %>
<p>
<a href="http://localhost/files/%EC%95%88%EB%85%95%ED%95%98%EC%84%B8%EC%9A%94.zip">안녕하세요.zip</a><br/>
<a href="files/강석.smi">강석.smi</a><br/>
<p>
<a href="filedown.jsp">filedown.jsp</a><br/>
<a href="filedown.jsp?filename=%EC%95%88%EB%85%95%ED%95%98%EC%84%B8%EC%9A%94.smi">안녕하세요.smi</a><br/>
<a href="filedown.jsp?filename=안녕하세요.smi">안녕하세요.smi</a><br/>


</body>
</html>



