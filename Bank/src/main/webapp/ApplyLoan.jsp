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
<link rel="stylesheet" href="./LoanFormStyles.css" />
<script type="text/javascript">
    var passwordcheck = '<%= lnMdl.getCustomerInfo()[1] %>';
</script>
<script src="./LoanFormValidation.js" defer></script>
<script src="./LoanFormAnimation.js" defer></script>
</head>
<body>
    <div id="container">
        <!-- Progress bar -->
        <div class="progressbar">
            <div class="progress" id="progress"></div>
            
            <div class="progress-step progress-step-active" data-title="Account"></div>
            <div class="progress-step" data-title="Supporting"></div>
            <div class="progress-step" data-title="Loan"></div>
        </div>
          <!-- Steps -->
        <div id="error"></div>
        <form id="applyLoan" action="./LoanController" method="post" class="form">
            <h1 class="text-center">Loan Application</h1>
            <div class="form-step form-step-active">
                <div class="input-group">
                    <fieldset>
                        <legend>Account Info</legend>
                        <label for="userid">Account Holder Id:</label>
                        <input type="number" id="userid" name="cust_Id" value=<%=lnMdl.cust_Id %> readonly required><br>
                        <label for="username">User Name:</label>
                        <input type="text" id="username" name="user_Name" value=<%=lnMdl.getCustomerInfo()[0] %> disabled><br>
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" value=<%=lnMdl.getCustomerInfo()[0] %> readonly><br>
                        For verification purposes,<br>
                        
                        <label for="password">Please Enter Your Password:</label>
                        <input type="password" id="password" autocomplete="off" required>
                    </fieldset>
                </div>

                <div class="">
                    <button class="btn btn-next width-50 ml-auto">Next</button>
                </div>
            </div>
            <div class="form-step">
                <div class="input-group">
                    <fieldset>
                        <legend>Supporting Info</legend>
                        <label for="salary">Monthly Income:</label>
                        <input type="number" id="salary" name="salary" title="In SGD S$"><br>
                        <label for="payslip">Please upload your latest payslip:</label><br>
                        <input type="file"  id="payslip" name="payslip">
                    </fieldset>
                </div>
                <div class="btns-group">
                    <button  class="btn btn-prev">Previous</button>
                    <button  class="btn btn-next">Next</button>
                </div>
            </div>
            <div class="form-step">
                <div class="input-group">
                    <fieldset>
                        <legend>Loan Info</legend>
                        <label for="loantype">Loan type:</label>
                        <select name="loan_type" id="loantype" required>
                            <option value="Pers1" checked>Personal Silver</option>
                            <option value="Pers2">Personal Gold</option>
                        </select>
                        <label for="loanamount" >Amount</label>
                        <input type="number" min="500" max="500" step=".01" id="loanamount" name="loan_amount" required>
                        <label for="loanterm">Loan Tenure:</label>
                        <select name="loan_term_mths" id="loanterm" required>
                            <option value="12" checked>12 Months</option>
                            <option value="24">24 Months</option>
                        </select><br>
                        <label for="interest">Annual Interest Rate</label>
                        <input type="number" name ="interest" readonly value="4.5">
                    </fieldset>
                    <div class="btns-group">
                        <button class="btn btn-prev">Previous</button>
                        <input type="submit" value="Apply" class="btn" />
                    </div>

                </div>
            </div>
            
        </form>
    </div>
</body>
</html>