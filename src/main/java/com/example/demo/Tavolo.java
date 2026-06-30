package com.example.demo;

import enums.StatoTavolo;

public class Tavolo {
    private int numeroTavolo;
    private int coperti;
    private StatoTavolo statoTavolo;

    public Tavolo(int numeroTavolo, int coperti, StatoTavolo statoTavolo) {
        this.numeroTavolo = numeroTavolo;
        this.coperti = coperti;
        this.statoTavolo = statoTavolo;
    }

    public int getNumeroTavolo() {
        return numeroTavolo;
    }

    public void setNumeroTavolo(int numeroTavolo) {
        this.numeroTavolo = numeroTavolo;
    }

    public int getCoperti() {
        return coperti;
    }

    public void setCoperti(int coperti) {
        this.coperti = coperti;
    }

    public StatoTavolo getStatoTavolo() {
        return statoTavolo;
    }

    public void setStatoTavolo(StatoTavolo statoTavolo) {
        this.statoTavolo = statoTavolo;
    }
}
