/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;

/**
 *
 * @author goreanuvictor
 */

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> catalog;
    private List<Member> members;

    public Library() {
        catalog = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        catalog.add(book);
        System.out.println("Adăugată în catalog: " + book.getTitle());
    }

    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Membru înregistrat: " + member.getName());
    }

    // Aici validăm și procesăm tranzacția
    public void processLoan(String memberId, String isbn) {
        Member member = findMember(memberId);
        Book book = findBook(isbn);

        if (member == null) {
            System.out.println("Eroare: Membrul nu a fost găsit.");
            return;
        }
        if (book == null) {
            System.out.println("Eroare: Cartea nu există în catalog.");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Eroare: Cartea '" + book.getTitle() + "' este deja împrumutată.");
            return;
        }

        // Actualizăm ambele capete ale relației
        book.checkOut();
        member.borrowBook(book);
        System.out.println("Succes: " + member.getName() + " a împrumutat '" + book.getTitle() + "'.");
    }

    public void processReturn(String memberId, String isbn) {
        Member member = findMember(memberId);
        Book book = findBook(isbn);

        if (member != null && book != null && member.getBorrowedBooks().contains(book)) {
            book.returnToLibrary();
            member.returnBook(book);
            System.out.println("Succes: '" + book.getTitle() + "' a fost returnată de " + member.getName() + ".");
        } else {
            System.out.println("Eroare la returnare: Date invalide sau cartea nu aparține acestui membru.");
        }
    }

    private Member findMember(String id) {
        for (Member m : members) {
            if (m.getId().equals(id)) return m;
        }
        return null;
    }

    private Book findBook(String isbn) {
        for (Book b : catalog) {
            if (b.getIsbn().equals(isbn)) return b;
        }
        return null;
    }
    
    public void printStatus() {
        System.out.println("\n--- Status Bibliotecă ---");
        for (Book b : catalog) System.out.println(b);
        System.out.println("-------------------------");
    }
}
