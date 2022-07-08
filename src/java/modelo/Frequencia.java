package modelo;

public class Frequencia {

    private int id;
    private String entrada;
    private String saida;
    private String sage_aluno;

    public Frequencia() {
    }
    
    public Frequencia(String entrada, String sage_aluno) {
        this.entrada = entrada;
        this.sage_aluno = sage_aluno;
    }
    
    public Frequencia(String entrada, String saida, String sage_aluno) {
        this.entrada = entrada;
        this.saida = saida;
        this.sage_aluno = sage_aluno;
    }

    public Frequencia(int id, String entrada, String saida, String sage_aluno) {
        this.id = id;
        this.entrada = entrada;
        this.saida = saida;
        this.sage_aluno = sage_aluno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public String getSage_aluno() {
        return sage_aluno;
    }

    public void setSage_aluno(String sage_aluno) {
        this.sage_aluno = sage_aluno;
    }
}
