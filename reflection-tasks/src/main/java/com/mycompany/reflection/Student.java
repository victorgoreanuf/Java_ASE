/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reflection;

/**
 *
 * @author goreanuvictor
 */

import java.io.Serializable;

// Implementăm interfața doar pentru a demonstra Task-ul 1
public class Student implements Serializable {
    private String name;
    private int age;
    public String university = "ASE";

    // Constructori (Task 8)
    public Student() {
        this.name = "Necunoscut";
        this.age = 0;
    }

    public Student(String name) {
        this.name = name;
        this.age = 20;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Metode publice (Task 5)
    public void sayHello() {
        System.out.println("Salut! Eu sunt " + name);
    }

    // Metode private (Task 7)
    private void secretMethod() {
        System.out.println("Metodă privată apelată! " + name + " are " + age + " ani.");
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", university='" + university + '\'' + '}';
    }
}
