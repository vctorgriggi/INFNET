public class Pedido {
    private int id;
    private String descricao;
    private double valor;

    /**
     * @param id Identificador único do pedido
     * @param descricao Descrição detalhada do pedido
     * @param valor Valor total em reais
     */
    public Pedido(int id, String descricao, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @param percentual Valor entre 0 e 100 representando o desconto
     * @return Valor final após aplicar desconto
     */
    public double aplicarDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Percentual deve estar entre 0 e 100");
        }

        double desconto = valor * (percentual / 100);
        return valor - desconto;
    }

    @Override
    public String toString() {
        return String.format("Pedido #%d: %s - R$ %.2f", id, descricao, valor);
    }
}