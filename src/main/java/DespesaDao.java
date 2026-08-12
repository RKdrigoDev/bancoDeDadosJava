import java.sql.*;

public class DespesaDao {
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;

    public DespesaDao(){
        this.connection= new Conexao().conectar();
    }
    public void inserir(Despesa despesa){
        sql = "insert into java_despesa(descricao, valor, data, id_categoria)" + "values(?, ?, ?, ?)";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, despesa.getDescricao());
            ps.setDouble(2, despesa.getValor());
            ps.setDate(3, Date.valueOf(despesa.getDataCompra()));
            ps.setInt(4, despesa.getCategoria().getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
