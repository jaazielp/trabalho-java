import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Emprestimo implements Serializable {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate dataDevolucaoEfetiva;
    private Object setDataDevolucaoEfetiva;


    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dataDevolucaoEfetiva = null;
    }


    public Livro getLivro() {
        return livro;
    }


    public void setLivro(Livro livro) {
        this.livro = livro;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }


    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }


    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }


    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void add(Emprestimo emprestimo) {
    }

    public void setDataDevolucao(boolean b) {
    }

    
    public void setDataDevolucaoEfetiva(Date dataDevolucaoEfetiva) {
        this.setDataDevolucaoEfetiva = dataDevolucaoEfetiva;
    }

    public static int size() {
        return 0;
    }

}
