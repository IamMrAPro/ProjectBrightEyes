/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.news;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class newsDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

    public ArrayList<news> ListNews() throws SQLException {
        ArrayList<news> list = new ArrayList<>();
        String sql = " SELECT  newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4 FROM news \n";

        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String newsname = rs.getString(1);
                String category = rs.getString(2);
                String authour = rs.getString(3);
                String datepublic = rs.getString(4);
                String images1 = rs.getString(5);
                String images2 = rs.getString(6);
                String images3 = rs.getString(7);
                String images4 = rs.getString(8);
                String newscontent1 = rs.getString(9);
                String newscontent2 = rs.getString(10);
                String newscontent3 = rs.getString(11);
                String newscontent4 = rs.getString(12);
                String issue1 = rs.getString(13);
                String issue2 = rs.getString(14);
                String issue3 = rs.getString(15);
                String issue4 = rs.getString(16);
                news n = new news(newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4);
                list.add(n);

            }
        } catch (SQLException e) {
            System.out.println(" error : " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;

    }

    public ArrayList<news> getSingle(String newsname) throws SQLException {
        System.out.println("getSingle ");
        ArrayList<news> list = new ArrayList<>();
        String sql = " SELECT  newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4 FROM news where newsname=? ";

        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, newsname);
            rs = ps.executeQuery();
            while (rs.next()) {
                newsname = rs.getString(1);
                String category = rs.getString(2);
                String authour = rs.getString(3);
                String datepublic = rs.getString(4);
                String images1 = rs.getString(5);
                String images2 = rs.getString(6);
                String images3 = rs.getString(7);
                String images4 = rs.getString(8);
                String newscontent1 = rs.getString(9);
                String newscontent2 = rs.getString(10);
                String newscontent3 = rs.getString(11);
                String newscontent4 = rs.getString(12);
                String issue1 = rs.getString(13);
                String issue2 = rs.getString(14);
                String issue3 = rs.getString(15);
                String issue4 = rs.getString(16);
                news n = new news(newsname, category, authour, datepublic, images1, images2, images3, images4, newscontent1, newscontent2, newscontent3, newscontent4, issue1, issue2, issue3, issue4);
                System.out.println("image" + datepublic);
                list.add(n);

            }
        } catch (SQLException e) {
            System.out.println(" error : " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

}
