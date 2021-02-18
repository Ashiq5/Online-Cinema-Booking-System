<%-- 
    Document   : myfirstJSP
    Created on : Dec 2, 2016, 1:46:42 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body background="Big Cinemas.jpg">
        <div align="center">
            <font color="white" size="20">Online Cinema Booking System
        </div>
        <div align="right"><font color="white" style="font-size:20px">
            <%
                String s=(String) session.getAttribute("username");
                session.setAttribute("username", s);
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
                <tr><td>Set your preferred date.</tr>
                <form action="Movies">
                    <%
                        session.setAttribute("username", s);
                    %>
                <tr><td>Date : <input type="date" name="da"></td></tr>
                <tr><td> &emsp;    </td></tr> 
                <tr><td> <input type="submit" value="See List" style="height:50px; width:170px">
                </form>
            </table>
            </font>
        </div>
       
       
        
    </body>
</html>
