package com.example.demo;

import java.util.List;

public class Menu {
    private List<Pizza> pizze;
    private List<Topping> extras;
    private List<Drink> bevande;

    public Menu(List<Pizza> pizze, List<Topping> extras, List<Drink> bevande) {
        this.pizze = pizze;
        this.extras = extras;
        this.bevande = bevande;
    }

    public void stampaMenu() {
        System.out.println("----------PIZZE------------");
        this.pizze.forEach(pizza -> pizza.showPizza());
        System.out.println("----------EXTRAS------------");
        this.extras.forEach(topping -> topping.showTopping());
        System.out.println("----------BEVANDE------------");
        this.bevande.forEach(drink -> drink.showDrink());
    }
}
