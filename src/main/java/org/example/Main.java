package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();

        Student student1 = new Student("1", "Bui Trang", "Female", "01/01/2004", "Yen Bai", "0123456789");
        Student student2 = new Student("2", "Phung Nam", "male", "02/02/2004", "Nam Dinh", "0123456789");
        Student student3 = new Student("3", "Hoang Dat", "Male", "03/03/2004", "Ha Noi", "0123456789");

        system.addStudent(student1);
        system.addStudent(student2);
        system.addStudent(student3);

        system.addGrade("1", "Math", 9.0);
        system.addGrade("1", "English", 8.0);
        system.addGrade("2", "Math", 9.5);
        system.addGrade("2", "History", 8.0);
        system.addGrade("3", "Math", 8.0);
        system.addGrade("3", "English", 8.5);

        System.out.println("Student List:");
        system.displayStudentList();

        System.out.println("Grades for Student ID 1:");
        system.displayStudentGrades("1");

        System.out.println("Average Grade for Student ID 1: " + system.calculateAverageGrade("1"));

        system.displayStudentWithHighestGrade();

        List<Student> students = Arrays.asList(student1, student2, student3);
        Set<String> commonCourses = system.findCommonCourses(students);
        System.out.println("Common Courses among Students:");
        System.out.println(commonCourses);
    }
}
