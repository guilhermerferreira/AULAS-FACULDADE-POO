package Biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    
    // Construtor
    public Emprestimo(int id, Livro livro, Usuario usuario, LocalDate dataEmprestimo) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
    }

    public boolean registrarDevolucao(LocalDate data){
        //Consistência se a data de devolução é igual ou maior que a 
        //data de Empréstimo
        if (data.equals(this.dataEmprestimo) || data.isAfter(this.dataEmprestimo)){
            this.dataDevolucao = data;
            return true;
        } else {
            return false; //Data de devolução inválida
        }
    }

    //Retorna uma String com o Status do Empréstimo com o seguinte Formato:
    //  1- Ativo - Emprestado em: dd/mm/aaaa, previsto para ser devolvido em dd/mm/aaaa
    //  2- Atrasado - Emprestado em: dd/mm/aaaa, deveria ser devolvido em dd/mm/aaaa. Atraso de X dias
    //  3- Finalizado - Emprestado em: dd/mm/aaaa e devolvido em dd/mm/aaaa [atraso de X dias]
    public String getStatus(){
        String resp;
        long dias;
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataPrevistaDevolucao = this.dataEmprestimo.plusDays(this.usuario.getPrazoEmprestimo());

        if (this.dataDevolucao != null ){ //Tem uma data de Devolução - Livro devolvido
            dias = ChronoUnit.DAYS.between(this.dataEmprestimo, this.dataDevolucao);
            resp = "Finalizado - Retirado em: "+formataData.format(this.dataEmprestimo)+", devolvido em: "+formataData.format(this.dataDevolucao);
            if (dias>this.usuario.getPrazoEmprestimo()){ //Devolvido com Atraso
                resp += ". Deveria ser devolvido em: "+formataData.format(dataPrevistaDevolucao)+". Atraso de "+ (dias - this.usuario.getPrazoEmprestimo()) +" dias";
            }
        }else{ //Não tem data de devolução
            if (dataPrevistaDevolucao.isBefore(LocalDate.now())){ //Atrasado
                dias = ChronoUnit.DAYS.between(dataPrevistaDevolucao, LocalDate.now());
                resp = "Atrasado - Retirado em: "+formataData.format(this.dataEmprestimo)+", deveria ser devolvido em: "+formataData.format(dataPrevistaDevolucao)+" - Atraso de: "+dias+" dias";    
            } else { //Ativo
                resp = "Ativo - Retirado em: "+formataData.format(this.dataEmprestimo)+", previsto para ser devolvido em: "+formataData.format(dataPrevistaDevolucao);
            }
        }

        return resp;
    }
}