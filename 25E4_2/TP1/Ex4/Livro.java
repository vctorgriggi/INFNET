public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(String titulo, String autor) {
        validarTitulo(titulo);
        validarAutor(autor);

        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true; // Livro começa disponível por padrão
    }

    private void validarTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título do livro não pode ser vazio");
        }
    }

    private void validarAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor do livro não pode ser vazio");
        }
    }

    /**
     * @return true se foi emprestado com sucesso, false se já estava emprestado
     */
    public boolean emprestar() {
        if (!disponivel) {
            return false;
        }
        disponivel = false;
        return true;
    }

    /**
     * @return true se foi devolvido com sucesso, false se já estava disponível
     */
    public boolean devolver() {
        if (disponivel) {
            return false;
        }
        disponivel = true;
        return true;
    }

    /**
     * @return true se disponível, false caso contrário
     */
    public boolean estaDisponivel() {
        return disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        String status = disponivel ? "Disponível" : "Emprestado";
        return String.format("'%s' por %s - %s", titulo, autor, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Livro livro = (Livro) obj;
        return titulo.equalsIgnoreCase(livro.titulo) &&
                autor.equalsIgnoreCase(livro.autor);
    }

    @Override
    public int hashCode() {
        return titulo.toLowerCase().hashCode() + autor.toLowerCase().hashCode();
    }
}