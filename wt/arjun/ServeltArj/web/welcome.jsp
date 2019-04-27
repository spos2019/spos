<%-- 
    Document   : welcome
    Created on : 22 Apr, 2019, 2:43:22 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

<%
            String f=request.getParameter("name");
            String l=request.getParameter("phone");
            out.println("<h1>Welcome "+f+" "+l+"!");
            out.println("<br/>Registration Complete!");
            %>    </body>
</html>
