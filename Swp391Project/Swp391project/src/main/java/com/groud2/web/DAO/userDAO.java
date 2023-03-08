/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.user;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nguye
 */
public class userDAO {
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

  

    
public user checklogin(String acc,String pass) throws SQLException, IOException {
        
        String sql = "SELECT account,password FROM swp.user where account=? and password =?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, acc);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                return new user(rs.getString(1),rs.getString(2));
}
} catch (SQLException e) {

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return null;

    }
}
    
    
    
<<<<<<< Updated upstream
    
    
    
=======
    public ArrayList<Attendance> getAttendanceHistory() throws SQLException{
        String sql = "SELECT * FROM attendance";
        ArrayList<Attendance> list = new ArrayList<>();
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String date = rs.getString(2);
                String userId = rs.getString(3);
                String name = rs.getString(4);
                String checkin1 = rs.getString(5);
                String checkout1 = rs.getString(6);
                String checkin2 = rs.getString(7);
                String checkout2 = rs.getString(8);
                String checkin3 = rs.getString(9);
                String checkout3 = rs.getString(10);
                String checkin4 = rs.getString(11);
                String checkout4 = rs.getString(12);
                
                Attendance at = new Attendance(id, date, userId, name, checkin1, checkout1, checkin2, checkout2, checkin3, checkout3, checkin4, checkout4);
                list.add(at);
            }
            
        } catch (Exception e) {
            System.out.println("Get history of attendance error: " + e.getMessage());
        }
        return list;
    }
    
      public ArrayList<user> getUsersByRole() throws SQLException, IOException {
            ArrayList<user> listrole = new ArrayList<>();
            String sql = "SELECT * FROM user WHERE role = 'doctor'";
    
    try {
        connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String userID = rs.getString(1);
                String fullname = rs.getString(2);
                String acc = rs.getString(3);
                String pass = rs.getString(4);
                String phonenumber = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                String bod = rs.getString(9);
                String userimages = rs.getString(10);
                String gender = rs.getString(8);
                String role = rs.getString(11);
                if(gender.equals("1")){
                    gender = "Male";
                }else{
                    gender = "FeMale";
                }
                user ur = new user(userID, fullname, acc, pass, phonenumber, address, email, gender, bod, userimages, role);
                
                listrole.add(ur);
                System.out.println("see");
            }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return listrole;
}
    
}  

>>>>>>> Stashed changes

