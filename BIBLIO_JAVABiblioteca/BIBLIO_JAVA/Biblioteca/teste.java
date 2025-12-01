package Biblioteca;

import java.time.LocalDate;

public class teste {

    public static void main(String[] args) {
        
        Livro livro1 = new Livro(1,"Desbravando Java e orientação a objetos",2014,"Casa do Código","9788555190599");
        Usuario aluno1 = (Usuario) new Aluno("202555001","Sistemas para Internet",1,"Olivaldo Dutra","oli@mail.com");

        //Emprestimo emp1 = new Emprestimo(1,livro1,aluno1,LocalDate.of(2025, 10, 5));
        Emprestimo emp1 = new Emprestimo(1,livro1,aluno1,LocalDate.of(2025, 10, 10));
        //emp1.registrarDevolucao(LocalDate.now());

        System.out.println(emp1.getStatus());
    }
    
}
