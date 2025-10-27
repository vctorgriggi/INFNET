import java.util.List;

public class RelatorioFinanceiro {

    public void gerarRelatorio(List<String> clientes, List<Double> saldos) {
        imprimirCabecalho();
        imprimirLinhasClientes(clientes, saldos);
        imprimirRodape();
    }

    private void imprimirCabecalho() {
        System.out.println("=== Relatório Financeiro ===");
    }

    private void imprimirLinhasClientes(List<String> clientes, List<Double> saldos) {
        for (int i = 0; i < clientes.size(); i++) {
            String linha = formatarLinhaCliente(clientes.get(i), saldos.get(i));
            System.out.println(linha);
        }
    }

    /**
     * @return String formatada
     */
    private String formatarLinhaCliente(String cliente, double saldo) {
        return String.format("Cliente: %s - Saldo: R$ %.2f", cliente, saldo);
    }

    private void imprimirRodape() {
        System.out.println("Fim do Relatório");
    }
}