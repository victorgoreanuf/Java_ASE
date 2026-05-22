/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankaccount.bank.account.system;

/**
 *
 * @author goreanuvictor
 */

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) throws InvalidAmountException {
        if (initialBalance < 0) {
            throw new InvalidAmountException("Eroare: Soldul inițial nu poate fi negativ!");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        System.out.println("Contul " + accountNumber + " a fost creat cu soldul: " + initialBalance);
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Eroare: Suma depusă trebuie să fie mai mare decât 0!");
        }
        balance += amount;
        System.out.println("S-au depus " + amount + " în contul " + accountNumber + ". Sold nou: " + balance);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Eroare: Suma retrasă trebuie să fie mai mare decât 0!");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Eroare: Fonduri insuficiente! Sold curent: " + balance);
        }
        balance -= amount;
        System.out.println("S-au retras " + amount + " din contul " + accountNumber + ". Sold nou: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}