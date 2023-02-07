/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.booking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class bookingDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

    public void insert(String name, String phone, String email, String date, String time, String medical, String payment) {
        try {
            String strSelect = "INSERT INTO `swp`.`booking`\n"
                    + "(`name`,`phone`,`email`,`date`,`time`,`medical`,`payment`)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?)";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(strSelect);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.setDate(4,Date.valueOf(date));
            ps.setString(5, time);
            ps.setString(6, medical);
            ps.setString(7, payment);
            System.out.println("check date: " + date);
            ps.execute();
            System.out.println("insert booking success");
        } catch (Exception e) {
            System.out.println("check SQL2: " + name);
            System.out.println("Insert booking error:" + e.getMessage());
        }

    }
     public ArrayList<booking> getAllBooking() throws SQLException {
       ArrayList<booking> list = new ArrayList<>();
        String sql = "SELECT * FROM booking";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);      
            while (rs.next()) {
                String bookingID = rs.getString(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                String email = rs.getString(4);
                String date = rs.getString(5);
                String time = rs.getString(6);
                String medical = rs.getString(7);
                String payment = rs.getString(9);
               
             
                booking g = new booking(bookingID, name, phone, email, date, time, medical, payment);
                list.add(g);
            }
        } catch (SQLException e) {
                System.out.println("get booking error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;

    }
    
}
