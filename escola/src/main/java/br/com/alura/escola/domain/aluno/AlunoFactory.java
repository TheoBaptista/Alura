package br.com.alura.escola.domain.aluno;

public class AlunoFactory {

	private Aluno aluno;
	
	public AlunoFactory comNomeCPFeEmail(String nome, String cpf, String email) {
		this.aluno = new Aluno(new CPF(cpf),nome,new Email(email));	
		return this;
	}
	
	public AlunoFactory comTelefone(String ddd,String numero) {
		this.aluno.adicionarTelefone(ddd, numero);
		return this;
	}
	
	public Aluno build() {
		return this.aluno;
	}
	
}
