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

    public ArrayList<glasses> getAllglasses() throws SQLException, IOException {
        ArrayList<glasses> list = new ArrayList<>();
        String sql = "SELECT * FROM glasses";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String glassID = rs.getString(1);
                String glassName= rs.getString(2);
                String color= rs.getString(3);
                String gender= rs.getString(4);
                String material= rs.getString(5);
                String style= rs.getString(6);
                String image= rs.getString(7);
                glasses g = new glasses(glassID, glassName, color, gender, material, style, image);
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