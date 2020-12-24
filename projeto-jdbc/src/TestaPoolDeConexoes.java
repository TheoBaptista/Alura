import java.sql.SQLException;

public class TestaPoolDeConexoes {
	public static void main(String[] args) throws SQLException {

		CriaConexao conexao = new CriaConexao();
		
		for(int i = 0; i < 20; i++) {
			conexao.recuperarConexa();
			System.out.println("Conexao de numero :" + i);
		}
		//use show processlist no client do banco. 
		
	}
}
