public class ResultadoValidacao {
    private boolean valido;
    private String mensagem;

    private ResultadoValidacao(boolean valido, String mensagem) {
        this.valido = valido;
        this.mensagem = mensagem;
    }

    public static ResultadoValidacao sucesso() {
        return new ResultadoValidacao(true, "Validação bem-sucedida");
    }

    public static ResultadoValidacao falha(String motivo) {
        return new ResultadoValidacao(false, motivo);
    }

    public boolean isValido() {
        return valido;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", valido ? "VÁLIDO" : "INVÁLIDO", mensagem);
    }
}