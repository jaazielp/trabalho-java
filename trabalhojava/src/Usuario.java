import java.io.Serializable;

public class Usuario implements Serializable {
    private String nome, endereco, email;
    private int telefone, id;
    private Emprestimo livroEmprestado;


    public Usuario(String nome, String endereco, String email, int telefone) {
        this.id = gerarIdUnico();
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }


    private int gerarIdUnico() {
        return 0;
    }

    
    public Emprestimo getLivroEmprestado(){
        return livroEmprestado;
    }

    public Usuario(String nome2, String telefone2, String endereco2, String email2) {
    }

    public void setLivroEmprestado(Emprestimo emprestimo) {
        livroEmprestado = emprestimo;
    }

    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public int getTelefone() {
        return telefone;
    }


    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setLivroEmprestado(Livro livro) {
    }

    public boolean temLivroEmprestado() {
        return livroEmprestado != null;
    }

    public int getID() {
        return 0;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", endereco=" + endereco + ", email=" + email + ", telefone=" + telefone + "]";
    }
}
