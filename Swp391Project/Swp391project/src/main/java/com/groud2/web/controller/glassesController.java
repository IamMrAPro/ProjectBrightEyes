/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.glassesDAO;
import com.groud2.web.model.OrderGlasses.Cart;
import com.groud2.web.model.OrderGlasses.Item;
import com.groud2.web.model.glasses;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author anhha
 */
public class glassesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet glassesController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet glassesController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        glassesDAO g =new glassesDAO() ;
        
        try {
            ArrayList<glasses> list = g.getAllglasses();
            Cookie[] arr =request.getCookies();
            String txt = "";
            if(arr !=null){
                for(Cookie c :arr){
                    if(c.getName().equals("cart")){
                        txt += c.getValue();
                    }
                }
            }
            Cart cart = new Cart(txt, list);
            List<Item> listItem = cart.getItems();
            int n;
            if(listItem!=null){
                n = listItem.size();
            }else{
                n=0;
            }
            
            request.setAttribute("size", n);
            
             request.setAttribute("listGlasses", list);
            
             request.getRequestDispatcher("Glasses.jsp").forward(request, response);
        } catch (SQLException ex) {
           
            Logger.getLogger(glassesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        
        return null;
        
    }// </editor-fold>

}
