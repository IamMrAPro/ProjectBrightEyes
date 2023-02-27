/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.Attendance;
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
public class TakeStaffAttendanceController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        userDAO u = new userDAO();
        
        String[] listUserName = req.getParameterValues("recordUser");
        String[] listID = req.getParameterValues("recordID");
        System.out.println("List name size = " + listUserName.length);
        
        for (String string : listUserName) {
            System.out.println("User name = " + string);
        }
        
        int len = listUserName.length;
        
        String[] checkin1 = req.getParameterValues("checkin1");
        String[] checkin2 = req.getParameterValues("checkin2");
        String[] checkin3 = req.getParameterValues("checkin3");
        String[] checkin4 = req.getParameterValues("checkin4");
        
        String[] checkout1 = req.getParameterValues("checkout1");
        String[] checkout2 = req.getParameterValues("checkout2");
        String[] checkout3 = req.getParameterValues("checkout3");
        String[] checkout4 = req.getParameterValues("checkout4");
        
//        System.out.println("checkin1 size = " + checkin1.length);
//        System.out.println("checkin2 size = " + checkin2.length);
//        System.out.println("checkin3 size = " + checkin3.length);
//        System.out.println("checkin4 size = " + checkin4.length);
//        
//        System.out.println("Checkout1 size = " + checkout1.length);
//        System.out.println("Checkout2 size = " + checkout2.length);
//        System.out.println("Checkout3 size = " + checkout3.length);
//        System.out.println("Checkout4 size = " + checkout4.length);
        
        String date = req.getParameter("date");
        ArrayList<Attendance> histories = null;
        try {
            histories = u.getAttendanceHistory();
        } catch (SQLException ex) {
            Logger.getLogger(TakeStaffAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String id = "1";
        try {
            if(histories != null){
                int size = histories.size();
            if(size > 0){
                id = String.valueOf(Integer.parseInt(histories.get(size-1).getId()) + 1);
            }
            }
        } catch (Exception e) {
            System.out.println("Error at here 01: " + e.getMessage());
        }
        // lỗi checkin checkout, số lần check 
        // mai validate check out không được nhỏ hơn checkin
        for(int i = 0; i < len; i++){
            if(checkin1[i].isEmpty()){
                checkin1[1] = "00:00";
            }
            if(checkout1[i].isEmpty()){
                checkout1[1] = "00:00";
            }
            if(checkin2[i].isEmpty()){
                checkin2[1] = "00:00";
            }
            if(checkout2[i].isEmpty()){
                checkout2[1] = "00:00";
            }
            if(checkin3[i].isEmpty()){
                checkin3[1] = "00:00";
            }
            if(checkout3[i].isEmpty()){
                checkout3[1] = "00:00";
            }
            if(checkin4[i].isEmpty()){
                checkin4[1] = "00:00";
            }
            if(checkout4[i].isEmpty()){
                checkout4[1] = "00:00";
            }
            
            u.takeAttendance(id, date, listID[i], listUserName[i], checkin1[i], checkout1[i], checkin2[i], checkout2[i], checkin3[i], checkout3[i], checkin4[i], checkout4[i]);
        }
        
        HttpSession session = req.getSession();
        ArrayList<user> listStaff = u.getListUser("admin", "");
        session.setAttribute("listStaff", listStaff);
        req.setAttribute("listStaff", listStaff);
        req.getRequestDispatcher("AdminView/admin-screen/TakeStaffAttendance.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        userDAO u = new userDAO();
        HttpSession session = req.getSession();
        ArrayList<user> listStaff = u.getListUser("admin", "");
        ArrayList<Attendance> listAttendance = null;
        try {
            listAttendance = u.getAttendanceHistory();
        } catch (SQLException ex) {
            Logger.getLogger(TakeStaffAttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("listAttendance", listAttendance);
        session.setAttribute("listStaff", listStaff);
        req.setAttribute("listStaff", listStaff);
        req.getRequestDispatcher("AdminView/admin-screen/TakeStaffAttendance.jsp").forward(req, resp);
    }
    
    
}
