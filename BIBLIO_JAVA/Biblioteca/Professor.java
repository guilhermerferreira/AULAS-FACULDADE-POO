package Biblioteca;

public class Professor extends Usuario {
    private String matricula;
    private String area;
    private String limiteEmp;
    
    public int getLimiteLivros(){
        return this.limiteEmp;
    }
    
}
