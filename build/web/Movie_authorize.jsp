<%-- 
    Document   : Movies
    Created on : Dec 4, 2016, 12:54:16 AM
    Author     : hp
--%>

<%@page import="ch01.TicketTime"%>
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
            <font color="white" size="20">Online Cinema booking System
        </div>
        <div align="left"><font color="white" style="font-size:20px">
            <%
                String s=(String) session.getAttribute("username");
                session.setAttribute("username", s);
                out.println(String.format("%s",s));
            %>
            <table>
                <form action="employ1">
                <tr>
                    <td><input type="submit" value="Shows" style="height:70px; width:270px">
                </form>
                <form action="employ4">
                
                    <td><input type="submit" value="Tickets" style="height:70px; width:270px">
                </form>
                <td>&emsp;&emsp;&emsp;&emsp;&emsp;
                <td>&emsp;&emsp;&emsp;&emsp;&emsp;
                <td>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <form action="Logout"> 
                    <td><input type="submit" value="Logout" style="height:70px; width:270px">
                </tr>
                </form>
            </table>
            </font>
        </div>
        
        <form action="ticket_authorize">
        <font color="white" style="font-size: 20px">
        <div align="center">
        <table border="1">
            <caption>Waiting for Authorization<br></caption>
            <tr>
                <th> No. </th>
                <th> User Name</th>
                <th> Hall No. </th>
                <%--<th> Seat No. </th>--%>
                <th> Movie Name </th>
                <th> Date </th>
                <th> Start_time </th>
                <th> Hall_type </th>
                <th> Price </th>
            <tr/>
            <% 
            
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
        %>
        </table>
        <div align="right">
            Please specify tickets that you want to validate.<input type="number" name="p">
            <%
                session.setAttribute("fd",transactions);
                session.setAttribute("username", s);
            %>
            <input type="submit" value="Validate" style="height: 50px; width:120px ">
            <br>Please specify tickets that you want to delete. <input type="number" name="q">
            <%
                session.setAttribute("fd",transactions);
                session.setAttribute("username", s);
            %>
            <input type="submit" value="Delete" style="height: 50px; width:125px ">
        </div>
        </form>
            <form action="tr">
         <table border="1">
            <caption>Bought Tickets<br></caption>
            <tr>
                <th> User Name </th>
                <th> Ticket No. </th>
                <th> Hall No. </th>
                <th> Movie Name </th>
                <th> Date </th>
                <th> Start_time </th>
                <th> Hall_type </th>
                <th> Price </th>
            <tr/>
            <% 
            
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
        %>
        </table>
        <div align="right">
        <input type="submit" value="Delete" style="height: 50px; width:125px ">
        </div>
        </form>
	
                
                
    </body>
</html>
