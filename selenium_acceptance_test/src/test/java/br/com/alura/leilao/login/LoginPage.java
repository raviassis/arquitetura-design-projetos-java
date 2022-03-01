package br.com.alura.leilao.login;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageObject {
    private static final String URL_LOGIN = "http://localhost:8080/login";

    public LoginPage() {
        super();
        this.browser.navigate().to(URL_LOGIN);
    }

    public void fillFormLogin(String username, String password) {
        this.browser.findElement(By.id("username")).sendKeys(username);
        this.browser.findElement(By.id("password")).sendKeys(password);
    }

    public void submit() {
        this.browser.findElement(By.id("login-form")).submit();
    }

    public LeiloesPage login(String username, String password) {
        this.fillFormLogin(username, password);
        this.submit();
        return new LeiloesPage(this.browser);
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
