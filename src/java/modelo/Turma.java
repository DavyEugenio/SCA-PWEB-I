package modelo;

public class Turma {

    private int id;
    private int id_curso;
    private int ano;
    private int semestre;
    private String turno;

    public Turma() {
    }

    public Turma(int id_curso, int ano, int semestre, String turno) {
        this.id_curso = id_curso;
        this.ano = ano;
        this.semestre = semestre;
        this.turno = turno;
    }

    public Turma(int id, int id_curso, int ano, int semestre, String turno) {
        this.id = id;
        this.id_curso = id_curso;
        this.ano = ano;
        this.semestre = semestre;
        this.turno = turno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
