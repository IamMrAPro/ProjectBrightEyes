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
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class userDAO {
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

<<<<<<< Updated upstream
    public user checklogin(String acc, String pass) throws SQLException, IOException {

=======
  

    
public user checklogin(String acc,String pass) throws SQLException, IOException {
        
>>>>>>> Stashed changes
        String sql = "SELECT account,password FROM swp.user where account=? and password =?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, acc);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
<<<<<<< Updated upstream

                return new user(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
=======
                
                return new user(rs.getString(1),rs.getString(2));
}
} catch (SQLException e) {
>>>>>>> Stashed changes

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return null;

    }
<<<<<<< Updated upstream

    public ArrayList<user> getAllByAcc(String account) throws SQLException, IOException {
        ArrayList<user> list = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
=======
public ArrayList<user> getAllByAcc(String account) throws SQLException, IOException {
        ArrayList<user> list = new ArrayList<>();
        String sql = "SELECT * FROM user where account=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, account);
>>>>>>> Stashed changes
            rs = ps.executeQuery();
            while (rs.next()) {
                String userID = rs.getString(1);
                String fullname = rs.getString(2);
                String acc = rs.getString(3);
                String pass = rs.getString(4);
                String phonenumber = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
<<<<<<< Updated upstream
                String bod = rs.getString(8);
                user g = new user(userID, fullname, acc, pass, phonenumber, address, email, bod);
                list.add(g);
            }
        } catch (SQLException e) {

        } finally {
            if (connection != null) {
                connection.close();
            }
=======
                String bod = rs.getString(9);
                String userimages = rs.getString(10);
                String gender = rs.getString(8);
                if(gender.equals("1")){
                    gender = "Male";
                }else{
                    gender = "FeMale";
                }
                user g = new user(userID, fullname, acc, pass, phonenumber, address, email, gender,bod, userimages);
                list.add(g);
            }
        } catch (SQLException e) {
                System.out.println("get profile error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
>>>>>>> Stashed changes
        }
        return list;

    }
<<<<<<< Updated upstream
   

=======
>>>>>>> Stashed changes
}
    
    
    
    
    
    

