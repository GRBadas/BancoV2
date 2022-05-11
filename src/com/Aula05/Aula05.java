package src.com.Aula05;

import java.util.Scanner;

public class Aula05{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){

        Usuario badas = Banco.criarUsuario("Badas","Badas" , "123", true);
        badas.getConta().setSaldo(500);
        UIMenu.run();
        
    }
}