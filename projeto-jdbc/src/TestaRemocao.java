import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {

		
		
		CriaConexao conexao =new CriaConexao();
		Connection recuperarConexa = conexao.recuperarConexa();
		PreparedStatement stm = recuperarConexa.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");
		stm.setInt(1, 1);
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		System.out.println("Quantidades de linhas que foram modificadas "+ linhasModificadas );
		
	}
}
