/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankaccount.bank.account.system;

/**
 *
 * @author goreanuvictor
 */
public class BankAccountSystem {

    public static void main(String[] args) {
        System.out.println("=== SISTEM BANCAR ===");

        try {
            // Crearea unui cont valid
            BankAccount account1 = new BankAccount("RO123456", 1000);
            
            // Operatiuni valide
            account1.deposit(500);
            account1.withdraw(200);

            System.out.println("\n--- Testare Excepții ---");
            
            // Testare scenariu: Sumă negativă la depunere
            try {
                account1.deposit(-100);
            } catch (InvalidAmountException e) {
                System.out.println("Excepție prinsă: " + e.getMessage());
            }

            // Testare scenariu: Fonduri insuficiente la retragere
            try {
                account1.withdraw(5000);
            } catch (InsufficientFundsException e) {
                System.out.println("Excepție prinsă: " + e.getMessage());
            }

            System.out.println("\n--- Testare Savings Account ---");
            SavingsAccount savings = new SavingsAccount("RO999999", 2000, 5.0); // 5% dobândă
            savings.applyInterest();

            // Testare scenariu: Creare cont cu sold negativ
            System.out.println("\nÎncercare creare cont invalid:");
            BankAccount invalidAccount = new BankAccount("RO000000", -50);

        } catch (InvalidAmountException | InsufficientFundsException e) {
            // Acest catch prinde excepția aruncată la crearea contului invalid de mai sus
            System.out.println("Excepție fatală prinsă: " + e.getMessage());
        }
    }
}
