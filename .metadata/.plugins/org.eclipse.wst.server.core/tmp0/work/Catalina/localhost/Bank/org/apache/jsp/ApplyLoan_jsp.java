/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.39
 * Generated at: 2022-05-10 01:17:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import model.LoanModel;

public final class ApplyLoan_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
 	
	LoanModel lnMdl = (LoanModel) session.getAttribute("lnMdl");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./LoanFormStyles.css\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var passwordcheck = '");
      out.print( lnMdl.getCustomerInfo()[1] );
      out.write("';\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"./LoanFormValidation.js\" defer></script>\r\n");
      out.write("<script src=\"./LoanFormAnimation.js\" defer></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id=\"container\">\r\n");
      out.write("        <!-- Progress bar -->\r\n");
      out.write("        <div class=\"progressbar\">\r\n");
      out.write("            <div class=\"progress\" id=\"progress\"></div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"progress-step progress-step-active\" data-title=\"Account\"></div>\r\n");
      out.write("            <div class=\"progress-step\" data-title=\"Supporting\"></div>\r\n");
      out.write("            <div class=\"progress-step\" data-title=\"Loan\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("          <!-- Steps -->\r\n");
      out.write("        <div id=\"error\"></div>\r\n");
      out.write("        <form id=\"applyLoan\" action=\"./LoanController\" method=\"post\" class=\"form\">\r\n");
      out.write("            <h1 class=\"text-center\">Loan Application</h1>\r\n");
      out.write("            <div class=\"form-step form-step-active\">\r\n");
      out.write("                <div class=\"input-group\">\r\n");
      out.write("                    <fieldset>\r\n");
      out.write("                        <legend>Account Info</legend>\r\n");
      out.write("                        <label for=\"userid\">Account Holder Id:</label>\r\n");
      out.write("                        <input type=\"number\" id=\"userid\" name=\"cust_Id\" value=");
      out.print(lnMdl.cust_Id );
      out.write(" readonly required><br>\r\n");
      out.write("                        <label for=\"username\">User Name:</label>\r\n");
      out.write("                        <input type=\"text\" id=\"username\" name=\"user_Name\" value=");
      out.print(lnMdl.getCustomerInfo()[0] );
      out.write(" disabled><br>\r\n");
      out.write("                        <label for=\"name\">Name:</label>\r\n");
      out.write("                        <input type=\"text\" id=\"name\" name=\"name\" value=");
      out.print(lnMdl.getCustomerInfo()[0] );
      out.write(" readonly><br>\r\n");
      out.write("                        For verification purposes,<br>\r\n");
      out.write("                        \r\n");
      out.write("                        <label for=\"password\">Please Enter Your Password:</label>\r\n");
      out.write("                        <input type=\"password\" id=\"password\" autocomplete=\"off\" required>\r\n");
      out.write("                    </fieldset>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"\">\r\n");
      out.write("                    <button class=\"btn btn-next width-50 ml-auto\">Next</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-step\">\r\n");
      out.write("                <div class=\"input-group\">\r\n");
      out.write("                    <fieldset>\r\n");
      out.write("                        <legend>Supporting Info</legend>\r\n");
      out.write("                        <label for=\"salary\">Monthly Income:</label>\r\n");
      out.write("                        <input type=\"number\" id=\"salary\" name=\"salary\" title=\"In SGD S$\"><br>\r\n");
      out.write("                        <label for=\"payslip\">Please upload your latest payslip:</label><br>\r\n");
      out.write("                        <input type=\"file\"  id=\"payslip\" name=\"payslip\">\r\n");
      out.write("                    </fieldset>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"btns-group\">\r\n");
      out.write("                    <button  class=\"btn btn-prev\">Previous</button>\r\n");
      out.write("                    <button  class=\"btn btn-next\">Next</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-step\">\r\n");
      out.write("                <div class=\"input-group\">\r\n");
      out.write("                    <fieldset>\r\n");
      out.write("                        <legend>Loan Info</legend>\r\n");
      out.write("                        <label for=\"loantype\">Loan type:</label>\r\n");
      out.write("                        <select name=\"loan_type\" id=\"loantype\" required>\r\n");
      out.write("                            <option value=\"Pers1\" checked>Personal Silver</option>\r\n");
      out.write("                            <option value=\"Pers2\">Personal Gold</option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                        <label for=\"loanamount\" >Amount</label>\r\n");
      out.write("                        <input type=\"number\" min=\"500\" max=\"500\" step=\".01\" id=\"loanamount\" name=\"loan_amount\" required>\r\n");
      out.write("                        <label for=\"loanterm\">Loan Tenure:</label>\r\n");
      out.write("                        <select name=\"loan_term_mths\" id=\"loanterm\" required>\r\n");
      out.write("                            <option value=\"12\" checked>12 Months</option>\r\n");
      out.write("                            <option value=\"24\">24 Months</option>\r\n");
      out.write("                        </select><br>\r\n");
      out.write("                        <label for=\"interest\">Annual Interest Rate</label>\r\n");
      out.write("                        <input type=\"number\" name =\"interest\" readonly value=\"4.5\">\r\n");
      out.write("                    </fieldset>\r\n");
      out.write("                    <div class=\"btns-group\">\r\n");
      out.write("                        <button class=\"btn btn-prev\">Previous</button>\r\n");
      out.write("                        <input type=\"submit\" value=\"Apply\" class=\"btn\" />\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
