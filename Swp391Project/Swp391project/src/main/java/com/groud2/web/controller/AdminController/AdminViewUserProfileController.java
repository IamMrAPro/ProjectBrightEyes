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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ao
 */
public class AdminViewUserProfileController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String backPage = req.getParameter("backPage");
        //String backpage = req.getParameter("backpage");
        System.out.println("Current account is: " + account);
        userDAO u = new userDAO();
        ArrayList<user> user = new ArrayList<>();
        try {
            user = u.getAllByAcc(account);
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewUserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        HttpSession session = req.getSession();
        String role = user.get(0).getRole();
        session.setAttribute("viewUserRole", role);
        req.setAttribute("backpage", backPage);
        System.out.println("back page = " + backPage);
        req.setAttribute("user", user);
        req.getRequestDispatcher("AdminView/admin-screen/AdminViewUserProfile.jsp").forward(req, resp);
    }
    
    
}
