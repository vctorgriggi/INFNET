public class Servico {

    /**
     * @param dado Texto a ser processado
     * @throws IllegalArgumentException se dado for null ou vazio
     */
    public void processar(String dado) {
        validarDado(dado);

        try {
            String processado = dado.toUpperCase();
            System.out.println("Processando: " + processado);
        } catch (Exception e) {
            tratarErroProcessamento(e);
        }
    }

    private void validarDado(String dado) {
        if (dado == null) {
            throw new IllegalArgumentException("Erro: Dado não pode ser nulo");
        }

        if (dado.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Dado não pode ser vazio");
        }
    }

    private void tratarErroProcessamento(Exception e) {
        System.err.println("Erro ao processar dado: " + e.getMessage());
        // Pode também logar o erro, notificar sistema, etc
    }
}