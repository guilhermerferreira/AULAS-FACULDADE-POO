package Biblioteca;

public class LivroAutor {
    private Livro livro;
    private Autor autor;

    public LivroAutor(Livro livro, Autor autor) {
        this.livro = livro;
        this.autor = autor;
    }
    public Livro getLivro(){
        return this.livro;
    }
    public Autor getAutor(){
        return this.autor;
    }

}
