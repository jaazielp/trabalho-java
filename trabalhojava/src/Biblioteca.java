
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    // executando o menu
    public void executarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        while (opcao != 6) {
            exibirMenu();
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    pesquisarLivro();
                    break;
                case 3:
                    cadastrarUsuario();
                    break;
                case 4:
                    emprestarLivro();
                    break;
                case 5:
                    devolverLivro();
                    break;
                case 6:
                    salvarDados();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
        // exibi o menu de opções
        private void exibirMenu() {
            System.out.println("=== MENU ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Pesquisar Livro");
            System.out.println("3. Cadastrar Usuário");
            System.out.println("4. Emprestar Livro");
            System.out.println("5. Devolver Livro");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
        }

        // cadastrando livros
        private void cadastrarLivro() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== CADASTRO DE LIVRO ===");
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            System.out.print("Autor: ");
            String autor = scanner.nextLine();
            System.out.print("Ano de Publicação: ");
            int anoPublicacao = scanner.nextInt();
            System.out.print("Número de Exemplares Disponíveis: ");
            int numExemplares = scanner.nextInt();
            
            Livro livro = new Livro(titulo, autor, anoPublicacao, numExemplares);
            livros.add(livro);
            
            System.out.println("Livro cadastrado com sucesso!");
        }
        
        // Pesquisando livro
        private void pesquisarLivro() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== PESQUISA DE LIVRO ===");
            System.out.println("1. Pesquisar por Código");
            System.out.println("2. Pesquisar por Título");
            System.out.println("3. Pesquisar por Autor");
            System.out.println("4. Pesquisar por Categoria"); // Adicione categorias aos livros, se necessário
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o código do livro: ");
                    int codigo = scanner.nextInt();
                    Livro livroPorCodigo = pesquisarLivroPorCodigo(codigo);
                    if (livroPorCodigo != null) {
                        System.out.println("Livro encontrado:");
                        System.out.println(livroPorCodigo);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o título do livro: ");
                    scanner.nextLine(); // Limpar o buffer do scanner antes de ler a próxima linha
                    String titulo = scanner.nextLine();
                    List<Livro> livrosPorTitulo = pesquisarLivroPorTitulo(titulo);
                    if (!livrosPorTitulo.isEmpty()) {
                        System.out.println("Livros encontrados:");
                        for (Livro livro : livrosPorTitulo) {
                            System.out.println(livro);
                        }
                    } else {
                        System.out.println("Nenhum livro encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o autor do livro: ");
                    scanner.nextLine(); // Limpar o buffer do scanner antes de ler a próxima linha
                    String autor = scanner.nextLine();
                    List<Livro> livrosPorAutor = pesquisarLivroPorAutor(autor);
                    if (!livrosPorAutor.isEmpty()) {
                        System.out.println("Livros encontrados:");
                        for (Livro livro : livrosPorAutor) {
                            System.out.println(livro);
                        }
                    } else {
                        System.out.println("Nenhum livro encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite a categoria do livro: ");
                    scanner.nextLine(); // Limpar o buffer do scanner antes de ler a próxima linha
                    String categoria = scanner.nextLine();
                    List<Livro> livrosPorCategoria = pesquisarLivroPorCategoria(categoria);
                    if (!livrosPorCategoria.isEmpty()) {
                        System.out.println("Livros encontrados:");
                        for (Livro livro : livrosPorCategoria) {
                            System.out.println(livro);
                        }
                    } else {
                        System.out.println("Nenhum livro encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        //Cadastrando usuario
        private void cadastrarUsuario() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== CADASTRO DE USUÁRIO ===");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("E-mail: ");
            String email = scanner.nextLine();
            
            Usuario usuario = new Usuario(nome, telefone, endereco, email);
            usuarios.add(usuario);
            
            System.out.println("Usuário cadastrado com sucesso!");
        }

        //Pesquisando livro por codigo
        private Livro pesquisarLivroPorCodigo(int codigo) {
            for(Livro livro : livros){
                if (livro.getCodigo() == codigo){
                    return livro;
                }
            }
            return null;
    }
        //Pesquisando livro por titulo
        private List<Livro> pesquisarLivroPorTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : livros){
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    //pesquisando livro por autor
    private List<Livro> pesquisarLivroPorAutor(String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)){
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    //Pesquisando livro por categoria
    private List<Livro> pesquisarLivroPorCategoria(String categoria) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(categoria)){
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }
    
    //metodo emprestar livro
    private void emprestarLivro() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== EMPRÉSTIMO DE LIVRO ===");
            System.out.print("Digite o código do livro: ");
            int codigoLivro = scanner.nextInt();
            Livro livro = pesquisarLivroPorCodigo(codigoLivro);
            
            if (livro != null) {
                System.out.print("Digite o ID do usuário: ");
                int idUsuario = scanner.nextInt();
                Usuario usuario = pesquisarUsuarioPorID(idUsuario);
                
                if (usuario != null) {
                    if (usuario.temLivroEmprestado()) {
                        System.out.println("Usuário já possui um livro emprestado. Não é possível realizar um novo empréstimo.");
                    } else if (livro.getNumExemplares() > 0) {
                        Date dataEmprestimo = new Date();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(dataEmprestimo);
                        calendar.add(Calendar.DAY_OF_YEAR, 7); // Definir data de devolução prevista para 7 dias após o empréstimo
                        Date dataDevolucaoPrevista = calendar.getTime();
                        
                        Emprestimo emprestimo = new Emprestimo(livro, usuario, null, null);
                        livro.adicionarEmprestimo(emprestimo);
                        usuario.setLivroEmprestado(emprestimo);
                        
                        System.out.println("Livro emprestado com sucesso!");
                    } else {
                        System.out.println("Não há exemplares disponíveis para empréstimo.");
                    }
                } else {
                    System.out.println("Usuário não encontrado.");
                }
            } else {
                System.out.println("Livro não encontrado.");
            }
    }

    //pesquisar usuario por ID
    private Usuario pesquisarUsuarioPorID(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getID() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    //metodo devolver livro
    private void devolverLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== DEVOLUÇÃO DE LIVRO ===");
        System.out.print("Digite o código do livro: ");
        int codigoLivro = scanner.nextInt();
        Livro livro = pesquisarLivroPorCodigo(codigoLivro);
        
        if (livro != null) {
            Emprestimo emprestimo = livro.getUltimoEmprestimo();
            
            if (emprestimo != null) {
                Date dataDevolucao = new Date();
                emprestimo.setDataDevolucaoEfetiva(dataDevolucao);
                livro.removerEmprestimo(emprestimo);
                
                Usuario usuario = emprestimo.getUsuario();
                usuario.setLivroEmprestado(livro);
                
                System.out.println("Livro devolvido com sucesso!");
            } else {
                System.out.println("O livro não está emprestado.");
            }
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void salvarDados() {
        try {
            FileOutputStream arquivo = new FileOutputStream("dados.bin");
            ObjectOutputStream objeto = new ObjectOutputStream(arquivo);
            objeto.writeObject(livros);
            objeto.writeObject(usuarios);
            objeto.close();
            arquivo.close();
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados.");
        }
    }
    
        public void carregarDados(){
        try {
            FileInputStream arquivo = new FileInputStream("dados.bin");
            ObjectInputStream objeto = new ObjectInputStream(arquivo);
            livros = (List<Livro>) objeto.readObject();
            usuarios = (List<Usuario>) objeto.readObject();
            objeto.close();
            arquivo.close();
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os dados.");
        }
    } 
}
