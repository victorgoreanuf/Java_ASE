/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehicle_managment_system;

/**
 *
 * @author goreanuvictor
 */

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String id, String brand, double speed, int mileage, double loadCapacity) {
        super(id, brand, speed, mileage);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 15000;
    }

    @Override
    public double rentalPrice(int days) {
        return (80.0 + 0.02 * loadCapacity) * days;
    }

    @Override
    public void move() {
        System.out.println("Camionul " + getBrand() + " transportă marfă grea la " + getSpeed() + " km/h.");
    }
}