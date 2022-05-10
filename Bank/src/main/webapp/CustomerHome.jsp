<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page errorPage="error.jsp" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
   <body>

       
     <%
         try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/banking","root","wassup85");
            Integer cust_Id = new Integer(4);
            session.setAttribute("con", con);
            session.setAttribute("cust_Id", cust_Id);
         }
         catch (Exception e) {
            e.printStackTrace();
         }
      %>
      <p><a href="./LoanController">Loans Page</a></p>
    
   </body> 

</body>
</html>