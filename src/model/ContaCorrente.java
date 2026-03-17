package model;

public class ContaCorrente extends Conta
{
    public ContaCorrente(String titular, String senha, int conta, int agencia) {
        super(titular, senha, conta, agencia);
    }

    public void depositar(double valor){
        if (valor < 1){
            System.out.println("Erro: O valor mínimo para depósito é de R$  1,00");
        } else {
            this.adicionarSaldo(valor);
        } if (this.getSaldo() > 2){
            System.out.println("Info Conta Corrente: A taxa para depósito de R$ 2,00 foi aplicada.");
            this.diminuirSaldo(-2);
        }
    }

    public void sacar(double valor){
        if (valor > this.getSaldo() || this.getSaldo() < 0){
            System.out.println("Erro: Saldo insuficiente.");
        } else {
            this.diminuirSaldo(valor);
        } if (this.getSaldo() > 2){
            System.out.println("Info Conta Corrente: A taxa para " +
                    "saque/transferência de R$ 2,00 foi aplicada.");
            this.diminuirSaldo(-2);
        }
    }

    @Override
    public void aplicarTaxa() {
        this.diminuirSaldo(-12);
    }
}

