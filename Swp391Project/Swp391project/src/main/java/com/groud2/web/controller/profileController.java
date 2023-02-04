/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
<<<<<<< Updated upstream
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.groud2.web.controller;

import com.groud2.web.DAO.profileDAO;
import com.groud2.web.model.profile;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
=======
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;
import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.user;
>>>>>>> Stashed changes

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< Updated upstream
=======

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.user;
import jakarta.servlet.http.HttpSession;
>>>>>>> Stashed changes
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
/**
 *
 * @author asus
 */
<<<<<<< Updated upstream
public class profileController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String account = req.getParameter("account");
        profileDAO g =new profileDAO() ;
        String password, email, phonenumber, fullname;
        try {
            ArrayList<profile> list = g.getProfileByID(account);
             req.setAttribute("profile", list);
             for(profile item : list){
                 System.out.println("day"+item.getFullname());
             }
             req.getRequestDispatcher("profile.jsp").forward(req, resp);
=======
public class profileController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet profile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet profile at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
         String account = request.getParameter("id");
        userDAO g =new userDAO() ;
        
        try {
            ArrayList<user> list = g.getAllByAcc(account);
            request.setAttribute("list", list);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
>>>>>>> Stashed changes
        } catch (SQLException ex) {
            System.out.println("hellloooo");
            Logger.getLogger(glassesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
<<<<<<< Updated upstream
=======

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

>>>>>>> Stashed changes
}
