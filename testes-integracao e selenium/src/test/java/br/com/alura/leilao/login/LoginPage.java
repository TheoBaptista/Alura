package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage extends PageObject {

	private static final String url_login = "http://localhost:8080/login";

	public LoginPage(WebDriver browser) {
		super(browser);
		browser.navigate().to(url_login);

	}

	private void preencherFormularioDeLogin(String usuario, String senha) {
		browser.findElement(By.id("username")).sendKeys(usuario);
		browser.findElement(By.id("password")).sendKeys(senha);
	}

	public LeiloesPage efetuarLogin(String usuario, String senha) {
		preencherFormularioDeLogin(usuario, senha);
		browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(LoginPage.super.getBrowser());
	}

	public Object getUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public boolean contemTexto(String string) {
		return browser.getPageSource().equals(string);
	}

	public boolean isPaginaAtual() {
		return browser.getCurrentUrl().contains(url_login);
	}

	public boolean isMensageLoginInvalidVisivel() {
		return browser.getPageSource().contains("Usuário e senha inválidos");
	}

}
