/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehicle_managment_system;

/**
 *
 * @author goreanuvictor
 */

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String id, String brand, double speed, int mileage, boolean hasSidecar) {
        super(id, brand, speed, mileage);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 6000;
    }

    @Override
    public double rentalPrice(int days) {
        double price = 30.0 * days;
        if (hasSidecar) {
            price += 15.0 * days;
        }
        return price;
    }

    @Override
    public void move() {
        System.out.println("Motocicleta " + getBrand() + " se strecoară prin trafic la " + getSpeed() + " km/h.");
    }
}
