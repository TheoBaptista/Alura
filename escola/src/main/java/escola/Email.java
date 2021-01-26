package escola;

public class Email {

	// A classe email nao eh uma entidade e sim Value Object. Entidade eh quando temos uma maneira de difernciar duas instacias dois objetos por meio de um identificador unico
	private String endereco;

	public Email(String endereco) {
		if(endereco == null || !endereco.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
			throw new IllegalArgumentException("E-mail está inválido");
		}
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}
	
	
	
		
}
