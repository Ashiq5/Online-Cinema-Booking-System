package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ch01.TicketTime;
import org.w3c.dom.Document;
import java.util.ArrayList;
import ch01.MovieTime;

public final class Movie_005fauthorize_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body background=\"Big Cinemas.jpg\">\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <font color=\"white\" size=\"20\">Online Cinema booking System\n");
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
      out.write("                <td>&emsp;&emsp;&emsp;&emsp;&emsp;\n");
      out.write("                <td>&emsp;&emsp;&emsp;&emsp;&emsp;\n");
      out.write("                <td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;\n");
      out.write("                <form action=\"Logout\"> \n");
      out.write("                    <td><input type=\"submit\" value=\"Logout\" style=\"height:70px; width:270px\">\n");
      out.write("                </tr>\n");
      out.write("                </form>\n");
      out.write("            </table>\n");
      out.write("            </font>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <form action=\"ticket_authorize\">\n");
      out.write("        <font color=\"white\" style=\"font-size: 20px\">\n");
      out.write("        <div align=\"center\">\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <caption>Waiting for Authorization<br></caption>\n");
      out.write("            <tr>\n");
      out.write("                <th> No. </th>\n");
      out.write("                <th> User Name</th>\n");
      out.write("                <th> Hall No. </th>\n");
      out.write("                ");
      out.write("\n");
      out.write("                <th> Movie Name </th>\n");
      out.write("                <th> Date </th>\n");
      out.write("                <th> Start_time </th>\n");
      out.write("                <th> Hall_type </th>\n");
      out.write("                <th> Price </th>\n");
      out.write("            <tr/>\n");
      out.write("            ");
 
            
            ArrayList<TicketTime> transactions = (ArrayList<TicketTime>) session.getAttribute("trte");
            if(transactions==null)
            {
                out.println("");
            }
            else if(transactions.size()==0)
            {
                out.println("No Available Ticket For Authorization");
            }
            else 
            {
                int count=0;
                for(TicketTime trans: transactions)
                {
                    count++;
                    out.println("<tr>");
                    out.println( String.format("<td>%d</td><td>%s</td><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%d</td>",count, trans.username, trans.hall_no, trans.movie_name,trans.date,trans.start_time,trans.hall_type,trans.price) );
                    //out.println("<td><input type=\"submit\" value=\"BOOK\"></td>");
                    out.println("</tr>");
                }
            }
        
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <div align=\"right\">\n");
      out.write("            Please specify tickets that you want to validate.<input type=\"number\" name=\"p\">\n");
      out.write("            ");

                session.setAttribute("fd",transactions);
                session.setAttribute("username", s);
            
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Validate\" style=\"height: 50px; width:120px \">\n");
      out.write("            <br>Please specify tickets that you want to delete. <input type=\"number\" name=\"q\">\n");
      out.write("            ");

                session.setAttribute("fd",transactions);
                session.setAttribute("username", s);
            
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Delete\" style=\"height: 50px; width:125px \">\n");
      out.write("        </div>\n");
      out.write("         <table border=\"1\">\n");
      out.write("            <caption>Bought Tickets<br></caption>\n");
      out.write("            <tr>\n");
      out.write("                <th> User Name </th>\n");
      out.write("                <th> Ticket No. </th>\n");
      out.write("                <th> Hall No. </th>\n");
      out.write("                <th> Movie Name </th>\n");
      out.write("                <th> Date </th>\n");
      out.write("                <th> Start_time </th>\n");
      out.write("                <th> Hall_type </th>\n");
      out.write("                <th> Price </th>\n");
      out.write("            <tr/>\n");
      out.write("            ");
 
            
            ArrayList<TicketTime> transaction = (ArrayList<TicketTime>) session.getAttribute("trta");
            if(transaction==null)
            {
                session.setAttribute("ftft",null);
                out.println("");
            }
            else if(transaction.size()==0)
            {
                session.setAttribute("ftft", null);
                out.println("No bought Ticket");
            }
            else 
            {
                int count=0;
                session.setAttribute("ftft", transaction);
                for(TicketTime trans: transaction)
                {
                    count++;
                    out.println("<tr>");
                    out.println( String.format("<td>%s</td><td>%s</td><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%d</td>", trans.username,trans.Ticket_no, trans.hall_no, trans.movie_name,trans.date,trans.start_time,trans.hall_type,trans.price) );
                    out.println("</tr>");
                }
            }
        
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <div align=\"right\">\n");
      out.write("        <input type=\"submit\" value=\"Delete\" style=\"height: 50px; width:125px \">\n");
      out.write("        </div>\n");
      out.write("        </form>\n");
      out.write("\t\n");
      out.write("                \n");
      out.write("                \n");
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
