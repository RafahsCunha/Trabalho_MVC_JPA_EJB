package br.estacio.modelo;

import br.estacio.conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    private Connection con;

    public UsuarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void Adiciona(Usuario usuario) {
        String sql = "INSERT INTO usuario(id, nome, email, senha)"
                   + "VALUES(?, ?, ?, ?);";
        try {
            PreparedStatement stmt = con.prepareStatement(sql); 
            
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            
            stmt.execute();
            
            stmt.close();
            con.close();
            
            System.out.println("Usuário gravado com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void Altera(Usuario usuario) {
        String sql = "UPDATE usuario SET nome= ?, email= ?, senha= ? WHERE id= ?;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql); 
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());
            
            stmt.execute();
            
            stmt.close();
            con.close();
            
            System.out.println("Usuário alterado com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void Apaga(Usuario usuario) {
        String sql = "DELETE FROM usuario WHERE id= ?;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql); 
            
            stmt.setInt(1, usuario.getId());
            
            stmt.execute();
            
            stmt.close();
            con.close();
            
            System.out.println("Usuário apagado com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> lista = new ArrayList();
        String sql = "SELECT * FROM usuario;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Usuario u =  new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                
                lista.add(u);
            }
            
            rs.close();
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return lista;
    }
    
    public Usuario getUsuario(String email) {
        Usuario u = new Usuario();
        String sql = "SELECT * FROM usuario WHERE email= ?;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
            } else {
                System.out.println("Usuário não encontrado!");
            }
            
            rs.close();
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }
    
    //Método para retornar todos os usuarios de um determinado pais
    public List<Usuario> getUsuariosPorPais(String pais) {
        List<Usuario> lista = new ArrayList();
        String sql = "SELECT * FROM usuario WHERE pais= ?;";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, pais);
            stmt.executeQuery();
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Usuario usuario =  new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                
                lista.add(usuario);
            }
            
            rs.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return lista;
    }
}