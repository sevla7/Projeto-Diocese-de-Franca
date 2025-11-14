package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // criar 3 variáveis
    // jdbc -> protocolo de comunicação do java com BD
    // postgresql -> banco de dados
    // localhost -> máquina local
    // 5432 -> porta onde o postgres fica escutando requisição
    // Diocese Franca -> nome do banco de dados
        static String URL = "jdbc:postgresql://localhost:5432/DioceseFranca";
    static String USER = "postgres";
    static String PASSWORD = "123";

    // função de conexão com o banco de dados
    public static Connection getConnection(){
        // tentar conectar
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e){
            // deu erro, não conseguiu conectar
            throw new RuntimeException("Erro ao conectar " + e.getMessage());
        }
    }
}