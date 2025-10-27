class PagamentoException extends Exception {
    public PagamentoException(String mensagem) {
        super(mensagem);
    }
}

class ValorInvalidoException extends PagamentoException {
    public ValorInvalidoException(double valor) {
        super(String.format("Valor inválido para pagamento: R$ %.2f", valor));
    }
}

class MetodoPagamentoInvalidoException extends PagamentoException {
    public MetodoPagamentoInvalidoException(String metodo) {
        super(String.format("Método de pagamento '%s' não é suportado. " +
                "Métodos válidos: cartao, boleto", metodo));
    }
}

class FalhaProcessamentoException extends PagamentoException {
    public FalhaProcessamentoException(String metodo, String motivo) {
        super(String.format("Falha ao processar pagamento via %s: %s", metodo, motivo));
    }
}