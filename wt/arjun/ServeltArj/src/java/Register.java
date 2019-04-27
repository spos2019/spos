/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class Register extends HttpServlet {

    
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();            /* TODO output your page here. You may use following sample code. */
            String name=request.getParameter("name");
            String add=request.getParameter("address");
            String ph=request.getParameter("phone");
            String pass=request.getParameter("pass");
            try{
                
                Class.forName("com.mysql.jdbc.Driver");
               Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
               PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into register values(?,?,?,?)");  
ps.setString(1,name);  
ps.setString(2,add);  
ps.setString(3,ph);  
ps.setString(4,pass);  
          
int i=ps.executeUpdate();  
if(i>0)  {
ServletContext sc = this.getServletContext();
RequestDispatcher rd = sc.getRequestDispatcher("/welcome.jsp");
rd.forward(request, response);
}

            } catch (IOException | ClassNotFoundException | SQLException | ServletException ex) {
            System.out.println(ex);
        }
    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
