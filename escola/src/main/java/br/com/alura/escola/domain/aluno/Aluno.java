package br.com.alura.escola.domain.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	private CPF cpf;
	private String nome;
	private Email email;
	private AlunoFactory fabricaAluno;
	private List<Telefone> telefones =  new ArrayList<Telefone>();

	
	
	public Aluno(CPF cpf, String nome, Email email) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public void adicionarTelefone(String ddd,String numero) {
		this.telefones.add(new Telefone(ddd,numero));
	}

	public CPF getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Email getEmail() {
		return email;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public AlunoFactory getFabricaAluno() {
		return fabricaAluno;
	}
	
	
	
	// desafios testar a classe telefone cpf e fazer as validacoes no telefone
	

	
}
