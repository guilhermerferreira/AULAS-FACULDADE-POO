package Biblioteca;

public class Funcionario extends Usuario {
    private String matricula;
    private String dpto;

     // Retorna a quantidade de livros que o aluno pode emprestar
    @Override
    public int getLimiteEmprestimo(){
        return 4;
    }

    // Retorna a qtd de Dias que o Usuario pode ficar com o Livro
    @Override
    public int getPrazoEmprestimo(){
        return 4;
    }
}
