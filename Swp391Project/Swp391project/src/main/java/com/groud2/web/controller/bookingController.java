/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.bookingDAO;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.booking;
import com.groud2.web.model.user;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        bookingDAO b =new bookingDAO();

        booking p = new booking();

        String sbtime = request.getParameter("submit_time");

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String medical = request.getParameter("description");
        String payment = request.getParameter("payment");
        

        
        b.insert(name, phone, email, date, time, medical, payment);
        request.getRequestDispatcher("booking.jsp").forward(request, response);
        request.setAttribute("name", name);
        request.setAttribute("phone", phone);
        request.setAttribute("email", email);
        request.setAttribute("date", date);
        request.setAttribute("time", time);
        request.setAttribute("medical", medical);
        request.setAttribute("payment", payment);
      
        System.out.println("check getPara: "+name);
        
    } 


        b.insert(name, phone, email, date, time, medical, payment,sbtime);
        request.getRequestDispatcher("booking.jsp").forward(request, response);
        System.out.println("check getPara: "+name);
        System.out.println("check submit time: "+ sbtime);
        
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
