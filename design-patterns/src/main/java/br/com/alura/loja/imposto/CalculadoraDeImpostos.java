package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

// classe contexto do padrão strategy
public class CalculadoraDeImpostos {

    public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
        // interagindo com alguma strategy a partir da sua interface
        return imposto.calcular(orcamento);
    }
}
