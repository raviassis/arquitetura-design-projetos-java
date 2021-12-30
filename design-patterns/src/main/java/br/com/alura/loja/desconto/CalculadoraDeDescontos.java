package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeDescontos {
    public BigDecimal calcular(Orcamento orcamento) {
        // instanciando descontos usando o padrão chain of responsability
        var desconto = new DescontoParaOrcamentoComMaisDeCincoItens();
        desconto.setProximo(new DescontoParaOrcamentoComPrecoMaiorQueQuinhentos())
                .setProximo(new SemDesconto());
        return desconto.calcular(orcamento);
    }
}
