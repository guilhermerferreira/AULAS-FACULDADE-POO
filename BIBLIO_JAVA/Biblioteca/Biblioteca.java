package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> Livros = new ArrayList<>();
    private List<Autor> Autores = new ArrayList<>();
    private List<Usuario> Usuarios = new ArrayList<>();
    private List<Emprestimo> Emprestimos = new ArrayList<>();
    private List<LivroAutor> LivroAutores = new ArrayList<>();


    private boolean existeLivroComId(int id){
        for (Livro livro : Livros) {
            if(livro.getId() == id){
                return true;
            }
        }
        return false;
    }

    private boolean existeLivroComIsbn(String isbn){
        for (Livro livro : Livros) {
            if(livro.getIsbn().equals(isbn)){
                return true;
            }
        }
        return false;
    }

    public List<Livro> getAll(){
        return this.Livros;
    }


    public void adicionarLivro(Livro livro){
        // Fazer as consistencias de acordo com as Regras de Negocio
        if (existeLivroComId(livro.getId())){
            throw new IllegalArgumentException("ID já Cadastrado!");
        }
        if (existeLivroComIsbn(livro.getIsbn())){
            throw new IllegalArgumentException("ISBN já Cadastrado!");
        }

        this.Livros.add(livro);
    }


    ////////// ----------------------------------------- //////////////


     private boolean existeAutorComId(int id){
        for (Autor autor : Autores) {
            if(autor.getId() == id){
                return true;
            }
        }
        return false;
    }

    private boolean existeAutorComNome(String nome){
        for (Autor autor : Autores) {
            if(autor.getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    public List<Autor> getAllAutors(){
        return this.Autores;
    }


   public void adicionarAutor(Autor autor){
        // Fazer as consistencias de acordo com as Regras de Negocio
        if (existeAutorComId(autor.getId())){
            throw new IllegalArgumentException("ID já Cadastrado!");
        }
        if (existeAutorComNome(autor.getNome())){
            throw new IllegalArgumentException("Nome já Cadastrado!");
        }

        this.Autores.add(autor);
    }

}
    





