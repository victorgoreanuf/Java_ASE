/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jdbc;

/**
 *
 * @author goreanuvictor
 */

public class Movie {
    private int id;
    private String title;
    private String director;
    private int releaseYear;

    public Movie(int id, String title, String director, int releaseYear) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    // Constructor fără ID (folosit când inserăm în baza de date, ID-ul fiind auto-generat)
    public Movie(String title, String director, int releaseYear) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public int getReleaseYear() { return releaseYear; }

    @Override
    public String toString() {
        return "ID: " + id + " | Film: " + title + " | Regizor: " + director + " | An: " + releaseYear;
    }
}
