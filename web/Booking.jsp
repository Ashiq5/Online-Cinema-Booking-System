<%-- 
    Document   : Booking
    Created on : Dec 5, 2016, 9:48:20 PM
    Author     : hp
--%>

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
                out.println(String.format("%s",s));
                session.setAttribute("username",s);
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
                <form action="tckt"> 
                    <%
                        //out.prinln(String.format("%s"),t.movie_name);
                        //session.setAttribute("flag",null);
                        session.setAttribute("username", s);
                    %>
                    <td><input type="submit" value="Tickets" style="height:70px; width:270px" />
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
        <form action="Tickets"
            <table>
            <%
                MovieTime t = (MovieTime) session.getAttribute("f");
                if(t!=null){
                    out.println(String.format("<tr><td>Movie Name : %s</td></tr><br><tr><td>Hall No : %d</td><br></tr><tr><td>Date : %s</td><br></tr><tr><td>Start Time : %s</td><br></tr><tr><td>Hall Type : %s</td><br></tr><tr><td>Price :  %d</td></tr><br>", t.movie_name,t.hall_no,t.date,t.start_time,t.hall_type,t.price));
                    out.println("Click \"BUY\" to apply for a ticket<br>");
                    session.setAttribute("flag", t);
                    session.setAttribute("username",s);
                    out.println("<input type=\"submit\" value=\"Buy\" style=\"height: 30px;width: 70px\"/>");
                    out.println("<form action=\"Movies\" <input type=\"submit\" value=\"Back to Movies\" style=\"height: 30px;width: 70px\"></form>");
                }
                else{
                    session.setAttribute("flag", null);
                    session.setAttribute("username",s);
                    out.println("Nothing to buy<br>");
                    out.println("<form action=\"Movies\" <input type=\"submit\" value=\"Back to Movies\" style=\"height: 30px;width: 70px\"></form>");
                }
                
                //session.setAttribute("flag", t);
             %>
            </table>
        </form>
        
             <br>
             <form action="Movies"
                   <input type="submit" value="CANCEL" style="height: 30px;width: 70px">
             </form>
             </font>   
    </body>
</html>
