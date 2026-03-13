package model;

public class ContaCorrente extends Conta
{
    public ContaCorrente(String titular, String senha, int conta, int agencia) {
        super(titular, senha, conta, agencia);
    }

    public void depositar(double valor){
        if (valor <= 0){
            System.out.println("Erro: O valor mínimo para depósito é de R$  1,00");
        } else {
            this.saldo += valor;
        } if (this.saldo > 2){
            System.out.println("Info Conta Corrente: A taxa para depósito de R$ 2,00 foi aplicada.");
            saldo -= 2;
        }
    }

    public void sacar(double valor){
        if (valor > this.saldo || this.saldo < 0){
            System.out.println("Erro: Saldo insuficiente.");
        } else {
            saldo -= valor;
        } if (saldo > 2){
            System.out.println("Info Conta Corrente: A taxa para saque de R$ 2,00 foi aplicada.");
            saldo -= 2;
        }
    }
}

