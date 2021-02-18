package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employ_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <body background=\"Big Cinemas.jpg\">\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <font color=\"white\" size=\"20\">Online Cinema booking\n");
      out.write("        </div>\n");
      out.write("        <div align=\"left\"><font color=\"white\" style=\"font-size:20px\">\n");
      out.write("            ");

                String s=(String) session.getAttribute("username");
                session.setAttribute("username", s);
                out.println(String.format("%s",s));
            
      out.write("\n");
      out.write("            <table>\n");
      out.write("                <form action=\"employ1\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"submit\" value=\"Shows\" style=\"height:70px; width:270px\">\n");
      out.write("                </form>\n");
      out.write("                <form action=\"employ4\">\n");
      out.write("                \n");
      out.write("                    <td><input type=\"submit\" value=\"Tickets\" style=\"height:70px; width:270px\">\n");
      out.write("                </form>\n");
      out.write("                <form action=\"employ5\">\n");
      out.write("                \n");
      out.write("                    <td><input type=\"submit\" value=\"Update\" style=\"height:70px; width:270px\">\n");
      out.write("                </form>\n");
      out.write("                <td>&emsp;&emsp;&emsp;&emsp;&emsp;\n");
      out.write("                <td>&emsp;&emsp;&emsp;&emsp;&emsp;\n");
      out.write("                <td>&emsp;&emsp;\n");
      out.write("                <form action=\"Logout\"> \n");
      out.write("                    <td><input type=\"submit\" value=\"Logout\" style=\"height:70px; width:270px\">\n");
      out.write("                </tr>\n");
      out.write("                </form>\n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("            </font>\n");
      out.write("            <font color=\"white\" style=\"font-size: 24px\">Add New Show.<br>\n");
      out.write("            <font color=\"white\" style=\"font-size: 24px\">\n");
      out.write("             <form action=\"employ2\">\n");
      out.write("                    ");

                        
                        session.setAttribute("username", s);
                    
      out.write("\n");
      out.write("                        <table>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                <td>Movie ID\t\n");
      out.write("                                <td><input type=\"text\" name=\"a\"/><br>\t\t\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Movie Name\n");
      out.write("                                <td><input type=\"text\" name=\"b\"/><br>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Genre\n");
      out.write("                                <td><input type=\"text\" name=\"c\"/><br>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Length \n");
      out.write("                                <td><input type=\"text\" name=\"d\"/><br>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr><td>Date</td><td> <input type=\"date\" name=\"da\"></td></tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Start time\n");
      out.write("                                <td><input type=\"text\" name=\"e\"/><br>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Show ID\n");
      out.write("                                <td><input type=\"text\" name=\"f\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Hall No\n");
      out.write("                                <td><input type=\"text\" name=\"g\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Price\n");
      out.write("                                <td><input type=\"number\" name=\"h\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                        \n");
      out.write("                            <input type=\"submit\" value=\"Add\" style=\"height:50px; width:170px\"></form>\n");
      out.write("        </div>\n");
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
