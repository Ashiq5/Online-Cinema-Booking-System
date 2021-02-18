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
        <title>User Login</title>
    </head>
    <body background="Big Cinemas.jpg">
            <div align="center">
                <font color="white" size="20">Online Cinema Booking System
            </div>
            
                
                    <font color="white" style="font-size: 24px">Sign In.
                    
                    <form action="myservlet">
                        UserName 	
			<input type="text" name="un"/>		
			Password
                        <input type="password" name="pw"/>
                        User
                        <input type="checkbox" name="check" value="user">
                        Employee
                        <input type="checkbox" name="check" value="employee">
                        Admin
                        <input type="checkbox" name="check" value="ADMIN">
                        <input type="submit" value="Login" style="height:25px; width:50px"><br/>
                    </form>
                    <font color="white" style="font-size: 24px">Register as an user.<br>
                    <form action="myfirstservlet">
                        <table>
                            <tr>
                                <td>First Name 	
                                <td><input type="text" name="a"/><br>		
                            </tr>
                            <tr>
                                <td>Last Name
                                <td><input type="text" name="b"/><br>
                            </tr>
                            <tr>
                                <td>Email ID
                                <td><input type="text" name="c"/><br>
                            </tr>
                            <tr>
                                <td>User Name 
                                <td><input type="text" name="d"/><br>
                            </tr>
                            <tr>
                                <td>Password
                                <td><input type="password" name="e"/><br>
                            </tr>
                            <tr>
                                <td>Confirm Password
                                <td><input type="password" name="f" /></td>
                            </tr>
                            <tr>
                                <td>Credit Card No.
                                <td><input type="text" name="g" /></td>
                            </tr>
                        </table>
                        <input type="submit" value="Register" style="height:50px; width:170px">
                    </form>			
    </body>
</html>
