package Biblioteca;

public class Funcionario extends Usuario {
    private String matricula;
    private String dpto;

     public Funcionario(int id, String nome, String email, String matricula, String dpto) {
        super(id, nome, email);
        this.matricula = matricula;
        this.dpto = dpto;
    }

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
