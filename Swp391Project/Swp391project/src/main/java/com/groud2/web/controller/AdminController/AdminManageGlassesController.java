/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.glassesDAO;
import com.groud2.web.model.glasses;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ao
 */
public class AdminManageGlassesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        glassesDAO g = new glassesDAO();
        ArrayList<glasses> listGlasses = g.getListGlass("");
        String mess = req.getParameter("message");
        HttpSession session = req.getSession();
         String username = (String)session.getAttribute("id");
         
         if(mess != null){
             if(mess.equals("addOK")){
                 req.setAttribute("message", "Add new glass successfully!");
             }
             else if(mess.equals("updateOK")){
                 req.setAttribute("message", "Update glass successfully!");
             }
             req.setAttribute("display", "display");
         }
         req.setAttribute("username", username);
        req.setAttribute("listGlasses", listGlasses);
        req.getRequestDispatcher("AdminView/admin-screen/ManageGlass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get request from client
        String position = req.getParameter("position");
        String setPos = req.getParameter("setPosition");
        String search = req.getParameter("searchGlass");
        if (position == null) {
            position = setPos;
        }
        //Handle request
        if (!position.equals("5")) {
            changePosition(position, req, resp);
        }
        else {
            if(search != null){
                glassesDAO gd = new glassesDAO();
                ArrayList<glasses> listGlasses = gd.getListGlass(search);
                req.setAttribute("listGlasses", listGlasses);
        req.getRequestDispatcher("AdminView/admin-screen/ManageGlass.jsp").forward(req, resp);
            }
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
                resp.sendRedirect("searchBooking");
                break;
            case "8":
                resp.sendRedirect("adminDashboard");
                break;
            default:
                throw new AssertionError();
        }
    }
}
