package br.estacio.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        
        String url = "jdbc:postgresql://localhost:5432/sistema_2"; 
        String user = "postgres"; 
        String pass = "postgre";
        
        try {
            return DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException e) {
            throw new RuntimeException();
        }        
    }              
}