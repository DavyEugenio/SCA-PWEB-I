package modelo;

public abstract class ServidorAbstrato {
    private String siape;
    private String nome;
    private String senha;
    private String funcao;

    public ServidorAbstrato() {
    }
    
    public ServidorAbstrato(String siape) {
        this.siape = siape;
        this.nome = "";
        this.senha = "";
        this.funcao ="";
    }
    
    public ServidorAbstrato(String siape, String nome) {
        this.siape = siape;
        this.nome = nome;
        this.senha = "";
        this.funcao = "";
    }
    
    public ServidorAbstrato(String siape, String nome, String senha) {
        this.siape = siape;
        this.nome = nome;
        this.senha = senha;
        this.funcao = "";
    }
    
    public ServidorAbstrato(String siape, String nome, String senha, String funcao) {
        this.siape = siape;
        this.nome = nome;
        this.senha = senha;
        this.funcao = funcao;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
}
