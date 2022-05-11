package src.com.Aula05;

public class Usuario extends Pessoa{
    
    public String login;
    public String senha;
    public Conta conta;

    

    public Usuario(String nome, String login, String senha, boolean cc) {
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        if(cc)
        this.conta = new ContaCorrente(0.0);
        else
        this.conta = new ContaPoupanca(0.0);
    }

    

    public Conta getConta() {
        return conta;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public boolean validarSenha(String senha){
        return this.senha.equals(senha);
    }

}
