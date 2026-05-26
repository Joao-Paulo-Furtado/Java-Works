package empresa;

public class Dolar extends Moeda {

    private static final double TAXA = 5.34; // TAXA REFERENTE A COTAÇÃO DO DIA 28/11/2025

    public Dolar(double valor) { super(valor); }

    @Override
    public double converter() {
        return valor * TAXA;
    }

    @Override
    public String tipo() {
        return "DOLAR";
    }
}
