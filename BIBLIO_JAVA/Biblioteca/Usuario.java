package Biblioteca;

abstract public class Usuario {
    private int id;
    private String nome;
    private String email;

    //Construtor da Classe
    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Este método (método polimórfico) será implementado em cada subclasse para 
    // Identificar o tipo do Usuário: Aluno, Professor ou Funcionario
    public abstract String getTipoUsuario();     

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    //Retorna a qtde de Livros que o Usuario pode emprestar
    public abstract int getLimiteLivros(); //comportamento definido nas subclasses

    //Retorna a qtde de Dias (prazo) que o livro pode ficar com o Usuário
    public abstract int getPrazoEmprestimo(); //comportamento definido nas subclasses
    
}
