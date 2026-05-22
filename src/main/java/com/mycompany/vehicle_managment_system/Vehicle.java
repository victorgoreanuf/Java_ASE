/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehicle_managment_system;

/**
 *
 * @author goreanuvictor
 */

public abstract class Vehicle {
    private String id;
    private String brand;
    private double speed;
    private int mileage;
    private boolean rented;

    public Vehicle(String id, String brand, double speed, int mileage) {
        this.id = id;
        this.brand = brand;
        this.speed = speed;
        this.mileage = mileage;
        this.rented = false;
    }

    public void move() {
        System.out.println("Vehiculul " + brand + " se deplasează cu " + speed + " km/h.");
    }

    public void rent() {
        if (rented) {
            throw new IllegalStateException("Eroare: Vehiculul " + id + " este deja închiriat!");
        }
        rented = true;
        System.out.println("Vehiculul " + brand + " (ID: " + id + ") a fost închiriat cu succes.");
    }

    public void returnVehicle(int drivenKm) {
        if (!rented) {
            throw new IllegalStateException("Eroare: Vehiculul " + id + " nu este închiriat în prezent!");
        }
        if (drivenKm <= 0) {
            throw new IllegalArgumentException("Eroare: Distanța condusă trebuie să fie mai mare decât 0.");
        }
        mileage += drivenKm;
        rented = false;
        System.out.println("Vehiculul " + brand + " (ID: " + id + ") a fost returnat. Noul rulaj: " + mileage + " km.");
    }

    public abstract boolean needsService();
    public abstract double rentalPrice(int days);

    public String getId() { return id; }
    public String getBrand() { return brand; }
    public double getSpeed() { return speed; }
    public int getMileage() { return mileage; }
    public boolean isRented() { return rented; }
}
