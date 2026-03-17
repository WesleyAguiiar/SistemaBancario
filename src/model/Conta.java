package model;

public abstract class Conta implements TaxaMensal{

    private int numeroConta;
    private int agencia;
    private String titular;
    private String senha;
    protected double saldo;

    public Conta(String titular, String senha, int conta, int agencia) {
        this.titular = titular;
        this.senha = senha;
        this.numeroConta = conta;
        this.agencia = agencia;
    }

    public void depositar(double valor){}

    public void sacar(double valor){}

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

    @Override
    public String toString() {
        return "Titular: " + titular +
                "\nConta: " + numeroConta +
                "\nAgencia: " + agencia +
                "\nSenha: " + senha +
                "\nSaldo: " + saldo;
    }
}
