/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author Ao
 */
public class AdminDasboardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         HttpSession session = req.getSession();
         String username = (String)session.getAttribute("id");
         
         req.setAttribute("totalRevenue", "100.000.000VND");
         req.setAttribute("totalDaysOfCurrentMonth", getDaysOfCurrentMonth());
         req.setAttribute("username", username);
        req.getRequestDispatcher("AdminView/admin-screen/AdminDashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get request from client
        String position = req.getParameter("position");
        String setPos = req.getParameter("setPosition");
        if (position == null) {
            position = setPos;
        }

        //Handle request
        if (!position.equals("1")) {
            changePosition(position, req, resp);
        } else {
            HttpSession session = req.getSession();
            String username = (String)session.getAttribute("id");
            
            req.setAttribute("totalDaysOfCurrentMonth", getDaysOfCurrentMonth());
            
            req.setAttribute("username", username);
            req.getRequestDispatcher("AdminView/admin-screen/AdminDashboard.jsp").forward(req, resp);
        }
    }

    private void changePosition(String pos, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        switch (pos) {
            case "1":
                resp.sendRedirect("adminDashboard");
                break;
            case "2":
                resp.sendRedirect("manageStaff");
                break;
            case "3":
                resp.sendRedirect("manageCustomer");
                break;
            case "4":
                resp.sendRedirect("manageRoom");
                break;
            case "5":
                resp.sendRedirect("manageGlasses");
                break;
            case "6":
                resp.sendRedirect("feedback");
                break;
            case "7":
                resp.sendRedirect("adminDashboard");
                break;
            case "8":
                resp.sendRedirect("adminDashboard");
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public int getDaysOfCurrentMonth(){
        LocalDate date = java.time.LocalDate.now();
        System.out.println("Today is: " + date);
        String today = date.toString();
        String[] time = today.split("-");

        int year = Integer.parseInt(time[0]);
        int month = Integer.parseInt(time[1]);
        
        LocalDate now = LocalDate.of(year, month, 1);
//        System.out.println("Totalday: " + now.lengthOfMonth());
        return now.lengthOfMonth();
    }
}
