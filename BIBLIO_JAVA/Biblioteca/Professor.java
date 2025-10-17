package Biblioteca;

public class Professor extends Usuario {
    private String matricula;
    private String area;
    
    // Retorna a quantidade de livros que o aluno pode emprestar
    @Override
    public int getLimiteEmprestimo(){
        return 5;
    }

    // Retorna a qtd de Dias que o Usuario pode ficar com o Livro
    @Override
    public int getPrazoEmprestimo(){
        return 5;
    }
    
}
