public class Conta {
    private String titular;
    private double saldo;

    public Conta(String titular, double saldoInicial) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("Titular não pode ser vazio");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo");
        }

        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public boolean temSaldoSuficiente(double valor) {
        return saldo >= valor;
    }

    public void debitar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
        if (!temSaldoSuficiente(valor)) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo -= valor;
    }

    public void creditar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
        saldo += valor;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return String.format("%s - Saldo: R$ %.2f", titular, saldo);
    }
}