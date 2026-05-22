/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankaccount.bank.account.system;

/**
 *
 * @author goreanuvictor
 */

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) throws InvalidAmountException {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        try {
            deposit(interest);
            System.out.println("Dobânda a fost aplicată cu succes.");
        } catch (InvalidAmountException e) {
            System.out.println("Eroare la aplicarea dobânzii: " + e.getMessage());
        }
    }
}