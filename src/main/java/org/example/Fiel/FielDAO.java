package org.example.Fiel;

import org.example.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FielDAO {
    // função para inserir um dev no banco de dados
    public void inserir(String nome, String email, String paroquia) {
        // monta uma string que representa o SQL
        String sql = "INSERT INTO \"Fiel\" (\"Nome\",\"Email\",\"Paróquia\") VALUES (?,?,?)";
        try { // tenta inserir
            // conecta no banco de dados
            Connection conexao = ConnectionFactory.getConnection();
            // prepara para inserir
            PreparedStatement stmt = conexao.prepareStatement(sql);
            // define os valores de nome e cpf
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, paroquia);
            // executa a inserção no banco de dados
            stmt.executeUpdate();
            System.out.println("Fiel adicionado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir fiel " + e.getMessage());
        }
    }

    // função para consultar todos os alunos no banco de dados
    public List<String> listar() {
        // cria a lista de fieis
        List<String> fieis = new ArrayList<>();
        // cria o SQL
        String sql = "SELECT * FROM \"Fiel\"";
        try { // vamos tentar selecionar
            // abre a conexão
            Connection conexao = ConnectionFactory.getConnection();
            // cria objeto que vai realmente consultar
            Statement stmt = conexao.createStatement();
            // executa a consulta e atribui resultado para objeto rs
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // adiciona id e nome na lista de fiéis
                fieis.add(rs.getInt("ID_Fiel") + " - " +
                        rs.getString("Nome") + " - " +
                        rs.getString("Email") + " - " +
                        rs.getString("Paróquia"));
            }
        } catch (SQLException e) { // tivemos um erro
            System.out.println("Erro ao listar desenvolvedores!" + e.getMessage());
        }
        return fieis; // retorna a lista de fieis
    }

    public void atualizar(int id, String novoNome, String novoEmail, String novaParoquia) {
        // monta o SQL
        String sql = "UPDATE \"Fiel\" SET \"Nome\" = ?, \"Email\" = ?, \"Paróquia\" = ? WHERE \"ID_Fiel\" = ?"; // SQL corrigido
        // tenta atualizar o fiel
        try {
            // abre a conexão com o banco
            Connection conexao = ConnectionFactory.getConnection();
            // cria a instrução (statement)
            PreparedStatement stmt = conexao.prepareStatement(sql);
            // atribuir os valores (?)
            stmt.setString(1, novoNome);
            stmt.setString(2, novoEmail);
            stmt.setString(3, novaParoquia); // Novo campo
            stmt.setInt(4, id); // ID
            // executa o comando de atualização
            int nroLinhasAfetadas = stmt.executeUpdate();
            if (nroLinhasAfetadas > 0) {
                System.out.println("Fiel atualizado com sucesso!");
            } else {
                System.out.println("Fiel não encontrado."); // Adicionado feedback
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar fiel " + e.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM \"Fiel\" WHERE \"ID_Fiel\" = ?"; // Coluna corrigida
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, id);
            int nroLinhasAfetadas = instrucao.executeUpdate();
            if (nroLinhasAfetadas > 0) {
                System.out.println("Fiel removido com sucesso!");
            } else {
                System.out.println("Fiel não encontrado."); // Adicionado feedback
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover fiel " + e.getMessage());
        }
    }
}