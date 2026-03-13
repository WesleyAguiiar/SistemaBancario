package dto;

public class UserDTOTransferencia extends UserDTO{

    public UserDTOTransferencia(int numeroConta, double valor, String senha) {
        this.numeroConta = numeroConta;
        this.valor = valor;
        this.senha = senha;
    }
}
