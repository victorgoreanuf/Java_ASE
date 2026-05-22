/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehicle_managment_system;

/**
 *
 * @author goreanuvictor
 */

import java.util.Objects;

public class Car extends Vehicle {
    private int doors;

    public Car(String id, String brand, double speed, int mileage, int doors) {
        super(id, brand, speed, mileage);
        this.doors = doors;
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 10000;
    }

    @Override
    public double rentalPrice(int days) {
        double basePrice = 50.0 * days;
        if (doors >= 4) {
            basePrice += basePrice * 0.10; // +10%
        }
        return basePrice;
    }

    @Override
    public void move() {
        System.out.println("Mașina " + getBrand() + " accelerează până la " + getSpeed() + " km/h.");
    }

    // Compararea a 2 mașini
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        // Considerăm 2 mașini la fel dacă au același brand, viteză și număr de uși
        return Double.compare(car.getSpeed(), getSpeed()) == 0 &&
               doors == car.doors &&
               Objects.equals(getBrand(), car.getBrand());
    }
}
