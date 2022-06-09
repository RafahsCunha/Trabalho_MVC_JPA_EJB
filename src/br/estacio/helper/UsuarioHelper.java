/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.helper;

import br.estacio.modelo.Usuario;
import br.estacio.visao.NovoUsuario;
import br.estacio.visao.TelaLogin;

/**
 *
 * @author rafael.hsilva
 */
public class UsuarioHelper {
    
    private TelaLogin telaLogin;
    private NovoUsuario novoUsuario;
    
    public UsuarioHelper(TelaLogin telaLogin){
        this.telaLogin = telaLogin;
    }
    
    public UsuarioHelper(NovoUsuario novoUsuario){
        this.novoUsuario = novoUsuario;
    }
    
    public Usuario getUsuarioLogin(){
        Usuario usuario = new Usuario();
        
        usuario.setEmail(telaLogin.getTxtEmail().getText());
        usuario.setSenha(String.valueOf(telaLogin.getTxtSenha().getPassword()));
        
        return usuario;
    }
    
    public void limparTelaLogin(){
        telaLogin.getTxtEmail().setText("");
        telaLogin.getTxtSenha().setText("");
    }
    
    public boolean formularioEmBranco(){
        return (novoUsuario.getTxtNome().getText().isEmpty()|| 
                    novoUsuario.getTxtEmail().getText().isEmpty() ||
                        String.valueOf(novoUsuario.getTxtSenha().getPassword()).isEmpty());
    }
    
    public Usuario getUsuarioFormulario(){
        Usuario usuario = new Usuario();
        
        usuario.setNome(novoUsuario.getTxtNome().getText());// a instancia usuario vai na tabela novoUsuario no campo de texto nome e pega o que está escrito no campo e insere em usuario
        usuario.setEmail(novoUsuario.getTxtEmail().getText());//idem ao comentario acima
        usuario.setSenha(String.valueOf(novoUsuario.getTxtSenha().getPassword()));
        return usuario;
    }
    
    public void limparFormulario(){
        novoUsuario.getTxtNome().setText("");
        novoUsuario.getTxtEmail().setText("");
        novoUsuario.getTxtSenha().setText("");
    }
}
