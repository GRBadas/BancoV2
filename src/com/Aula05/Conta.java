package src.com.Aula05;
import java.util.Scanner;

public class Conta {
    static Scanner input = new Scanner(System.in);

    public double saldo;

    public Conta() {
        System.out.println("Digite o saldo inicial da conta :");
        double saldo = input.nextDouble();
        this.saldo = saldo;
    }

    public Conta(double saldoInicial) {
    }

    public void credito(){
    }

    public void debito(){
    }

    public void saldo(){

    }
}
