package model;

public class ContaPoupanca extends Conta implements TaxaMensal
{
    public ContaPoupanca(String titular, String senha, int conta, int agencia) {
        super(titular, senha, conta, agencia);
    }

    public void depositar(double valor){
        if (valor <= 0){
            System.out.println("Erro: O valor mínimo para depósito é de R$  1,00");
        } else {
            this.saldo += valor;
        }
    }

    public void sacar(double valor){
        if (valor > this.saldo || this.saldo < 0){
            System.out.println("Erro: Saldo insuficiente.");
        } else {
            saldo -= valor;
        }
    }

    @Override
    public void aplicarTaxa() {
        this.saldo += saldo * 0.005;
    }
}
