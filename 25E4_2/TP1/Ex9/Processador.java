public class Processador {

    /**
     * @param valor Valor a ser processado
     */
    public void executar(String valor) {
        if (valor != null) {
            processarValor(valor);
        } else {
            tratarValorNulo();
        }
    }

    private void processarValor(String valor) {
        System.out.println("Processando: " + valor);
        // Lógica adicional de processamento aqui
    }

    private void tratarValorNulo() {
        System.out.println("Aviso: Valor nulo não pode ser processado");
    }
}