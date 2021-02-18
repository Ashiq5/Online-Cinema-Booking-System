package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UserLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User Login</title>\n");
      out.write("    </head>\n");
      out.write("    <body background=\"Big Cinemas.jpg\">\n");
      out.write("            <div align=\"center\">\n");
      out.write("                <font color=\"white\" size=\"20\">Online Cinema Booking System\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("                \n");
      out.write("                    <font color=\"white\" style=\"font-size: 24px\">Sign In.\n");
      out.write("                    \n");
      out.write("                    <form action=\"myservlet\">\n");
      out.write("                        UserName \t\n");
      out.write("\t\t\t<input type=\"text\" name=\"un\"/>\t\t\n");
      out.write("\t\t\tPassword\n");
      out.write("                        <input type=\"password\" name=\"pw\"/>\n");
      out.write("                        User\n");
      out.write("                        <input type=\"checkbox\" name=\"check\" value=\"user\">\n");
      out.write("                        Employee\n");
      out.write("                        <input type=\"checkbox\" name=\"check\" value=\"employee\">\n");
      out.write("                        Admin\n");
      out.write("                        <input type=\"checkbox\" name=\"check\" value=\"ADMIN\">\n");
      out.write("                        <input type=\"submit\" value=\"Login\" style=\"height:25px; width:50px\"><br/>\n");
      out.write("                    </form>\n");
      out.write("                    <font color=\"white\" style=\"font-size: 24px\">Register as an user.<br>\n");
      out.write("                    <form action=\"myfirstservlet\">\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>First Name \t\n");
      out.write("                                <td><input type=\"text\" name=\"a\"/><br>\t\t\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Last Name\n");
      out.write("                                <td><input type=\"text\" name=\"b\"/><br>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Email ID\n");
      out.write("                                <td><input type=\"text\" name=\"c\"/><br>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>User Name \n");
      out.write("                                <td><input type=\"text\" name=\"d\"/><br>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Password\n");
      out.write("                                <td><input type=\"password\" name=\"e\"/><br>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Confirm Password\n");
      out.write("                                <td><input type=\"password\" name=\"f\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Credit Card No.\n");
      out.write("                                <td><input type=\"text\" name=\"g\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                        <input type=\"submit\" value=\"Register\" style=\"height:50px; width:170px\">\n");
      out.write("                    </form>\t\t\t\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
