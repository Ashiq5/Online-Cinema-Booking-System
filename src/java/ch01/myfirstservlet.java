/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
@WebServlet(name = "myfirstservlet", urlPatterns = {"/myfirstservlet"})
public class myfirstservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("a");
        String lastName = request.getParameter("b");
        String username = request.getParameter("d");
        String password = request.getParameter("e");
        String e=request.getParameter("f");
        String email=request.getParameter("c");
        String credit=request.getParameter("g");
        DataAccess db = new DataAccess();
        int count = db.createAccount(firstName, lastName, username, password,email,credit);
        if(count==1 && e.equals(password))
        {
            
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet myfirstservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>first name:"+firstName+"</h1>")
            out.println("<h1>You've been registered into the system.Please Login using your credentials.</h1>");
            request.getRequestDispatcher("/UserLogin.jsp").forward(request,response);
            //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/hotels.jsp");
            out.println("</body>");
            out.println("</html>");
        }
        

            //RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
            //rd.forward(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
            rd.forward(request, response); 
        }
            }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
