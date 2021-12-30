package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

// classe abstrata para o padrão chain of responsability
public abstract class Desconto {
    protected Desconto proximo;

    public Desconto setProximo(Desconto proximo) {
        return this.proximo = proximo;
    }

    public abstract BigDecimal calcular(Orcamento orcamento);
}
