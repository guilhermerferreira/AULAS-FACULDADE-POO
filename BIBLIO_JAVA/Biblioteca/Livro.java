package Biblioteca;

public class Livro {
    private int id;
    private String titulo;
    private int ano;
    private String editora;
    private String isbn;
    private boolean disponivel;
    

    public boolean isDisponivel(){
        return this.isDisponivel();
    }

    public boolean emprestar(){
        if (this.isDisponivel()){
            this.disponivel = false; //Altera a disponibilidade para false
            return true;
        }else{ // Livro ja emprestado
            return false; //Melhora gerando um exception
        }
    } //Fim de emprestar

    public boolean devolver(){
        if (!this.isDisponivel()){
            this.disponivel = true;
            return true;
        }else{
            return false;
        }
    } //Fim devolver
}
