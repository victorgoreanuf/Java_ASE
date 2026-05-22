/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehicle_managment_system;

/**
 *
 * @author goreanuvictor
 */

public class Garage {
    private Vehicle[] fleet;
    private int size;

    public Garage(int capacity) {
        fleet = new Vehicle[capacity];
        size = 0;
    }

    public boolean add(Vehicle v) {
        if (size >= fleet.length) {
            System.out.println("Eroare: Garajul este plin!");
            return false;
        }
        if (findById(v.getId()) != null) {
            System.out.println("Eroare: Un vehicul cu ID-ul " + v.getId() + " există deja!");
            return false;
        }
        fleet[size++] = v;
        System.out.println("Vehiculul " + v.getBrand() + " a fost adăugat cu succes.");
        return true;
    }

    public Vehicle findById(String id) {
        for (int i = 0; i < size; i++) {
            if (fleet[i].getId().equals(id)) {
                return fleet[i];
            }
        }
        return null;
    }

    public void rentById(String id) {
        Vehicle v = findById(id);
        if (v != null) {
            try {
                v.rent();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Vehiculul cu ID-ul " + id + " nu a fost găsit.");
        }
    }

    public void returnById(String id, int drivenKm) {
        Vehicle v = findById(id);
        if (v != null) {
            try {
                v.returnVehicle(drivenKm);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Vehiculul cu ID-ul " + id + " nu a fost găsit.");
        }
    }

    public void printAvailable() {
        System.out.println("\n--- Vehicule Disponibile ---");
        for (int i = 0; i < size; i++) {
            if (!fleet[i].isRented()) {
                System.out.println("- " + fleet[i].getBrand() + " (ID: " + fleet[i].getId() + ")");
            }
        }
    }

    public void printNeedsService() {
        System.out.println("\n--- Vehicule care necesită service ---");
        for (int i = 0; i < size; i++) {
            if (fleet[i].needsService()) {
                System.out.println("- " + fleet[i].getBrand() + " (Rulaj: " + fleet[i].getMileage() + " km)");
            }
        }
    }

    public void printRentalEstimate(String id, int days) {
        Vehicle v = findById(id);
        if (v != null) {
            System.out.println("Estimare preț pentru " + v.getBrand() + " pe " + days + " zile: " + v.rentalPrice(days) + " USD");
        } else {
            System.out.println("Vehiculul nu a fost găsit pentru estimare.");
        }
    }
}