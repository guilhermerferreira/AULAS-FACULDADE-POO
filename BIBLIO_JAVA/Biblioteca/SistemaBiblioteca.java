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

        while(true){
            System.out.println("ID do autor (apenas números)");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            } else{
                System.err.println("ERRO: O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine();
            }
        }

        System.out.println("Nome do Autor: ");
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
      
      //                  USUARIO                  //


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

        // Entrada ID
        while (true){
            System.out.print("ID do Usuario (apenas números): ");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("ERRO: O Ano deve ser um número inteiro. Tente novamente.");
                scanner.nextLine();
            }
        }

        System.out.print("Nome: ");
        nome = scanner.nextLine();

        System.out.print("Email: ");
        email = scanner.nextLine();

        while (true){
            System.out.println("Selecione o tipo ([1]Aluno [2]Professor [3]Funcionário) -> ");
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

            novoUsuario = new Aluno(id, nome, email, ra, curso);

        } else if (tipo == 2){ // Professor
            System.out.print("Matricula: ");
            matricula = scanner.nextLine();

            System.out.print("Area: ");
            area = scanner.nextLine();

            novoUsuario = new Professor(id, nome, email, matricula, area);

        } else if (tipo == 3){ // Funcionario
            System.out.print("Matricula: ");
            matricula = scanner.nextLine();

            System.out.print("Departamento: ");
            dpto = scanner.nextLine();

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
        System.out.println(" [6] Relatório Todos Livros");
        System.out.println(" [7] Relatório Todos Autores");
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
            case 6: //Relatóiro todos os Livros;
                relatorioTodosLivros();
                break;        
            case 7: // Relatorio todos autores;
                relatorioTodosAutores();
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

