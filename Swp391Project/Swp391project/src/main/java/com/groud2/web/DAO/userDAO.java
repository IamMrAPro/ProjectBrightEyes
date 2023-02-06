/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.user;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

    public user checklogin(String acc, String pass) throws SQLException, IOException {

        String sql = "SELECT account,password FROM swp.user where account=? and password =?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, acc);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {

                return new user(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return null;

    }

public boolean checkAccount(String account) throws SQLException, IOException {

        String sql = "SELECT account FROM swp.user where account=?  ";
        try { 
            System.out.println("account "+ account);
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, account);      
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("accccc   "+ rs.getString(1));
                return true;
            }
        } catch (SQLException e) {

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return false;

    }

    public boolean createData(String fullname, String account, String password, String phonenumber, String address, String email, String gender, String birthofdate) throws SQLException {
       String sql = "INSERT INTO `swp`.`user`\n"
                    + "(`fullname`,`account`,`password`,`phonenumber`,`address`,`email`,`gender`,`bod`) values (?,?,?,?,?,?,?,?)";       
        try {   
            System.out.println("name"+fullname);
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setString(2, account);
            ps.setString(3, password);
            ps.setString(4, phonenumber);
            ps.setString(5, address);
            ps.setString(6, email);
            if (gender=="Male") {
                 ps.setString(7, "1");
            }else
                ps.setString(7, "0");
            
            ps.setDate(8, Date.valueOf(birthofdate));
            ps.executeUpdate();
            System.out.println("Them vao thanh cong");
            return true;
        } catch (SQLException e) {
                 System.out.println("Create error : " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return false;
    }
}
