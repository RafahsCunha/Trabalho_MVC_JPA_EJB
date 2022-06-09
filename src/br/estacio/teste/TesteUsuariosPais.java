package br.estacio.teste;

import br.estacio.modelo.Usuario;
import br.estacio.modelo.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;

public class TesteUsuariosPais {
    public static void main(String[] args) {
        
        UsuarioDAO dao = new UsuarioDAO();
       
        List<Usuario> lista = dao.getUsuariosPorPais("Brasil");
       
        for (Usuario usuario: lista) {
            System.out.println(usuario);
        }
    }
}