/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.PreparedStatement;
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
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            String n=request.getParameter("username");  
             String p=request.getParameter("userpass");  
             
             boolean status;  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/test","root","");  
      
PreparedStatement ps=con.prepareStatement(  "select * from register where name=? and password=?");  
ps.setString(1,n);  
ps.setString(2,p);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  

if(status)  {
ServletContext sc = this.getServletContext();
RequestDispatcher rd = sc.getRequestDispatcher("/welcome.jsp");
rd.forward(request, response);
}
          
}catch(Exception e)
    {System.out.println(e);}  
        }
    
    }

