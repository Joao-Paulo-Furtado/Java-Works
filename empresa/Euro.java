package empresa;

public class Euro extends Moeda {

    private static final double TAXA = 6.19; // TAXA REFERENTE A COTAÇÃO DO DIA 28/11/2025

    public Euro(double valor) { super(valor); }

    @Override
    public double converter() {
        return valor * TAXA;
    }

    @Override
    public String tipo() {
        return "EURO";
    }
}
