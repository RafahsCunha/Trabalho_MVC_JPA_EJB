/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.controle;

import br.estacio.helper.UsuarioHelper;
import br.estacio.modelo.Usuario;
import br.estacio.modelo.UsuarioDAO;
import br.estacio.visao.NovoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael.hsilva
 */
class ControleNovoUsuario {
    private NovoUsuario visao;
    private Usuario modelo;

    public ControleNovoUsuario() {
        
        this.visao = new NovoUsuario();
        this.visao.setVisible(true);
        
        iniciar();
    }

    private void iniciar() {
        
        visao.getRootPane().setDefaultButton(visao.getBtnGravar());//O botão gravar fica marcado como padrão e com destaque de cor azul, e fica piscando
        
        visao.getBtnGravar().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioHelper helper = new UsuarioHelper(visao);
                if(helper.formularioEmBranco()){
                    JOptionPane.showMessageDialog(visao,"Todos os campos devem ser preenchidos","Error!", JOptionPane.WARNING_MESSAGE);
                }else{//Pegar o dado do formulário, acessar o DAO e fazer a gravação 
                    modelo = helper.getUsuarioFormulario();
                    UsuarioDAO dao = new UsuarioDAO();
                    dao.Adiciona(modelo);
                    JOptionPane.showMessageDialog(visao,"Usuario" + modelo.getNome()+"gravado com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    visao.dispatchEvent(new WindowEvent(visao, WindowEvent.WINDOW_CLOSING));//fecha a janela depois de ter inserido e gravado os dados no banco
                }//dispatchEvent ==> dispara um novo evento, novo evento acessa a janela visao e executa o evento de fechar a janela
            }   //
        });
        
        visao.getBtnLimpar().addActionListener(new ActionListener() {//Limpar o formulário ao licar no botão limpar
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioHelper helper = new UsuarioHelper(visao);
                helper.limparFormulario();
            }
        });
    }
}
