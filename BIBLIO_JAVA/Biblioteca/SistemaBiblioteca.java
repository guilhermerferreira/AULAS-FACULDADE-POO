package Biblioteca; 


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


    //// CADASTRO AUTOR
    
    public void cadastrarAutor(){
        int id = 0;
        String nome = null;

        System.out.println("\n --- CADASTRO NOVO AUTOR ---");
        //Entrada do ID (tratamento básico de erro para int)
        while(true){
            System.out.printf("ID do autor (apenas números) -> ");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            } else{
                System.err.println("ERRO: O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine();
            }
        }

        System.out.printf("Nome do Autor: ");
        nome = scanner.nextLine();

        Autor novoAutor = new Autor(id, nome);

        try {
            // Assume que este método está na Biblioteca
            biblio.adicionarAutor(novoAutor); 
            System.out.println("Autor cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            // Captura exceções (ex: ID ou nome duplicado)
            System.err.println("Erro ao cadastrar autor: " + e.getMessage());
        }
    }
        // Relatorio de todos os autores
    public void relatorioTodosAutores(){
        List<Autor> listaAutores = biblio.getAllAutors();

        System.out.println("\n---- RELATÓRIO TODOS OS AUTORES ----");
        if (listaAutores.size()>0){
            //4 35 4 20
            System.out.println("Id   Nome                              ");
        }else{
            System.out.println("Nenhum Autor Cadastrado!");
            return;
        }
        for (Autor autor : listaAutores) {
            System.out.printf("%-4d %-35s ",autor.getId(), autor.getNome());
            System.err.println();
        }
    }

    ////////// ----------------------------------------- //////////////


    /// CADASTRO LIVRO
 
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
    }    
    // Relatorio de todos os livros
    public void relatorioTodosLivros(){
        List<Livro> listaLivros = biblio.getAll();

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


    ////////// ----------------------------------------- //////////////
      
    //  CADASTRO USUARIO                                             //
 

    public void CadastrarUsuario(){
        int id = 0;
        String nome = null;
        String email = null;
        int tipo;
        String ra = null;
        String curso = null;
        String matricula = null;
        String area = null;
        String dpto = null;
        Usuario novoUsuario = null;


        System.out.println("\n--- CADASTRO DE NOVO USUARIO ---");

        //Entrada do ID (tratamento básico de erro para int)
        while (true){
            System.out.print("ID do Usuario (apenas números): ");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } else {
                System.out.println("ERRO: O Ano deve ser um número inteiro. Tente novamente.");
                scanner.nextLine();
            }
        }
        // Entrada do Nome
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        // Entrada do email
        System.out.print("Email: ");
        email = scanner.nextLine();

        while (true){
            System.out.printf("Selecione o tipo ([1]Aluno [2]Professor [3]Funcionário) -> ");
            if (scanner.hasNextInt()){
                tipo = scanner.nextInt();
                scanner.nextLine();
                if (tipo == 1 || tipo == 2 || tipo == 3){
                    break;
                } else{
                     System.out.println("ERRO: O tipo de Usuario esta incorreto. Tente novamente.");
                    scanner.nextLine();
                }
            } else {
                System.out.println("ERRO: O tipo deve ser um número inteiro. Tente novamente.");
                scanner.nextLine();
            }
        }

        if (tipo ==1 ){ // Aluno  
            System.out.print("RA: ");
            ra = scanner.nextLine();

            System.out.print("Curso: ");
            curso = scanner.nextLine();
             // Instacia o objeto usuario como aluno
            novoUsuario = new Aluno(id, nome, email, ra, curso);

        } else if (tipo == 2){ // Professor
            System.out.print("Matricula: ");
            matricula = scanner.nextLine();

            System.out.print("Area: ");
            area = scanner.nextLine();
             // Instacia o objeto usuario como professor
            novoUsuario = new Professor(id, nome, email, matricula, area);

        } else if (tipo == 3){ // Funcionario
            System.out.print("Matricula: ");
            matricula = scanner.nextLine();

            System.out.print("Departamento: ");
            dpto = scanner.nextLine();
            // Instacia o objeto usuario como funcionario
            novoUsuario = new Funcionario(id, nome, email, matricula, dpto);

        } else{
            System.out.println("Opcao Invalida. Tente novamente.");
        }

        try {
            // Assume que este método está na Biblioteca
            biblio.adicionarUsuario(novoUsuario); 
            System.out.println("Usuario cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            // Captura exceções (ex: ID Nome ou email duplicado)
            System.err.println("Erro ao cadastrar Usuario: " + e.getMessage());
        }
    }
    public void relatorioTodosUsuarios(){
        List<Usuario> listaUsuarios = biblio.getAllUsuarios();

        System.out.println("\n---- RELATÓRIO TODOS OS LIVROS ----");
        if (listaUsuarios.size() > 0){       // 4 35 25 //
            System.out.println("Id   Nome                         Email                        Ra/Matricula/dpto/Area "); 
        }
        else{
            System.out.println("Nenhum Usuario cadastrado!");
            return;
        }
        for (Usuario usuario : listaUsuarios){
            System.out.printf("%-4d %-35s %-20s", usuario.getId(), usuario.getNome(), usuario.getEmail());
            if (usuario.getTipoUsuario().equals("Aluno")){
                Aluno aluno = (Aluno) usuario;
                System.out.printf("%-12s %s%n", aluno.getRa(), aluno.getCurso());
            }
            if (usuario.getTipoUsuario().equals("Funcionario")){
                Funcionario funcionario = (Funcionario) usuario;
                System.out.printf("%-12s %s%n", funcionario.getMatricula(), funcionario.getdpto());
            }
            if (usuario.getTipoUsuario().equals("Professor")){
                Professor professor = (Professor) usuario;
                System.out.printf("%-12s %s%n", professor.getMatricula(), professor.getArea());
            }
            }
        
        }

       ////////// ----------------------------------------- //////////////
       //                   RELACIONAR LIVRO AUTOR                      //

       public void RelacionarLivroAutor(){
        int idLivro = 0;
        int idAutor = 0;

        System.out.println("\n--- RELAÇÃO LIVRO AUTOR ---");

        System.out.printf("Digite o ID do livro -> ");
        while (true) {
            if (scanner.hasNextInt()){
                idLivro = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } else {
                System.out.println("ERRO: O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine();
            }
        }
        // Localizando o Livro a partir do id
        Livro livro = biblio.localizarLivro(idLivro);
        if (livro == null){
            System.out.println("Livro não encontrado!");
            return;
        }

          System.out.printf("Digite o ID do autor -> ");
        while (true) {
            if (scanner.hasNextInt()){
                idAutor = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                break;
            } else {
                System.out.println("ERRO: O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine();
            }
        }

        // Localizando o Autor a partir do id
        Autor autor = biblio.localizarAutor(idAutor);
        if (autor == null){
            System.out.println("Autor não encontrado!");
            return;
        }

        
    }



      ////////// ----------------------------------------- //////////////
    

    // Método Principal de Execução
    public void executar() {
        int opcao = 0;
        
        //Insere Alguns Livros para teste:
        biblio.adicionarLivro(new Livro(1, "Java Essencial", 2020, "Alta Books", "1234567890"));
        biblio.adicionarLivro(new Livro(2, "Estruturas de Dados", 2018, "Pearson", "0987654321"));
        biblio.adicionarLivro(new Livro(3, "Algoritmos em Java", 2022, "Elsevier", "1112223334"));

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
        System.out.println(" [4] Empréstimo");
        System.out.println(" [5] Devolução");
        System.out.println(" [6] Relacionar Livro Autor");
        System.out.println(" [7] Relatório Todos Livros");
        System.out.println(" [8] Relatório Todos Autores");
        System.out.println(" [9] Relatório Todos Usuários");
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
                CadastrarUsuario();
                break;
            case 4: //Emprestimo();
                System.out.println("Empréstimo em desenvolvimento...");
                break;
            case 5: //Devolucao();
                System.out.println("Devolução em desenvolvimento...");
                break;
            case 6: //Devolucao();
                RelacionarLivroAutor();
                break;
            case 7: //Relatóiro todos os Livros;
                relatorioTodosLivros();
                break;        
            case 8: // Relatorio todos autores;
                relatorioTodosAutores();
                break;        
            case 9: // Relatorio todos autores;
                relatorioTodosUsuarios();
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

