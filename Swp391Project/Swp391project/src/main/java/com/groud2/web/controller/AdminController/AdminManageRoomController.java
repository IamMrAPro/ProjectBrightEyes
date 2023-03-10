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
public class AdminManageRoomController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        roomDAO r = new roomDAO();
        ArrayList<room> listRoom = r.getListRoom("");
        String mess = req.getParameter("message");

<<<<<<< Updated upstream
=======
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("id");

        if (mess != null) {
            if (mess.equals("OK")) {
                mess = "Add new room successfuly!";
            } else if(mess.equals("Error")) {
                mess = "Add new room error with data!";
            }
            else if(mess.equals("updateOK")){
                mess = "Update room information successfully!";
            }
            else if(mess.equals("updateFailed")){
                mess = "Update room error with data!";
            }
            else if(mess.equals("deleteOK")){
                mess = "Delete room information successfully!";
            }
            else if(mess.equals("deleteFailed")){
                mess = "Delete room error with data!";
            }
            req.setAttribute("display", "display");
            req.setAttribute("message", mess);
        }

        req.setAttribute("username", username);
>>>>>>> Stashed changes
        req.setAttribute("listRoom", listRoom);
        req.getRequestDispatcher("AdminView/admin-screen/ManageRoom.jsp").forward(req, resp);
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
        if (position.equals("4")) {
            String roomID = req.getParameter("newRoomID");
            String roomName = req.getParameter("newRoomName");
            String roomFunction = req.getParameter("newRoomFunction");

            String add = req.getParameter("addRoom");
            if (add != null) {
                roomDAO rd = new roomDAO();
                if (rd.addNewRoom(roomID, roomName, roomFunction)) {
                    resp.sendRedirect("manageRoom?message=OK");
                } else {
                    resp.sendRedirect("manageRoom?message=Error");
                }
            }

        } else {
            changePosition(position, req, resp);
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
                resp.sendRedirect("adminDashboard");
                break;
            case "8":
                resp.sendRedirect("adminDashboard");
                break;
            default:
                throw new AssertionError();
        }
    }
}
