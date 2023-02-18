/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.groud2.web.Payment;

import com.groud2.web.DAO.glassesDAO;
import com.groud2.web.controller.glassesController;
import com.groud2.web.model.OrderGlasses.Cart;
import com.groud2.web.model.OrderGlasses.Order;
import com.groud2.web.model.glasses;
import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhha
 */
public class CheckoutController extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckoutController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("emailOrder");
        String phone = request.getParameter("phone");
        String adress = request.getParameter("adress");
        String city = request.getParameter("city");
        String UnitShip = request.getParameter("unitShip");
        String cityShip = "";
        String unit = "";
        if(cityShip.equals("1")){
            cityShip += "Ha noi";
        }else if(cityShip.equals("2")){
             cityShip += "Ho Chi Minh";
        }else if(cityShip.equals("3")){
             cityShip += "Can Tho";
        }else if(cityShip.equals("4")){
             cityShip += "Lao Cai";
        }else if(cityShip.equals("5")){
             cityShip += "Ha Tinh";
        }else if(cityShip.equals("6")){
             cityShip += "Da Nang";
        }
         if(unit.equals("1")){
            cityShip += "VNpost";
        }else if(unit.equals("2")){
             cityShip += "Giao Hang Tiet Kiem";
        }else if(cityShip.equals("3")){
             cityShip += "Giao hang nhanh";
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
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
            HttpSession session = request.getSession();
            String idCustom = String.valueOf(session.getAttribute("id"));
            Cart cart = new Cart(txt, list);
       
            Order o = new Order(cart, idCustom, adress, cityShip, unit,30,0,null, null, "Wait for confirmation");
            PaymentServices paymentServices = new PaymentServices() ;
            String approvalLink = paymentServices.authorizePayment(o);
            response.sendRedirect(approvalLink);
            
            
        } catch (SQLException ex) {
          
            Logger.getLogger(glassesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PayPalRESTException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
