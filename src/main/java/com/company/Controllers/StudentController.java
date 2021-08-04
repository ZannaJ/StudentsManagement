package com.company.Controllers;

import com.company.dbhelper.DbConnection;
import com.company.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentController {

    // Initialize the scanner

    static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;
    public static boolean addNewStudent() {

        System.out.println("Enter the name of the student: ");
        String name = scanner.next();

        System.out.println("Enter the age of the student: ");
        int age = scanner.nextInt();


        try {
            ps = DbConnection.getConnection().prepareStatement("INSERT INTO students(name, age)" + "VALUES('" + name + "', " + age + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
    public static Student getStudentById() {
        System.out.println("Enter the id of the student: ");
        int id = scanner .nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT * FROM students WHERE id=" + id);
            rs = ps.executeQuery();

            int studentId, age;
            String name;

            return new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));



        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
