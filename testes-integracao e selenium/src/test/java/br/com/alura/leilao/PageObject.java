package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;

public abstract class PageObject {

	protected WebDriver browser;

	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		this.browser = browser;
	}

	public WebDriver getBrowser() {
		return browser;
	}

	public void fechar() {
		this.browser.quit();
	}

}
