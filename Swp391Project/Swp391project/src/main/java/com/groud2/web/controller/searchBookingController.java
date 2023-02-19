/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.bookingDAO;
import com.groud2.web.model.booking;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

<<<<<<<< Updated upstream:Swp391Project/Swp391project/src/main/java/com/groud2/web/controller/bookListController.java

========
>>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/java/com/groud2/web/controller/searchBookingController.java
/**
 *
 * @author asus
 */
<<<<<<<< Updated upstream:Swp391Project/Swp391project/src/main/java/com/groud2/web/controller/bookListController.java
public class bookListController extends HttpServlet {
========
public class searchBookingController extends HttpServlet {
>>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/java/com/groud2/web/controller/searchBookingController.java

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
<<<<<<<< Updated upstream:Swp391Project/Swp391project/src/main/java/com/groud2/web/controller/bookListController.java
            out.println("<title>Servlet bookListController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet bookListController at " + request.getContextPath() + "</h1>");
========
            out.println("<title>Servlet searchBookingController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchBookingController at " + request.getContextPath() + "</h1>");
>>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/java/com/groud2/web/controller/searchBookingController.java
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
<<<<<<<< Updated upstream:Swp391Project/Swp391project/src/main/java/com/groud2/web/controller/bookListController.java
        bookingDAO b = new bookingDAO();
//        booking p = new booking();
        System.out.print("Lay du lieu booking: ");
        try {
            ArrayList<booking> list = b.getAllBooking();
            System.out.println("Thanh cong");
            request.setAttribute("list", list);
           
            request.getRequestDispatcher("bookList.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            System.out.println("failed");
            Logger.getLogger(glassesController.class.getName()).log(Level.SEVERE, null, ex);
        }
========
        processRequest(request, response);
>>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/java/com/groud2/web/controller/searchBookingController.java
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
<<<<<<<< Updated upstream:Swp391Project/Swp391project/src/main/java/com/groud2/web/controller/bookListController.java
        processRequest(request, response);
========
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        
        bookingDAO b = new bookingDAO();
        try {
           if (email != null && !email.isEmpty()) {
                ArrayList<booking> list = b.getAllByEmail(email);
                System.out.println("check email: "+ email);
                request.setAttribute("list", list);
            } else if (phone != null && !phone.isEmpty()) {
                ArrayList<booking> list = b.getAllByPhone(phone);
                System.out.println("Search by phone number: " + phone);
                request.setAttribute("list", list);
            } else if (email != null && phone != null && !email.isEmpty() && !phone.isEmpty()) {
                ArrayList<booking> list = b.getAllByBoth(email, phone);
                request.setAttribute("list", list);
            }
            request.getRequestDispatcher("searchBooking.jsp").forward(request, response);
        
        } catch (SQLException ex) {
            System.out.println("hellloooo");
            Logger.getLogger(glassesController.class.getName()).log(Level.SEVERE, null, ex);
        }
>>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/java/com/groud2/web/controller/searchBookingController.java
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
