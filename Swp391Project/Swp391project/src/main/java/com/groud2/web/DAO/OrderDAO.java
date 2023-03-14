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
    public void insertOrder( String glasses ,String nameCustomer, String shipAdress,String unitShip,float shiping,String order,String status){
         try {
            String strSelect = "INSERT INTO `orderglasses`(`glasses`,`nameCustomer`,`shipDAddress`,`unitship`,`shiping`,`orderdate`,`statuss`) VALUES (?,?,?,?,?,?,?)";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(strSelect);
            
            ps.setString(1, glasses);
            ps.setString(2, nameCustomer);
            ps.setString(3, shipAdress);
            ps.setString(4, unitShip);
            ps.setFloat(5, shiping);
            ps.setString(6, order);
            ps.setString(7, status);
            ps.execute();
            System.out.println("insert  success");
        } catch (Exception e) {
            System.out.println("Insert  error:" + e.getMessage());
        }
    }
}
