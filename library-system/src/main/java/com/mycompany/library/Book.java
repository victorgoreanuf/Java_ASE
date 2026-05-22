/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;

/**
 *
 * @author goreanuvictor
 */

public class Book {
    private String isbn;
    private String title;
    private boolean isAvailable;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.isAvailable = true; // Orice carte adăugată este disponibilă by default
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }

    public void checkOut() { this.isAvailable = false; }
    public void returnToLibrary() { this.isAvailable = true; }

    @Override
    public String toString() {
        return title + " (ISBN: " + isbn + ") - " + (isAvailable ? "Disponibilă" : "Împrumutată");
    }
}
