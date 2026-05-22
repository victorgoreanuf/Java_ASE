/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reflection;

/**
 *
 * @author goreanuvictor
 */

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionTasks {

    public static void main(String[] args) {
        try {
            Class<?> studentClass = Student.class;

            System.out.println("=== 1. Print class information ===");
            System.out.println("Class Name: " + studentClass.getSimpleName());
            System.out.println("Package: " + studentClass.getPackageName());
            System.out.println("Superclass: " + studentClass.getSuperclass().getName());
            System.out.println("Interfaces: " + Arrays.toString(studentClass.getInterfaces()));

            System.out.println("\n=== 2. List all fields ===");
            for (Field field : studentClass.getDeclaredFields()) {
                System.out.println("Field: " + field.getName() + " | Type: " + field.getType().getSimpleName() + " | Modifier: " + Modifier.toString(field.getModifiers()));
            }

            System.out.println("\n=== 3. List all methods ===");
            for (Method method : studentClass.getDeclaredMethods()) {
                System.out.println("Method: " + method.getName() + " | Return: " + method.getReturnType().getSimpleName() + " | Modifiers: " + Modifier.toString(method.getModifiers()));
            }

            System.out.println("\n=== 4. Create an object dynamically ===");
            Constructor<?> defaultConstructor = studentClass.getDeclaredConstructor();
            Object dynamicStudent = defaultConstructor.newInstance();
            System.out.println("Created: " + dynamicStudent);

            System.out.println("\n=== 5. Call a public method ===");
            Method sayHelloMethod = studentClass.getMethod("sayHello");
            sayHelloMethod.invoke(dynamicStudent);

            System.out.println("\n=== 6. Access a private field ===");
            Field nameField = studentClass.getDeclaredField("name");
            nameField.setAccessible(true); // Permitem accesul la field-ul private
            System.out.println("Vechiul nume: " + nameField.get(dynamicStudent));
            nameField.set(dynamicStudent, "Victor");
            System.out.println("Noul nume: " + nameField.get(dynamicStudent));

            System.out.println("\n=== 7. Invoke a private method ===");
            Method secretMethod = studentClass.getDeclaredMethod("secretMethod");
            secretMethod.setAccessible(true);
            secretMethod.invoke(dynamicStudent);

            System.out.println("\n=== 8. Constructor selection ===");
            Constructor<?> constructor1 = studentClass.getDeclaredConstructor(String.class);
            Object student1 = constructor1.newInstance("Ana");
            System.out.println("Student(String): " + student1);

            Constructor<?> constructor2 = studentClass.getDeclaredConstructor(String.class, int.class);
            Object student2 = constructor2.newInstance("Bogdan", 22);
            System.out.println("Student(String, int): " + student2);

            System.out.println("\n=== 9. Build a simple object inspector ===");
            inspect(student2);

            System.out.println("\n=== 10. JSON serializer ===");
            System.out.println(toJson(student2));

            System.out.println("\n=== 11. CSV mapper ===");
            String csvHeaders = "name, age, university";
            String csvRow = "Cristi, 25, Politehnica";
            Student csvStudent = fromCsv(csvHeaders, csvRow, Student.class);
            System.out.println("Mapped from CSV: " + csvStudent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void inspect(Object obj) throws IllegalAccessException {
        System.out.println("Inspecting object of class: " + obj.getClass().getSimpleName());
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println("  - " + field.getName() + " = " + field.get(obj));
        }
    }
    
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\":");
            
            Object value = fields[i].get(obj);
            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }
            if (i < fields.length - 1) json.append(",");
        }
        json.append("}");
        return json.toString();
    }
    
    public static <T> T fromCsv(String headers, String row, Class<T> clazz) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance(); // Creăm obiect gol
        String[] headerArray = headers.split(",");
        String[] rowArray = row.split(",");

        for (int i = 0; i < headerArray.length; i++) {
            String fieldName = headerArray[i].trim();
            String value = rowArray[i].trim();

            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                Class<?> type = field.getType();

                if (type == int.class || type == Integer.class) {
                    field.set(obj, Integer.parseInt(value));
                } else if (type == String.class) {
                    field.set(obj, value);
                }
            } catch (NoSuchFieldException e) {
                // Ignorăm coloanele din CSV care nu există ca variabile în clasă
            }
        }
        return obj;
    }
}
