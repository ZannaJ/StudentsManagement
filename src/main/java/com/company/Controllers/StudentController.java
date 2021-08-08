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
            // INSERT INTO students(name, age) VALUES('enakn', 23)
            ps = DbConnection.getConnection().prepareStatement("INSERT INTO students(name, age)" + "VALUES('" + name + "', " + age + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
    public static Student getStudentById() {

        // Prompt the user to enter the id of the student they want to retrieve.

        System.out.println("Enter the id of the student: ");
        int id = scanner .nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT * FROM students WHERE id=" + id);
            rs = ps.executeQuery();

            int studentId, age;
            String name;
            Student student = new Student();

            while (rs.next()) {
                studentId = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                student.setId(studentId);
                student.setName(name);
                student.setAge(age);

            }
                return student;
//            return new Student(id, name, age);



        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void addStudentScore() {
        System.out.println("Enter the student's id: ");
        int id = scanner.nextInt();

        System.out.println("Enter the mathematics score: ");
        int mathScore = scanner.nextInt();

        System.out.println("Enter the english score: ");
        int englishScore = scanner.nextInt();



        try {
            ps = DbConnection.getConnection().prepareStatement("INSERT INTO scores (Mathematics, English, student_id) VALUES(" + mathScore + "," + englishScore + "," + id + ")");
            ps.execute();
            System.out.println("Successfully added score.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Assignment
        // Add methods to remove a students score, edit a students score and remove a student and edit student's details.
    }
}
