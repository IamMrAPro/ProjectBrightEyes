/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.glassesDAO;
import com.groud2.web.DAO.roomDAO;
import com.groud2.web.DAO.userDAO;
import com.groud2.web.model.glasses;
import com.groud2.web.model.room;
import com.groud2.web.model.user;
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
public class AdminHome extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = (String)session.getAttribute("id");
        
        userDAO u = new userDAO();
        roomDAO r = new roomDAO();
        glassesDAO gl = new glassesDAO();
        ArrayList<user> listUser = u.getListUser(userId, "");
        ArrayList<user> listCustomer = u.getListCustomer("");
        ArrayList<room> listRoom = r.getListRoom("");
        ArrayList<glasses> listGlass = gl.getListGlass("");
        
        String searchStaff = req.getParameter("listStaffSearch");
        String customerSearch = req.getParameter("customerSearch");
        String roomSearch = req.getParameter("roomSearch");
        String itemSearch = req.getParameter("itemSearch");
        String checked = (String) req.getServletContext().getAttribute("userChoose");
        String[] adminChoose = req.getParameterValues("adminChoose");
        
        System.out.println("user are choose: " + checked);
        
        try {
            System.out.println("adminChoose = " + adminChoose[0] + " and its length = " + adminChoose.length);
        } catch (Exception e) {
            System.out.println("Print error: " + e.getMessage());
        }
        
        if(searchStaff != null){
            listUser = u.getListUser(userId, searchStaff);
        }
        
        if(customerSearch != null) {
            listCustomer = u.getListCustomer(customerSearch);
        }
        
        if(roomSearch != null ){
            listRoom = r.getListRoom(roomSearch);
        }
        
        if(itemSearch != null){
            listGlass = gl.getListGlass(itemSearch);
        }
        
        req.setAttribute("listGlass", listGlass);
        req.setAttribute("getChoose", checked);
        req.setAttribute("listRoom", listRoom);
        req.setAttribute("listCustomer", listCustomer);
        req.setAttribute("listUser", listUser);
        req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = (String)session.getAttribute("id");
        
        userDAO u = new userDAO();
        roomDAO room = new roomDAO();
        glassesDAO gl = new glassesDAO();
        ArrayList<user> listUser = u.getListUser(userId, "");
        ArrayList<user> listCustomer = u.getListCustomer("");
        ArrayList<room> listRoom = room.getListRoom("");
        ArrayList<glasses> listGlass = gl.getListGlass("");
        String username = u.getUserName(userId);
        
        req.setAttribute("username", username);
        req.setAttribute("listGlass", listGlass);
        req.setAttribute("listRoom", listRoom);
        req.setAttribute("listCustomer", listCustomer);
        req.setAttribute("listUser", listUser);
        req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
    }
    
    
}
