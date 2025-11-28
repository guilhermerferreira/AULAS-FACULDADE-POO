package Biblioteca;

public class Funcionario extends Usuario {
    private String matricula;
    private String dpto;

    //Construor
    public Funcionario(String matricula, String dpto, int id, String nome, String email) {
        super(id, nome, email);
        this.matricula = matricula;
        this.dpto = dpto;
    }    
    
    public String getMatricula() {
        return matricula;
    }

    public String getDpto() {
        return dpto;
    }

    @Override
    public String getTipoUsuario() {
        return "Funcionario";
    }

    //Retorna a qtde de Livros que o Usuario pode emprestar
    @Override
    public int getLimiteLivros(){
        return 4;
    }

    //Retorna a qtde de Dias (prazo) que o livro pode ficar com o Usuário
    @Override
    public int getPrazoEmprestimo(){
        return 7;
    }
}
