package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void deveriaEfeturarLogin() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        WebDriver browser = new ChromeDriver();
        String loginUrl = "http://localhost:8080/login";
        browser.navigate().to(loginUrl);
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertNotEquals(browser.getCurrentUrl(), loginUrl);

        Assert.assertEquals(browser.findElement(By.id("usuario-logado")).getText(), "fulano");
        browser.quit();
    }
}
