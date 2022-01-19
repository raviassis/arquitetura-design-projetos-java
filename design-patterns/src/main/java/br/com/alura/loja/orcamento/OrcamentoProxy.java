package br.com.alura.loja.orcamento;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

public class OrcamentoProxy implements Orcavel {
    private BigDecimal valor;
    private Orcamento orcamento;

    @Override
    public BigDecimal getValor() {
        if (this.valor == null) {
            this.valor = orcamento.getValor();
        }
        return this.valor;
    }

    public OrcamentoProxy(Orcamento orcamento) {
        this.orcamento = orcamento;
    }
}
