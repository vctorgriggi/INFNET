import java.util.HashMap;
import java.util.Map;

public class SistemaBancario {
    private Map<String, Conta> contas;
    private ServicoTransferencia servicoTransferencia;

    public SistemaBancario() {
        this.contas = new HashMap<>();
        this.servicoTransferencia = new ServicoTransferencia();
    }

    public void criarConta(String titular, double saldoInicial) {
        if (contas.containsKey(titular)) {
            System.out.println("Erro: Conta já existe para " + titular);
            return;
        }

        Conta conta = new Conta(titular, saldoInicial);
        contas.put(titular, conta);
    }

    public String transferir(String titularOrigem, String titularDestino, double valor) {
        Conta origem = contas.get(titularOrigem);
        Conta destino = contas.get(titularDestino);

        if (origem == null || destino == null) {
            return "Erro na transferência: Conta não encontrada.";
        }

        return servicoTransferencia.transferir(origem, destino, valor);
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public Conta buscarConta(String titular) {
        return contas.get(titular);
    }
}