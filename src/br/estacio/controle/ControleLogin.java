/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.controle;

import br.estacio.helper.UsuarioHelper;
import br.estacio.modelo.Usuario;
import br.estacio.modelo.UsuarioDAO;
import br.estacio.visao.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael.hsilva
 */
public class ControleLogin {

    private TelaLogin visao;
    private Usuario modelo;
    
    public ControleLogin(){
        
        visao = new TelaLogin();
        visao.setVisible(true);
        
//        modelo = new Usuario();
        
        iniciar();
    
    }
    
    private void iniciar(){
        
        visao.getBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioDAO dao = new UsuarioDAO();
//              modelo = dao.getUsuario(visao.getTxtEmail().getText());
                UsuarioHelper helper = new UsuarioHelper(visao);
                Usuario usuarioFormulario = helper.getUsuarioLogin();
                modelo = dao.getUsuario(usuarioFormulario.getEmail());
                
                if(modelo.getEmail() != null &&
                        modelo.validarLogin(usuarioFormulario.getEmail(), usuarioFormulario.getSenha())){
//                    JOptionPane.showMessageDialog(visao,"Usuario Logado\n" + modelo.toString());
                    JOptionPane.showMessageDialog(visao,"Usuario Logado com sucesso\n");
                    helper.limparTelaLogin();
                }else{
                    JOptionPane.showMessageDialog(visao,"Usuario ou senha invalida","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
       
        visao.getBtnNovoUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControleNovoUsuario novoUsuario = new ControleNovoUsuario();
            }
        });
    }

}