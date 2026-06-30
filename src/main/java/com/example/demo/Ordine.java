package com.example.demo;


import enums.StatoOrdine;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Ordine {
    private static final AtomicLong numero = new AtomicLong(100);

    private List<ArticoloMenu> articoliOrdine;
    private Tavolo tavolo;
    private double sommaTotale;
    private long numeroTavolo;
    private StatoOrdine statoOrdine;
    private LocalDateTime oraOrdine;
    private double prezzoCoperto;

    public Ordine(List<ArticoloMenu> articoliOrdine, Tavolo tavolo, double prezzoCoperto) {
        this.articoliOrdine = articoliOrdine;
        this.tavolo = tavolo;
        this.prezzoCoperto = prezzoCoperto;
        this.sommaTotale = getSommaOrdine();
        this.numeroTavolo = numero.getAndIncrement();
        this.statoOrdine = StatoOrdine.IN_CORSO;
        this.oraOrdine = LocalDateTime.now();
    }

    public double getSommaOrdine() {
        return this.articoliOrdine.stream().mapToDouble(articolo -> articolo.getPrice()).sum() + tavolo.getCoperti() * prezzoCoperto;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "articoliOrdine=" + articoliOrdine +
                ", tavolo=" + tavolo +
                ", sommaTotale=" + sommaTotale +
                ", numeroTavolo=" + numeroTavolo +
                ", statoOrdine=" + statoOrdine +
                ", oraOrdine=" + oraOrdine +
                '}';
    }


    public List<ArticoloMenu> getArticoliOrdine() {
        return articoliOrdine;
    }

    public void setArticoliOrdine(List<ArticoloMenu> articoliOrdine) {
        this.articoliOrdine = articoliOrdine;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }

    public void setTavolo(Tavolo tavolo) {
        this.tavolo = tavolo;
    }

    public double getSommaTotale() {
        return sommaTotale;
    }

    public void setSommaTotale(double sommaTotale) {
        this.sommaTotale = sommaTotale;
    }

    public long getNumeroTavolo() {
        return numeroTavolo;
    }

    public void setNumeroTavolo(long numeroTavolo) {
        this.numeroTavolo = numeroTavolo;
    }

    public StatoOrdine getStatoOrdine() {
        return statoOrdine;
    }

    public void setStatoOrdine(StatoOrdine statoOrdine) {
        this.statoOrdine = statoOrdine;
    }

    public LocalDateTime getOraOrdine() {
        return oraOrdine;
    }

    public void setOraOrdine(LocalDateTime oraOrdine) {
        this.oraOrdine = oraOrdine;
    }
}
