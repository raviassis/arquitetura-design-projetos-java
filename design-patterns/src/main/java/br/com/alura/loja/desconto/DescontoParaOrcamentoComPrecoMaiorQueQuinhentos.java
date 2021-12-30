package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

// handler do padrão chain of responsability
public class DescontoParaOrcamentoComPrecoMaiorQueQuinhentos extends Desconto {
    public BigDecimal calcular(Orcamento orcamento) {
        if (orcamento.getValor().compareTo(new BigDecimal("500")) > 0)
            return orcamento.getValor().multiply(new BigDecimal("0.05"));
        return this.proximo.calcular(orcamento);
    }
}
