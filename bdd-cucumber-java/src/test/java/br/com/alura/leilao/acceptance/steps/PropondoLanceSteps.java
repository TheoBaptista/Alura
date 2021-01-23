
package br.com.alura.leilao.acceptance.steps;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {

	private Lance lance;
	private Leilao leilao;
	private List<Lance> lista;

	@Before
	public void setup() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Tablet XPTO");
	}
	// Atenção com as anotações before e after do cucumber. pois elas rodam em todos os testes idependentemente da classe
	// ao implementar esses metodos ter muito cuidado o que colocar neles

	@After
	public void tearDown() {
		// System.out.println("after");
	}

	@Dado("um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario, BigDecimal.TEN);

	}

	@Quando("propoe o lance")
	public void quando_propoe_o_lance() {
		leilao.propoe(lance);
	}

	@Entao("o lance eh aceito")
	public void entao_o_lance_eh_aceito() {
		assertEquals(1, leilao.getLances().size());
		assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}

	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario(Double double1, String string) {
		Lance lance = new Lance(new Usuario(string), new BigDecimal(double1));
		lista.add(lance);
	}

	@Quando("propoe varios lances ao leilao")
	public void propoe_varios_lances_ao_leilao() {
		lista.forEach(lance -> leilao.propoe(lance));
	}

	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		// ver o que está acontecendo neste teste coloquei um apenas para passar e
		// continuar os videos
		assertEquals(this.lista.size(), leilao.getLances().size());
		assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
		assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());

	}

	
	// ah diferenca de um esquema de cenario para a data table eh que no primeiro o teste executara para cada dado
	// ja para data table, o dados serao executados no mesmo teste
	@Dado("um lance invalido de {double} reais e do usuario {string}")
	public void um_lance_invalido_de_reais(Double valor, String nome) {
		this.lance = new Lance(new BigDecimal(valor));		
	}

	@Entao("o lance nao eh aceito")
	public void o_lance_nao_eh_aceito() {
		assertEquals(0, leilao.getLances().size());
	}
	
	
	
	
	@Dado("dois lances")
	public void dois_lances(DataTable dataTable) {
		List<Map<String, String>> maps = dataTable.asMaps();
		maps.forEach( (mapa) -> {
				Lance lance = new Lance(new Usuario(mapa.get("nomeUsuario")), new BigDecimal(mapa.get("valor")));
				lista.add(lance);
		});
		
	}



	@Entao("o segundo lance nao eh aceito")
	public void o_segundo_lance_nao_eh_aceito() {
		lista.forEach( lance -> leilao.propoe(lance));
		assertEquals(1 , leilao.getLances().size());
		assertEquals(this.lista.get(0).getValor() , leilao.getLances().get(0).getValor());
	}

}
