package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class PageObject {

	protected WebDriver browser;

	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		if(browser != null) {
		this.browser = browser;
		}else {
			this.browser = new ChromeDriver();
		}
	}

	public WebDriver getBrowser() {
		return browser;
	}

	public void fechar() {
		this.browser.quit();
	}

}
