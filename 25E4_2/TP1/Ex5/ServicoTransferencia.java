public class ServicoTransferencia {

    /**
     * @return Mensagem de resultado
     */
    public String transferir(Conta origem, Conta destino, double valor) {
        if (origem == null || destino == null) {
            return "Erro: Contas não podem ser nulas.";
        }

        if (valor <= 0) {
            return "Erro: Valor deve ser positivo.";
        }

        if (!origem.temSaldoSuficiente(valor)) {
            return "Erro na transferência: Saldo insuficiente.";
        }

        try {
            origem.debitar(valor);
            destino.creditar(valor);
            return "Transferência realizada com sucesso.";
        } catch (Exception e) {
            return "Erro na transferência: " + e.getMessage();
        }
    }
}