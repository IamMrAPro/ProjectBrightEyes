/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller.AdminController;

import com.groud2.web.DAO.roomDAO;
import com.groud2.web.model.room;
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
public class AdminUpdateRoomController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomID = req.getParameter("roomID");
        String roomName = req.getParameter("roomName");
        String roomFunction = req.getParameter("roomFunction");
        
        String update = req.getParameter("update");
        String delete = req.getParameter("delete");
        
        roomDAO rd = new roomDAO();
        if(update != null){
            
            if(rd.updateRoom(roomID, roomName, roomFunction)){
                resp.sendRedirect("manageRoom?message=updateOK");
            }
            else {
                resp.sendRedirect("manageRoom?message=updateFailed");
            }
        }
        
        if(delete != null){
            if(rd.deleteRoom(roomID)){
                resp.sendRedirect("manageRoom?message=deleteOK");
            }
            else {
                resp.sendRedirect("manageRoom?message=deleteFailed");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomID = req.getParameter("roomID");
        
        System.out.println("RoomID = " + roomID);
        roomDAO rd = new roomDAO();
        ArrayList<room> getRoom = rd.getRoomByID(roomID);
        System.out.println("room Name: " + getRoom.get(0).getRoomName());
        req.setAttribute("listRoom", getRoom);
        req.getRequestDispatcher("AdminView/admin-screen/AdminUpdateRoom.jsp").forward(req, resp);
    }
    
    
}
