<%-- 
    Document   : Movies
    Created on : Dec 4, 2016, 12:54:16 AM
    Author     : hp
--%>

<%@page import="org.w3c.dom.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ch01.employtime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="Big Cinemas.jpg">
        <div align="center">
            <font color="white" size="20">Online Cinema Booking System
        </div>
        
        
        <td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        <font color="white" style="font-size:20px">
	<TABLE id="dataTable" width="1150px" height="50px" border="1">
            <caption> All Employee list(including you) </caption>
            <tr>
                <th> Username </th>
                <th> Password </th>
                <th> First_name </th>
                <th> Last_name </th>
                <th> JOB_TYPE </th>
                
            <tr/>
            
            <% 
            
            ArrayList<employtime> transactions = (ArrayList<employtime>) session.getAttribute("transactions");
            if(transactions==null)
            {
                out.println("");
            }
            else if(transactions.size()==0)
            {
                out.println("");
            }
            else 
            {
                int count=0;
                for(employtime trans: transactions)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td>", trans.user_name, trans.pass, trans.first_name,trans.last_name,trans.job_type) );
          
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        %>
            
            
	</TABLE>
                
                
    </body>
</html>
