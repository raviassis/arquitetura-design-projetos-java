package br.com.alura.leilao.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private static final String URL_BASE = "http://localhost:8080";
    private WebDriver browser;

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
    }

    @BeforeEach
    public void beforeEach() {
        this.browser = new ChromeDriver();
    }

    @AfterEach
    public void affterEach() {
        browser.quit();
    }

    @Test
    public void deveriaEfeturarLogin() {
        String loginUrl = URL_BASE + "/login";
        browser.navigate().to(loginUrl);
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        Assertions.assertNotEquals(browser.getCurrentUrl(), loginUrl);

        Assertions.assertEquals(browser.findElement(By.id("usuario-logado")).getText(), "fulano");
    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {
        String loginUrl = URL_BASE + "/login";
        browser.navigate().to(loginUrl);
        browser.findElement(By.id("username")).sendKeys("invalido");
        browser.findElement(By.id("password")).sendKeys("invalido");
        browser.findElement(By.id("login-form")).submit();

        Assertions.assertEquals(browser.getCurrentUrl(), loginUrl + "?error");

        Assertions.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos"));
        Assertions.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));
    }

    @Test
    public void naoDeveriaAcessarPaginaRestrita() {
        String loginUrl = URL_BASE + "/login";
        browser.navigate().to(URL_BASE + "/leiloes/2");

        Assertions.assertEquals(browser.getCurrentUrl(), loginUrl);
        Assertions.assertFalse(browser.getPageSource().contains("Dados do Leilão"));
    }
}
