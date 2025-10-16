package Biblioteca;

public class Aluno extends Usuario {
    private String ra;
    private String curso;
    private int limiteEmp; //qtd de livros que pode emprestar

    // Retorna a quantidade de livros que o aluno pode emprestar
    public int getLimiteLivros(){
        return this.limiteEmp;
    }
}
