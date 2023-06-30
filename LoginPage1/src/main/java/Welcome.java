
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public ServletConfig getServletConfig() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getServletInfo() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.setContentType("text/html");
//		PrintWriter printw = response.getWriter();
//
//		HttpSession session=((HttpServletRequest) request).getSession();
//		String name=(String)session.getAttribute("name");
//		
//		
////		String htmlResponse = "<h2>Hello " + name + "</h2>";
//		
//		printw.println("<form action=\"Logout\" method=\"post\">"
//				+"<h2>Hello " +name+ "</h2>"
//				+"<br> <input type=\"submit\" value=\"Logout\" />"
//				+"</form>");
//	}
//       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printw = response.getWriter();

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");

		printw.println("<form action=\"Logout\" method=\"post\">" + "<h2>Hello " + name + "</h2>"
				+ "<br> <input type=\"submit\" value=\"Logout\" />" + "</form>");

	}
}
