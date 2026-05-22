/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jdbc;

/**
 *
 * @author goreanuvictor
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMoviesCrud {
    
    private static final String JDBC_URL = "jdbc:h2:mem:moviesdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            System.out.println("Conexiune la baza de date reușită!");

            createTable(conn);

            System.out.println("\n--- Adăugare filme (CREATE) ---");
            insertMovie(conn, new Movie("Interstellar", "Christopher Nolan", 2014));
            insertMovie(conn, new Movie("The Matrix", "Lana & Lilly Wachowski", 1999));
            insertMovie(conn, new Movie("Inception", "Christopher Nolan", 2010));

            System.out.println("\n--- Lista filme (READ) ---");
            printAllMovies(conn);

            System.out.println("\n--- Actualizare film cu ID-ul 2 (UPDATE) ---");
            updateMovieYear(conn, 2, 2000); // Modificăm anul pentru Matrix
            printAllMovies(conn);

            System.out.println("\n--- Ștergere film cu ID-ul 3 (DELETE) ---");
            deleteMovie(conn, 3);
            printAllMovies(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS movies (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY, " +
                     "title VARCHAR(255) NOT NULL, " +
                     "director VARCHAR(255), " +
                     "release_year INT)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabelul 'movies' a fost creat (sau exista deja).");
        }
    }
    
    private static void insertMovie(Connection conn, Movie movie) throws SQLException {
        String sql = "INSERT INTO movies (title, director, release_year) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getDirector());
            pstmt.setInt(3, movie.getReleaseYear());
            pstmt.executeUpdate();
        }
    }
    
    private static void printAllMovies(Connection conn) throws SQLException {
        String sql = "SELECT * FROM movies";
        List<Movie> movies = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                movies.add(new Movie(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("director"),
                    rs.getInt("release_year")
                ));
            }
        }
        
        if (movies.isEmpty()) {
            System.out.println("Nu există filme în baza de date.");
        } else {
            for (Movie m : movies) {
                System.out.println(m);
            }
        }
    }
    
    private static void updateMovieYear(Connection conn, int id, int newYear) throws SQLException {
        String sql = "UPDATE movies SET release_year = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newYear);
            pstmt.setInt(2, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Filmul cu ID-ul " + id + " a fost actualizat.");
            }
        }
    }

    private static void deleteMovie(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM movies WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Filmul cu ID-ul " + id + " a fost șters.");
            }
        }
    }
}
