package Biblioteca;

public class Aluno extends Usuario {
    private String ra;
    private String curso;

    //Construtor
    public Aluno(String ra, String curso, int id, String nome, String email) {
        super(id, nome, email);
        this.ra = ra;
        this.curso = curso;        
    }

    public String getRa() {
        return ra;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String getTipoUsuario() {
        return "Aluno";
    }

    //Retorna a qtde de Livros que o Usuario pode emprestar
    @Override
    public int getLimiteLivros(){
        return 3;
    }

    //Retorna a qtde de Dias (prazo) que o livro pode ficar com o Usuário
    @Override
    public int getPrazoEmprestimo(){
        return 5;
    }

}
