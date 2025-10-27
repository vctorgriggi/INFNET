import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Biblioteca {
    private List<Livro> acervo;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
    }

    /**
     * @param titulo Título do livro
     * @param autor Autor do livro
     */
    public void adicionarLivro(String titulo, String autor) {
        Livro livro = new Livro(titulo, autor);
        acervo.add(livro);
    }

    /**
     * @param livro Livro a ser adicionado
     */
    public void adicionarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser null");
        }
        acervo.add(livro);
    }

    /**
     * @param titulo Título do livro
     * @return Optional contendo o livro se encontrado, vazio caso contrário
     */
    private Optional<Livro> buscarLivroPorTitulo(String titulo) {
        return acervo.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }

    /**
     * @param titulo Título do livro a ser emprestado
     * @return Mensagem de resultado da operação
     */
    public String emprestarLivro(String titulo) {
        Optional<Livro> livroOpt = buscarLivroPorTitulo(titulo);

        if (!livroOpt.isPresent()) {
            return "Livro não encontrado.";
        }

        Livro livro = livroOpt.get();
        if (livro.emprestar()) {
            return "Livro emprestado: " + titulo;
        } else {
            return "Livro já está emprestado.";
        }
    }

    /**
     * @param titulo Título do livro a ser devolvido
     * @return Mensagem de resultado da operação
     */
    public String devolverLivro(String titulo) {
        Optional<Livro> livroOpt = buscarLivroPorTitulo(titulo);

        if (!livroOpt.isPresent()) {
            return "Livro não encontrado.";
        }

        Livro livro = livroOpt.get();
        if (livro.devolver()) {
            return "Livro devolvido: " + titulo;
        } else {
            return "Livro já estava disponível.";
        }
    }

    /**
     * @param titulo Título do livro
     * @return true se disponível, false caso contrário
     */
    public boolean verificarDisponibilidade(String titulo) {
        Optional<Livro> livroOpt = buscarLivroPorTitulo(titulo);
        return livroOpt.isPresent() && livroOpt.get().estaDisponivel();
    }

    /**
     * @return Lista de livros disponíveis
     */
    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> disponiveis = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.estaDisponivel()) {
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }

    /**
     * @return Lista de livros emprestados
     */
    public List<Livro> listarLivrosEmprestados() {
        List<Livro> emprestados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (!livro.estaDisponivel()) {
                emprestados.add(livro);
            }
        }
        return emprestados;
    }

    /**
     * @return Lista com cópia do acervo
     */
    public List<Livro> listarTodosLivros() {
        return new ArrayList<>(acervo);
    }

    /**
     * @return Número de livros
     */
    public int quantidadeLivros() {
        return acervo.size();
    }

    /**
     * @param mensagem Mensagem a ser exibida
     */
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}