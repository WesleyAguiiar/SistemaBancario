package dto;

public abstract class UserDTO {
    protected String nomeTitular;
    protected String senha;
    protected int tipoConta;
    protected int numeroConta;
    protected double valor;

    public String getNomeTitular() {
        return nomeTitular;
    }

    public String getSenha() {
        return senha;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getValor() {
        return valor;
    }
}
