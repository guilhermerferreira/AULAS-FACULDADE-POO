package Biblioteca;

public class Professor extends Usuario {
    private String matricula;
    private String area;

    public Professor(String matricula, String area, int id, String nome, String email) {
        super(id, nome, email);
        this.matricula = matricula;
        this.area = area;        
    }    

    public String getMatricula() {
        return matricula;
    }

    public String getArea() {
        return area;
    }

    @Override
    public String getTipoUsuario() {
        return "Professor";
    }    

    //Retorna a qtde de Livros que o Usuario pode emprestar
    @Override
    public int getLimiteLivros(){
        return 5;
    }

    //Retorna a qtde de Dias (prazo) que o livro pode ficar com o Usuário
    @Override
    public int getPrazoEmprestimo(){
        return 7;
    }

}
