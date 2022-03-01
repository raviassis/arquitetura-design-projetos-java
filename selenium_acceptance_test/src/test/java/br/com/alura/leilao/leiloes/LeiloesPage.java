package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage extends PageObject {
    private static final String URL_LEILOES = "http://localhost:8080/leiloes";

    public LeiloesPage(WebDriver browser) {
        super(browser);
    }

    public CadastroLeilaoPage openForm() {
        this.browser.navigate().to(URL_LEILOES + "/new");
        return new CadastroLeilaoPage(this.browser);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String hoje) {
        WebElement linha = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linha.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaData = linha.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValor = linha.findElement(By.cssSelector("td:nth-child(3)"));

        return colunaNome.getText().equals(nome)
                && colunaData.getText().equals(hoje)
                && colunaValor.getText().equals(valor);
    }

    public boolean isPaginaAtual() {
        return this.browser.getCurrentUrl().equals(URL_LEILOES);
    }
}
