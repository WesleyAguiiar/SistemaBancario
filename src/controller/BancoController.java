package controller;

import dto.UserDTO;
import dto.UserDTOCadastro;
import dto.UserDTOLogin;
import dto.UserDTOTransferencia;

import java.util.Scanner;

public class BancoController {

    Scanner sc = new Scanner(System.in);

    public UserDTO menuCadastro(){

        System.out.println("--------------- CADASTRO ---------------\n");
        System.out.print("Digite o seu nome: ");
        String nomeTitular = sc.nextLine();

        System.out.print("Escolha uma senha: ");
        String senha = sc.nextLine();

        int tipoConta;

        do {
            System.out.println("1. Criar conta corrente ou 2. criar conta poupança: ");
            tipoConta = verificarInteiro();

        } while (tipoConta != 1 && tipoConta != 2);
        return new UserDTOCadastro(nomeTitular, senha, tipoConta);
    }

    public UserDTO menuLogin(){
        System.out.println("--------------- LOGIN ---------------\n");
        System.out.print("Digite o número da conta: ");
        int numeroConta = verificarInteiro();

        System.out.print("Digite a sua senha: ");
        String senha = sc.nextLine();

        return new UserDTOLogin(numeroConta, senha);
    }

    public int menuInicial(){
        while (true){
            System.out.println("-------------- MENU INICIAL --------------\n");
            System.out.println("1. Cadastrar uma nova conta");
            System.out.println("2. Realizar login em uma conta existente");
            System.out.println("0. Encerrar programa\n");
            int opcao = verificarInteiro();

            if (opcao < 0 || opcao > 2){
                System.out.println("Erro: Opção inválida.");
                continue;
            }
            return opcao;
        }
    }

    public int menuPrincipal(){
        while (true){
            System.out.println("-------------- MENU PRINCIPAL --------------\n");
            System.out.println("1. Realizar um depósito");
            System.out.println("2. Realizar um saque");
            System.out.println("3. Realizar uma transferência");
            System.out.println("4. Consultar saldo");
            System.out.println("0. Encerrar programa\n");
            int opcao = verificarInteiro();

            if (opcao < 0 || opcao > 4){
                System.out.println("Erro: Opção inválida.");
            } else {
                return opcao;
            }
        }
    }

    public double dadosDeposito(){
        System.out.println("--------------- DEPOSITO ---------------\n");
        return verificarDouble();
    }

    public double dadosSaque(){
        System.out.println("--------------- SAQUE ---------------\n");
        return verificarDouble();
    }

    public UserDTO dadosTransferencia(){
        System.out.println("--------------- TRANSFERENCIA ---------------\n");
        System.out.print("Digite o numero da conta recebedora: ");
        int numeroConta = verificarInteiro();

        System.out.print("Digite o valor à ser transferido: ");
        double valor = verificarDouble();

        System.out.println("Digite a senha da sua conta: ");
        String senha = sc.nextLine();

        return new UserDTOTransferencia(numeroConta, valor, senha);
    }

    double verificarDouble(){
        while(true){
            System.out.print("\nDigite o valor: ");
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nErro: Digite apenas números!");
            }
        }
    }

    int verificarInteiro(){
        while (true){
            System.out.print("\nDigite o valor: ");
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e){
                System.out.println("\nErro: Digite apenas números!");
            }
        }
    }
}
