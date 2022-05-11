package src.com.Aula05;

import java.util.ArrayList;

public class Banco {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static Usuario usuarioLogado = null;

    public static Usuario criarUsuario(String nome, String login, String senha, boolean cc){
        Usuario usuario = new Usuario(nome, login, senha, cc);
        usuarios.add(usuario);
        return usuario;
    }

    public static Usuario autenticar(String login, String senha){
        for (int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).login.equals(login)){
                if(usuarios.get(i).validarSenha(senha)){
                    usuarioLogado = usuarios.get(i);
                    return usuarioLogado;
                }
            }
        }
    
    return null;
 }

 public static Object getUsuarioLogado(){
     return usuarioLogado;
 }
}
