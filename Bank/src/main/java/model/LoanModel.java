package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoanModel {
	public int cust_Id, status, repaymentStatus;
	String customerInfo[] = new String[2] ;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	String loanTable[][], repaymentTable[][];
	Connection con;
	
	
	public void setLoanTable(ResultSet res) throws SQLException {
		res.last();
		int rowCount = res.getRow();
		System.out.println("row count" + rowCount);
		res.first();
		
		loanTable = new String[rowCount][6];
		for( int i = 0; i < rowCount; i++) {
		
			loanTable[i][0] = dateFormat.format(res.getTimestamp(1));
			System.out.println("printing "+loanTable[i][0]); 
			loanTable[i][1] = Integer.toString(res.getInt(2));
			System.out.println("printing "+loanTable[i][1]);
			loanTable[i][2] = res.getString(3);
			System.out.println("printing "+loanTable[i][2]);
			loanTable[i][3]	= Integer.toString(res.getInt(4));
			System.out.println("printing "+loanTable[i][3]);
			loanTable[i][4]	= Float.toString(res.getFloat(5));
			System.out.println("printing "+loanTable[i][4]);
			loanTable[i][5]	= Float.toString(res.getFloat(6));
			System.out.println("printing "+i+" "+loanTable[i][5]);
			System.out.println();
			System.out.println();
			if(i<rowCount-1)res.next();
		}
	}
	public void setRepaymentTable(ResultSet res) throws SQLException {
		res.last();
		int rowCount = res.getRow();
		res.first();
		repaymentTable = new String[rowCount][5];
		for( int i = 0; i < rowCount; i++) {
			
			repaymentTable[i][0] = dateFormat.format(res.getTimestamp(1));
			repaymentTable[i][1] = Integer.toString(res.getInt(2));
			repaymentTable[i][2] = Float.toString(res.getFloat(3));
			repaymentTable[i][3] = Integer.toString(res.getInt(4));
			repaymentTable[i][4] = Float.toString(res.getFloat(5));
			if(i<rowCount-1)res.next();
		}
	}
	
	public String[][] getLoanTable(){
		return loanTable;
	}
	public String[][] getRepaymentTable(){
		return repaymentTable;
	}
	
	ResultSet retrieveLoanRecords() {
		PreparedStatement pstmt = null ;
		ResultSet res = null;
		try {
			this.con = con;
			pstmt = con.prepareStatement("Select loan_TimeStamp, loans.loan_Id, loan_type, loan_term_mths, loan_amount,"
//														+ " If(ISNULL(outstanding)=1, loan_amount, outstanding)"
														+ " loan_outstanding"
														+ " From banking.loans"
														+ " where loans.cust_Id = ?"
														+ " order by loans.loan_Id desc;");
			pstmt.setInt(1, cust_Id);
			res = pstmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
		
	}
	
	ResultSet retrievePaymentRecords() {
		PreparedStatement pstmt = null ;
		ResultSet res = null;
		
		try {
			this.con = con;
			pstmt = con.prepareStatement("Select repayment_TimeStamp, repayment_Id, repayment_amount, loanrepayments.loan_Id, outstanding"
														+ " from banking.loanrepayments Left Join banking.loans "
														+ " on loans.loan_Id = loanrepayments.loan_Id"
														+ " where loans.cust_Id = ?"
														+ " order by loans.loan_Id desc;");
			pstmt.setInt(1, cust_Id);
			res = pstmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
		
	}
	void setCustomerInfo(int cust_Id, Connection con) {
		this.cust_Id = cust_Id;
		this.con = con;
		PreparedStatement pstmt = null ;
		ResultSet res = null;
		
		try {
			pstmt = con.prepareStatement("Select user_Name, password from customer where cust_Id = ?");
			pstmt.setInt(1, cust_Id);
			System.out.println("before customer execution");
			res = pstmt.executeQuery();
			System.out.println("after customer execution");
			res.next();
			customerInfo[0] = res.getString(1);
			customerInfo[1]= res.getString(2);
			System.out.println("This is customerinfo: "+(customerInfo[0]));
			System.out.println((customerInfo[1]));
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	
	public String[] getCustomerInfo() {
		return customerInfo;
	}
	
	
	public LoanModel(int cust_Id, Connection con) throws SQLException {
		
			setCustomerInfo(cust_Id, con);
		
			ResultSet resP, resL = retrieveLoanRecords();
			
			if(!resL.next()) {
				this.status = 0;
				System.out.println("table is empty");
			}
			else {
				this.status = 1;
				setLoanTable(resL);
				
				resP = retrievePaymentRecords();
				System.out.println("payment Records shold be null"+ resP.next());
				if(!resP.next()) {
					this.repaymentStatus = 0;
					System.out.println("repayment table is empty");
				}
				else {
					this.repaymentStatus = 1;
					setRepaymentTable(resP);
				}
			}
	}
	
	public int applyLoan(int cust_Id, String loan_type , double loan_amount , int loan_term_mths) {
		status = 0;
		System.out.println("applying loan");
		double monthlyInterestRate= 0.01;
		PreparedStatement pstmt = null;
		try {
			con.setAutoCommit(false);
			 pstmt = con.prepareStatement("Insert into banking.loans (cust_Id, loan_amount, loan_type, loan_term_mths, loan_outstanding)"
																+ "Values (?,?,?,?,?);");
			
			pstmt.setInt(1, cust_Id);
			pstmt.setDouble(2, loan_amount);
			pstmt.setString(3, loan_type);
			pstmt.setInt(4, loan_term_mths);
			pstmt.setDouble(5, loan_amount);
			System.out.println("loan initialized");
			status = pstmt.executeUpdate();
			System.out.println("loan inserted status="+status);
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			status = -1;
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				status = -2;
				e1.printStackTrace();
			}
		}
		
		try {
			con.setAutoCommit(false);
			ResultSet res = retrieveLoanRecords();
			res.first();
			System.out.println("start event");
			pstmt = con.prepareStatement("SET GLOBAL event_scheduler = ON;");
			pstmt.execute();
			System.out.println(res.getMetaData().getColumnName(1)+"type"+res.getMetaData().getColumnType(1));
			String eventName = "accrue_interest_on_cust_Id"+ cust_Id + "_loan_Id"+res.getInt(2);
			System.out.println(eventName);
			pstmt = con.prepareStatement("CREATE EVENT "+eventName+" ON SCHEDULE EVERY 1 MONTH STARTS (CURRENT_DATE) ON COMPLETION PRESERVE DO UPDATE banking.loans SET loans.loan_outstanding = (loans.loan_outstanding*(1+?))	WHERE loans.loan_ID = ? AND loans.loan_outstanding > 0");
			
//			pstmt.setString(1, eventName);
			pstmt.setDouble(1, monthlyInterestRate);
			pstmt.setInt(2, res.getInt(2));
			System.out.println("start event 2");
			System.out.println("result of event"+pstmt.execute());
			
			setLoanTable(retrieveLoanRecords());
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			status = -3;
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				status = -4;
				e1.printStackTrace();
			}
		}
		return status;
		
	}

}
