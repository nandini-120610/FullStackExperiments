package com.skill4.DI;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private int studentId;
    private String name;
    private String course;
    private int year;

    // Default constructor (needed for annotation configuration)
    public Student() {
    }

    // Constructor Injection (for XML configuration)
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    // Setter Injection
    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Year: " + year);
    }
}