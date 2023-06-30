
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobNumber");
		String password = request.getParameter("password");
		PrintWriter printw = response.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "root");
			PreparedStatement ps = con
					.prepareStatement("insert into Logger(f_name,l_name,email,mobile,pword) values(?,?,?,?,?)");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setString(4, mobile);
			ps.setString(5, password);

			int m = ps.executeUpdate();
			if (m != 0) {
				System.out.println("Logger inserted successfully.");
				printw.println("Logger inserted successfully.");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		printw.close();
	}

}
