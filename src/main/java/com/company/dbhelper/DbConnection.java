package com.company.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection getConnection() {
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", User.USERNAME.getValue(), User.PASSWORD.getValue());
            System.out.println("Database Connected Successfully.");

        }catch (SQLException e) {
//            System.out.println("Unable to connect to database");
            e.printStackTrace();

        }
        return connection;
    }



}
