<%-- 
    Document   : Movies
    Created on : Dec 4, 2016, 12:54:16 AM
    Author     : hp
--%>

<%@page import="org.w3c.dom.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ch01.dorkar"%>
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
        <form action="employ3" style="height:50 px;width: 170px;">
        <font color="white" style="font-size:20px">
	<TABLE id="dataTable" width="1150px" height="50px" border="1">
            <caption> All Shows </caption>
            <tr>
                <th> Show ID </th>
                <th> Start Time </th>
                <th> Movie Name </th>
                <th> Genre </th>
                <th> Length </th>
                <th> Hall No </th>
                <th> Movie Id </th>
                <th> Date </th>
                <th> Price </th>
                
            <tr/>
            
            <% 
            
            ArrayList<dorkar> transactions = (ArrayList<dorkar>) session.getAttribute("transactions");
            if(transactions==null)
            {
                out.println("");
            }
            else if(transactions.size()==0)
            {
                out.println("No Available Movie For Your Selected Date");
            }
            else 
            {
                int count=0;
                for(dorkar trans: transactions)
                {
                    count++;
                    out.println("<tr>");
  
                    out.println( String.format("<td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%d mins</td><td>%d</td><td>%s</td><td>%s</td><td>%d</td>", trans.show_id, trans.start_time, trans.movie_name,trans.genre,trans.length,trans.hall_no,trans.movie_id,trans.date,trans.price) );
             
                    out.println("</tr>");
                }
                out.println("");
                out.println("</table>");
            }
        %>
            
            
	</TABLE>
        <div align="right">
            <input type="submit" value="Back"  style="height:50px;width:170px;"/>
        </div>
        </form>   
                
    </body>
</html>
