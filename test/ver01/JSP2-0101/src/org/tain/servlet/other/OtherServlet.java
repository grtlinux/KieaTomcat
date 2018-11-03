package org.tain.servlet.other;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OtherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final boolean flag = true;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");

		String email = getServletContext().getInitParameter("email");
		String debug = getServletConfig().getInitParameter("debug");
		String listings = getServletConfig().getInitParameter("listings");
		String dummy = getServletConfig().getInitParameter("dummy");
		if (flag) System.out.printf(">>>>> [%s] [%s] [%s] [%s]%n", email, debug, listings, dummy);
		
		try {
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Other Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>OtherServlet</h2>");
			out.println("안녕하세요. Servlet 입니다.<br>");
			out.printf("[%s] [%s] [%s] [%s]<br>%n", email, debug, listings, dummy);
			out.println("</body>");
			out.println("</html>");
			
			out.flush();
			out.close();
		} catch (Exception e) {
			getServletContext().log("Error in HelloServlet:", e);
		}
	}
}
