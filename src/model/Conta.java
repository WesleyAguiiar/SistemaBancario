package model;

public abstract class Conta {

    private int numeroConta; // Serão gerados automaticamente
    private int agencia; // Serão gerados automaticamente
    private String titular;
    private String senha;
    private double saldo;

    public Conta(String titular, String senha, int conta, int agencia) {
        this.titular = titular;
        this.senha = senha;
        this.numeroConta = conta;
        this.agencia = agencia;
    }

    boolean depositar(double valor){
        if (valor <= 0){
            return false;
        }
        this.saldo += valor;
        return true;
    }

    boolean sacar(double valor){
        if (valor < this.saldo){
            return false;
        }
        this.saldo -= valor;
        return true;
    }

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

    @Override
    public String toString() {
        return "Titular: " + titular +
                "\nConta: " + numeroConta +
                "\nAgencia: " + agencia +
                "\nSenha: " + senha +
                "\nSaldo: " + saldo;
    }
}
