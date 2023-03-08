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
import jakarta.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ao
 */
public class AdminAddNewUserController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String account = req.getParameter("account");
        //String id = req.getParameter("id");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phonenumber");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String dob = req.getParameter("dob");
        String role = req.getParameter("role");
        
        String password = "";
        try {
            password = encyptPass("123");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdminAddNewUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String id = String.valueOf(GetLastUserID());
        userDAO u = new userDAO();
        u.addUser(id, name, gender, role, email, phone, address, account, password);
        
        resp.sendRedirect("manageCustomer");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = String.valueOf(GetLastUserID());
        System.out.println("back page = " + backPage);
        req.setAttribute("userRole", userRole);
        req.setAttribute("id", id);
        req.getRequestDispatcher("AdminView/admin-screen/AdminAddNewUser.jsp").forward(req, resp);
    }
    
    public int GetLastUserID(){
        userDAO u = new userDAO();
        ArrayList<user> list = u.getListUser("", "");
        int id = 0;
        for (user object : list) {
            int userId = Integer.parseInt(object.getUserId());
            if(userId > id) id = userId;
        }
        id++;
        return id;
    }
    
    String encyptPass(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toLowerCase();
        return myHash;
    }
}
