package Biblioteca;

abstract public class Usuario {
    private int id;
    private String nome;
    private String email;
    
    // Retorna a quantidade de livros que o usuario pode emprestar.
    // Comportamento definido nas subclasses
    public abstract int getLimiteEmprestimo(); 

    // Retorna a quantidade de dias que o Usuario tem para ficar com o Livro
    public abstract int getPrazoEmprestimo(); 
}
