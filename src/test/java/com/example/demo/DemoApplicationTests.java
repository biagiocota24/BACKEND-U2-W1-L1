package com.example.demo;

import ch.qos.logback.classic.spi.PackagingDataCalculator;
import enums.StatoTavolo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    // Topping riutilizzabili
    private Topping prosciutto;
    private Topping ananas;
    private Topping funghi;
    private Topping salamePiccante;

    // Pizze base (senza extra aggiuntivi, solo pomodoro+mozzarella di default)
    private Pizza margherita;
    private Pizza margheritaXL;

    // Pizze con extra già aggiunti
    private Pizza hawaiian;
    private Pizza hawaiianXL;

    // Drink
    private Drink cocaCola;
    private Drink acqua;

    // Tavolo e lista articoli per test su Ordine
    private Tavolo tavolo;
    private List<ArticoloMenu> listaArticoli;
    private double prezzoCoperto;

    @BeforeEach
    void oggetti() {

        prosciutto = new Topping("Prosciutto", 1.0, 80);
        ananas = new Topping("Ananas", 0.8, 40);
        funghi = new Topping("Funghi", 0.7, 25);
        salamePiccante = new Topping("Salame piccante", 1.5, 100);

        margherita = new Pizza("Margherita", false);
        margheritaXL = new Pizza("Margherita", true);

        hawaiian = new Pizza("Hawaiian", false);
        hawaiian.addExtra(prosciutto);
        hawaiian.addExtra(ananas);

        hawaiianXL = new Pizza("Hawaiian", true);
        hawaiianXL.addExtra(prosciutto);
        hawaiianXL.addExtra(ananas);


        cocaCola = new Drink("Coca Cola", 2.5, 150, 0.33);
        acqua = new Drink("Acqua", 1.0, 0, 0.5);


        tavolo = new Tavolo(1, 2, StatoTavolo.LIBERO);
        prezzoCoperto = 2.0;


        listaArticoli = new ArrayList<>();
        listaArticoli.add(margherita);
        listaArticoli.add(hawaiianXL);
        listaArticoli.add(cocaCola);
    }

    @Test
        // CONTROLLA CHE PIZZE E CALORIE DELLE PIZZE VENGANO CALCOLATE BENE
    void calcolaCalorie_PrezzoPizzaSemplice() {
        int calorie = hawaiian.getCalories();
        double prezzo = hawaiian.getPrice();
        assertEquals(830, calorie);
        assertEquals(6.30, prezzo);
    }

    @Test
        // CONTROLLA CHE PIZZE E CALORIE DELLE PIZZE XL VENGANO CALCOLATE BENE
    void calcolaCalorie_PrezzoPizzaXL() {
        int calorieXL = hawaiianXL.getCalories();
        double prezzoXL = hawaiianXL.getPrice();
        assertEquals(830 * 1.5, calorieXL);
        assertEquals(6.30 * 1.5, prezzoXL);
    }

    @Test
    void verificaSommaTotaleOrdine() {
        Ordine ordine = new Ordine(listaArticoli, tavolo, prezzoCoperto);
        double conto = ordine.getSommaOrdine();
        double contoAmano = listaArticoli.stream().mapToDouble(articolo -> articolo.getPrice()).sum() + tavolo.getCoperti() * prezzoCoperto;
        assertEquals(contoAmano, conto);
    }

    @ParameterizedTest
    void 
}

