package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class User_0020Page_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>User Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <font color=\"blue\" size=\"20\">Online Cinema Booking System\n");
      out.write("        </div>\n");
      out.write("        <div align=\"right\">\n");
      out.write("            ");

                String s=(String) session.getAttribute("username");
                out.println(String.format("%s",s));
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div align=\"left\"><font color=\"black\" style=\"font-size:20px\">\n");
      out.write("            <table>\n");
      out.write("                <form action=\"userpage\"> \n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"submit\" value=\"Movies\" style=\"height:70px; width:270px\">\n");
      out.write("                </form>\n");
      out.write("                <form action=\"Tickets\"> \n");
      out.write("                    <td><input type=\"submit\" value=\"Tickets\" style=\"height:70px; width:270px\">\n");
      out.write("                </form>\t\n");
      out.write("                <td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;\n");
      out.write("                <td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;\n");
      out.write("                <form action=\"Logout\"> \n");
      out.write("                    <td><input type=\"submit\" value=\"Logout\" style=\"height:70px; width:270px\">\n");
      out.write("                </tr>\n");
      out.write("                </form>\n");
      out.write("                <tr><td>Set your preferred date.</tr>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <form action=\"Movies\">\n");
      out.write("                <tr><td>Date : <input type=\"date\" name=\"da\"></td></tr>\n");
      out.write("                <tr><td> &emsp;    </td></tr> \n");
      out.write("                <tr><td> <input type=\"submit\" value=\"See List\" style=\"height:50px; width:170px\">\n");
      out.write("                </form>\n");
      out.write("            </table>\n");
      out.write("            </font>\n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("       \n");
      out.write("        \n");
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
