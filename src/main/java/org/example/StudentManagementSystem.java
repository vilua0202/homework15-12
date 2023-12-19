package org.example;

import java.util.*;

class StudentManagementSystem {
    private List<Student> studentList;

    public StudentManagementSystem() {
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void displayStudentList() {
        for (Student student : studentList) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Gender: " + student.getGender());
            System.out.println("Date of Birth: " + student.getDateOfBirth());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Contact Number: " + student.getContactNumber());
            System.out.println("Courses: " + student.getCourses());
            System.out.println("Grades: " + student.getGrades());
            System.out.println();
        }
    }

    public void addGrade(String studentId, String course, double grade) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                student.getCourses().add(course);
                student.getGrades().put(course, grade);
            }
        }
    }

    public void displayStudentGrades(String studentId) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println("Grades for Student ID " + studentId + ":");
                for (Map.Entry<String, Double> entry : student.getGrades().entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }
    }

    public double calculateAverageGrade(String studentId) {
        double total = 0;
        int count = 0;
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                for (double grade : student.getGrades().values()) {
                    total += grade;
                    count++;
                }
            }
        }
        return count > 0 ? total / count : 0;
    }

    public void displayStudentWithHighestGrade() {
        double highestGrade = 0;
        Student studentWithHighestGrade = null;

        for (Student student : studentList) {
            for (double grade : student.getGrades().values()) {
                if (grade > highestGrade) {
                    highestGrade = grade;
                    studentWithHighestGrade = student;
                }
            }
        }

        if (studentWithHighestGrade != null) {
            System.out.println("Student with the highest grade:");
            System.out.println("Student ID: " + studentWithHighestGrade.getStudentId());
            System.out.println("Name: " + studentWithHighestGrade.getName());
            System.out.println("Highest Grade: " + highestGrade);
        } else {
            System.out.println("No students found.");
        }
    }

    public Set<String> findCommonCourses(List<Student> students) {
        if (students.size() == 0) {
            return new HashSet<>();
        }

        Set<String> commonCourses = new HashSet<>(students.get(0).getCourses());

        for (Student student : students) {
            commonCourses.retainAll(student.getCourses());
        }

        return commonCourses;
    }
}
