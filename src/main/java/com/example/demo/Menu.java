package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
        this.pizze.stream().filter(pizza -> pizza.isXL() == false).forEach(pizza -> pizza.showPizza());
        System.out.println("----------PIZZE-XL------------");
        this.pizze.stream().filter(pizza -> pizza.isXL() == true).forEach(pizza -> pizza.showPizza());
        System.out.println("----------EXTRAS------------");
        this.extras.forEach(topping -> topping.showTopping());
        System.out.println("----------BEVANDE------------");
        this.bevande.forEach(drink -> drink.showDrink());
    }

    public List<Pizza> getPizze() {
        return this.pizze.stream().filter(pizza -> pizza.isXL() == false).toList();
    }

    public List<Pizza> getPizzeXL() {
        return this.pizze.stream().filter(pizza -> pizza.isXL() == true).toList();
    }

    public void setPizze(List<Pizza> pizze) {
        this.pizze = pizze;
    }

    public List<Topping> getExtras() {
        return extras;
    }

    public void setExtras(List<Topping> extras) {
        this.extras = extras;
    }

    public List<Drink> getBevande() {
        return bevande;
    }

    public void setBevande(List<Drink> bevande) {
        this.bevande = bevande;
    }
}
