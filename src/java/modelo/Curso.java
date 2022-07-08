package modelo;

public class Curso {

    private int id;
    private String nome;
    private String modalidade;

    public Curso() {
    }

    public Curso(String nome, String modalidade) {
        this.nome = nome;
        this.modalidade = modalidade;
    }

    public Curso(int id, String nome, String modalidade) {
        this.id = id;
        this.nome = nome;
        this.modalidade = modalidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
}
