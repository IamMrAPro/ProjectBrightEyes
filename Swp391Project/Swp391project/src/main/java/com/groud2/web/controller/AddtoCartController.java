/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.controller;

import com.groud2.web.DAO.glassesDAO;
import com.groud2.web.model.Item;
import com.groud2.web.model.Order;

import com.groud2.web.model.glasses;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhha
 */

public class AddtoCartController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int quantity =1;
//        String id ;
//        glassesDAO g =new glassesDAO();
//        if(req.getParameter("glassesId")!=null){
//            
//            id = req.getParameter("glassesId");
//            glasses glass;
//            try {
//                glass = g.getGlassesId(id);
//                if(glass!=null){
//                if(req.getParameter("quantity")!=null){
//                    quantity = Integer.parseInt(req.getParameter("quanity"));
//                }
//                HttpSession session = req.getSession();
//                if(session.getAttribute("order")==null){
//                    Order order = new Order();
//                    List<Item> listItems = new ArrayList<Item>();
//                    Item item = new Item();
//                    item.setQuantity(quantity);
//                    item.setGlass(glass);
//                    item.setPrice(glass.getPrice());
//                    listItems.add(item);
//                    order.setItems(listItems);
//                    session.setAttribute("order", order);
//                }else{
//                    Order order = (Order) session.getAttribute("order");
//                    List<Item> listItems = order.getItems();
//                    boolean check =false;
//                    for(Item item : listItems){
//                        if(item.getGlass().getGlassID()==glass.getGlassID()){
//                            item.setQuantity(item.getQuantity()+quantity);
//                            check = true;
//                        }
//                    }
//                    if(check=false){
//                        Item item =new Item();
//                        item.setQuantity(quantity);
//                        item.setGlass(glass);
//                        item.setPrice(glass.getPrice());
//                        listItems.add(item);
//                        
//                    }
//                   
//                    session.setAttribute("order", order);
//                }
//            }
//            } catch (SQLException ex) {
//                Logger.getLogger(AddtoCartController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            resp.sendRedirect(req.getContextPath()+"/cart");
//        }else{
//            resp.sendRedirect(req.getContextPath()+"/cart");
//        }
//    }
//    
}}
