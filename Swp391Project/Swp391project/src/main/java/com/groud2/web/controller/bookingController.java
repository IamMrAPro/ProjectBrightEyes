/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;


import com.groud2.web.DAO.EmailDAO;
import com.groud2.web.DAO.bookingDAO;
import com.groud2.web.DAO.userDAO;
import jakarta.mail.MessagingException;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.DatatypeConverter;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhha
 */
public class bookingController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet bookingController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet bookingController at " + request.getContextPath() + "</h1>");
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


        bookingDAO b = new bookingDAO();

  
       
        String sbtime;
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String medical = request.getParameter("description");
        String payment = request.getParameter("payment");
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Định dạng ngày giờ theo định dạng "yyyy-MM-dd HH:mm:ss"
        String formattedDateTime = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        sbtime=formattedDateTime;
        
        userDAO u = new userDAO();
        String account = u.checkEmail(email);
       
    
        try {
            EmailDAO e = new EmailDAO();
            e.MailConfirmAppointment(email, name, date, time);
            System.out.println("send mail Succuess");
            request.setAttribute("success", "You have successfully booked. Please check your email for details about the consulting");
        

        } catch (MessagingException ex) {
            Logger.getLogger(bookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        b.insert(name, phone, email, date, time, medical, payment, sbtime);
        System.out.println("date = "  + date);
      
        request.getRequestDispatcher("booking.jsp").forward(request, response);
   
        b.insert(name, phone, email, date, time, medical, payment, sbtime);
        request.getRequestDispatcher("booking.jsp").forward(request, response);
   

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

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    private final String NAME_PATTERN = "^[a-zA-Z\\sáàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵĐđ]+$";
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
      String encyptPass(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toLowerCase();
        return myHash;
    }
}
