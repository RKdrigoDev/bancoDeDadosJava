import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void listar (){
        sql="select * from java_categoria";
        try{
            ps= connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("ID: "+ rs.getInt("id"));
                System.out.println("Categoria: "+ rs.getInt("categoria"));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
