/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.controller.loginController;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ao
 */
public class AdminAddNewUserController extends HttpServlet {

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
        String backPage = req.getParameter("backPage");
        String password = "";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            LocalDate now = LocalDate.now();
            LocalDate date = LocalDate.parse(dob);
            System.out.println(date);
            if (date.isBefore(now)) {
                // Thời gian do người dùng nhập vào hợp lệ, tiếp tục xử lý
                System.out.println("Thời gian hợp lệ");
            } else {
                // Thời gian do người dùng nhập vào trước thời gian hiện tại, thông báo lỗi
                req.setAttribute("ms1", "The time you entered is not valid. Please try again!!!");
                req.getRequestDispatcher("AdminView/admin-screen/AdminAddNewUser.jsp").forward(req, resp);
            }
        } catch (Exception e) {

        }

        try {
            password = encyptPass(password);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("encode password error: " + ex.getMessage());
        }

        userDAO u = new userDAO();
        boolean registerOK, emailOK;
        try {
            registerOK = u.checkAccount(account);
            emailOK = u.checkEmailRegister(email);
            if (registerOK == true || emailOK == true) {
                req.setAttribute("ms1", "Add new user failed , Please try again!!!");
                req.getRequestDispatcher("AdminView/admin-screen/AdminAddNewUser.jsp").forward(req, resp);
            } else {
                u.createData(name, account, password, phone, address, email, gender, dob, role);
                resp.sendRedirect(backPage);
                //response.sendRedirect("loginuser");

            }
        } catch (SQLException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String backPage = req.getParameter("backPage");
        String userRole = req.getParameter("userRole");
        String id = String.valueOf(GetLastUserID());
        System.out.println("back page = " + backPage);
        req.setAttribute("userRole", userRole);
        req.setAttribute("id", id);
        req.setAttribute("backPage", backPage);
        req.getRequestDispatcher("AdminView/admin-screen/AdminAddNewUser.jsp").forward(req, resp);
    }

    public int GetLastUserID() {
        userDAO u = new userDAO();
        ArrayList<user> list = u.getListUser("", "");
        int id = 0;
        for (user object : list) {
            int userId = Integer.parseInt(object.getUserId());
            if (userId > id) {
                id = userId;
            }
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
