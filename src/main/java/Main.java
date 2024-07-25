import br.com.primeiroProjeto.modelo.conexao.ConexaoMySql;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException{
        ConexaoMySql conexao = new ConexaoMySql();
        
        String sql = "Select * from categoria";
        
        ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
        
        while(result.next()){
            System.out.println(result.getString("nome"));
        }
    }
    
}
