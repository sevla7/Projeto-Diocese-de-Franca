package org.example.Categoria;

import org.example.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    // função para inserir um dev no banco de dados
    public void inserir(String nome) {
        // monta uma string que representa o SQL
        String sql = "INSERT INTO categoria (nome_categoria) VALUES (?)";
        try { // tenta inserir
            // conecta no banco de dados
            Connection conexao = ConnectionFactory.getConnection();
            // prepara para inserir
            PreparedStatement stmt = conexao.prepareStatement(sql);
            // define os valores de nome e cpf
            stmt.setString(1, nome);
            // executa a inserção no banco de dados
            stmt.executeUpdate();
            System.out.println("Categoria adicionada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir categoria " + e.getMessage());
        }
    }

    // função para consultar todos os alunos no banco de dados
    public List<String> listar() {
        // cria a lista de categorias
        List<String> categoria = new ArrayList<>();
        // cria o SQL
        String sql = "SELECT * FROM categoria";
        try { // vamos tentar selecionar
            // abre a conexão
            Connection conexao = ConnectionFactory.getConnection();
            // cria objeto que vai realmente consultar
            Statement stmt = conexao.createStatement();
            // executa a consulta e atribui resultado para objeto rs
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // adiciona id e nome na lista de fiéis
                categoria.add(rs.getInt("id_categoria") + " - " +
                        rs.getString("nome_categoria"));
            }
        } catch (SQLException e) { // tivemos um erro
            System.out.println("Erro ao listar categoria!" + e.getMessage());
        }
        return categoria; //
    }

    public void atualizar(int id, String novoNome) {
        // monta o SQL
        String sql = "UPDATE categoria SET nome_categoria = ? WHERE id_categoria = ?"; // SQL corrigido
        // tenta atualizar o fiel
        try {
            // abre a conexão com o banco
            Connection conexao = ConnectionFactory.getConnection();
            // cria a instrução (statement)
            PreparedStatement stmt = conexao.prepareStatement(sql);
            // atribuir os valores (?)
            stmt.setString(1, novoNome);
            stmt.setInt(2, id); // ID
            // executa o comando de atualização
            int nroLinhasAfetadas = stmt.executeUpdate();
            if (nroLinhasAfetadas > 0) {
                System.out.println("Categoria atualizada com sucesso!");
            } else {
                System.out.println("Categoria não encontrada."); // Adicionado feedback
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar categoria " + e.getMessage());
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?"; // Coluna corrigida
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, id);
            int nroLinhasAfetadas = instrucao.executeUpdate();
            if (nroLinhasAfetadas > 0) {
                System.out.println("Categoria removida com sucesso!");
            } else {
                System.out.println("Categoria não encontrado."); // Adicionado feedback
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover categoria " + e.getMessage());
        }
    }
}