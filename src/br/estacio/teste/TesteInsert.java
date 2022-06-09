package br.estacio.teste;

import br.estacio.modelo.Usuario;
import br.estacio.modelo.UsuarioDAO;

public class TesteInsert {
    public static void main(String[] args) { 
       
        Usuario u1 = new Usuario();
       
        //u1.setId(1007);
        u1.setNome("teste");
        u1.setEmail("teste");
        // u1.setPais("Brasil"); 
        u1.setSenha("teste");
       
        UsuarioDAO dao = new UsuarioDAO();
        dao.Adiciona(u1);
    }
}