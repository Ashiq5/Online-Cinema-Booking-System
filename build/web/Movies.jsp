<%-- 
    Document   : Movies
    Created on : Dec 4, 2016, 12:54:16 AM
    Author     : hp
--%>

<%@page import="org.w3c.dom.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ch01.MovieTime"%>
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
        <div align="right"><font color="white" style="font-size:20px">
            <%
                String s=(String) session.getAttribute("username");
                session.setAttribute("username",s);
                out.println(String.format("%s",s));
            %>
        </div>
        <div align="left"><font color="white" style="font-size:20px">
            <table>
                <form action="userpage"> 
                    <%
                        session.setAttribute("username", s);
                    %>
                <tr>
                    <td><input type="submit" value="Movies" style="height:70px; width:270px">
                </form>
                <form action="Tickets"> 
                    <%
                        session.setAttribute("flag",null);
                        session.setAttribute("username", s);
                    %>
                    <td><input type="submit" value="Tickets" style="height:70px; width:270px">
                </form>	
                <td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <form action="Logout"> 
                    <td><input type="submit" value="Logout" style="height:70px; width:270px">
                </tr>
                </form>
            </table>
            </font>
        </div>
        
        
        <font color="white" style="font-size:20px">
	<TABLE id="dataTable" width="1150px" height="50px" border="1">
            <caption> Available Movies</caption>
            <tr>
                <th> No. </th>
                <th> Movie_name </th>
                <th> Genre </th>
                <th> Movie_Length </th>
                <th> Date </th>
                <th> Start_time </th>
                <th> Hall_type </th>
                <th> Price </th>
                <th> Hall No</th>
            <tr/>
            <form action="Booking">
            <% 
            
            ArrayList<MovieTime> transactions = (ArrayList<MovieTime>) session.getAttribute("transactions");
            if(transactions==null)
            {
                out.println("");
            }
            else if(transactions.size()==0)
            {
                out.println("No Available Movie For Your Selected Date");
                session.setAttribute("movie",null);
            }
            else 
            {
                int count=0;
                for(MovieTime trans: transactions)
                {
                    count++;
                    out.println("<tr>");
                    out.println( String.format("<td>%d</td><td>%s</td><td>%s</td><td>%d mins</td><td>%s</td><td>%s</td><td>%s</td><td>%d</td><td>%d</td>",count, trans.movie_name, trans.genre, trans.length,trans.date,trans.start_time,trans.hall_type,trans.price,trans.hall_no) );
                    //out.println("<td><input type=\"submit\" value=\"BOOK\"></td>");
                    out.println("</tr>");
                }
                session.setAttribute("movie", transactions);
                out.println("</table>");
            }
        %>
        </TABLE>
        <div align="right">
            Please Specify your Movie Number<input type="number" name="p">
            <%
                        session.setAttribute("username", s);
            %>
            <input type="submit" value="BOOK" style="height: 50px; width:120px ">
        </div>
            </form>
	
                
                
    </body>
</html>
