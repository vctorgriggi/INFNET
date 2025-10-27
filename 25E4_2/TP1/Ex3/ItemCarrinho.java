public class ItemCarrinho {
    private String produto;
    private double preco;
    private int quantidade;

    public ItemCarrinho(String produto, double preco, int quantidade) {
        validarProduto(produto);
        validarPreco(preco);
        validarQuantidade(quantidade);

        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    private void validarProduto(String produto) {
        if (produto == null || produto.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio");
        }
    }

    private void validarPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
    }

    private void validarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
    }

    public double calcularSubtotal() {
        return preco * quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return String.format("%s - R$ %.2f x %d = R$ %.2f",
                produto, preco, quantidade, calcularSubtotal());
    }
}