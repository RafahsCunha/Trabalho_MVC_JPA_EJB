package br.estacio.teste;

import br.estacio.modelo.Usuario;
import br.estacio.modelo.UsuarioDAO;

public class TesteSelectUsuario {
    public static void main(String[] args) {
        
        UsuarioDAO dao = new UsuarioDAO();
        
        Usuario u = dao.getUsuario("teste.teste@gmail.com");
        
        System.out.println(u);
    }
}