public class Pagamento {

    /**
     * @param valor Valor do pagamento
     * @param metodo Método de pagamento ("cartao" ou "boleto")
     * @throws ValorInvalidoException se valor for inválido
     * @throws MetodoPagamentoInvalidoException se método não for suportado
     * @throws FalhaProcessamentoException se houver falha no processamento
     */
    public void processarPagamento(double valor, String metodo)
            throws ValorInvalidoException, MetodoPagamentoInvalidoException,
            FalhaProcessamentoException {

        // Validação de valor
        validarValor(valor);

        // Validação de método
        validarMetodo(metodo);

        // Processa conforme o método
        if (metodo.equalsIgnoreCase("cartao")) {
            processarCartao(valor);
        } else if (metodo.equalsIgnoreCase("boleto")) {
            processarBoleto(valor);
        }
    }

    private void validarValor(double valor) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException(valor);
        }
    }

    private void validarMetodo(String metodo) throws MetodoPagamentoInvalidoException {
        if (metodo == null || metodo.trim().isEmpty()) {
            throw new MetodoPagamentoInvalidoException("null/vazio");
        }

        if (!metodo.equalsIgnoreCase("cartao") && !metodo.equalsIgnoreCase("boleto")) {
            throw new MetodoPagamentoInvalidoException(metodo);
        }
    }

    private void processarCartao(double valor) throws FalhaProcessamentoException {
        try {
            // Simula processamento
            System.out.println("Pagamento de R$ " + valor + " realizado via cartão.");

            // Aqui viria a integração com operadora de cartão
            // Se falhar, lança exception específica

        } catch (Exception e) {
            throw new FalhaProcessamentoException("cartão", e.getMessage());
        }
    }

    private void processarBoleto(double valor) throws FalhaProcessamentoException {
        try {
            // Simula processamento
            System.out.println("Pagamento de R$ " + valor + " realizado via boleto.");

            // Aqui viria a geração do boleto
            // Se falhar, lança exception específica

        } catch (Exception e) {
            throw new FalhaProcessamentoException("boleto", e.getMessage());
        }
    }

    /**
     * Método auxiliar para uso seguro (não lança checked exceptions)
     * Retorna true se sucesso, false se falhou
     */
    public boolean tentarProcessar(double valor, String metodo) {
        try {
            processarPagamento(valor, metodo);
            return true;
        } catch (PagamentoException e) {
            System.err.println("Erro no pagamento: " + e.getMessage());
            return false;
        }
    }
}