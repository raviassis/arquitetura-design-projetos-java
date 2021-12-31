package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

// handler do padrão chain of responsability
public class SemDesconto extends Desconto {
    @Override
    protected boolean deveAplicar(Orcamento orcamento) {
        return true;
    }

    @Override
    protected BigDecimal efetuarCalculo(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }
}
