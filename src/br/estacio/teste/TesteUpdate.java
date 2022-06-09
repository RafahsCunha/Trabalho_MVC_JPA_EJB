package br.estacio.teste;

import br.estacio.modelo.Usuario;
import br.estacio.modelo.UsuarioDAO;

public class TesteUpdate {
    public static void main(String[] args) {  
       
        Usuario u1 = new Usuario();
       
        u1.setId(1004);
        u1.setNome("teste.teste");
        u1.setEmail("teste.teste@hotmail.com");
        u1.setSenha("000000");

        UsuarioDAO dao = new UsuarioDAO();
        dao.Altera(u1);
    }
}