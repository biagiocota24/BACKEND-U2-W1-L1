package com.example.demo;

import enums.StatoTavolo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestoreOrdini {
    private List<Ordine> listaOrdini;
    private Menu menu;

    @Value("${ristorante.prezzoCoperto}")
    private double prezzoCoperto;


    public GestoreOrdini(Menu menu) {
        this.menu = menu;
        this.listaOrdini = new ArrayList<>();
    }

    public void creaOrdine(List<ArticoloMenu> listaArticoli, Tavolo tavolo) {
        Ordine nuovoOrdine = new Ordine(listaArticoli, tavolo, prezzoCoperto);
        this.listaOrdini.add(nuovoOrdine);
        tavolo.setStatoTavolo(StatoTavolo.OCCUPATO);
    }


    public List<Ordine> getListaOrdini() {
        return listaOrdini;
    }

    public void setListaOrdini(List<Ordine> listaOrdini) {
        this.listaOrdini = listaOrdini;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
