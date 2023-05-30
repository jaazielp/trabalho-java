import java.io.Serializable;
import java.util.List;

public class Livro implements Serializable, Pesquisavel {
    private String titulo, autor;
    private int anoPublicacao, numExemplares, codigo;
    private List<Emprestimo> emprestimos;

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }


    public Livro(String titulo, String autor, int anoPublicacao, int numExemplares) {
        this.codigo = gerarCodigoUnico();
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numExemplares = numExemplares;
    }

    private int gerarCodigoUnico() {
        return 0;
    }

    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public int getAnoPublicacao() {
        return anoPublicacao;
    }


    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }


    
    public int getNumExemplares() {
        return numExemplares - Emprestimo.size();
    }


    public void setNumExemplares(int numExemplares) {
        this.numExemplares = numExemplares;
    }


    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao + ", numExemplares="
                + numExemplares + "]";
    }


    @Override
    public boolean pesquisar(String termo, int opcao) {
        if (opcao == 1) {
            return titulo.toLowerCase().contains(termo.toLowerCase());
        } else if (opcao == 2) {
            return autor.toLowerCase().contains(termo.toLowerCase());
        } else {
            return false;
        }
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimo.add(emprestimo);
    }


    public Emprestimo getUltimoEmprestimo() {
        if (emprestimos.isEmpty()) {
            return null;
        }
        return emprestimos.get(emprestimos.size() - 1);
    }


    public void removerEmprestimo(Emprestimo emprestimo) {
        emprestimos.remove(emprestimo);
    }


    public int getCodigo() {
        return 0;
    }

   
}
