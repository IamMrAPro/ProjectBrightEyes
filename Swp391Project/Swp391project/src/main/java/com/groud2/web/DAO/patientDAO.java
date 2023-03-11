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
import java.util.ArrayList;

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

     public ArrayList<patient> getPatientByDay(String fullname, String process, String datenow) throws SQLException {
        ArrayList<patient> listwattingPatient = new ArrayList<>();
        System.out.println("da vao den day roi");
        try {
            String sql = "SELECT patientName,phone,email,address,timeOrder,medicalDate,medicalTime,symptom,conclude,medicine,doctorName,status,process,Idcard FROM patient where doctorName=? and process=? and medicalDate=?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setString(2, process);
            ps.setString(3, datenow);
            rs = ps.executeQuery();
            while (rs.next()) {
                String patientName = rs.getString(1);
                String phone = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);

                String timeOrder = rs.getString(5);
                String medicalDate = rs.getString(6);
                String medicalTime = rs.getString(7);
                String symptom = rs.getString(8);
                String conclude = rs.getString(9);
                String medicine = rs.getString(10);
                String doctorName = rs.getString(11);
                String status = rs.getString(12);
                process = rs.getString(13);
                String Idcard = rs.getString(14);
                if (status.equals("0")) {
                    status = "OffLine";
                } else {
                    status = "Online";
                }
                if (process.equals("0")) {
                    process = "Watting";
                } else {
                    process = "Complete";
                }
                patient pa = new patient(patientName, Idcard, patientName, phone, email, address, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);

                listwattingPatient.add(pa);
                System.out.println("hay ok kok ko");
            }
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return listwattingPatient;
    }

    public ArrayList<patient> getInformationPatient(String fullname, String process, String datenow, String Idcard) throws SQLException {
        ArrayList<patient> listInformationPatient = new ArrayList<>();
        String sql = "SELECT patientName,phone,email,address,timeOrder,medicalDate,medicalTime,symptom,conclude,medicine,doctorName,status,process,Idcard,gender,bod FROM patient where doctorName=? and process=? and medicalDate=? and Idcard=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setString(2, process);
            ps.setString(3, datenow);
            ps.setString(4, Idcard);
            rs = ps.executeQuery();
            while (rs.next()) {
                String patientName = rs.getString(1);
                String phone = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);

                String timeOrder = rs.getString(5);
                String medicalDate = rs.getString(6);
                String medicalTime = rs.getString(7);
                String symptom = rs.getString(8);
                String conclude = rs.getString(9);
                String medicine = rs.getString(10);
                String doctorName = rs.getString(11);
                String status = rs.getString(12);
                process = rs.getString(13);
                Idcard = rs.getString(14);
                String gender = rs.getString(15);
                String bod = rs.getString(16);

                if (status.equals("0")) {
                    status = "OffLine";
                } else {
                    status = "Online";
                }
                if (process.equals("0")) {
                    process = "Watting";
                } else {
                    process = "Complete";
                }
                patient pa = new patient(patientName, Idcard, patientName, phone, email, address, gender, bod, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);
                listInformationPatient.add(pa);

            }
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return listInformationPatient;
    }

    public void Successful(String processOK, String Idcard, String datenow) throws SQLException {
        String sql = " UPDATE patient SET process= ? WHERE `IdCard` = ? and `medicalDate` = ? ";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, processOK);
            ps.setString(2, Idcard);
            ps.setString(3, datenow);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }
    public void Successful1(String processOK, String Idcard, String datenow) throws SQLException {
        String sql = " UPDATE patient SET status= ? WHERE `IdCard` = ? and `medicalDate` = ? ";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, processOK);
            ps.setString(2, Idcard);
            ps.setString(3, datenow);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    public ArrayList<patient> getPatientByDayOrder(String fullname, String process, String datenow, String status) throws SQLException {
        ArrayList<patient> listwattingPatient = new ArrayList<>();
        String sql = "SELECT patientName,phone,email,address,timeOrder,medicalDate,medicalTime,symptom,conclude,medicine,doctorName,status,process,Idcard FROM patient where doctorName=? and process=? and medicalDate=? and status=?";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setString(2, process);
            ps.setString(3, datenow);
            ps.setString(4, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                String patientName = rs.getString(1);
                String phone = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);

                String timeOrder = rs.getString(5);
                String medicalDate = rs.getString(6);
                String medicalTime = rs.getString(7);
                String symptom = rs.getString(8);
                String conclude = rs.getString(9);
                String medicine = rs.getString(10);
                String doctorName = rs.getString(11);
                status = rs.getString(12);
                process = rs.getString(13);
                String Idcard = rs.getString(14);
                if (status.equals("0")) {
                    status = "OffLine";
                } else {
                    status = "Online";
                }
                if (process.equals("0")) {
                    process = "Watting";
                } else {
                    process = "Complete";
                }
                patient pa = new patient(patientName, Idcard, patientName, phone, email, address, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);

                listwattingPatient.add(pa);
            }
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return listwattingPatient;

    }

    public ArrayList<patient> getInformationPatient(String Idcard, String medicalDate) throws SQLException {

        ArrayList<patient> listwattingPatient = new ArrayList<>();
        System.out.println("da vao den day roi");
        try {
            String sql = "SELECT patientName,phone,email,address,timeOrder,medicalDate,medicalTime,symptom,conclude,medicine,doctorName,status,process,Idcard FROM patient where Idcard=? and medicalDate=?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, Idcard);
            ps.setString(2, medicalDate);
            rs = ps.executeQuery();
            while (rs.next()) {
                String patientName = rs.getString(1);
                String phone = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);
                String timeOrder = rs.getString(5);
                medicalDate = rs.getString(6);
                String medicalTime = rs.getString(7);
                String symptom = rs.getString(8);
                String conclude = rs.getString(9);
                String medicine = rs.getString(10);
                String doctorName = rs.getString(11);
                String status = rs.getString(12);
                String process = rs.getString(13);
                Idcard = rs.getString(14);
                if (status.equals("0")) {
                    status = "OffLine";
                } else {
                    status = "Online";
                }
                if (process.equals("0")) {
                    process = "Watting";
                } else {
                    process = "Complete";
                }
                patient pa = new patient(patientName, Idcard, patientName, phone, email, address, timeOrder, medicalDate, medicalTime, symptom, conclude, medicine, doctorName, status, process);

                listwattingPatient.add(pa);
                System.out.println("hay ok kok ko");
            }
        } catch (SQLException e) {
            System.out.println("get Patient error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return listwattingPatient;

    }

    public void Delete(String Idcard, String medicalDate) throws SQLException {
        String sql = " delete from patient WHERE IdCard=? and medicalDate=? ";
        try {
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, Idcard);
            ps.setString(2, medicalDate);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Delete error: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }
   
}
