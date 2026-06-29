package com.example.demo;

public class Drink extends ArticoloMenu {
    private double size;

    public Drink(String name, double price, int calories, double size) {
        super(name, price, calories);
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void showDrink() {
        System.out.println(this.getName() + " (" + this.size + "l)" + "      " + this.getCalories() + "      " + this.getPrice());
    }
}
