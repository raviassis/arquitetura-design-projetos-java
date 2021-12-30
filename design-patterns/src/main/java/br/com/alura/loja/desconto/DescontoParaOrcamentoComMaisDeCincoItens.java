package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

// handler do padrão chain of responsability
public class DescontoParaOrcamentoComMaisDeCincoItens extends Desconto {
    public BigDecimal calcular(Orcamento orcamento) {
        if (orcamento.getQuantidadeItens() > 5)
            return orcamento.getValor().multiply(new BigDecimal("0.1"));
        return proximo.calcular(orcamento);
    }
}
