package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
    protected WebDriver browser;

    public PageObject() {
        this(null);
    }

    public PageObject(WebDriver browser) {
        if (browser == null) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
            this.browser = new ChromeDriver();
        } else
            this.browser = browser;
    }

    public void quit() {
        this.browser.quit();
    }
}
