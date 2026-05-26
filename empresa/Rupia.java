package empresa;

public class Rupia extends Moeda {

    private static final double TAXA = 0.060; // TAXA REFERENTE A COTAÇÃO DO DIA 28/11/2025

    public Rupia(double valor) { super(valor); }

    @Override
    public double converter() {
        return valor * TAXA;
    }

    @Override
    public String tipo() {
        return "RUPIA INDIANA";
    }
}
