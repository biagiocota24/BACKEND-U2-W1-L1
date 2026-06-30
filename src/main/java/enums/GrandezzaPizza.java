package enums;

public enum GrandezzaPizza {
    NORMALE(1.0), XL(1.5);

    private final double moltiplicatore;

    GrandezzaPizza(double moltiplicatore) {
        this.moltiplicatore = moltiplicatore;
    }

    public double getMoltiplicatore() {
        return moltiplicatore;
    }
}
