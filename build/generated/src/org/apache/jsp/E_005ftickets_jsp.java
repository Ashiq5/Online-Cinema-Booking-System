package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class E_005ftickets_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <SCRIPT language=\"javascript\">\n");
      out.write("\t\tfunction addRow(tableID) {\n");
      out.write("\n");
      out.write("\t\t\tvar table = document.getElementById(tableID);\n");
      out.write("\n");
      out.write("\t\t\tvar rowCount = table.rows.length;\n");
      out.write("\t\t\tvar row = table.insertRow(rowCount);\n");
      out.write("\n");
      out.write("\t\t\tvar cell1 = row.insertCell(0);\n");
      out.write("\t\t\tvar element1 = document.createElement(\"input\");\n");
      out.write("\t\t\telement1.type = \"checkbox\";\n");
      out.write("\t\t\telement1.name=\"chkbox[]\";\n");
      out.write("\t\t\tcell1.appendChild(element1);\n");
      out.write("\n");
      out.write("\t\t\tvar cell2 = row.insertCell(1);\n");
      out.write("\t\t\tcell2.innerHTML = rowCount + 1;\n");
      out.write("\n");
      out.write("\t\t\tvar cell3 = row.insertCell(2);\n");
      out.write("\t\t\tvar element2 = document.createElement(\"input\");\n");
      out.write("\t\t\telement2.type = \"text\";\n");
      out.write("\t\t\telement2.name = \"txtbox[]\";\n");
      out.write("\t\t\tcell3.appendChild(element2);\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t}\n");
      out.write("\n");
      out.write("\t\tfunction deleteRow(tableID) {\n");
      out.write("\t\t\ttry {\n");
      out.write("\t\t\tvar table = document.getElementById(tableID);\n");
      out.write("\t\t\tvar rowCount = table.rows.length;\n");
      out.write("\n");
      out.write("\t\t\tfor(var i=0; i<rowCount; i++) {\n");
      out.write("\t\t\t\tvar row = table.rows[i];\n");
      out.write("\t\t\t\tvar chkbox = row.cells[0].childNodes[0];\n");
      out.write("\t\t\t\tif(null != chkbox && true == chkbox.checked) {\n");
      out.write("\t\t\t\t\ttable.deleteRow(i);\n");
      out.write("\t\t\t\t\trowCount--;\n");
      out.write("\t\t\t\t\ti--;\n");
      out.write("\t\t\t\t}\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t}catch(e) {\n");
      out.write("\t\t\t\talert(e);\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\n");
      out.write("\t</SCRIPT>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <INPUT type=\"button\" value=\"Authorize\" onclick=\"deleteRow('dataTabl')\" />\n");
      out.write("        <TABLE id=\"dataTabl\" width=\"1150px\" height=\"50px\" border=\"1\">\n");
      out.write("            \n");
      out.write("            <TR>\n");
      out.write("                <TD> <INPUT type=\"checkbox\" name=\"chk\"/> </TD>\n");
      out.write("\t\t<TD>123</TD>\n");
      out.write("\t\t<TD> is@gmail.com </TD>\n");
      out.write("\t\t<TD> 122 </TD>\n");
      out.write("                <TD>16-12-2016</TD>\n");
      out.write("                <TD> A1 </TD>\n");
      out.write("\t\t<TD> Premium </TD>\n");
      out.write("                <TD>2</TD>  \n");
      out.write("\t    </TR>\n");
      out.write("            \n");
      out.write("\t</TABLE>\n");
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
