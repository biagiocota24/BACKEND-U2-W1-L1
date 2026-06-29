package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    // ===================== TOPPINGS =====================

    @Bean
    public Topping prosciutto() {
        return new Topping("Prosciutto", 1.0, 80);
    }

    @Bean
    public Topping ananas() {
        return new Topping("Ananas", 0.8, 40);
    }

    @Bean
    public Topping funghi() {
        return new Topping("Funghi", 0.7, 25);
    }

    @Bean
    public Topping wurstel() {
        return new Topping("Wurstel", 1.2, 120);
    }

    @Bean
    public Topping gorgonzola() {
        return new Topping("Gorgonzola", 1.1, 90);
    }

    @Bean
    public Topping salamePiccante() {
        return new Topping("Salame piccante", 1.5, 100);
    }

    // ===================== PIZZE =====================

    @Bean
    public Pizza margherita() {
        return new Pizza("Margherita");
        // nessun extra: solo pomodoro e mozzarella, come da base dell'esercizio
    }

    @Bean
    public Pizza hawaiian(Topping prosciutto, Topping ananas) {
        Pizza p = new Pizza("Hawaiian");
        p.addExtra(prosciutto);
        p.addExtra(ananas);
        return p;
    }

    @Bean
    public Pizza boscaiola(Topping funghi, Topping wurstel) {
        Pizza p = new Pizza("Boscaiola");
        p.addExtra(funghi);
        p.addExtra(wurstel);
        return p;
    }

    @Bean
    public Pizza doppioProsciutto(Topping prosciutto) {
        Pizza p = new Pizza("Doppio Prosciutto");
        p.addExtra(prosciutto);
        p.addExtra(prosciutto); // stesso bean, aggiunto due volte
        return p;
    }

    @Bean
    public Pizza quattroGusti(Topping prosciutto, Topping funghi, Topping gorgonzola, Topping ananas) {
        Pizza p = new Pizza("Quattro Gusti");
        p.addExtra(prosciutto);
        p.addExtra(funghi);
        p.addExtra(gorgonzola);
        p.addExtra(ananas);
        return p;
    }

    @Bean
    public Pizza diavola(Topping salamePiccante) {
        Pizza p = new Pizza("Diavola");
        p.addExtra(salamePiccante);
        return p;
    }
    // ===================== DRINKS =====================

    @Bean
    public Drink colaDrink() {
        return new Drink("Coca Cola", 2.5, 150, 0.33);
    }

    @Bean
    public Drink acquaDrink() {
        return new Drink("Acqua", 1.0, 0, 0.5);
    }

    @Bean
    public Drink aranciataDrink() {
        return new Drink("Aranciata", 2.5, 140, 0.33);
    }

    @Bean
    public Drink birraDrink() {
        return new Drink("Birra", 3.5, 200, 0.33);
    }

    @Bean
    public Drink teDrink() {
        return new Drink("Tè Freddo", 2.5, 90, 0.33);
    }

    @Bean
    public Menu menu(List<Pizza> pizze, List<Topping> extras, List<Drink> drinks) {
        return new Menu(pizze, extras, drinks);
    }
}