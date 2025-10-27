import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<ItemCarrinho> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    /**
     * @param produto Nome do produto
     * @param preco Preço unitário
     * @param quantidade Quantidade
     */
    public void adicionarProduto(String produto, double preco, int quantidade) {
        ItemCarrinho item = new ItemCarrinho(produto, preco, quantidade);
        itens.add(item);
    }

    /**
     * @return Valor total
     */
    public double calcularTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    /**
     * @return String formatada com o total
     */
    public String obterTotalFormatado() {
        return String.format("Total da compra: R$ %.2f", calcularTotal());
    }

    public void exibirTotal() {
        System.out.println(obterTotalFormatado());
    }

    /**
     * @return Lista imutável de itens
     */
    public List<ItemCarrinho> getItens() {
        return new ArrayList<>(itens);
    }

    /**
     * @return Número de itens
     */
    public int quantidadeItens() {
        return itens.size();
    }

    /**
     * @return true se vazio, false caso contrário
     */
    public boolean estaVazio() {
        return itens.isEmpty();
    }
}