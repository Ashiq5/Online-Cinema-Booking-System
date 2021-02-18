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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class myservlet extends HttpServlet {

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
        String username = request.getParameter("un");
        String password = request.getParameter("pw");
        DataAccess db = new DataAccess();
        int cnt = db.existUser(username, password);
        String em=request.getParameter("check");
        int cnt1 = db.existEmployee(username, password,em);
        System.out.println(username+password+cnt1+em);
        if(cnt==1 && request.getParameter("check").equals("user"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("User Page.jsp");
            rd.forward(request, response);
        }
        else if(cnt1==1 && request.getParameter("check").equals("employee") )
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("employ.jsp");
            rd.forward(request, response);
        }
        else if(cnt1==1 && request.getParameter("check").equals("ADMIN") )
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("boss.jsp");
            rd.forward(request, response);
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
    
