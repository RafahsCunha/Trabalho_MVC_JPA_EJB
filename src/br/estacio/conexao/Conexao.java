package br.estacio.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao { // Classe de conexão com o Banco
    public static void main(String[] args) {
        
        String  url = "jdbc:postgresql://localhost:5432/sistema_2"; // URL de conexão, Local do banco, nome do banco
        String user = "postgres"; // usuário 
        String pass = "postgre"; // Senha
        
        try { // Retorna True se a conecção com o banco for realizada com sucesso
            
            Connection con = DriverManager.getConnection(url, user, pass); // Instacia o objeto con da classe DriverManager com os parâmetros url, user, pass
            System.out.println("Conexao Realizada com sucesso!"); 
            
            con.close();
            System.out.println("Conexao encerrada!"); 
            
        } catch (SQLException e) { // Caso a conecção não seja realizada, o try entra no bloco cath, retorna a mensagem de falha e a mensagem de erro
            
            System.out.println("Falha na conexão!");
            System.out.println(e.getMessage());
            
        }        
    }
}