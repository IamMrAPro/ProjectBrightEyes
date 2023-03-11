/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.profile;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author asus
 */
public class profileDAO {
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

    public ArrayList<profile> getAllprofile() throws SQLException, IOException {
        ArrayList<profile> list = new ArrayList<>();
        String sql = "SELECT * FROM profile";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
               
                String userId = rs.getString(1);
                String fullname= rs.getString(2);
                String account= rs.getString(3);
                String pass= rs.getString(4);
                String phonenumber= rs.getString(5);
                String address= rs.getString(6);
                String email= rs.getString(7);
               
                profile g = new profile(userId, fullname, account, pass, phonenumber, address, email);
                
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
  public ArrayList<profile> getProfileByID(String account) throws SQLException, IOException {
        ArrayList<profile> list = new ArrayList<>();
        String sql = "SELECT * FROM profile where account=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
               
                String userId = rs.getString(1);
                String fullname = rs.getString(2);
                account = rs.getString(3);
                String pass= rs.getString(4);
                String phonenumber= rs.getString(5);
                String address= rs.getString(6);
                String email= rs.getString(7);
               
                profile g = new profile(userId, fullname, account, pass, phonenumber, address, email);
                
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
