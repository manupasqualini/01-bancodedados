import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
        //System.out.println(connection);

        String sql;
        PreparedStatement ps;
        ResultSet rs; //variavel qnd usa select



        //listar todos os dados da tabela
        sql = "SELECT * from java_categoria";

        try{
            ps=connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.print("ID:" + rs.getInt("id")+"  ");
                System.out.println("CATEGORIA: "+ rs.getString("categoria"));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
