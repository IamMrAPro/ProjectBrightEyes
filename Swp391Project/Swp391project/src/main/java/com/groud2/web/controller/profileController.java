/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.groud2.web.controller;

import com.groud2.web.DAO.profileDAO;
import com.groud2.web.model.profile;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class profileController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String account = req.getParameter("account");
        profileDAO g =new profileDAO() ;
        String password, email, phonenumber, fullname;
        try {
            ArrayList<profile> list = g.getProfileByID(account);
             req.setAttribute("profile", list);
             for(profile item : list){
                 System.out.println("day"+item.getFullname());
             }
             req.getRequestDispatcher("profile.jsp").forward(req, resp);
        } catch (SQLException ex) {
            System.out.println("hellloooo");
            Logger.getLogger(glassesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
