package src.com.Aula05;


public abstract class Conta {
    public double saldo;
  
    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public Conta() {
    }

    public void credito(){}

    public void debito(){}

    public void saldo(){}

    public void setSaldo(double saldo){
    this.saldo = saldo;
    }
}
