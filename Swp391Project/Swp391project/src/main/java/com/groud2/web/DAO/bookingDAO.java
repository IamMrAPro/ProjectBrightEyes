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
<<<<<<< Updated upstream
            String strSelect = "INSERT INTO `swp`.`booking`\n"
                    + "(`name`,`phone`,`email`,`date`,`time`,`medical`,`payment`)\n"
=======
            String strSelect = "INSERT INTO swp.`booking`\n"
                    + "(name,`phone`,`email`,`date`,`time`,`medical`,`payment`,`sbtime`)\n"
>>>>>>> Stashed changes
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?)";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(strSelect);
            ps.setString(1, name);
            System.out.println("Name booking: " + name);
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
<<<<<<< Updated upstream
=======
   public ArrayList<booking> getCurrentBooking() throws SQLException {
        ArrayList<booking> list = new ArrayList<>();
        String sql = "SELECT * FROM booking WHERE date = current_date();";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String bookingID = rs.getString(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                String email = rs.getString(4);
                String date = rs.getString(5);
                String time = rs.getString(6);
                String medical = rs.getString(7);
                String payment = rs.getString(8);
                String sbtime = rs.getString(9);

                booking g = new booking(bookingID, name, phone, email, date, time, medical, payment, sbtime);
                list.add(g);
                System.out.println("get booking success");
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

    public ArrayList<booking> getAllByEmail(String email) throws SQLException, IOException {
        ArrayList<booking> list = new ArrayList<>();
        String sql = "SELECT * FROM booking where email=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                String bookId = rs.getString(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                String date = rs.getString(5);
                String time = rs.getString(6);
                String medical = rs.getString(7);
                String payment = rs.getString(8);
                String sbtime = rs.getString(9);

                booking g = new booking(bookId, name, phone, email, date, time, medical, payment, sbtime);
                System.out.println("get booking by email success");
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println("get booking by email error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return list;
    }

    public ArrayList<booking> getAllByPhone(String phone) throws SQLException, IOException {
        ArrayList<booking> list = new ArrayList<>();
        String sql = "SELECT * FROM booking where phone=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            while (rs.next()) {
                String bookId = rs.getString(1);
                String name = rs.getString(2);
                String email = rs.getString(4);
                String date = rs.getString(5);
                String time = rs.getString(6);
                String medical = rs.getString(7);
                String payment = rs.getString(8);
                String sbtime = rs.getString(9);

                booking g = new booking(bookId, name, phone, email, date, time, medical, payment, sbtime);
                System.out.println("get booking by phone success");
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println("get booking by phone error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return list;
    }

    public ArrayList<booking> getAllByBoth(String email, String phone) throws SQLException {
        ArrayList<booking> list = new ArrayList<>();
        String sql = "SELECT * FROM booking where phone=? AND email=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, phone);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                String bookId = rs.getString(1);
                String name = rs.getString(2);
                String date = rs.getString(5);
                String time = rs.getString(6);
                String medical = rs.getString(7);
                String payment = rs.getString(8);
                String sbtime = rs.getString(9);

                booking g = new booking(bookId, name, phone, email, date, time, medical, payment, sbtime);
                System.out.println("get booking by phone, email success");
                list.add(g);
            }
        } catch (SQLException e) {
            System.out.println("get booking by phone,email error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return list;
    }

    public boolean checkEmail(String email) throws SQLException, IOException {

        String sql = "SELECT email FROM swp.user where email=?  ";
        try {
            System.out.println("check email booking: " + email);
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("email: " + rs.getString(1));
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

    public boolean checkPhone(String phone) throws SQLException, IOException {

        String sql = "SELECT phone FROM swp.user where phone=?  ";
        try {
            System.out.println("check phone booking: " + phone);
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("phone: " + rs.getString(1));
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

    public boolean checkExist(String email, String phone) throws SQLException {
        Connection conn = dbc.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean exist = false;
        try {
            String sql = "SELECT COUNT(*) AS count FROM booking WHERE email = ? OR phone = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, phone);
            rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    exist = true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return exist;
    }

    public void cancelBooking(String id) throws SQLException {
        String sql = "DELETE FROM swp.`booking`\n"
                + "WHERE bookId = \"" + id + "\";";
        connection = dbc.getConnection();
        ps = connection.prepareStatement(sql);

        ps.executeUpdate();
    }
>>>>>>> Stashed changes
    
    public ArrayList<booking> getAllById(String bookId) throws SQLException, IOException {
        ArrayList<booking> listId = new ArrayList<>();
        String sql = "SELECT * FROM booking where bookId=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, bookId);
            rs = ps.executeQuery();
            while (rs.next()) {
              
                String name = rs.getString(2);
                String phone = rs.getString(3);
                 String email = rs.getString(4);
                String date = rs.getString(5);
                String time = rs.getString(6);
                String medical = rs.getString(7);
                String payment = rs.getString(8);
                String sbtime = rs.getString(9);

                booking g = new booking(bookId, name, phone, email, date, time, medical, payment, sbtime);
                System.out.println("get booking by id success");
                listId.add(g);
            }
        } catch (SQLException e) {
            System.out.println("get booking by email error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return listId;
    }
}