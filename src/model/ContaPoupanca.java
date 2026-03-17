package model;

public class ContaPoupanca extends Conta
{
    public ContaPoupanca(String titular, String senha, int conta, int agencia) {
        super(titular, senha, conta, agencia);
    }

    public void depositar(double valor){
        if (valor <= 0){
            System.out.println("Erro: O valor mínimo para depósito é de R$  1,00");
        } else {
            this.adicionarSaldo(valor);
        }
    }

    public void sacar(double valor){
        if (valor > this.getSaldo() || this.getSaldo() < 0){
            System.out.println("Erro: Saldo insuficiente.");
        } else {
            this.diminuirSaldo(valor);
        }
    }

    @Override
    public void aplicarTaxa() {
        this.adicionarSaldo(this.getSaldo() * 0.005);
    }
}
