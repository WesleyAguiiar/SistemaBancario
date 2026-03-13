package dto;

public class UserDTOCadastro extends UserDTO{

    public UserDTOCadastro(String nomeTitular, String senha, int tipoConta) {
        this.nomeTitular = nomeTitular;
        this.senha = senha;
        this.tipoConta = tipoConta;
    }
}
