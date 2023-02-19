/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.glasses;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhha
 */
public class glassesDAO {

  
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

    public  ArrayList<glasses> getAllglasses() throws SQLException, IOException {
        ArrayList<glasses> list = new ArrayList<>();
        String sql = "SELECT * FROM glasses";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String gende;
                String glassID = rs.getString(1);
                String glassName= rs.getString(2);
                String color= rs.getString(3);
                String gender= rs.getString(4);
                String material= rs.getString(5);
                String style= rs.getString(6);
                String image= rs.getString(7);
                String price= rs.getString(8);
//                String quantity= rs.getString(9);
                String quantity = "100";
                if(gender.equals("1")){
                    gende = "Male";
                }else{
                    gende = "FeMale";
                }
                glasses g = new glasses(glassID, glassName, color, gende, material, style, image,price,Integer.parseInt(quantity));
                
                list.add(g);
}
} catch (SQLException e) {

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;

    }

      public glasses getGlassesId(String id) throws SQLException, IOException  {
        glasses g = new glasses();
        String sql = "SELECT * FROM swp.glasses where glassesID ="+id;
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String gende;
                String glassID = rs.getString(1);
                String glassName= rs.getString(2);
                String color= rs.getString(3);
                String gender= rs.getString(4);
                String material= rs.getString(5);
                String style= rs.getString(6);
                String image= rs.getString(7);
                String price= rs.getString(8);
                if(gender.equals("1")){
                    gende = "Male";
                }else{
                    gende = "FeMale";
                }
                g.setColor(color);
                g.setGender(gender);
                g.setGlassID(glassID);
                g.setGlassName(glassName);
                g.setImage(image);
                g.setMaterial(material);
                g.setPrice(price);
                g.setStyle(style);
                
                
}
} catch (SQLException e) {

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return g;
    }



    public boolean addNewGlass(glasses gl) {
        try {
            String mysql = "insert into glasses(glassID, glassName, color, gender, material, style, image, price)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?)";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(mysql);
            ps.setString(1, gl.getGlassID());
            ps.setString(2, gl.getGlassName());
            ps.setString(3, gl.getColor());
            ps.setString(4, gl.getGender());
            ps.setString(5, gl.getMaterial());
            ps.setString(6, gl.getStyle());
            ps.setString(7, gl.getImage());
            ps.setString(8, gl.getPrice());
            ps.execute();
        } catch (Exception e) {
            System.out.println("Add new glass into db error: " + e.getMessage());
            return false;
        }
        return true;
    }

    public ArrayList<glasses> getListGlass(String search) {
        ArrayList<glasses> listGlass = new ArrayList<>();
        try {
            String sql = "Select * from glasses";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                String color = rs.getString(3);
                String gender = rs.getString(4);
                String material = rs.getString(5);
                String style = rs.getString(6);
                String image = rs.getString(7);
                String price = rs.getString(8);
//                 String quantity= rs.getString(9);
                String quantity = "100";
                
                glasses g = new glasses(id, name, color, gender, material, style, image, price,Integer.parseInt(quantity));
                if(name.toLowerCase().contains(search.toLowerCase())){
                    listGlass.add(g);
                }
            }
        } catch (Exception e) {
            System.out.println("Get list glass from db error: " + e.getMessage());
            return new ArrayList<>();
        }
        return listGlass; 
   }

    public glasses getProductInfor(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

  
}
