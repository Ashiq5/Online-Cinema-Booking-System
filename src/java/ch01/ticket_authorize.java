/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class ticket_authorize extends HttpServlet {

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
        HttpSession session = request.getSession();
        String s=(String) session.getAttribute("username");
        ArrayList<TicketTime> movie=(ArrayList<TicketTime>) session.getAttribute("fd");
        String pq=request.getParameter("p");
        String rs=request.getParameter("q");
        int r=50001,m=50001;
        if(pq=="" && rs==""){movie=null;}
        else if(pq!=""){r=Integer.parseInt(pq);}
        else if(rs!=""){m=Integer.parseInt(rs);}
        if(movie==null){
            
        }
        else if(movie!=null){
            for(int i=0;i<movie.size();i++){
                if(r!=50001 && i+1==r){
                    TicketTime f=movie.get(i);
                    DataAccess db=new DataAccess();
                    System.out.println(f.username+s+f.show_id);
                    db.insertTicket(f.username,s,f.show_id,f.hall_no,f.start_time,f.date);
                }
            }
            if(r==50001 && m!=50001){
                    TicketTime f=movie.get(m-1);
                    DataAccess db=new DataAccess();
                    //System.out.println(f.username+s+f.show_id);
                    db.deletet_w_f_a(f.username,f.date,f.start_time);
            }
        }
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
