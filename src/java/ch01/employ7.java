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
public class employ7 extends HttpServlet {

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
        String movie_id = request.getParameter("gh");
        /*String movie_name = request.getParameter("b");
        String genre = request.getParameter("c");
        String len = request.getParameter("d");
        int length=Integer.parseInt(len);*/
        String start_time = request.getParameter("e");
        String show_id = request.getParameter("f");
        String hall = request.getParameter("g");
        //int length=Integer.parseInt(len);
        int hall_no=Integer.parseInt(hall);
        String d;
        d = request.getParameter("da");
        int price=Integer.parseInt(request.getParameter("h"));
        HttpSession session = request.getSession();
        String s = (String) session.getAttribute("username");
        DataAccess db = new DataAccess();
        //int p=db.coy3(movie_id,movie_name,genre,length);
        int q=db.coy4(d,start_time,s,movie_id,show_id,hall_no,price);
        session.setAttribute("username", s);
        RequestDispatcher rd = request.getRequestDispatcher("employ.jsp");
        rd.forward(request, response);
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
