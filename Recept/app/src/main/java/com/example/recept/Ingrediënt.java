package com.example.recept;

public class Ingrediënt {
    String name,unit;
    double amount;
    Ingrediënt (String name, double amount, String unit) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public double getAmount() {
        return this.amount;
    }

    public double setAmount(double newAmount) {
        this.amount = newAmount;
        return this.amount;
    }
}
