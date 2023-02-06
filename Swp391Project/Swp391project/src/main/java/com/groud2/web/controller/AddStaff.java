/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ao
 */
public class AddStaff extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("staffName");
        String id = req.getParameter("staffID");
        String gender = req.getParameter("staffGender");
        String role = req.getParameter("staffFunction");
        String email = req.getParameter("staffEmail");
        String phone = req.getParameter("staffPhone");
        String address = req.getParameter("staffAddress");
        String account = req.getParameter("staffAccount");
        String password = "";
        try {
            password = encyptPass("123456");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AddStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Account: " + account);
        userDAO u = new userDAO();
        if(!u.isExisted(id)){
            u.addUser(id, name, gender, role, email, phone, address, account, password);
            resp.sendRedirect("adminHome");
        }
        else {
            resp.sendRedirect("addStaff");
        }
        
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("AddStaff.jsp").forward(req, resp);
    }
    
        String encyptPass(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toLowerCase();
        return myHash;
//>>>>>>> Stashed changes:Swp391Project/Swp391project/src/main/java/loginController.java
    }
}
