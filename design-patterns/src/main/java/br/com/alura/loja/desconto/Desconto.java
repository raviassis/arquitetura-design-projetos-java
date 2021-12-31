package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

// classe abstrata para o padrão chain of responsability
public abstract class Desconto {
    protected Desconto proximo;

    public Desconto setProximo(Desconto proximo) {
        if (this.proximo == null) {
            this.proximo = proximo;
        } else {
            this.proximo.setProximo(proximo);
        }
        return this;
    }

    // pattern template method
    public BigDecimal calcular(Orcamento orcamento) {
        if (deveAplicar(orcamento))
            return efetuarCalculo(orcamento);
        return this.proximo.calcular(orcamento);
    }

    // abstract steps for template method
    protected abstract boolean deveAplicar(Orcamento orcamento);
    protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);
}
