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


            System.out.println("Check login error: " + e.getMessage());

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

    public String getUserRole(String account) {
        try {
            String sql = "Select role from user where account = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, account);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Get user role error: " + e.getMessage());
        }
        return "";
    }

    public boolean isExisted(String id) {
        try {
            String sql = "Select * from user where userId = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Check user is existed: " + e.getMessage());
        }
        return false;
    }

    public void addUser(String id, String name, String gender, String role, String email, String phone, String address, String account, String password) {
        try {
            String sql = "insert into user(userId, fullname, gender, email, phonenumber, role, address, account, password) "
                    + " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, gender);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, role);
            ps.setString(7, address);
            ps.setString(8, account);
            ps.setString(9, password);
            
            ps.execute();
        } catch (Exception e) {
            System.out.println("Add new staff to db error: " + e.getMessage());
        }
    }

    public ArrayList<user> getListUser(String userId, String searcName) {
        ArrayList<user> listUser = new ArrayList<>();
        try {
            String mySelect = "Select * from user";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(mySelect);
            rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String fullname = rs.getString(2);
                String gender = rs.getString(3);
                String account = rs.getString(4);
                String password = rs.getString(5);
                String phonenumber = rs.getString(6);
                String address = rs.getString(7);
                String email = rs.getString(8);
                String dob = rs.getString(9);
                String role = rs.getString(10);
                
                user us = new user(id, fullname, account, password, phonenumber, address, email, dob, role, gender);
                
                if(!account.equals(userId) && (!role.equals("") || !role.equals("customer")) && fullname.toLowerCase().contains(searcName.toLowerCase())){
                    listUser.add(us);
                }
            }
        } catch (Exception e) {
            System.out.println("Get list user from database error: " + e.getMessage());
            return new ArrayList<>();
        }
        
        return listUser;
    }

    public ArrayList<user> getListCustomer(String search) {
        ArrayList<user> listUser = new ArrayList<>();
        try {
            String mySelect = "Select * from user";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(mySelect);
            rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String fullname = rs.getString(2);
                String gender = rs.getString(3);
                String account = rs.getString(4);
                String password = rs.getString(5);
                String phonenumber = rs.getString(6);
                String address = rs.getString(7);
                String email = rs.getString(8);
                String dob = rs.getString(9);
                String role = rs.getString(10);
                
                user us = new user(id, fullname, account, password, phonenumber, address, email, dob, role, gender);
                
                if((role.equals("") || role.equals("customer")) && fullname.toLowerCase().contains(search.toLowerCase())){
                    listUser.add(us);
                }
            }
        } catch (Exception e) {
            System.out.println("Get list customer from database error: " + e.getMessage());
            return new ArrayList<>();
        }
        
        return listUser;
    }

    public String getUserName(String userId) {
        String name = "";
        try {
            String sql = "Select fullname from user where account = ?";
            connection = dbc.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while(rs.next()){
                name = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Get user name: " + e.getMessage());
        }
        return name;
    }


}