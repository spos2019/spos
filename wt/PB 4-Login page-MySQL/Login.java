import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");  

		PreparedStatement ps = c.prepareStatement("select Username,Pass from Passtable where Username=? and Pass=?");
		ps.setString(1, un);
		ps.setString(2, pw);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			response.sendRedirect("success.html");
			return;
		}
		
		response.sendRedirect("error.html");
		return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
