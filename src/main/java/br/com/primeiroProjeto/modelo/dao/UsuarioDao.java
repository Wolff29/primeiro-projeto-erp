
package br.com.primeiroProjeto.modelo.dao;
import br.com.primeiroProjeto.modelo.conexao.ConexaoMySql;
import br.com.primeiroProjeto.modelo.dominio.Perfil;
import br.com.primeiroProjeto.modelo.dominio.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    
    public List<Usuario> buscarTodosUsuarios(){
        String sql = "SELECT * FROM usuario";
        List<Usuario> users = new ArrayList<>();
        try {
            ResultSet result = conn.obterConexao().prepareStatement(sql).executeQuery();
            while(result.next()){
                users.add(getUsuario(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: ", e.getMessage()));
        }
        return users;
    }

    private Usuario getUsuario(ResultSet result) throws SQLException{
        Usuario usuario = new Usuario();

        usuario.setID(result.getInt("id"));
        usuario.setNome(result.getString("nome"));
        usuario.setUsuário(result.getString("usuario"));
        usuario.setSenha(result.getString("senha"));
        usuario.setPerfil(result.getObject("perfil", Perfil.class));
        usuario.setAtivo(result.getBoolean("ativo"));
        usuario.setDataHoraCriacao(result.getObject("data_hora_criacao", LocalDateTime.class));
        usuario.setUltimoLogin(result.getObject("ultimo_login", LocalDateTime.class));

        return usuario;
    }

    public Usuario buscarUsuarioId(int ID){
        String sql = "SELECT * FROM usuario where ID = " + ID;
        List<Usuario> users = new ArrayList<>();
        try {
            ResultSet result = conn.obterConexao().prepareStatement(sql).executeQuery();
            if(result.next()){
                return  getUsuario(result);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public Usuario buscarUsuarioUsuario(String usuario){
        String sql = "SELECT * FROM usuario where ID = " + usuario;
        List<Usuario> users = new ArrayList<>();
        try {
            ResultSet result = conn.obterConexao().prepareStatement(sql).executeQuery();
            if(result.next()){
                return  getUsuario(result);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
