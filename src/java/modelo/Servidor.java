package modelo;

public class Servidor extends ServidorAbstrato {

    public Servidor() {
    }

    public Servidor(String siape) {
        super(siape);
    }

    public Servidor(String siape, String nome) {
        super(siape, nome);
    }

    public Servidor(String siape, String nome, String senha) {
        super(siape, nome, senha);
    }

    public Servidor(String siape, String nome, String senha, String funcao) {
        super(siape, nome, senha, funcao);
    }

}
