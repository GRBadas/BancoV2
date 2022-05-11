package src.com.Aula05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UIMenu {

    static Scanner input = new Scanner(System.in);

    public static int menuPrincipal() {
        int opt;
        ArrayList<Integer> validOptions = new ArrayList<>(Arrays.asList(1, 2, 3));

        System.out.println("Selecione a opção desejada ");
        System.out.printf(
                "--------------------\n1) Criar nova conta \n2) Acessar conta \n3) Sair \n-------------------- \n");
        opt = input.nextInt();
        if (!validOptions.contains(opt))
            return menuPrincipal();

        switch (opt) {

            case 1: { // criar conta
                input = new Scanner(System.in);
                System.out.println("Digite o nome do usuario: ");
                String nome = input.nextLine();

                System.out.println("Digite o login do usuario: ");
                String login = input.nextLine();
                while(Banco.checarSeLoginExiste(login)){
                    System.out.println("Login já utilizado, insira um novo login.");
                    login = input.nextLine();
                }
                

                System.out.println("Digite a senha do usuario: ");
                String senha = input.nextLine();

                Boolean tipoConta = true;
                System.out.println("Conta poupança ? (s/n) ");
                if(input.nextLine().equals("s"))
                    tipoConta = false;  

                Usuario user = Banco.criarUsuario(nome, login, senha, tipoConta);
                System.out.println("Digite seu saldo inicial : ");
                double saldoInicial = input.nextDouble();
                user.getConta().setSaldo(saldoInicial);

                System.out.println("Conta criada, retornando ao menu principal.");
                System.out.println("--------------------");
                menuPrincipal();
                break;
            }
            case 2: { // Acessar conta
                input = new Scanner(System.in);
                System.out.println("Digite o login do usuario: ");
                String login = input.nextLine();
                System.out.println("Digite a senha do usuario: ");
                String senha = input.nextLine();

                Banco.autenticar(login, senha);
                if (Banco.usuarioLogado != null) {
                    System.out.print("Seja bem vindo " + Banco.usuarioLogado.login + "!");
                    menuConta(Banco.usuarioLogado.getConta());
                } else {
                    System.out.println("Usuario não encontrado");
                }
                break;
            }
            case 3: {
                System.out.println("Até logo..");
                System.exit(0);
                break;
            }

        }
        return menuPrincipal();
    }


    public static void menuConta(Conta conta) {
        int opt;
        ArrayList<Integer> validOptions = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("Selecione a opção desejada ");
        System.out.printf(
                "1) Realizar operação de crédito \n2) Realizar operação de saque \n3) Verificar saldo \n4) Encerrar sessão");
        opt = input.nextInt();
        if (!validOptions.contains(opt)) {
            System.out.println("Opção inválida. ");
            menuConta(conta);
        }

        switch (opt) {
            case 1: {
                conta.credito();
                break;
            }
            case 2: {
                conta.debito();
                break;
            }
            case 3: {
                conta.saldo();
                break;
            }
            case 4: {
                Banco.usuarioLogado = null;
                menuPrincipal();
                break;
            }
        }
        UIMenu.menuConta(conta);
    }

    public static void run() {
        menuPrincipal();
 }
}
