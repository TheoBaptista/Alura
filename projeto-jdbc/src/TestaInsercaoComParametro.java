import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {

		CriaConexao conexao = new CriaConexao();
		try(Connection connection = conexao.recuperarConexa()){
		connection.setAutoCommit(false);

		try (PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)",
				Statement.RETURN_GENERATED_KEYS)) {

			adicionarVariavel("VAI PRA PUTA QUE TE PARIU", "SEU MERDINHA", stm);
			adicionarVariavel("BOLSONARO VAI TOMAR NO TEU CU", "ARROMBADO DE MERDA", stm);

			connection.commit();

			
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("ROLLBACK EXECUTADO");
		}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys();) {

			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi " + id);
			}
		}

	}
}
