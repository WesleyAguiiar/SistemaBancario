package repository;

import exceptions.ContaNaoEncontradaException;
import model.Conta;

import java.util.ArrayList;

public class BancoRepository
{
    private ArrayList<Conta> contas = new ArrayList<>();

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public Conta buscarConta(int numeroConta) throws ContaNaoEncontradaException {
        for (Conta conta : contas){
            if (conta.getNumeroConta() == numeroConta){
                return conta;
            }
        }
        throw new ContaNaoEncontradaException(numeroConta);
    }

    public boolean autenticar(Conta conta, String senha){
        return conta.getSenha().equals(senha);
    }
}
