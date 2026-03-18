package service;

import controller.BancoController;
import dto.UserDTO;
import exceptions.ContaNaoEncontradaException;
import exceptions.SaldoInsuficienteException;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import repository.BancoRepository;

public class BancoService {
    private final BancoController bancoController = new BancoController();
    private final BancoRepository bancoRepository = new BancoRepository();
    private Conta userAtual;

    private int numeroConta = 999;
    private int numeroAgencia = 1999;

    public void menuInicial() {
        while (true) {
            int opcao = bancoController.menuInicial();

            if (opcao == 1) {
                cadastrarConta();
            } else if (opcao == 0) {
                System.out.println("Info: Sistema encerrado!");
                break;
            } else {
                Conta tempConta = login();
                if (tempConta != null) {
                    userAtual = tempConta;
                    break;
                }
            }
        }
        menuPrincipal();
    }

    private void menuPrincipal() {
        if (userAtual != null) {
            while (true) {
                int opcao = bancoController.menuPrincipal();

                switch (opcao) {
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
                                + "\nSaldo: R$ " + userAtual.getSaldo() + "\n");
                        continue;
                    case 5:
                        userAtual.aplicarTaxa();
                        continue;
                    case 0:
                        System.out.println("Info: Sistema encerrado.");
                        System.exit(0);
                        break;
                }
            }
        }
    }

    private void cadastrarConta() {
        Conta conta;
        UserDTO userDTO = bancoController.menuCadastro();

        if (userDTO.getTipoConta() == 1) {
            conta = new ContaCorrente(userDTO.getNomeTitular(), userDTO.getSenha(), numeroConta++, numeroAgencia++);
        } else {
            conta = new ContaPoupanca(userDTO.getNomeTitular(), userDTO.getSenha(), numeroConta++, numeroAgencia++);
        }
        bancoRepository.adicionarConta(conta);
        System.out.println("O número da sua conta é: " + conta.getNumeroConta());
    }

    private Conta login() {
        // Adição de contas para teste.

        /*Conta wesley = new ContaCorrente("Wesley", "123", numeroConta++, numeroAgencia++);
        Conta joao = new ContaPoupanca("Joao", "123", numeroConta++, numeroAgencia++);
        bancoRepository.adicionarConta(wesley);
        bancoRepository.adicionarConta(joao);*/

        // Início da função

        UserDTO userDTO = bancoController.menuLogin();
        try {
            Conta conta = bancoRepository.buscarConta(userDTO.getNumeroConta());
            if (conta != null && bancoRepository.autenticar(conta, userDTO.getSenha())) {
                System.out.println("Info: Login realizado com sucesso.");
                return conta;
            }
        } catch (ContaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private void transferir() {
        UserDTO userDTO = bancoController.dadosTransferencia();

        try {
            Conta conta = bancoRepository.buscarConta(userDTO.getNumeroConta());
            if (userDTO.getSenha().equals(userAtual.getSenha())) {
                userAtual.sacar(userDTO.getValor());
                conta.depositar(userDTO.getValor());
                System.out.println("Info: Transferência realizada com sucesso!");
                System.out.println("Saldo atual: R$ " + userAtual.getSaldo() + "\n");
            } else {
                System.out.println("Erro: Senha incorreta.");
            }
        } catch (ContaNaoEncontradaException | SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}
