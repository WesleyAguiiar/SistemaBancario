package model;

public abstract class Conta {

    private int numeroConta; // Serão gerados automaticamente
    private int agencia; // Serão gerados automaticamente
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

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) { this.senha = senha; }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
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
