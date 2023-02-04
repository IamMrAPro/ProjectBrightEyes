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

    public ArrayList<user> getAllByAcc(String account) throws SQLException, IOException {
        ArrayList<user> list = new ArrayList<>();
        String sql = "SELECT * FROM user";
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
                String bod = rs.getString(8);
                user g = new user(userID, fullname, acc, pass, phonenumber, address, email, bod);
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
   

}
