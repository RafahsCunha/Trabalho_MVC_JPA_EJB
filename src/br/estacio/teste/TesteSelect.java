package br.estacio.teste;

import br.estacio.modelo.Usuario;
import br.estacio.modelo.UsuarioDAO;
import java.util.ArrayList;

public class TesteSelect {
    public static void main(String[] args) {
        
        UsuarioDAO dao = new UsuarioDAO();
       
        ArrayList<Usuario> lista = dao.getUsuarios();

        for (Usuario usuario: lista) {
            System.out.println(usuario);
        }
    }
}