package Biblioteca;

public class Professor extends Usuario {
    private String matricula;
    private String area;
    
    
    public Professor(int id, String nome, String email, String matricula, String area) {
        super(id, nome, email);
        this.matricula = matricula;
        this.area = area;
    }

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
