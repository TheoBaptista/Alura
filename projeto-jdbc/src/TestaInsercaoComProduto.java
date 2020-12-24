import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDao;
import modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
	
		Produto comoda = new Produto("Cômoda","Cômoda Vertical");
		
		try(Connection connection = new CriaConexao().recuperarConexa()){
			
			ProdutoDao produtoDao = new ProdutoDao(connection);
			produtoDao.salvarProduto(comoda);
			List<Produto> produtos = produtoDao.listarProduto();
			
			produtos.forEach(System.out::println);
			
		}			
		
	}

}
