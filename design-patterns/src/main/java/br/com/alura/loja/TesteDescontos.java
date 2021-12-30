package br.com.alura.loja;

import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteDescontos {
    public static void main(String[] args) {
        var primeiroOrcamento = new Orcamento(new BigDecimal("200"), 6);
        var segundoOrcamento = new Orcamento(new BigDecimal("1000"), 1);
        var calculadora = new CalculadoraDeDescontos();
        System.out.println(calculadora.calcular(primeiroOrcamento));
        System.out.println(calculadora.calcular(segundoOrcamento));
    }
}
