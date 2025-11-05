package org.example.Desenvolvedor;

import org.example.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO - Data Access Object
public class DesenvolvedorDAO {
    // função para inserir um dev no banco de dados
        public void inserir(String nome, String email){
        // monta uma string que representa o SQL
        String sql = "INSERT INTO \"Desenvolvedor\" (\"Nome\",\"Email\") VALUES (?,?)";
        try { // tenta inserir
            // conecta no banco de dados
            Connection conexao = ConnectionFactory.getConnection();
            // prepara para inserir
            PreparedStatement stmt = conexao.prepareStatement(sql);
            // define os valores de nome e cpf
            stmt.setString(1, nome);
            stmt.setString(2, email);
            // executa a inserção no banco de dados
            stmt.executeUpdate();
            System.out.println("Desenvolvedor adicionado com sucesso!");
        }
        catch(SQLException e){
            System.out.println("Erro ao inserir desenvolvedor " + e.getMessage());
        }
    }
    // função para consultar todos os alunos no banco de dados
    public List<String> listar(){
        // cria a lista de desenvolvedores
        List<String> desenvolvedores = new ArrayList<>();
        // cria o SQL
        String sql = "SELECT * FROM \"Desenvolvedor\"";
        try { // vamos tentar selecionar
            // abre a conexão
            Connection conexao = ConnectionFactory.getConnection();
            // cria objeto que vai realmente consultar
            Statement stmt = conexao.createStatement();
            // executa a consulta e atribui resultado para objeto rs
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){ // para cada de devs
                // adiciona id e nome na lista de devs
                desenvolvedores.add(rs.getInt("ID_Dev") + " - " +
                        rs.getString("Nome"));
            }
        }
        catch(SQLException e){ // tivemos um erro
            System.out.println("Erro ao listar desenvolvedores!" + e.getMessage());
        }
        return desenvolvedores; // retorna a lista de desenvolvedores
    }

    public void atualizar(int id, String novoNome, String novoEmail) {
        // monta o SQL
        String sql = "UPDATE \"Desenvolvedor\" SET \"Nome\" = ?, \"Email\" = ? WHERE \"ID_Dev\" = ?";
        // tenta atualizar o aluno
        try {
            // abre a conexão com o banco
            Connection conexao = ConnectionFactory.getConnection();
            // cria a instrução (statement)
            PreparedStatement stmt = conexao.prepareStatement(sql);
            // atribuir os valores (?)
            stmt.setString(1, novoNome);
            stmt.setString(2, novoEmail);
            stmt.setInt(3, id);
            // executa o comando de atualização
            int nroLinhasAfetadas = stmt.executeUpdate();
            if (nroLinhasAfetadas > 0) {
                System.out.println("Desenvolvedor atualizado com sucesso!");
            }
            else {
                System.out.println();
            }
        }
        catch (SQLException e) {
            System.out.println("Erro ao atualizar desenvolvedor " + e.getMessage());
        }
    }
    public void remover(int id) {
        String sql = "DELETE FROM \"Desenvolvedor\" WHERE \"ID_Dev\" = ?";
        try {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, id);
            int nroLinhasAfetadas = instrucao.executeUpdate();
            if (nroLinhasAfetadas > 0) {
                System.out.println("Desenvolvedor removido com sucesso!");
            }
            else {
                System.out.println();
            }
        }
        catch (SQLException e) {
            System.out.println("Erro ao inserir desenvolvedor " + e.getMessage());
        }
    }

}