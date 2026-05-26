package empresa;

public abstract class Moeda {

    protected double valor;

    public Moeda(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public abstract double converter();
    public abstract String tipo();

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Moeda)) return false;
        Moeda m = (Moeda) obj;
        return this.getClass() == m.getClass() &&
               Math.abs(this.valor - m.valor) < 0.0001;
    }
}
