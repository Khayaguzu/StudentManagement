/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmangement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class representing a student with various details.
 * Includes methods for managing student records.
 */
public class Student {
    
    // Private member variables to store student details
    private String id;
    private String name;
    private int age;
    private String course;
    private String email;
    
    // Constructor to initialize a Student object with provided details
    public Student(String id, String name, int age, String course, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
    }

    // Getters for student details
    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    // Method to add a new student to the list
    public static void saveStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        // Enter Student Age
        int age = getValidAge(scanner);
        
        System.out.print("Enter student course: ");
        String course = scanner.nextLine();
        
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        
        students.add(new Student(id, name, age, course, email));
        System.out.println("Student details saved successfully!");
    }

    // Method to search for a student by ID
    public static Student searchStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to search: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Method to delete a student by ID
    public static void deleteStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            System.out.print("Are you sure you want to delete this student? (yes/no): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes")) {
                students.remove(studentToRemove);
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student deletion cancelled.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to generate a report of all students
    public static void studentReport(ArrayList<Student> students) {
        System.out.println("Student Report:");
        int count = 1;
        for (Student student : students) {
            System.out.println();
            System.out.println("STUDENT " + count);
            System.out.println("-------------------------------------------");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Course: " + student.getCourse());
            System.out.println("Email: " + student.getEmail());
            System.out.println("-------------------------------------------");
            count++;
        }
    }

    // Method to exit the application
    public static void exitStudentApplication() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }

    // Helper method to get and validate student age
    public static int getValidAge(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter student age: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (age >= 16) {
                    return age;
                } else {
                    System.out.println("Invalid age. Please enter a valid age (16 or above).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
