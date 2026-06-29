package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza extends ArticoloMenu {
    private List<Topping> extras;

    public Pizza(String name, double price) {
        super(name, price, 600);
        this.extras = new ArrayList<>();
        this.extras.add(new Topping("Pomodoro", 0, 40));
        this.extras.add(new Topping("mozzarella", 0, 70));
    }

    public List<Topping> getExtras() {
        return extras;
    }

    public void addExtra(Topping extra) {
        this.extras.add(extra);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + this.extras.stream().mapToDouble(topping -> topping.getPrice()).sum();
    }

    @Override
    public int getCalories() {
        return super.getCalories() + this.extras.stream().mapToInt(topping -> topping.getCalories()).sum();
    }

    public void showPizza() {
        String nomiTopping = this.extras.stream().map(topping -> topping.getName()).collect(Collectors.joining(", "));
        System.out.println(this.getName() + "(" + nomiTopping + ")" + "      " + this.getCalories() + "      " + this.getPrice());
    }
}
