package repository;

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
}
