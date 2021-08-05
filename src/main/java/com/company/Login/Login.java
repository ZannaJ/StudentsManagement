package com.company.Login;

import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean userSignUp() {
        System.out.println("Enter the username: ");
        String username = scanner.next();

        System.out.println("Enter the password: ");
        String password = scanner.next();

        try {
            ps = DbConnection.getConnection().prepareStatement("INSERT INTO users(username, password)" + "VALUES('" + username + "', " + password + ")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public static boolean userLogin() {
        System.out.println("Enter the username: ");
        String username = scanner.next();

        System.out.println("Enter the password: ");
        String password = scanner.next();

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT * FROM users WHERE username='" + username + "password='" + "', " + password + "'");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
