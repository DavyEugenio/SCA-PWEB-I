package modelo;

public class Aluno {

    private String sage;
    private String nome;
    private int id_turma;
    private String senha;
    private String status;

    public Aluno() {
    }

    public Aluno(String sage, String nome, int id_turma, String senha, String status) {
        this.sage = sage;
        this.nome = nome;
        this.id_turma = id_turma;
        this.senha = senha;
        this.status = status;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
