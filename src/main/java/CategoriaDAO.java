import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;

    public CategoriaDAO(){
        this.connection = new Conexao().conectar();
    }
    // inserir um registro na tabela java_categoria
    public void inserir(Categoria categoria){
        sql = "insert into java_categoria(categoria) values (?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, categoria.getCategoria());
            ps.execute();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //listagem das categorias
    public List<Categoria> listar (){
        sql="select * from java_categoria";
        List<Categoria> lista = new ArrayList<>();
        try{
            ps= connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               lista.add(new Categoria(rs.getInt("id"),
                       rs.getString("categoria")));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
    public String pesquisar(int id){
        sql= "select * from java_categoria where id = ?";
        try{
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getString("categoria");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
