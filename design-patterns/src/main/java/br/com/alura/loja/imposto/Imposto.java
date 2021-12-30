package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

// interface para o padrão strategy
public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}
