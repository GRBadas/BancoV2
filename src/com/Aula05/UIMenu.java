package src.com.Aula05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UIMenu extends Conta{

    static Scanner input = new Scanner(System.in);

    public static int menuPrincipal(){
        int opt;
        ArrayList<Integer> validOptions = new ArrayList<>(Arrays.asList(1,2,3));
        do{
            System.out.println("Selecione a opção desejada ");
            System.out.printf("1) Criar nova conta \n2) Acessar conta \n3) Sair \n");
            opt = input.nextInt();
        }while(!validOptions.contains(opt));
        return opt;
    }

    public static void menuConta(){
        int opt;
        ArrayList<Integer> validOptions = new ArrayList<>(Arrays.asList(1,2,3));
        do{
            System.out.println("Selecione a opção desejada ");
            System.out.printf("1) Realizar operação de crédito \n2) Realizar operação de saque \n3) Verificar saldo \n4) Encerrar sessão");
            opt = input.nextInt();
        }while(!validOptions.contains(opt));
        
        switch(opt){
            case 1 : {
                Conta.credito();
            }
            case 2 : {
                Conta.debito();
            }
            case 3 : {
                Conta.saldo();
            }
            case 4 : {
                UIMenu.run();
            }
        }
    }

    public static Object run(){
        int option = menuPrincipal();
        String nome, login, senha;
        switch(option){

            case 1 : {
                System.out.println("Digite o nome do usuario");
                input.nextLine();
                nome = input.nextLine();
                System.out.println("Digite o login do usuario");
                login = input.nextLine();
                System.out.println("Digite a senha do usuario");
                senha = input.nextLine();
                Banco.criarUsuario(nome,login,senha,true);
                System.out.println("Conta criada, retornando ao menu principal.");
                System.out.println(Banco.usuarios.toString());
                System.out.println("--------------------");
                menuConta();
                break;
            }
            case 2 : {
                System.out.println("Digite o login do usuario");
                input.nextLine();
                login = input.nextLine();
                System.out.println("Digite a senha do usuario");
                senha = input.nextLine();
                
                if(Banco.autenticar(login,senha)>0){
                    System.out.print("Seja bem vindo ");
                    System.out.println(Banco.getUsuarioLogado());
                    menuConta();
                }else{
                    System.out.println("Usuario não encontrado");
                }
                break;
            }
            case 3 : {
                System.out.println("Até logo..");
                System.exit(0);
                break;
            }
            
        }
        return run();
    }
    
}
