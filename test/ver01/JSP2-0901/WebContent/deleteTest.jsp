<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.sql.*"%>

<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		String jdbcUrl = "jdbc:mysql://192.168.1.13:3306/tain";
		String dbId = "root";
		String dbPass = "toor";
		 
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
		
		String sql= "select id, passwd from member where id= ?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,id);
		rs=pstmt.executeQuery();
    
		if (rs.next()) { 
			String rId=rs.getString("id");
			String rPasswd=rs.getString("passwd");
			if (id.equals(rId) && passwd.equals(rPasswd)) {
				sql= "delete from member where id= ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,id);
				pstmt.executeUpdate();
			}
%>
<html>
<head><title>레코드 삭제예제</title></head>
<body>
  member1 테이블의 레코드를 삭제했습니다.
</body>
</html>
<%
		} else {
			out.println("아이디나 패스워드가 틀렸습니다.");
		}
	} catch (Exception e) { 
		e.printStackTrace();
	} finally {
		if (rs != null) try {rs.close();} catch (SQLException sqle){}
		if (pstmt != null) try {pstmt.close();} catch (SQLException sqle){}
		if (conn != null) try {conn.close();} catch (SQLException sqle){}
	}
%>