package com.example.recept;

public class Ingrediënt {
    String name,unit;
    float amount;
    Ingrediënt (String name, float amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public String getName() {
        return this.name;
    }

    public float getAmount() {
        return this.amount;
    }

    public String getUnit() {
        return this.unit;
    }

    public float setAmount(float newAmount) {
        this.amount = newAmount;
        return this.amount;
    }
}
