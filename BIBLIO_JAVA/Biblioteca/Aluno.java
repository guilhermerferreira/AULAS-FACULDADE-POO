package Biblioteca;

 class Aluno extends Usuario {
    private String ra;
    private String curso;

    public Aluno(int id, String nome, String email, String ra, String curso) {
        super(id, nome, email);
        this.ra = ra;
        this.curso = curso;
    }
    // Retorna o tipo do usuario como aluno
    @Override
    public String getTipoUsuario(){
        return "Aluno";
    }

    // Retorna a quantidade de livros que o aluno pode emprestar
    @Override
    public int getLimiteEmprestimo(){
        return 3;
    }

    // Retorna a qtd de Dias que o Usuario pode ficar com o Livro
    @Override
    public int getPrazoEmprestimo(){
        return 3;
    }

    public String getRa(){
        return this.ra;
    }

    public String getCurso(){
        return this.curso;
    }

}
