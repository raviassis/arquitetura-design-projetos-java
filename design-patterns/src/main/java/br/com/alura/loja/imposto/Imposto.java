package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

// Aplicando o padrão decorator
public abstract class Imposto {
    private Imposto outro;

    public Imposto(Imposto outro) {
        this.outro = outro;
    }

    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

    public BigDecimal calcular(Orcamento orcamento) {
        var valorImposto = this.realizarCalculo(orcamento);
        if(this.outro != null) {
            valorImposto = valorImposto.add(this.outro.realizarCalculo(orcamento));
        }
        return valorImposto;
    }
}
