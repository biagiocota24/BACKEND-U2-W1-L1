package com.example.demo;

import enums.GrandezzaPizza;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza extends ArticoloMenu {
    private List<Topping> extras;
    private boolean isXL;

    public Pizza(String name, boolean isXL) {
        super(name, 4.50, 600);
        this.extras = new ArrayList<>();
        this.extras.add(new Topping("Pomodoro", 0, 40));
        this.extras.add(new Topping("mozzarella", 0, 70));
        this.isXL = isXL;
    }

    public List<Topping> getExtras() {
        return extras;
    }

    public void addExtra(Topping extra) {
        this.extras.add(extra);
    }

    @Override
    public double getPrice() {
        double somma = super.getPrice() + this.extras.stream().mapToDouble(topping -> topping.getPrice()).sum();
        if (!this.isXL) return somma;
        else return somma * 1.5;
    }

    @Override
    public int getCalories() {
        int calorie = super.getCalories() + this.extras.stream().mapToInt(topping -> topping.getCalories()).sum();
        if (!this.isXL) return calorie;
        else return (int) (calorie * 1.5);
    }

    public void showPizza() {
        String nomiTopping = this.extras.stream().map(topping -> topping.getName()).collect(Collectors.joining(", "));
        System.out.println("- " + this.getName() + "(" + nomiTopping + ")" + "      " + this.getCalories() + "      " + this.getPrice() + "€");
    }

    public void setExtras(List<Topping> extras) {
        this.extras = extras;
    }

    public boolean isXL() {
        return isXL;
    }

    public void setXL(boolean XL) {
        isXL = XL;
    }
}
