import java.sql.*;

public class DespesaDAO {
    private Connection connection; //primeiro: estabelecer conexão com o banco
    private PreparedStatement ps; //leva as operações para o BD
    private ResultSet rs; //variavel para o uso de SELECT
    private String sql;

    public DespesaDAO(){this.connection = new Conexao().conectar();}

    public void inserir(Despesa despesa){
        sql = "insert into java_despesa(descricao,valor,data,id_categoria) values(?,?,?,?)";
        //qntd de ? = qtd de insersão
        //dentro do parenteses é o nome das colunas escrito no banco de dados
        try{
            ps=connection.prepareStatement(sql);
            ps.setString(1, despesa.getDescricao());//parameter index é o index das ?
            ps.setDouble(2,despesa.getValor());
            ps.setDate(3, Date.valueOf(despesa.getData()));
            ps.setInt(4,despesa.getCategoria().getId());
            ps.execute();


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }//inserir


}
