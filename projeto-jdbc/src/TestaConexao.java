import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		CriaConexao conexao = new CriaConexao();

		Connection connection = conexao.recuperarConexa();
		
		System.out.println("Fechando a conexão");
		connection.close();
	}

}
