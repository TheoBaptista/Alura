package br.com.alura.leilao.utilo.builder;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

public class LeilaoBuilder {

	
	 //Esta é uma classe Test data Builder
	private String nome;
	private BigDecimal valorInicial;
	private Usuario usuario;
	private LocalDate data;

	public LeilaoBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}

	public LeilaoBuilder comValorInicial(String valorInicial) {
		this.valorInicial = new BigDecimal(valorInicial);
		return this;
	}

	public LeilaoBuilder comUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}

	public LeilaoBuilder comData(LocalDate data) {
		this.data = data;
		return this;
	}

	public Leilao build() {
		return new Leilao(nome, valorInicial, data, usuario);
	}

}
