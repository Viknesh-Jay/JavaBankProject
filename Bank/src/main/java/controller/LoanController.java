package controller;

import model.LoanModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoanController
 */
public class LoanController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String URI = request.getHeader("referer");
		System.out.println(URI);
		System.out.println(URI.equals("http://localhost:8089/Bank/CustomerHome.jsp"));
		
		if (URI.equals("http://localhost:8089/Bank/CustomerHome.jsp")){
			System.out.println("enterd if statement");
			try {
				HttpSession session = request.getSession(true);
				System.out.println("session gotten");
				
				Connection con = (Connection) session.getAttribute("con");
				System.out.println("Connection established");
				Integer customerId = (Integer) session.getAttribute("cust_Id");
				int cust_Id = (customerId!=null)?customerId.intValue():0;
				System.out.println("customerid:"+cust_Id);
				
				LoanModel lnMdl = new LoanModel(cust_Id, con);
				session.setAttribute("lnMdl", lnMdl);
//				request.setAttribute("lnMdl", lnMdl);
//				request.setAttribute("loanStatus", new Integer(lnMdl.status));
//				request.setAttribute("repaymentStatus", new Integer(lnMdl.repaymentStatus));
//				
//				if(lnMdl.status != 0) {
//					request.setAttribute("loanTable", lnMdl.getLoanTable());
//					System.out.println("loantablelength"+lnMdl.getLoanTable().length);
//				}
//				if(lnMdl.repaymentStatus != 0)request.setAttribute("repaymentTable", lnMdl.getRepaymentTable());
//				
				
				request.getRequestDispatcher("./CustomerLoan.jsp").forward(request,response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (URI.equals("http://localhost:8089/Bank/ApplyLoan.jsp")) {
			int cust_Id = Integer.parseInt(request.getParameter("cust_Id"));
			String loan_type = request.getParameter("loan_type");
			double loan_amount = Double.parseDouble(request.getParameter("loan_amount"));
			int loan_term_mths = Integer.parseInt(request.getParameter("loan_term_mths")); 
			System.out.println("custid,loantype,loananoumt,loan terms"+cust_Id+loan_type+loan_amount+loan_term_mths);
			LoanModel lnMdl = (LoanModel) request.getSession(true).getAttribute("lnMdl");
			System.out.println("model status"+lnMdl.status);
		    lnMdl.applyLoan(cust_Id, loan_type, loan_amount, loan_term_mths);
			request.getRequestDispatcher("./CustomerLoan.jsp").forward(request,response);
			
		}
	}

}
