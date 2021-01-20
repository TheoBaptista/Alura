package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	private LoginPage paginaDeLogin;

	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage(new ChromeDriver());

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
		
		//implementar esse teste depois
		
		Assert.assertTrue(paginaDeLogin.isPaginaAtual());
		Assert.assertFalse(paginaDeLogin.contemTexto("Dados do leilão"));
	}

}
