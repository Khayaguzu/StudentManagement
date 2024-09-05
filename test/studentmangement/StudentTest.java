
package studentmangement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private ArrayList<Student> students;

    @BeforeEach
    public void setup() {
        students = new ArrayList<>();
    }

    @Test
    public void testSaveStudent() {
        // Arrange
        String id = "St194";
        String name = "Khaya Guzu";
        int age = 20;
        String course = "Dsid";
        String email = "Khaya@gmail.com";
        
        // Act
        students.add(new Student(id, name, age, course, email));
        
        // Assert
        assertEquals(1, students.size());
        assertEquals(id, students.get(0).getId());
        assertEquals(name, students.get(0).getName());
        assertEquals(age, students.get(0).getAge());
        assertEquals(course, students.get(0).getCourse());
        assertEquals(email, students.get(0).getEmail());
    }

    @Test
    public void testSearchStudent() {
        // Arrange
        Student student = new Student("St099", "Gaba Doe", 20, "Dsid", "Gaba@gmail.com");
        students.add(student);
        
        // Act
        Student foundStudent = Student.searchStudent(students);
        
        // Assert
        assertNotNull(foundStudent);
        assertEquals(student.getId(), foundStudent.getId());
        assertEquals(student.getName(), foundStudent.getName());
        assertEquals(student.getAge(), foundStudent.getAge());
        assertEquals(student.getCourse(), foundStudent.getCourse());
        assertEquals(student.getEmail(), foundStudent.getEmail());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        // Act
        Student foundStudent = Student.searchStudent(students);
        
        // Assert
        assertNull(foundStudent);
    }

    @Test
    public void testDeleteStudent() {
        // Arrange
        Student student = new Student("St088", "Lwa Doe", 20, "Dsid", "Lwadoe@gmail.com");
        students.add(student);
        
        // Act
        Student.deleteStudent(students);
        
        // Assert
        assertEquals(0, students.size());
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Act
        int initialSize = students.size();
        Student.deleteStudent(students);
        
        // Assert
        assertEquals(initialSize, students.size());
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        // Act
        int age = Student.getValidAge(new Scanner("20"));
        
        // Assert
        assertEquals(20, age);
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        // Act
        int age = Student.getValidAge(new Scanner("15"));
        
        // Assert
        assertEquals(-1, age);  // Assuming the method returns -1 for invalid age
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        // Act
        int age = Student.getValidAge(new Scanner("abc"));
        
        // Assert
        assertEquals(-1, age);  // Assuming the method returns -1 for invalid input
    }
}
