import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		CriaConexao conexao = new CriaConexao();

		Connection connection = conexao.recuperarConexa();
		
		PreparedStatement  stm = connection.prepareStatement("SELECT * FROM PRODUTO");

		boolean resultado = stm.execute();

		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println("Id do produto: " + id);
			String nome = rst.getString("NOME");
			System.out.println("Nome produto: " + nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println("Descricao: " + descricao);
		}

		System.out.println(resultado);

		connection.close();
	}

}
