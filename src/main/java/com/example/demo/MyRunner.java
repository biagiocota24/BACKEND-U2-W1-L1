package com.example.demo;

import enums.StatoTavolo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    private Menu menu;
    private GestoreOrdini gestoreOrdini;

    public MyRunner(Menu menu, GestoreOrdini gestoreOrdini) {
        this.menu = menu;
        this.gestoreOrdini = gestoreOrdini;
    }

    @Override
    public void run(String... args) throws Exception {
        menu.stampaMenu();

        List<ArticoloMenu> lista = new ArrayList<>();
        lista.add(menu.getPizze().getFirst());
        lista.add(menu.getPizzeXL().getFirst());
        lista.add(menu.getBevande().getFirst());

        Tavolo tavolo = new Tavolo(1, 2, StatoTavolo.LIBERO);

        gestoreOrdini.creaOrdine(lista, tavolo);

        System.out.println("----------------ORDINE CREATO DAL CAMERIERE-------------------");
        gestoreOrdini.getListaOrdini().forEach(ordine -> ordine.showOrdine());

    }
}
