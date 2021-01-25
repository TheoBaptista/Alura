package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.lance.LancesPage;

public class LoginTest {

	private LoginPage paginaDeLogin;

	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage(null);

	}

	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		paginaDeLogin.efetuarLogin("fulano", "pass");

		;
		Assert.assertFalse(paginaDeLogin.isPaginaAtual());
		Assert.assertEquals("fulano", paginaDeLogin.getUsuarioLogado());

	}

	@Test
	public void NaoDeveriaEfetuarLoginComDadosInvalidos() {
		paginaDeLogin.efetuarLogin("invalido","123456");

		Assert.assertNull(paginaDeLogin.getUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.isPaginaAtual());
		Assert.assertTrue(paginaDeLogin.isMensageLoginInvalidVisivel());
	}

	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		
		LancesPage paginaDeLances = new LancesPage(null);
		
		Assert.assertTrue(paginaDeLances.isPaginaAtual());
		Assert.assertFalse(paginaDeLances.isTituloLeilaoVisivel());
		
		paginaDeLances.fechar();
	}

}
