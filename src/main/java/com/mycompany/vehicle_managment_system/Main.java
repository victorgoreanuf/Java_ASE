/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vehicle_managment_system;

/**
 *
 * @author goreanuvictor
 */
public class Main {

    public static void main(String[] args) {
        // Punctul 3: Demonstrarea polimorfismului într-un array simplu
        System.out.println("=== 3) DEMONSTRARE POLIMORFISM ===");
        Vehicle[] polyVehicles = new Vehicle[3];
        polyVehicles[0] = new Car("C999", "Skoda Octavia", 200, 1500, 4);
        polyVehicles[1] = new Motorcycle("M999", "Yamaha R1", 280, 500, false);
        polyVehicles[2] = new Truck("T999", "Volvo FH", 90, 8000, 18000);
        
        for (Vehicle v : polyVehicles) {
            v.move(); // Polimorfism: se apelează metoda specifică fiecărei clase copil
        }

        // Punctul 4: Compararea a 2 mașini folosind .equals()
        System.out.println("\n=== 4) COMPARARE MAȘINI (.equals) ===");
        Car car1 = new Car("C001", "Dacia Logan", 160, 5000, 4);
        Car car2 = new Car("C002", "Dacia Logan", 160, 8000, 4);
        Car car3 = new Car("C003", "Ford Focus", 180, 2000, 4);
        
        System.out.println("car1 equals car2 (Același brand/viteză/uși): " + car1.equals(car2)); // true
        System.out.println("car1 equals car3: " + car1.equals(car3)); // false

        // Punctul 8: Demo pentru Garage
        System.out.println("\n=== 8) DEMO GARAGE ===");
        Garage myGarage = new Garage(10);

        // Adăugare a 5 vehicule
        myGarage.add(car1);
        myGarage.add(new Car("C004", "BMW Seria 3", 220, 11000, 2)); // Peste 10k -> are nevoie de service
        myGarage.add(new Motorcycle("M001", "Honda CB500", 180, 6500, true)); // Peste 6k -> are nevoie de service
        myGarage.add(new Truck("T001", "MAN TGX", 110, 14000, 20000));
        myGarage.add(polyVehicles[0]); // Adăugăm și Skoda dinainte (ID: C999)

        // Încercare de adăugare duplicat
        myGarage.add(new Car("C001", "Altă Dacie", 100, 0, 4));

        System.out.println("\n--- Estimări prețuri ---");
        myGarage.printRentalEstimate("C001", 3); // Dacia (50 * 3 + 10% din cauza celor 4 uși)
        myGarage.printRentalEstimate("T001", 2); // Truck

        // Închiriere 2 vehicule
        System.out.println("\n--- Închiriere ---");
        myGarage.rentById("C001");
        myGarage.rentById("M001");
        
        // Încercare de a închiria din nou același vehicul (va prinde excepția)
        myGarage.rentById("C001");

        myGarage.printAvailable();

        System.out.println("\n--- Returnare ---");
        myGarage.returnById("C001", 350); // Adaugă 350 km la Dacia
        
        myGarage.printNeedsService();
    }
}
