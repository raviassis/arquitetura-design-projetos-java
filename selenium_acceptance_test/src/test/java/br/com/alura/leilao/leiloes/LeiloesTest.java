package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest{
    private LeiloesPage leiloesPage;
    private CadastroLeilaoPage cadastroLeilaoPage;

    @BeforeEach
    public void beforeEach() {
        this.leiloesPage = new LoginPage().login("fulano", "pass");
        this.cadastroLeilaoPage = this.leiloesPage.openForm();
    }

    @AfterEach
    public void afterEach() {
        this.leiloesPage.quit();
    }

    @Test
    public void deveCadastrarLeilao() {
        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao do dia " + hoje;
        String valor = "500.00";
        this.leiloesPage = this.cadastroLeilaoPage.cadastrarLeilao(nome, valor, hoje);
        Assertions.assertTrue(this.leiloesPage.isLeilaoCadastrado(nome, valor, hoje));
    }

    @Test
    public void deveriaValidarCadastroLeilao() {
        this.cadastroLeilaoPage.cadastrarLeilao("", "", "");
        Assertions.assertFalse(this.cadastroLeilaoPage.isPaginaAtual());
        Assertions.assertTrue(this.leiloesPage.isPaginaAtual());
        Assertions.assertTrue(this.cadastroLeilaoPage.isValidationMessagesShow());

    }



}
