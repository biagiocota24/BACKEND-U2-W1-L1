package com.example.demo;

import enums.StatoTavolo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {


//      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        Menu menu = context.getBean(Menu.class);
        menu.stampaMenu();

        List<ArticoloMenu> lista = new ArrayList<>();
        lista.add(menu.getPizze().getFirst());
        lista.add(menu.getBevande().getFirst());

        Tavolo tavolo = new Tavolo(1, 2, StatoTavolo.LIBERO);


        GestoreOrdini cameriere = context.getBean(GestoreOrdini.class);

        cameriere.creaOrdine(lista, tavolo);
        System.out.println("--------------ORDINE CREATO DAL CAMERIERE------------------");
        cameriere.getListaOrdini().forEach(ordine -> System.out.println(ordine));

    }
}
