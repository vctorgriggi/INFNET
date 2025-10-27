public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
        validarTitular(titular);
        validarSaldoNaoNegativo(saldo, "Saldo inicial");

        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        validarValorPositivo(valor, "Depósito");
        saldo += valor;
    }

    /**
     * @throws SaldoInsuficienteException se não houver saldo suficiente
     */
    public void sacar(double valor) throws SaldoInsuficienteException {
        validarValorPositivo(valor, "Saque");
        validarSaldoSuficiente(valor);

        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    // Métodos de validação privados

    private void validarTitular(String titular) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("Titular não pode ser vazio");
        }
    }

    private void validarSaldoNaoNegativo(double valor, String contexto) {
        if (valor < 0) {
            throw new IllegalArgumentException(contexto + " não pode ser negativo");
        }
    }

    private void validarValorPositivo(double valor, String operacao) {
        if (valor <= 0) {
            throw new IllegalArgumentException(operacao + " deve ser positivo");
        }
    }

    private void validarSaldoSuficiente(double valor) throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException(
                    String.format("Saldo insuficiente. Saldo atual: R$ %.2f, Valor solicitado: R$ %.2f",
                            saldo, valor)
            );
        }
    }
}

/**
 * Exception customizada para saldo insuficiente
 */
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}