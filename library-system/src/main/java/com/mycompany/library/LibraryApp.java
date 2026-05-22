/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;

/**
 *
 * @author goreanuvictor
 */

public class LibraryApp {
    public static void main(String[] args) {
        System.out.println("=== Sistem Gestiune Bibliotecă ===");
        Library library = new Library();

        // Populam baza de date
        library.addBook(new Book("ISBN001", "Design Patterns"));
        library.addBook(new Book("ISBN002", "Clean Code"));
        library.addBook(new Book("ISBN003", "Java Concurrency"));

        library.registerMember(new Member("M01", "Victor"));
        library.registerMember(new Member("M02", "Ana"));

        library.printStatus();

        // Testare sistem de împrumut
        System.out.println("\n--- Procesare Împrumuturi ---");
        library.processLoan("M01", "ISBN001"); // Victor împrumută Design Patterns
        library.processLoan("M02", "ISBN001"); // Ana încearcă să ia aceeași carte (Va da eroare controlată)
        library.processLoan("M02", "ISBN002"); // Ana împrumută Clean Code
        
        library.printStatus();

        // Testare returnare
        System.out.println("\n--- Procesare Returnări ---");
        library.processReturn("M01", "ISBN001"); // Victor returnează cartea
        
        library.printStatus();
    }
}
