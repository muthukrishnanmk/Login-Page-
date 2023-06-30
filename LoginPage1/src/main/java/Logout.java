
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter printw = response.getWriter();

		response.setContentType("text/html");

//	        System.out.println("Session before invalidate: "+ request.getSession(false));

//	        request.getSession(false).invalidate();
		HttpSession session = request.getSession();
		if (session != null) {

			request.getSession(false).invalidate();

			System.out.println("hh");

		} else {
			System.out.println("session is null");
		}
//	        System.out.println("Session after invalidate: "+ request.getSession(false));

		printw.println("Thank you! You are successfully logged out.");
		printw.close();
	}

}
