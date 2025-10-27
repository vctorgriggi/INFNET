public class Servico {
    private ValidadorCPF validador;

    public Servico() {
        this.validador = new ValidadorCPF();
    }

    /**
     * Abordagem 1: Usando classe de resultado
     *
     * @param dado Dado a ser processado
     */
    public void processar(String dado) {
        // Validação prévia
        if (dado == null) {
            System.err.println("Erro: Dado não pode ser nulo");
            return;
        }

        // Processa
        try {
            String processado = dado.toUpperCase();
            System.out.println("Processando: " + processado);
        } catch (Exception e) {
            System.err.println("Erro ao processar: " + e.getMessage());
        }
    }

    /**
     * Abordagem 2: Usando exception
     *
     * @param cpf CPF a ser processado
     */
    public void processarCPF(String cpf) {
        try {
            validador.validarComException(cpf);
            System.out.println("CPF válido: " + cpf);
            // Continua processamento...

        } catch (CPFInvalidoException e) {
            System.err.println("Erro na validação: " + e.getMessage());
        }
    }

    /**
     * Abordagem 3: Usando classe de resultado (mais flexível)
     *
     * @param cpf CPF a ser processado
     */
    public void processarCPFComResultado(String cpf) {
        ResultadoValidacao resultado = validador.validar(cpf);

        if (resultado.isValido()) {
            System.out.println("CPF válido: " + cpf);
            // Continua processamento...
        } else {
            System.err.println("CPF inválido: " + resultado.getMensagem());
        }
    }
}