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
                <form action="employ5">
                
                    <td><input type="submit" value="Update" style="height:70px; width:270px">
                </form>
                <td>&emsp;&emsp;&emsp;&emsp;&emsp;
                <td>&emsp;&emsp;&emsp;&emsp;&emsp;
                <td>&emsp;&emsp;
                <form action="Logout"> 
                    <td><input type="submit" value="Logout" style="height:70px; width:270px">
                </tr>
                </form>
                
            </table>
            </font>
            <font color="white" style="font-size: 24px">Update Existing Show.<br>
            <font color="white" style="font-size: 24px">
             <form action="employ6">
                    <%
                        
                        session.setAttribute("username", s);
                    %>
                        <table>
                            
                            
                            <tr>
                                <td>Movie ID	
                                <td><input type="text" name="a"/><br>		
                            </tr>
                            <tr>
                                <td>Movie Name
                                <td><input type="text" name="b"/><br>
                            </tr>
                            <tr>
                                <td>Genre
                                <td><input type="text" name="c"/><br>
                            </tr>
                            <tr>
                                <td>Length 
                                <td><input type="text" name="d"/><br>
                            </tr>
                            <tr><td><input type="submit" value="Update Movie" style="height:50px; width:170px"></td></tr></table>
                           
                            </form>
                            <form action="employ7">
                                <%
                        
                        session.setAttribute("username", s);
                    %>
                                <table>
                             <tr>
                                <td>Movie ID	
                                <td><input type="text" name="gh"/><br>		
                            </tr>
                            <tr><td>Date</td><td> <input type="date" name="da"></td></tr>
                            <tr>
                                <td>Start time
                                <td><input type="text" name="e"/><br>
                            </tr>
                            <tr>
                                <td>Show ID
                                <td><input type="text" name="f" /></td>
                            </tr>
                            <tr>
                                <td>Hall No
                                <td><input type="text" name="g" /></td>
                            </tr>
                            <tr>
                                <td>Price
                                <td><input type="number" name="h" /></td>
                            </tr>
                        </table>
                        
                            <input type="submit" value="Update Show" style="height:50px; width:170px"></form>
        </div>
       
        
    </body>
</html>
