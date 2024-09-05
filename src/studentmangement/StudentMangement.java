/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmangement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class StudentMangement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("*****************************************************");
        System.out.print("ENTER (1) to launch the menu or any other key to exit: ");
        
        String input = scanner.nextLine();
        if (!input.equals("1")) {
            System.out.println("Exiting application!");
            System.exit(0);
        }
        
        ArrayList<Student> students = new ArrayList<>();
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Capture new student");
            System.out.println("2. Search for student");
            System.out.println("3. Delete student");
            System.out.println("4. View student report");
            System.out.println("5. Exit application");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            switch (choice) {
                case 1:
                    Student.saveStudent(students);
                    break;
                case 2:
                    Student student = Student.searchStudent(students);
                    if (student != null) {
                        System.out.println("Student found:");
                        System.out.println("ID: " + student.getId());
                        System.out.println("Name: " + student.getName());
                        System.out.println("Age: " + student.getAge());
                        System.out.println("Course: " + student.getCourse());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    Student.deleteStudent(students);
                    break;
                case 4:
                    Student.studentReport(students);
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

} 
   
       
    
    
