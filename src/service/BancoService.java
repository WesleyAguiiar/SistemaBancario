package service;

import controller.BancoController;
import dto.UserDTO;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import repository.BancoRepository;

public class BancoService
{
    BancoController bancoController = new BancoController();
    BancoRepository bancoRepository = new BancoRepository();
    Conta userAtual;

    int numeroConta = 999;
    int numeroAgencia = 1999;

    public void cadastrarConta(){
        Conta conta;
        UserDTO userDTO = bancoController.menuCadastro();

        if(userDTO.getTipoConta() == 1){
            conta = new ContaCorrente(userDTO.getNomeTitular(), userDTO.getSenha(), numeroConta++, numeroAgencia++);
        } else {
            conta = new ContaPoupanca(userDTO.getNomeTitular(), userDTO.getSenha(), numeroConta++, numeroAgencia++);
        }
        bancoRepository.adicionarConta(conta);
        System.out.println(conta);
    }

    public boolean login(){
        UserDTO userDTO = bancoController.menuLogin();

        for (Conta conta : bancoRepository.getContas()){
            if (conta.getNumeroConta() == userDTO.getNumeroConta()){
                if (conta.getSenha().equals(userDTO.getSenha())){
                    System.out.println("Info: Login realizado com sucesso!");
                    userAtual = conta;
                    return true;
                }
            }
        }
        return false;
    }
}
