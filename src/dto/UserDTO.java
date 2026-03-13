package dto;

public class UserDTO {
    String nomeTitular;
    String senha;
    int tipoConta;
    int numeroConta;

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
}
