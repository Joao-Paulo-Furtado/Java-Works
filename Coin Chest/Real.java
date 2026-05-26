package empresa;

public class Real extends Moeda {

    public Real(double valor) { super(valor); }

    @Override
    public double converter() {
        return valor; // SEM OPERAÇÃO NECESSARIA
    }

    @Override
    public String tipo() {
        return "REAL";
    }
}
