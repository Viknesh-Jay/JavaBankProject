<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page errorPage="error.jsp" %>
<%@ page import="java.sql.*" %>
<%@ page import="model.LoanModel" %>
<!DOCTYPE html>
<% 	
	LoanModel lnMdl = (LoanModel) session.getAttribute("lnMdl");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<body>
	
		
      <p>Status </p>
      <p>Repayment Status:<%= lnMdl.status %> </p>
      <h1>Coin Flipper <%=lnMdl.repaymentStatus %></h1>
      <p>Flipping a coin...</p>
         <h1>Coin Flipper</h1>
    	<% if(lnMdl.status == 0 ){ %>
      		<p>You have no loans!</p>
    	<% } else{ %>
    		<% String[][] loanTable = lnMdl.getLoanTable(); %>
    		<% for( int i = 0; i < loanTable.length; i++){ %>
      					<p>Tails!<%=loanTable[i][0]%></p>
      					<p>Tails!<%=loanTable[i][1] %></p>
      					<p>Tails!<%=loanTable[i][2] %></p>
      					<p>Tails!<%=loanTable[i][3] %></p>
      					<p>Tails!<%=loanTable[i][4] %></p>
      					<p>Tails!<%=loanTable[i][5] %></p>
      					<p>Tails <%=i %></p>
    	<% }} %>
    	<hr>
			<a href="./ApplyLoan.jsp">Apply Loan</a>
			
 
 
    <hr>
   </body>
</body>
</html>