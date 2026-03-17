package model;

public abstract class Conta implements TaxaMensal{

    private int numeroConta;
    private int agencia;
    private String titular;
    private String senha;
    private double saldo;

    public Conta(String titular, String senha, int conta, int agencia) {
        this.titular = titular;
        this.senha = senha;
        this.numeroConta = conta;
        this.agencia = agencia;
    }

    public abstract void depositar(double valor);

    public abstract void sacar(double valor);

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getSenha() {
        return senha;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(double saldo) {
        this.saldo += saldo;
    }

    public void diminuirSaldo(double valor){
        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return "Titular: " + titular +
                "\nConta: " + numeroConta +
                "\nAgencia: " + agencia +
                "\nSaldo: " + saldo;
    }
}
