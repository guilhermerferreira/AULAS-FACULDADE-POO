package Biblioteca;

abstract public class Usuario {
    private int id;
    private String nome;
    private String email;
    
    //Retorna a quantidade de livros que o usuario pode emprestar.
    //Esta classe sera sobrescrita nas classes filhas.
    public int getLimiteLivros(){
        return 0;
    }
}
