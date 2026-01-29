package com.klu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id;
    private String name;
    private String gender;

    @Autowired
    private Certification certification;   // AUTOWIRING

    public Student() {
        this.id = 910;
        this.name = "Poojitha Battu";
        this.gender = "Female";
    }

    public void display() {
        System.out.println("Student ID   : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Gender       : " + gender);
        certification.display();
    }
}