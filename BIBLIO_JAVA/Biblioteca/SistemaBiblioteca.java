package Biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class SistemaBiblioteca {
    private Biblioteca biblio;
    private Scanner scanner; //Classe para entrada de dados via Teclado
    
    // Construtor: Inicializa a Biblioteca e o Scanner
    public SistemaBiblioteca() {
        this.biblio = new Biblioteca();
        this.scanner = new Scanner(System.in);         
    }

    public void cadastrarLivro() {
        int id = 0;
        int ano = 0;
        String titulo = null;
        String editora = null;
        String isbn = null;

        System.out.println("\n--- CADASTRO DE NOVO LIVRO ---");
        //Entrada do ID (tratamento básico de erro para int)
        while (true) {
            System.out.print("ID do Livro (apenas números): ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } else {
                System.err.println("ERRO: O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer de entrada incorreta
            }
        }
        
        //Entrada do Título do Livro
        System.out.print("Título: ");
        titulo = scanner.nextLine();
        
        //Entrada do Ano de Publicação (tratamento básico de erro para int)
        while (true) {
            System.out.print("Ano de Publicação (apenas números): ");
            if (scanner.hasNextInt()) {
                ano = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } else {
                System.err.println("ERRO: O Ano deve ser um número inteiro. Tente novamente.");
                scanner.nextLine();
            }
        }
        
        //Entrada da Editora
        System.out.print("Editora: ");
        editora = scanner.nextLine();
        
        //Entrada do ISBN
        System.out.print("ISBN: ");
        isbn = scanner.nextLine();
        
        //Instanciar um Objeto Livro
        Livro novoLivro = new Livro(id, titulo, ano, editora, isbn);
        
        //Inserir o Livro na Lista de Livros da Biblioteca (Persistência)
        try {
            // Assume que este método está na Biblioteca
            biblio.adicionarLivro(novoLivro); 
            System.out.println("Livro cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            // Captura exceções (ex: ID ou ISBN duplicado)
            System.err.println("Erro ao cadastrar livro: " + e.getMessage());
        }
    }//cadastrarLivro()    

    public void relatorioTodosLivros(){
        List<Livro> listaLivros = biblio.getAllLivros();

        System.out.println("\n---- RELATÓRIO TODOS OS LIVROS ----");
        if (listaLivros.size()>0){
            //4 35 4 20
            System.out.println("Id   Título                              Ano  Editora              ISBN");
        }else{
            System.out.println("Nenhum Livro Cadastrado!");
            return;
        }
        for (Livro livro : listaLivros) {
            System.out.printf("%-4d %-35s %4d %-20s %-11s%n",livro.getId(), livro.getTitulo(),livro.getAno(),livro.getEditora(), livro.getIsbn());
        }

    }//Fim relatorioTodosLivros()

    public void cadastrarAutor() {
        int id = 0;
        String nome = null;

        System.out.println("\n--- CADASTRO DE NOVO AUTOR ---");
        //Entrada do ID (tratamento básico de erro para int)
        while (true) {
            System.out.print("ID do Autor (apenas números): ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } else {
                System.err.println("ERRO: O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer de entrada incorreta
            }
        }
        
        //Entrada do Nome do Autor
        System.out.print("Nome do Autor: ");
        nome = scanner.nextLine();
                
        //Instanciar um Objeto Autor
        Autor novoAutor = new Autor(id, nome);
        
        //Inserir o Autor na Lista de Autores da Biblioteca (Persistência)
        try {
            // Assume que este método está na Biblioteca
            biblio.adicionarAutor(novoAutor); 
            System.out.println("Autor cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            // Captura exceções (ex: ID ou Nome duplicado)
            System.err.println("Erro ao cadastrar Autor: " + e.getMessage());
        }
    }//Fim cadastrarAutor()    

    public void relatorioTodosAutores(){
        List <Autor> listaAutores = biblio.getAllAutores();

        System.out.println("\n---- RELATÓRIO TODOS OS AUTORES ----");
        if (listaAutores.size()>0){
            System.out.println("Id   Nome");
        }else{
            System.out.println("Nenhum Autor Cadastrado!");
            return;
        }
        for (Autor autor : listaAutores) {
            System.out.printf("%-4d %s %n",autor.getId(), autor.getNome());
        }
    }//Fim relatorioTodosAutores()

    public void cadastrarUsuario() {
        int id = 0;
        String nome = null;
        String email = null;
        String ra = null;
        String curso = null;
        String matricula = null;
        String area = null;
        String dpto = null;
        int tipo = 0; 
        Usuario novoUsuario = null;

        System.out.println("\n--- CADASTRO DE NOVO USUÁRIO ---");
        //Entrada do ID (tratamento básico de erro para int)
        while (true) {
            System.out.print("ID do Usuário (apenas números): ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } else {
                System.err.println("ERRO: O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer de entrada incorreta
            }
        }
        
        //Entrada do Nome do Usuário
        System.out.print("Nome do Usuário: ");
        nome = scanner.nextLine();
                
        //Entrada do Email do Usuário
        System.out.print("Email do Usuário: ");
        email = scanner.nextLine();

        while (true) {
            System.out.print("Selecione o Tipo([1]Aluno [2]Professor [3]Funcionário)-> ");
            if (scanner.hasNextInt()) {
                tipo = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                if (tipo==1 || tipo==2 || tipo==3){
                    break;
                }else{
                    System.err.println("ERRO: O tipo deve ser 1, 2 ou 3. Tente novamente.");    
                }
            } else {
                System.err.println("ERRO: O tipo deve ser 1, 2 ou 3. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer de entrada incorreta
            }
        }

        if (tipo==1){  //Usuário Aluno
            //Entrada do RA do Aluno
            System.out.print("RA do Aluno: ");
            ra = scanner.nextLine();            

            //Entrada do Curso do Aluno
            System.out.print("Curso do Aluno: ");
            curso = scanner.nextLine();            

            //Instanciar um Objeto Aluno
            //novoUsuario = (Usuario) new Aluno(ra, curso, id, nome, email);
            //NÃO preciso do cast (Usuario). O Java já faz o upcasting automaitcamente
            novoUsuario = new Aluno(ra, curso, id, nome, email);

        }else if (tipo==2) { //Usuário Professor
            //Entrada da Matrícula do Professor
            System.out.print("Matrícula do Professor: ");
            matricula = scanner.nextLine();

            //Entrada da Área do Professor
            System.out.print("Área de Ensino: ");
            area = scanner.nextLine();

            //Instanciar um Objeto Professor
            //novoUsuario = (Usuario) new Professor(matricula, area, id, nome, email);
            //NÃO preciso do cast (Usuario). O Java já faz o upcasting automaitcamente
            novoUsuario = new Professor(matricula, area, id, nome, email);
        }else{ //Usuário Funcionário
            //Entrada da Matrícula do Funcionário
            System.out.print("Matrícula do Funcionário: ");
            matricula = scanner.nextLine();

            //Entrada do Dpto do Funcionário
            System.out.print("Departamento: ");
            dpto = scanner.nextLine();

            //Instanciar um Objeto Funcionário
            //novoUsuario = (Usuario) new Funcionario(matricula, dpto, id, nome, email);
            //NÃO preciso do cast (Usuario). O Java já faz o upcasting automaitcamente
            novoUsuario = new Funcionario(matricula, dpto, id, nome, email);
        }

        //Inserir o Usuário na Lista de Usuários da Biblioteca (Persistência)
        try {
            // Assume que este método está na Biblioteca
            biblio.adicionarUsuario(novoUsuario); 
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            // Captura exceções (ex: ID ou Nome duplicado)
            System.err.println("Erro ao cadastrar Usuário: " + e.getMessage());
        }
    }//Fim cadastrarUsuario()    

    public void relatorioTodosUsuarios(){
        List<Usuario> listaUsuarios = biblio.getAllUsuarios();

        System.out.println("\n---- RELATÓRIO TODOS OS USUÁRIOS ----");
        if (listaUsuarios.size()>0){
            //4 35 20 12 
            System.out.println("Id   Nome                                Email               Ra/Matrícula Curso/Area/Depto");
        }else{
            System.out.println("Nenhum Usuário Cadastrado!");
            return;
        }
        for (Usuario usuario : listaUsuarios) {
            System.out.printf("%-4d %-35s %-20s",usuario.getId(), usuario.getNome(),usuario.getEmail());
            if (usuario.getTipoUsuario().equals("Aluno")){
                Aluno aluno = (Aluno) usuario; //Downcast
                System.out.printf("%-12s %s%n",aluno.getRa(), aluno.getCurso());
            }else if (usuario.getTipoUsuario().equals("Professor")){
                Professor professor = (Professor) usuario; //Downcast
                System.out.printf("%-12s %s%n",professor.getMatricula(), professor.getArea());
            } else {
                Funcionario funcionario = (Funcionario) usuario; //Downcast
                System.out.printf("%-12s %s%n",funcionario.getMatricula(), funcionario.getDpto());
            }
        }

    }//Fim relatorioTodosUsuarios()
 
    public void relacionarLivroAutor(){
        int idlivro;
        int idautor;

        System.out.println(">>> RELACIONAMENTO LIVRO -> AUTOR:");
        //Solicitar o ID do Livro, Buscar e mostrar
        while (true) {
            System.out.print("Digite o ID do Livro (apenas números): ");
            if (scanner.hasNextInt()) {
                idlivro = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } else {
                System.err.println("ERRO: O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer de entrada incorreta
            }
        }

        //Buscar o Livro e mostrar
        Livro livro = biblio.getLivroById(idlivro);
        if (livro==null){
            throw new IllegalArgumentException("Livro NÃO Localizado!");
        }else{
            System.out.println(livro.getId()+" - "+livro.getTitulo());
            if (!Util.confirma(scanner, "Confirma Livro")){
                throw new IllegalArgumentException("Livro NÃO Confirmado!");
            }
        }
        //Solicitar o código do Autor 
        while (true) {
            System.out.print("Digite o ID do Autor (apenas números): ");
            if (scanner.hasNextInt()) {
                idautor = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } else {
                System.err.println("ERRO: O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer de entrada incorreta
            }
        }

        //Buscar o Autor e mostrar
        Autor autor = biblio.getAutorById(idautor);
        if (autor==null){
            throw new IllegalArgumentException("Autor NÃO Localizado!");
        }else{
            System.out.println(autor.getId()+" - "+autor.getNome());
            if (!Util.confirma(scanner, "Confirma Autor")){
                throw new IllegalArgumentException("Autor NÃO Confirmado!");
            }            
        }

        //Pedir Confirmação
        if (Util.confirma(scanner, "Gravar Relacionamento")){
            LivroAutor livroAutor = new LivroAutor(livro, autor);
            try {
                biblio.adicionarLivroAutor(livroAutor);
                System.out.println("Relacionamento Concluído com Sucesso.");        
            } catch (Exception e) {
                System.err.println("ERRO: Não foi possível concluir o Relacionamento. "+ e.getMessage());
            }
            
        }else{
            System.out.println("Operação Cancelada!");
        }

    }//Fim relacionarLivroAutor()

    public void relatorioTodosRelacionamentos(){
        List <LivroAutor> listaLivroAutores = biblio.getAllLivroAutores();

        System.out.println("\n---- RELATÓRIO TODOS OS RELACIONAMENTOS Livro->Autor ----");
        if (!listaLivroAutores.isEmpty()){
            System.out.println("       L I V R O             A U T O R ");
        }else{
            System.out.println("Nenhum Relacionamento Cadastrado!");
            return;
        }
        for (LivroAutor livroautor : listaLivroAutores) {
            Livro livro = livroautor.getLivro();
            Autor autor = livroautor.getAutor();
            System.out.println(livro.getId()+"-"+livro.getTitulo()+" -> "+autor.getId()+"-"+autor.getNome());
        }
    }//Fim relatorioTodosRelacionamentos()

    public void emprestimo(){
        int idusuario = 0;
        int idlivro = 0;
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Solicitar o ID do Usuário, Buscar e Mostrar
        System.out.println(">>> E M P R É S T I M O:");
        while (true) {
            System.out.print("ID do Usuário (apenas números): ");
            if (scanner.hasNextInt()) {
                idusuario = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } else {
                System.err.println("ERRO: O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer de entrada incorreta
            }
        }

        Usuario usuario = biblio.getUsuarioById(idusuario);
        if (usuario==null){
            throw new IllegalArgumentException("Usuário NÃO Localizado!");
        }else{
            System.out.println(usuario.getId()+" - "+usuario.getNome());
            if (!Util.confirma(scanner, "Confirma Usuário")){
                throw new IllegalArgumentException("Usuário NÃO Confirmado!");
            }
        }        

        //Solicitar o ID do Livro, Buscar e Mostrar
        while (true) {
            System.out.print("Digite o ID do Livro (apenas números): ");
            if (scanner.hasNextInt()) {
                idlivro = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } else {
                System.err.println("ERRO: O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer de entrada incorreta
            }
        }

        //Buscar o Livro e mostrar
        Livro livro = biblio.getLivroById(idlivro);
        if (livro==null){
            throw new IllegalArgumentException("Livro NÃO Localizado!");
        }else{
            System.out.println(livro.getId()+" - "+livro.getTitulo());
            if (!Util.confirma(scanner, "Confirma Livro")){
                throw new IllegalArgumentException("Livro NÃO Confirmado!");
            }
        }

        //Calcular e mostrar Data Devolução
        System.out.println("Tipo Usuário: "+ usuario.getTipoUsuario());
        System.out.println("Limite de Empréstimos: "+ usuario.getLimiteLivros());
        System.out.println("Prazo de Empréstimo: "+ usuario.getPrazoEmprestimo()+" dias");
        System.out.println("Data prevista para Devolução: "+formataData.format(LocalDate.now().plusDays(usuario.getPrazoEmprestimo())));

        //Pedir Confirmação e Gravar 
        //Obs.: Consistência de Limite Livros do usuário e Consistência Livro Já Emprestado Feito na classe Biblioteca
        if (Util.confirma(scanner, "Gravar Empréstimo")){
            Emprestimo emprestimo = new Emprestimo(biblio.getIdUltimoEmprestimo()+1,livro, usuario,LocalDate.now());
            try {
                biblio.adicionarEmprestimo(emprestimo);
                System.out.println("Empréstimo Concluído com Sucesso.");        
            } catch (Exception e) {
                System.err.println("ERRO: Não foi possível concluir o Empréstimo. "+ e.getMessage());
            }
            
        }else{
            System.out.println("Operação Cancelada!");
        }
                
    }//Fim emprestimo()

    public void relatorioTodosEmprestimos(){
        List <Emprestimo> listaEmprestimos = biblio.getAllEmprestimos();


        System.out.println("\n---- RELATÓRIO TODOS OS Empréstimos ----");
        if (!listaEmprestimos.isEmpty()){
            //3 25 20 10 9
            System.out.println("ID  L I V R O                 U S U Á R I O        Empréstimo Devolução Observação");
        }else{
            System.out.println("Nenhum Empréstimo Encontrado!");
            return;
        }        
        for (Emprestimo emprestimo : listaEmprestimos) {
            Livro livro = emprestimo.getLivro();
            Usuario usuario = emprestimo.getUsuario();
            String status = null;

            long dias = ChronoUnit.DAYS.between(emprestimo.getDataEmprestimo(), LocalDate.now());
            if ( dias <= usuario.getPrazoEmprestimo()){
                status = "No Prazo!";
            } else {
                status = "Atrasado!";
            }
            System.out.printf("%-3d %d-%-23s %d-%-18s %-10s %-10s %-10s\n",emprestimo.getId(),
                livro.getId(),livro.getTitulo(),usuario.getId(),usuario.getNome(),
                emprestimo.getStrDataEmprestimo(),emprestimo.getStrDataDevolucao(), status);
        }        

    }//Fim relatorioTodosEmprestimos()

    public void devolucao(){
        int idlivro = 0;
        Emprestimo emprestimo = null;
        Usuario usuario;
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Solicitar id do Livro a ser Devolvido, localizar e mostrar
        while (true) {
            System.out.print("Digite o ID do Livro (apenas números): ");
            if (scanner.hasNextInt()) {
                idlivro = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } else {
                System.err.println("ERRO: O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer de entrada incorreta
            }
        }

        //Buscar o Livro, mostrar e pedir Confirmação
        Livro livro = biblio.getLivroById(idlivro);
        if (livro==null){
            throw new IllegalArgumentException("Livro NÃO Localizado!");
        }else{
            System.out.println(livro.getId()+" - "+livro.getTitulo());
            if (!Util.confirma(scanner, "Confirma Livro")){
                throw new IllegalArgumentException("Livro NÃO Confirmado!");
            }
        }

        //Buscar o Empréstimo Ativo do Livro para já mostrar o Usuário e Pedir Confirmação
        emprestimo = biblio.getEmprestimoAtivoLivro(livro);
        if (emprestimo==null){
            throw new IllegalArgumentException("Nenhum Empréstimo em Aberto para este Livro!");
        }

        //Se achou o Empréstimo, mostra dados e Pede Confirmação
        usuario = emprestimo.getUsuario();
        System.out.println("Usuário: "+ usuario.getTipoUsuario()+ ": "+usuario.getNome());
        System.out.println("Data prevista para Devolução: "+formataData.format(LocalDate.now().plusDays(usuario.getPrazoEmprestimo())));

        if (!Util.confirma(scanner, "Confirma Devolução")){
            throw new IllegalArgumentException("Devolução NÃO Confirmada!");
        }

        emprestimo.registrarDevolucao(LocalDate.now());
        emprestimo.getLivro().devolver();


        //FALTA TERMINAR AQUI!!!

    }//Fim devolucao()

    // Método Principal de Execução
    public void executar() {
        int opcao = 0;
        
        //Insere Alguns Livros para teste:
        biblio.adicionarLivro(new Livro(1, "Java: como programar", 2017, "Pearson", "9788543004792"));
        biblio.adicionarLivro(new Livro(2, "Estruturas de Dados", 2010, "Pearson", "9788576058816"));
        biblio.adicionarLivro(new Livro(3, "Algoritmos em Java", 2017, "Casa do Código", "9788555192449"));
        //Adicionar Alguns Autores para teste:
        biblio.adicionarAutor(new Autor(1,"Paul J. Deitel"));
        biblio.adicionarAutor(new Autor(2,"Harvey M. Deitel"));
        biblio.adicionarAutor(new Autor(3,"Ana Fernanda Gomes Ascencio"));
        biblio.adicionarAutor(new Autor(4,"Graziela Santos de Araújo"));
        biblio.adicionarAutor(new Autor(5,"Guilherme Silveira"));
        //Adicionar Alguns Usuários para teste:
        biblio.adicionarUsuario(new Aluno("202555999","Sistemas", 1,"Olivaldo Pereira","oli@valdo.com"));
        biblio.adicionarUsuario(new Professor("1139","Informática", 2,"Jandrovir Fonseca","jandro@fon.com"));
        biblio.adicionarUsuario(new Funcionario("5543","Tesouraria", 3,"Ana Barrilha","ana@barri.com"));
        

        // Loop principal: Mantém o menu rodando até que a opção Sair seja escolhida
        do {
            exibirMenu();
            
            // Tratamento de erro para garantir que o usuário digitou um número
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha (newline)
                executarOpcao(opcao);
            } else {
                System.err.println("\nOPÇÃO INVÁLIDA! Por favor, digite um número.");
                scanner.nextLine(); // Limpa a entrada para evitar loop infinito
                opcao = -1; // Reinicia o loop
            }
        } while (opcao != 0);
        
        // Fecha o recurso Scanner
        this.scanner.close(); 
        System.out.println("\nSistema encerrado. Hasta la vista, baby!");
    }

    // Método para exibir as opções do menu
    private void exibirMenu() {
        System.out.println("\n=============================================");
        System.out.println("    SISTEMA DE GERENCIAMENTO DE BIBLIOTECA    ");
        System.out.println("=============================================");
        System.out.println(" [1] Cadastrar Livro");
        System.out.println(" [2] Cadastrar Autor");
        System.out.println(" [3] Cadastrar Usuário");
        System.out.println(" [4] Relacionar Livro-Autor");
        System.out.println(" [5] Empréstimo");
        System.out.println(" [6] Devolução");
        System.out.println(" [7] Relatório Todos Livros");
        System.out.println(" [8] Relatório Todos Autores");
        System.out.println(" [9] Relatório Todos Usuários");
        System.out.println(" [10] Relatório Todos Relacionamentos");
        System.out.println(" [11] Relatório Todos os Empréstimos");
        System.out.println("---------------------------------------------");
        System.out.println(" [0] Sair                      ");
        System.out.println("=============================================");
        System.out.print("Escolha uma opção-> ");
    }

    // Método para executar a funcionalidade escolhida
    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1: //Cadastro de Livro
                cadastrarLivro();
                break;
            case 2: //Cadastro de Autor
                cadastrarAutor();
                break;
            case 3: //Cadastro de Usuário
                cadastrarUsuario();
                break;
            case 4: //Relacionar Livro-Autor
                try{
                    relacionarLivroAutor();
                }catch(Exception e){
                    System.err.println("Erro "+ e.getMessage());
                }
                break;                                
            case 5: //Emprestimo();
                try{
                    emprestimo();
                }catch(Exception e){
                    System.err.println("Erro "+ e.getMessage());
                }
                break;
            case 6: //Devolucao();
                try {
                    devolucao();
                } catch (Exception e) {
                    System.err.println("ERRO: "+ e.getMessage());
                }    
                break;
            case 7: //Relatóiro todos os Livros
                relatorioTodosLivros();
                break;
            case 8: //Relatóiro todos os Autores
                relatorioTodosAutores();
                break;                                
            case 9: //Relatóiro todos os Usuários
                relatorioTodosUsuarios();
                break;                                
            case 10: //Relatóiro todos Relacionamentos1
                relatorioTodosRelacionamentos();
                break;                                
            case 11: //Relatóiro todos Empréstimos
                relatorioTodosEmprestimos();
                break;

                case 0: //Sair
                break;
            default:
                System.err.println("Opção inválida. Tente novamente.");
                break;
        }
    }
      
    // Método main para rodar o sistema
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();
        sistema.executar();
    }
}
