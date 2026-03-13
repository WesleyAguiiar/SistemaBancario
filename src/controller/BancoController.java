package controller;

import dto.UserDTO;
import dto.UserDTOCadastro;
import dto.UserDTOLogin;

import java.util.Scanner;

public class BancoController {

    Scanner sc = new Scanner(System.in);
    UserDTO userDTO;

    public UserDTO menuCadastro(){

        System.out.println("--------------- CADASTRO ---------------\n");
        System.out.print("Digite o seu nome: ");
        String nomeTitular = sc.nextLine();

        System.out.print("Escolha uma senha: ");
        String senha = sc.nextLine();

        int tipoConta;

        while (true){
            System.out.println("1. Criar conta corrente ou 2. criar conta poupança: ");
            tipoConta = verificarInteiro();

            if (tipoConta < 1 || tipoConta > 2){} else {break;}
        }
        return userDTO = new UserDTOCadastro(nomeTitular, senha, tipoConta);
    }

    public UserDTO menuLogin(){
        System.out.println("--------------- LOGIN ---------------\n");
        System.out.print("Digite o número da conta: ");
        int numeroConta = verificarInteiro();

        System.out.print("Digite a sua senha: ");
        String senha = sc.nextLine();

        return userDTO = new UserDTOLogin(numeroConta, senha);
    }

    double menuDeposito(){
        while (true){
            System.out.println("--------------- DEPOSITO ---------------\n");
            double valor = verificarDouble();
        }
    }

    double menuSaque(){
        while (true){
            System.out.println("--------------- DEPOSITO ---------------\n");
            double valor = verificarDouble();
            return valor;
        }
    }


    double verificarDouble(){
        while(true){
            System.out.print("Digite o valor: ");
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números!");
            }
        }
    }

    int verificarInteiro(){
        while (true){
            System.out.print("Digite o valor: ");
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Erro: Digite apenas números!");
            }
        }
    }
}
