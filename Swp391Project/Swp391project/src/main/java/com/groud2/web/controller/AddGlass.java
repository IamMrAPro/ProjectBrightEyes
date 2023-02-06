/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.glassesDAO;
import com.groud2.web.model.glasses;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Ao
 */
public class AddGlass extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("glassID");
        String name = req.getParameter("glassName");
        String gender = req.getParameter("glassGender");
        String style = req.getParameter("glassStyle");
        String material = req.getParameter("glassMaterial");
        String color = req.getParameter("glassColor");
        String image = req.getParameter("glassUpload");
        String price = req.getParameter("glassPrice");
        
        glasses gl = new glasses(id, name, color, gender, material, style, image, price);
        glassesDAO g = new glassesDAO();
        if(g.addNewGlass(gl)){
            resp.sendRedirect("adminHome");
        }
        else {
            req.getRequestDispatcher("AddItem.jsp").forward(req, resp);
        }
    }

    
}
