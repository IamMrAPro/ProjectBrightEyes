/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ao
 */
public class AdminManageCustomerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDAO u = new userDAO();
        ArrayList<user> listCustomer = u.getListCustomer("");

        req.setAttribute("listCustomer", listCustomer);
        req.getRequestDispatcher("AdminView/admin-screen/ManageCustomer.jsp").forward(req, resp);
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
        if (!position.equals("3")) {
            changePosition(position, req, resp);
        }
    }

    private void changePosition(String pos, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
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
        } catch (Exception e) {
            System.out.println("Change position page error: " + e.getMessage());
        }
    }
}
