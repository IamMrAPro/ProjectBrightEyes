/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author anhha
 */
public class OrderDAO {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;
    public void insertOrder(int id, String glasses ,String customerId, String shipAdress,String unitShip,float shiping,String order,String status){
         try {
            String strSelect = "INSERT INTO `swp`.`orderglasses`(`id`,`glasses`,`customerId`,`shipDAddress`,`unitship`,`shiping`,`orderdate`,`statuss`) VALUES (?,?,?,?,?,?,?,?)";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(strSelect);
            ps.setInt(1, id);
            ps.setString(2, glasses);
            ps.setString(3, customerId);
            ps.setString(4, shipAdress);
            ps.setString(5, unitShip);
            ps.setFloat(6, shiping);
            ps.setString(7, order);
            ps.setString(8, status);
            ps.execute();
            System.out.println("insert  success");
        } catch (Exception e) {
            System.out.println("Insert  error:" + e.getMessage());
        }
    }
}
