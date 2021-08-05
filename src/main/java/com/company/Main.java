package com.company;

import com.company.Controllers.StudentController;
import com.company.Login.Login;

public class Main {
    public static void main(String[] args) {
        // ternary operator.

//        System.out.println(StudentController.addNewStudent() ? "Successfully added new student" : "Failed to add a new student. ");

//        System.out.println("The student is: " + StudentController.getStudentById().getName());

//        System.out.println(5 > 7 ? "It's true" : "It's false");
        System.out.println(Login.userSignUp() ? "Added a new user." : "Can't add a new user.");
    }
}
