<%-- 
    Document   : Tickets
    Created on : Dec 5, 2016, 10:35:25 PM
    Author     : hp
--%>

<%@page import="ch01.TicketTime"%>
<%@page import="java.util.ArrayList"%>
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
        <font color="white" style="font-size: 20px">
        <div align="center">
        <table border="1">
            <caption>Waiting for Authorization<br></caption>
            <tr>
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
            
            ArrayList<TicketTime> transactions = (ArrayList<TicketTime>) session.getAttribute("tran");
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
                    out.println( String.format("<td>%s</td><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%d</td>", trans.username, trans.hall_no, trans.movie_name,trans.date,trans.start_time,trans.hall_type,trans.price) );
                    //out.println("<td><input type=\"submit\" value=\"BOOK\"></td>");
                    out.println("</tr>");
                }
            }
        %>
        </table>
            <br>
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
            
            ArrayList<TicketTime> transaction = (ArrayList<TicketTime>) session.getAttribute("trans");
            if(transaction==null)
            {
                out.println("");
            }
            else if(transaction.size()==0)
            {
                out.println("No bought Ticket");
            }
            else 
            {
                int count=0;
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
        </div>
    </body>
</html>
