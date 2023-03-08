/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groud2.web.DAO;

import com.groud2.web.DAO.context.DBContext;
import com.groud2.web.model.patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class patientDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbc = new DBContext();
    Connection connection = null;

    public void insertPatient(String IdCard, String patientName, String phone, String email, String address, String bod, String gender, String medicalDate, String symptom, String doctorName) throws SQLException {
        String sql = "INSERT INTO `swp`.`patient` (IdCard,patientName,phone,email,address,bod,gender,medicalDate,symptom,doctorName)VALUES (?,?,?,?,?,?,?,?,?,?) "  ;                             
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, IdCard);
            ps.setString(2, patientName);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.setString(6, bod);
        int gender1;
            if (gender.equals("male")) {
                gender1 = 1;
            } else {
               gender1 = 0;
            }
            
            ps.setInt(7, gender1);
            ps.setString(8, medicalDate);
            ps.setString(9, symptom);
            ps.setString(10, doctorName);
            ps.executeUpdate();
            System.out.println("Thêm vào database  thành công");
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

     public void insertPatient2(String IdCard, String patientName, String phone, String email, String address, String bod, String gender,String timeOder, String medicalDate, String symptom, String doctorName,String status) throws SQLException {
        String sql = "INSERT INTO `swp`.`patient` (IdCard,patientName,phone,email,address,bod,gender,timeOrder,medicalDate,symptom,doctorName,status)VALUES (?,?,?,?,?,?,?,?,?,?,?,1) "  ;                             
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, IdCard);
            ps.setString(2, patientName);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.setString(6, bod);
        int gender1;
            if (gender.equals("male")) {
                gender1 = 1;
            } else {
               gender1 = 0;
            }
            
            ps.setInt(7, gender1);
            ps.setString(8, timeOder);
            ps.setString(9, medicalDate);
            ps.setString(10, symptom);
            ps.setString(11, doctorName);
          
            ps.executeUpdate();
            System.out.println("Thêm vào database  thành công");
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

   
}
