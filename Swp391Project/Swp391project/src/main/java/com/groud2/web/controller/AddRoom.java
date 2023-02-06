/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.roomDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Ao
 */
public class AddRoom extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String roomName = req.getParameter("roomName");
            String roomID = req.getParameter("roomID");
            String roomFunction = req.getParameter("roomFunction");
            
            roomDAO room = new roomDAO();
            if(room.addNewRoom(roomID, roomName, roomFunction)){
                resp.sendRedirect("adminHome");
            }
            else {
                req.getRequestDispatcher("AddRoom.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            System.out.println("Add new room error at servlet: " + e.getMessage());
        }
    }
    
    
}
