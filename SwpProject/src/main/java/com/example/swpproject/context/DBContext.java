package com.example.swpproject.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext {
    public Connection getConnection() {
        try {
            // Initialize all the information regarding
            // Database Connection
            String dbDriver = "com.mysql.cj.jdbc.Driver";
            String dbURL = "jdbc:mysql:// localhost:3306/";
            // Database name to access
            String dbName = "swp";
            String dbUsername = "root";
            String dbPassword = "admin";

            Class.forName(dbDriver);
            Connection con = DriverManager.getConnection(dbURL + dbName,
                    dbUsername,
                    dbPassword);
            System.out.println("Connect Successfull");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        DBContext db = new DBContext();
        System.out.println(db.getConnection());
        System.out.println(db.getConnection().getCatalog());
    }
}
