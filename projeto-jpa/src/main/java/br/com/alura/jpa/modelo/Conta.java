package br.com.alura.jpa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer agencia;
	private Integer numero;
	private String titular;
	private Double saldo = 0.00;

	//EAGER define que quando disparado uma query não será de modo preguicoso. virá antes de ser solicitado. antecipadamente
	@OneToMany(mappedBy = "conta", fetch = FetchType.EAGER)//sempre passar o atributo que mapeia o relacionamento na outra entidade no caso o conta;
	private List<Movimentacao> movimentacoes;
	
	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Long getId() {
		return id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void setId(long l) {
		this.id = l;
		
	}

	public List<Movimentacao> getMovimentacoes() {
		
		return movimentacoes;
	}
}
