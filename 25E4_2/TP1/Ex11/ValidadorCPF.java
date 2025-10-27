public class ValidadorCPF {

    /**
     * @param cpf CPF a ser validado
     * @return Resultado contendo status e mensagem explicativa
     */
    public ResultadoValidacao validar(String cpf) {
        // Validação: CPF não pode ser nulo
        if (cpf == null) {
            return ResultadoValidacao.falha("CPF não pode ser nulo");
        }

        // Remove caracteres não numéricos
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        // Validação: CPF deve ter exatamente 11 dígitos
        if (cpfLimpo.length() != 11) {
            return ResultadoValidacao.falha(
                    String.format("CPF deve ter 11 dígitos (informado: %d)", cpfLimpo.length())
            );
        }

        // Validação: CPF não pode ter todos dígitos iguais
        if (cpfLimpo.matches("(\\d)\\1{10}")) {
            return ResultadoValidacao.falha("CPF não pode ter todos os dígitos iguais");
        }

        // Aqui viriam as validações de dígitos verificadores

        return ResultadoValidacao.sucesso();
    }

    /**
     * @throws CPFInvalidoException se CPF for inválido
     */
    public void validarComException(String cpf) throws CPFInvalidoException {
        ResultadoValidacao resultado = validar(cpf);

        if (!resultado.isValido()) {
            throw new CPFInvalidoException(resultado.getMensagem());
        }
    }
}

class CPFInvalidoException extends Exception {
    public CPFInvalidoException(String mensagem) {
        super(mensagem);
    }
}