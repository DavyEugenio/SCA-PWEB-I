package modelo;

public class Operador extends ServidorAbstrato{

    public Operador() {
    }

    public Operador(String siape) {
        super(siape);
    }

    public Operador(String siape, String nome) {
        super(siape, nome);
    }

    public Operador(String siape, String nome, String senha) {
        super(siape, nome, senha);
    }

    public Operador(String siape, String nome, String senha, String funcao) {
        super(siape, nome, senha, funcao);
    }
}
