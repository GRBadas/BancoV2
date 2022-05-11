package src.com.Aula05;

public class ContaCorrente extends Conta{

    public ContaCorrente(double s) {
        super(s);
    }
    
    @Override
    public void credito() {
        System.out.println("Digite quanto você deseja depositar :");
        double deposito = input.nextDouble();
        this.saldo = saldo + deposito;
        System.out.println("Seu saldo é : " + this.saldo);
    }
    
    @Override
    public void debito(){
        System.out.println("Digite quanto você deseja sacar :");
        double saque = input.nextDouble();
        if (this.saldo < saque){           
          System.out.println("Você n tem esse dinheiro não, maluco, relaxa aí !");
        } else {
            this.saldo = saldo - saque;
            System.out.println("Seu saldo é : " + this.saldo);
        }
    }

    @Override
    public void saldo(){
        System.out.println("Seu saldo é : " + this.saldo);
    }
}