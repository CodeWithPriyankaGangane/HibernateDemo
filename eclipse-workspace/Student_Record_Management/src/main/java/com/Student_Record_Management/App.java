package com.Student_Record_Management;

import java.util.List;
import java.util.Scanner;

import com.Student_Record_Management.Entity.Student;
import com.Student_Record_Management.Utility.StudentDAO;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Marks by ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student s = new Student();
                    System.out.print("Enter name: ");
                    s.setName(sc.next());
                    System.out.print("Enter email: ");
                    s.setEmail(sc.next());
                    System.out.print("Enter course: ");
                    s.setCourse(sc.next());
                    System.out.print("Enter marks: ");
                    s.setMarks(sc.nextInt());
                    dao.addStudent(s);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int idToUpdate = sc.nextInt();
                    System.out.print("Enter new marks: ");
                    int newMarks = sc.nextInt();
                    dao.updateMarksById(idToUpdate, newMarks);
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int idToDelete = sc.nextInt();
                    dao.deleteStudent(idToDelete);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
