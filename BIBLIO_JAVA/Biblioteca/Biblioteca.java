package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> Livros = new ArrayList<>();
    private List<Autor> Autores = new ArrayList<>();
    private List<Usuario> Usuarios = new ArrayList<>();
    private List<Emprestimo> Emprestimos = new ArrayList<>();
    private List<LivroAutor> LivroAutores = new ArrayList<>();


    ////////// ----------------------------------------- //////////////

    //                  LIVRO               //

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
    
    //                  AUTOR                //

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


    ////////// ----------------------------------------- //////////////
    
    //                  USUARIO                //

    private boolean existeUsuarioComId(int id){
        for (Usuario usuario : Usuarios) {
            if(usuario.getId() == id){
                return true;
            }
        }
        return false;
    }

    private boolean existeUsuarioComNome(String nome){
        for (Usuario usuario : Usuarios) {
            if(usuario.getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    public List<Usuario> getAllUsuarios(){
        return this.Usuarios;
    }


    public void adicionarUsuario(Usuario usuario){
        if (existeUsuarioComId(usuario.getId())){
            throw new IllegalArgumentException("ID já Cadastrado!");
        } 
        if (existeUsuarioComNome(usuario.getNome())){
            throw new IllegalArgumentException("Nome já Cadastrado!");
        }

        this.Usuarios.add(usuario);
    }

    // LIVRO AUTOR

    // LOCALIZA O ID DO LIVRO
    public Livro localizarLivro(int idProcurado){
        for (Livro livro : Livros){
            if(livro.getId() == idProcurado){
                return livro;
            }
        }
        return null;
    }

    // LOCALIZA O ID DO AUTOR
    public Autor localizarAutor(int idProcurado){
        for(Autor autor : Autores){
            if(autor.getId() == idProcurado){
                return autor;
            }
        }
        return null;
    }
    

}
    





