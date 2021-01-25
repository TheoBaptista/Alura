package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;

public class LeiloesPage extends PageObject {

	private static final String URL_LIST = "http://localhost:8080/leiloes";
	private static final String	UTL_FORM = "http://localhost:8080/leiloes/new";
	
	public LeiloesPage(WebDriver browser) {
		super(browser);		
	}
	
	public CadastroLeilaoPage carregarFormulario() {
		this.browser.navigate().to(UTL_FORM);
		return new CadastroLeilaoPage(browser);
	}
	
	public boolean isLeilaoCadastrado(String nome, String valorInicial, String dataAbertura) {
		WebElement linhaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		WebElement colunaNome = linhaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaDataAbertura = linhaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValorInicial = linhaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		
		return colunaNome.getText().equals(nome) && colunaDataAbertura.getText().equals(dataAbertura) && colunaValorInicial.getText().equals(valorInicial);
		
		// dar preferencia ao id do que cssSelector
	}
	
	public boolean isPaginaAtual() {
		return this.browser.getCurrentUrl().equals(URL_LIST);
	}
	
}
