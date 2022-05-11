package src.com.Aula05;

import java.util.ArrayList;

public class Banco {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static int contUsuarios = 0;
    public int UsuarioLogado = -1;

    public static void criarUsuario(String nome, String login, String senha, boolean cc){
        usuarios.add(new Usuario(nome,login,senha,cc));
        contUsuarios ++;
    }

    public static int autenticar(String login, String senha){
        for (int i = 0; i < contUsuarios; i++){
            if(usuarios.get(i).login.equals(login)){
                if(usuarios.get(i).validarSenha(senha)){
                    return i;
                }
            }
        }
    
    return -1;
 }

 public static Object getUsuarioLogado(){
     throw new UnsupportedOperationException("Not supported yet");
 }
}
