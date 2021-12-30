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

    public abstract BigDecimal calcular(Orcamento orcamento);
}
