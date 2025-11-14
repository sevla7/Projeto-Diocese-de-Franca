package org.example.Atualizacao;

import org.example.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtualizacaoDAO {
    // A função inserir agora recebe um objeto Atualizacao completo
    public void inserir(int id_chamado, String devolutiva) {
        // Monta a string SQL com todos os atributos da tabela ATUALIZAÇÃO
        String sql = "INSERT INTO atualizacao (id_chamado_fk, devolutiva) " +
                "VALUES (?, ?)";
        try { // tenta inserir
            // conecta no banco de dados
            Connection conexao = ConnectionFactory.getConnection();
            // prepara para inserir
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id_chamado);
            stmt.setString(2, devolutiva);
            // executa a inserção no banco de dados
            stmt.executeUpdate();
            System.out.println("Atualização registrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir atualização: " + e.getMessage());
        }
    }

    // Função para listar todas as atualizações de um CHAMADO específico
    public List<String> listar() {
        String sql = "SELECT * FROM atualizacao";
        // cria a lista de atualizacoes
        List<String> atualizacoes = new ArrayList<>();
        // cria o SQL
        try { // vamos tentar selecionar
            // abre a conexão
            Connection conexao = ConnectionFactory.getConnection();
            // cria objeto que vai realmente consultar
            Statement stmt = conexao.createStatement();
            // executa a consulta e atribui resultado para objeto rs
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // adiciona id e nome na lista de fiéis
                atualizacoes.add(rs.getString("id_atualizacao") + " - " +
                        rs.getString("id_chamado_fk") + " - " +
                        rs.getString("devolutiva"));
            }
        } catch (SQLException e) { // tivemos um erro
            System.out.println("Erro ao listar atualizacoes!" + e.getMessage());
        }
        return atualizacoes; // retorna a lista de atualizacoes
    }

    // Função para atualizar uma atualização existente
    public void atualizar(int idAtualizacao, String novaDevolutiva) {
        String sql = "UPDATE atualizacao SET devolutiva = ? WHERE id_atualizacao = ?";
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);


            stmt.setString(1, novaDevolutiva);
            stmt.setInt(2, idAtualizacao);


            int nroLinhasAfetadas = stmt.executeUpdate();
            if (nroLinhasAfetadas > 0) {
                System.out.println("Atualização de log atualizada com sucesso!");
            } else {
                System.out.println("Atualização não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o log: " + e.getMessage());
        }
    }

    // Função para remover uma atualização
    public void remover(int idAtualizacao) {
        String sql = "DELETE FROM atualizacao WHERE id_atualizacao = ?";
        try {

            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement instrucao = conexao.prepareStatement(sql);

            instrucao.setInt(1, idAtualizacao);

            int nroLinhasAfetadas = instrucao.executeUpdate();
            if (nroLinhasAfetadas > 0) {
                System.out.println("Atualização removida com sucesso!");
            } else {
                System.out.println("Atualização não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover atualização: " + e.getMessage());
        }
    }

}


