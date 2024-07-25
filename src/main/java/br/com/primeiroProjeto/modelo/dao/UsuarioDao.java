
package br.com.primeiroProjeto.modelo.dao;
import br.com.primeiroProjeto.modelo.conexao.ConexaoMySql;
import br.com.primeiroProjeto.modelo.dominio.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDao {
    public ConexaoMySql conn;
    public UsuarioDao() {
        this.conn = new ConexaoMySql();
    }
    
    public String salvar(Usuario user){
        return user.getID() == 0L ? adcionar(user) : editar(user);
    }

    private String adcionar(Usuario user) {
        String sql = "INSERT INTO usuario(nome, usuario, senha, perfil) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conn.obterConexao().prepareStatement(sql);
            preenchendoValores(preparedStatement, user);
            int resultado = preparedStatement.executeUpdate();
            return resultado == 1 ? "Usuario adicionado!" : "Falha ao adicionar usuario!";
        } catch (SQLException e) {
            return "Erro ao adicionar usuario: " + e.getMessage();
        }
    }   

    private String editar(Usuario user) {
        String sql = "UPDATE usuario SET nome = ?, usuario = ?, senha = ?, perfil = ? WHERE = id = ?";
        try {
            PreparedStatement preparedStatement = conn.obterConexao().prepareStatement(sql);
            preenchendoValores(preparedStatement, user);
            int resultado = preparedStatement.executeUpdate();
            return resultado == 1 ? "Usuario editado!" : "Falha ao editar usuario!";
        } catch (SQLException e) {
            return "Erro ao editar usuario: " + e.getMessage();
        }
    }

    private void preenchendoValores(PreparedStatement preparedStatement, Usuario user) throws SQLException{
        preparedStatement.setString(1, user.getNome());
        preparedStatement.setString(2, user.getUsuário());
        preparedStatement.setString(3, user.getSenha());
        preparedStatement.setString(4, user.getPerfil().name());
        
        if(user.getID() != 0L){
            preparedStatement.setLong(6, user.getID());
        }
    }
    
    public List<user> buscarTodosUsuarios(){
        String sql = "SELECT * FROM usuario";
        try {
            
        } catch (Exception e) {
        }
    }
}
