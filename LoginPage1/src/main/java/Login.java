
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter printw = response.getWriter();

		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from Logger where email=? and pword=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String fname = rs.getString(1);
				String emaildb = rs.getString(3);
				String passworddb = rs.getString(5);
				System.out.println("b4");
				if (email.equals(emaildb) && pass.equals(passworddb)) {
					HttpSession session = request.getSession();
					session.setAttribute("name", fname);
					String sessionId = request.getSession().getId();

					System.out.println("login:" + sessionId);

//					RequestDispatcher rd = request.getRequestDispatcher("Welcome");
//					rd.include(request, response);
					response.sendRedirect("Welcome");
				}
				System.out.println("after");
			} else {
				printw.println("Sorry email or password is wrong.");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		printw.close();
	}

}
