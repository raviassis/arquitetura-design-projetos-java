package br.com.alura.leilao.login;

import org.junit.jupiter.api.*;

public class LoginTest {

    private LoginPage loginPage;

    @BeforeEach
    public void beforeEach() {
        this.loginPage = new LoginPage();
    }

    @AfterEach
    public void affterEach() {
        this.loginPage.quit();
    }

    @Test
    public void deveriaEfeturarLogin() {
        this.loginPage.fillFormLogin("fulano", "pass");
        this.loginPage.submit();
        Assertions.assertFalse(this.loginPage.isLoginPage());
        Assertions.assertEquals(this.loginPage.getLogedUser(), "fulano");
    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {
        this.loginPage.fillFormLogin("invalido", "invalido");
        this.loginPage.submit();

        Assertions.assertTrue(this.loginPage.isLoginPage());
        Assertions.assertNull(this.loginPage.getLogedUser());
    }

    @Test
    public void naoDeveriaAcessarPaginaRestrita() {
        this.loginPage.navigateToLeiloesPage(2);

        Assertions.assertTrue(this.loginPage.isLoginPage());
        Assertions.assertFalse(this.loginPage.containsText("Dados do Leilão"));
    }
}
