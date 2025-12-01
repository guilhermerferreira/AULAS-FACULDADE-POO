package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> Livros = new ArrayList<>();
    private List<Autor> Autores = new ArrayList<>();
    private List<Usuario> Usuarios = new ArrayList<>();
    private List<Emprestimo> Emprestimos = new ArrayList<>();
    private List<LivroAutor> LivroAutores = new ArrayList<>();

    /*Percorre a Lista para verificar a existência de um Livro com um ID
     * Retorno:
     *      true se encontrou um Livro com o ID procurado
     *      false se NÃO encontrou
     */
    private boolean existeLivroComId(int id){
        for (Livro livro : this.Livros){
            if (livro.getId() == id){
                return true;
            }
        }
        return false;
    }

    /*Percorre a Lista para verificar a existência de um Livro com um ISBN
     * Retorno:
     *      true se encontrou um Livro com o ISBN procurado
     *      false se NÃO encontrou
     */
    private boolean existeLivroComIsbn(String isbn){
        for (Livro livro : this.Livros){
            if (livro.getIsbn().equals(isbn)){
                return true;
            }
        }
        return false;
    }

    /*  Adiciona um Livro na Lista de Livros:
     *    - Recebe um objeto Livro e insere na Lista de Livros
     *    - Consistências aqui: JÁ existe um Livro com o Id, ou ISBN
     *      - Caso NÃO passe na consistência gera uma Exceção
     */   
    public void adicionarLivro(Livro livro){
        //Fazer Consistências segundo as Regras de Negócio
        if (existeLivroComId(livro.getId())){ 
            throw new IllegalArgumentException("ID já cadastrado!");
        }
        if (existeLivroComIsbn(livro.getIsbn())){
            throw new IllegalArgumentException("ISBN já cadastrado!");
        }

        //Adicionar na Lista se tudo OK.
        this.Livros.add(livro);
    }

    /*
     *  Retorna a Lista de Livros Cadastrados
     */
    public List<Livro> getAllLivros(){
        return Livros;
    }

    //Retorna o objeto Livro com o ID ou null se NÃO encontrar
    public Livro getLivroById(int id){
        for (Livro livro : this.Livros){
            if (livro.getId() == id){
                return livro;
            }
        }
        return null;
    }


    /*Percorre a Lista para verificar a existência de um Autor com um ID
     * Retorno:
     *      true se encontrou um Autor com o ID procurado
     *      false se NÃO encontrou
     */
    private boolean existeAutorComId(int id){
        for (Autor autor: this.Autores){
            if (autor.getId() == id){
                return true;
            }
        }
        return false;
    }

    /*Percorre a Lista para verificar a existência de um Autor com um Nome
     * Retorno:
     *      true se encontrou um Autor com o ID procurado
     *      false se NÃO encontrou
     */
    private boolean existeAutorComNome(String nome){
        for (Autor autor: this.Autores){
            if (autor.getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    /*  Adiciona um Autor na Lista de Autores:
     *    - Recebe um objeto Autor e insere na Lista de Autores
     *    - Consistências aqui: JÁ existe um Autor com o Id, ou nome
     *      - Caso NÃO passe na consistência gera uma Exceção
     */   
    public void adicionarAutor(Autor autor){
        //Fazer Consistências segundo as Regras de Negócio
        if (existeAutorComId(autor.getId())){ 
            throw new IllegalArgumentException("ID já cadastrado!");
        }
        if (existeAutorComNome(autor.getNome())){
            throw new IllegalArgumentException("Autor com este Nome já cadastrado!");
        }

        //Adicionar na Lista se tudo OK.
        this.Autores.add(autor);
    }    

    //Retorna o objeto Autor com o ID ou null se NÃO encontrar
    public Autor getAutorById(int id){
        for (Autor autor : this.Autores){
            if (autor.getId() == id){
                return autor;
            }
        }
        return null;
    }


    /*
     *  Retorna a Lista de Autores Cadastrados
     */
    public List<Autor> getAllAutores(){
        return Autores;
    }

    /*Percorre a Lista para verificar a existência de um Usuário com um ID
     * Retorno:
     *      true se encontrou um Autor com o ID procurado
     *      false se NÃO encontrou
     */
    private boolean existeUsuarioComId(int id){
        for (Usuario usuario: this.Usuarios){
            if (usuario.getId() == id){
                return true;
            }
        }
        return false;
    }

    /*Percorre a Lista para verificar a existência de um Usuario com um Nome
     * Retorno:
     *      true se encontrou um Autor com o ID procurado
     *      false se NÃO encontrou
     */
    private boolean existeUsuarioComNome(String nome){
        for (Usuario usuario: this.Usuarios){
            if (usuario.getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    /*  Adiciona um Usuário na Lista de Usuários:
     *    - Recebe um objeto Usuario e insere na Lista de Usuários
     *    - Consistências aqui: JÁ existe um Usuárip com o Id, ou nome
     *      - Caso NÃO passe na consistência gera uma Exceção
     */   
    public void adicionarUsuario(Usuario usuario){
        //Fazer Consistências segundo as Regras de Negócio
        if (existeUsuarioComId(usuario.getId())){ 
            throw new IllegalArgumentException("ID já cadastrado!");
        }
        if (existeUsuarioComNome(usuario.getNome())){
            throw new IllegalArgumentException("Autor com este Nome já cadastrado!");
        }

        //Adicionar na Lista se tudo OK.
        this.Usuarios.add(usuario);
    }    
    
    //Retorna a Lista de Usuarios Cadastrados
    public List<Usuario> getAllUsuarios(){
        return Usuarios;
    }

    //Retorna o objeto Usuario com o ID ou null se NÃO encontrar
    public Usuario getUsuarioById(int id){
        for (Usuario usuario : this.Usuarios){
            if (usuario.getId() == id){
                return usuario;
            }
        }
        return null;
    }

    //Adiciona o Relacionamento na Lista LivroAutores
    public void adicionarLivroAutor(LivroAutor livroAutor){
        //Fazer Consistências segundo as Regras de Negócio
        if (LivroAutores.contains(livroAutor)){ 
            throw new IllegalArgumentException("Relacionamento já cadastrado!");
        }else{
            LivroAutores.add(livroAutor); //Adiciona o relacionamento
        }
    }//Fim adicionarLivroAutor()

     //Retorna a Lista de Relacionamentos LivroAutor
    public List<LivroAutor> getAllLivroAutores(){
        return LivroAutores;
    }    

    public int getIdUltimoEmprestimo(){
        if (Emprestimos.size()>0){
            return Emprestimos.get(Emprestimos.size()-1).getId();
        }else{ //NÃO tem nenhum emprestimo
            return 0;
        }
    }//Fim getIdUltimoEmprestimo()

    //Retorna a quantidade de Empréstimos já realizados pelo Usuário
    public int qtdeEmprestimosDoUsuario(int idusuario){
        int cont=0;
        for (Emprestimo emprestimo : this.Emprestimos){
            if (emprestimo.getUsuario().getId() == idusuario){
                cont++;
            }
        }
        return cont;
    }//Fim qtdeEmprestimosDoUsuario()

    public boolean contains(Emprestimo emprestimo){
        for (Emprestimo empres : this.Emprestimos){
            if ((empres.getUsuario().getId() == emprestimo.getUsuario().getId()) && 
               (empres.getLivro().getId() == emprestimo.getLivro().getId())){
                return true;
            }
        }        
        return false;
    }//Fim contains()

    public void adicionarEmprestimo(Emprestimo emprestimo){
        //Consistência de Livro Disponível
        if (!emprestimo.getLivro().isDisponivel()){
            throw new IllegalArgumentException("Este Livro já foi emprestado!");
        }
        //Consistência se o Usuário já atingiu seu Limite de Empréstimo
        if(emprestimo.getUsuario().getLimiteLivros()<=qtdeEmprestimosDoUsuario(emprestimo.getUsuario().getId())){
            throw new IllegalArgumentException("Usuário já atingiu seu limite de Empréstimo!");
        }
        //Consistência se já existe esse empréstimo
        if (contains(emprestimo)){
            throw new IllegalArgumentException("Este Empréstimo já foi registrado anteriormente!");
        }

        //Adiciona o Empréstimo
        Emprestimos.add(emprestimo);
        //Registra que o livro Não está disponível
        emprestimo.getLivro().emprestar();
    }

    //Retorna a Lista de Empréstimos Cadastrados
    public List<Emprestimo> getAllEmprestimos(){
        return Emprestimos;
    }

    //Localiza o empréstimo do Livro que esteja sem data de devolução (null)
    //OBSERVAÇÃO: Lembrar de inicializar a data de devolução com null no Contrutor da classe Emprestimo()
    public Emprestimo getEmprestimoAtivoLivro(Livro livro){
        for (Emprestimo emprestimo : this.Emprestimos){
            if ((emprestimo.getLivro().getId() == livro.getId()) && (emprestimo.getDataDevolucao()==null)){
                return emprestimo;
            }
        }
        return null;
    }//Fim getEmprestimoAbertoLivro()    

}
