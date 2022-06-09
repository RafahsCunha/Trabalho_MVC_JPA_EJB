package br.estacio.teste;

import br.estacio.modelo.Usuario;
import br.estacio.modelo.UsuarioDAO;

public class TesteDelete {
    public static void main(String[] args) {
        
        Usuario u1 = new Usuario();
        u1.setId(1002);
       
        UsuarioDAO dao = new UsuarioDAO();
        dao.Apaga(u1);
    }
}