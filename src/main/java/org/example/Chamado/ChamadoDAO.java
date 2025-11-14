package org.example.Chamado;

import org.example.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChamadoDAO {
    public void inserir (int idFiel, int idDev, int idCat, String titulo,
                         String descricao, String status, String prioridade, String data_fechamento){
        String sql = "INSERT INTO chamado (id_fiel_fk, id_dev_fk, id_categoria_fk, titulo, " +
                "descricao, status, prioridade, data_fechamento) VALUES (?,?,?,?,?, ?, ?, ?)";
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            // Ajustada a ordem dos parâmetros
            stmt.setInt(1, idFiel);
            stmt.setInt(2, idDev);
            stmt.setInt(3, idCat);
            stmt.setString(4, titulo);
            stmt.setString(5, descricao);
            stmt.setString(6, status);
            stmt.setString(7, prioridade);

            // permite data_fechamento vazia
            if (data_fechamento == null || data_fechamento.isEmpty()) {
                stmt.setNull(8, java.sql.Types.DATE);
            } else {
                stmt.setString(8, data_fechamento);
            }

            stmt.executeUpdate();
            System.out.println("Chamado feito com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao emitir chamdo " + e.getMessage());
        }
    }

    public List<String> listar() {

        List<String> chamado = new ArrayList<>();
        String sql = "SELECT * FROM chamado";
        try {
            Connection conexao = ConnectionFactory.getConnection();

            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                chamado.add(rs.getInt("id_chamado") + " - " +
                        rs.getString("titulo") + " - " +
                        rs.getString("descricao") + " - " +
                        rs.getString("status")+ " - " +
                        rs.getString("prioridade")+ " - " +
                        rs.getString("data_fechamento"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar chamados!" + e.getMessage());
        }
        return chamado;
    }

    public void remover(int id) {
        String sql = "DELETE FROM chamado WHERE id_chamado = ?";

        try {

            Connection conexao = ConnectionFactory.getConnection();
            //cria uma instrução de banco de dados
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            // define o valor do id
            instrucao.setInt(1, id);

            int nroLinhasAfetadas = instrucao.executeUpdate();
            // testa a quantidade de linhas afetadas
            if (nroLinhasAfetadas > 0) {
                System.out.println("Chamado removido com sucesso!");
            } else {
                System.out.println("Chamado não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover chamado" + e.getMessage());

        }
    }

    // Corrigido: novaDA agora é String
    public void atualizar (int id, String novoTitulo, String novaDescricao, String novoStatus, String novaPrioridade){

        String sql = "UPDATE chamado SET titulo = ?, descricao = ?, status = ?," +
                " prioridade = ? WHERE id_chamado = ?";

        try {

            Connection conexao = ConnectionFactory.getConnection();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, novoTitulo);
            stmt.setString(2, novaDescricao);
            stmt.setString(3, novoStatus);
            stmt.setString(4, novaPrioridade);
            stmt.setInt(5, id);

            int nroLinhasAfetadas = stmt.executeUpdate();
            if (nroLinhasAfetadas>0){
                System.out.println("Chamado atualizado com sucesso!");
            }
            else{
                System.out.println("Chamado não encontrado.");
            }
        }
        catch (SQLException e){
            System.out.println("Erro ao atualizar chamado " + e.getMessage());
        }
    }

}