import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       CategoriaDAO categoriaDAO = new CategoriaDAO();
       Categoria categoria = new Categoria("zzz");
       categoriaDAO.inserir(categoria);

       // listagem das categorias
        List<Categoria> lista = categoriaDAO.listar();
        for (Categoria c: lista){
            System.out.println("ID: "+ c.getId()+"");
            System.out.println("Categoria: "+ c.getCategoria());
        }
    }
}