package Biblioteca;

public class Livro {
    private int id;
    private String titulo;
    private int ano;
    private String editora;
    private String isbn;
    private boolean disponivel; 
    
    //Construtor
    public Livro(int id, String titulo, int ano, String editora, String isbn){
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.editora = editora;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public int getId(){
        return this.id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getEditora() {
        return editora;
    }
    public String getIsbn(){
        return this.isbn;
    }
    
    //Verifica a disponibilidade do Livro
    public boolean isDisponivel(){
        return this.disponivel;
    }//Fim isDisponivel()

    //Altera a disponibilidade para false (Emprestado)
    public boolean emprestar(){
        if (this.isDisponivel()){
            this.disponivel = false;
            return true;
        }else{  //Livro já está emprestado!
            return false; //Aqui melhorar gerando uma exception
        }
    }//Fim emprestar()

    //Altera a disponibilidade para true (diponível)
    public boolean devolver(){
        if (!this.isDisponivel()){
            this.disponivel = true;
            return true;
        }else{
            return false; //Aqui poderia gerar um exception
        }
    }//Fim devolver()

}
