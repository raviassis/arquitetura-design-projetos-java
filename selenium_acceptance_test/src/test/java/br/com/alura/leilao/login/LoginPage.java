package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    private static final String URL_LOGIN = "http://localhost:8080/login";
    private WebDriver browser;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        this.browser = new ChromeDriver();
        browser.navigate().to(URL_LOGIN);
    }

    public void quit() {
        this.browser.quit();
    }

    public void fillFormLogin(String username, String password) {
        this.browser.findElement(By.id("username")).sendKeys(username);
        this.browser.findElement(By.id("password")).sendKeys(password);
    }

    public void submit() {
        this.browser.findElement(By.id("login-form")).submit();
    }

    public boolean isLoginPage() {
        return this.browser.getCurrentUrl().contains(URL_LOGIN);
    }

    public String getLogedUser() {
        try {
            return this.browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    public void navigateToLeiloesPage(int i) {
        this.browser.navigate().to("http://localhost:8080/leiloes/" + i);
    }

    public boolean containsText(String text) {
        return this.browser.getPageSource().contains(text);
    }
}
