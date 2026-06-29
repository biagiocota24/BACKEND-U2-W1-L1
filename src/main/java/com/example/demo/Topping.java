package com.example.demo;

public class Topping extends ArticoloMenu {

    public Topping(String name, double price, int calories) {
        super(name, price, calories);
    }


    public void showTopping() {
        System.out.println(this.getName() + "      " + this.getCalories() + "      " + this.getPrice());
    }


}
