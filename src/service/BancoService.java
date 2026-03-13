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
     private Conta userAtual;

    int numeroConta = 999;
    int numeroAgencia = 1999;

    public void menuInicial(){
        while (true){
            int opcao = bancoController.menuInicial();

            if (opcao == 1){
                cadastrarConta();
            } else if (opcao == 0) {
                System.out.println("Info: Sistema encerrado!");
                break;
            } else {
                Conta tempConta = login();
                if(tempConta != null){
                    userAtual = tempConta;
                    break;
                }
            }
        }
    }

    public void menuPrincipal(){
        if (userAtual != null){
            while(true){
                int opcao = bancoController.menuPrincipal();

                switch (opcao){
                    case 1:
                        userAtual.depositar(bancoController.dadosDeposito());
                        continue;
                    case 2:
                        userAtual.sacar(bancoController.dadosSaque());
                        continue;
                    case 3:
                        transferir();
                        continue;
                    case 4:
                        System.out.println("Titular: " + userAtual.getTitular()
                                + "\nSaldo: " + userAtual.getSaldo());
                        continue;
                    case 0:
                        System.out.println("Info: Sistema encerrado.");
                        System.exit(0);
                        break;
                }
            }
        }
    }

    public void cadastrarConta(){
        Conta conta;
        UserDTO userDTO = bancoController.menuCadastro();

        if(userDTO.getTipoConta() == 1){
            conta = new ContaCorrente(userDTO.getNomeTitular(), userDTO.getSenha(), numeroConta++, numeroAgencia++);
        } else {
            conta = new ContaPoupanca(userDTO.getNomeTitular(), userDTO.getSenha(), numeroConta++, numeroAgencia++);
        }
        bancoRepository.adicionarConta(conta);
        System.out.println("O número da sua conta é: " + conta.getNumeroConta());
    }

    public Conta login(){
        UserDTO userDTO = bancoController.menuLogin();

        for (Conta conta : bancoRepository.getContas()){
            if (conta.getNumeroConta() == userDTO.getNumeroConta()){
                if (conta.getSenha().equals(userDTO.getSenha())){
                    System.out.println("Info: Login realizado com sucesso!");
                    return conta;
                }
            }
        }
        return null;
    }

    public void transferir(){
        UserDTO userDTO = bancoController.dadosTransferencia();

        Conta conta = bancoRepository.buscarConta(userDTO.getNumeroConta());

        if (conta != null && userDTO.getSenha().equals(userAtual.getSenha())){
            conta.depositar(userDTO.getValor());
            userAtual.sacar(userDTO.getValor());
            System.out.println("Info: Transferência realizada com sucesso!");
            System.out.println("Saldo atual: R$ " + userAtual.getSaldo());
            // Apenas para teste
            System.out.println("Saldo da conta recebedora: " + conta.getSaldo());
        }
    }
}
