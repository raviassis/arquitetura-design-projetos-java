package br.com.alura.loja.orcamento;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
public class ItemOrcamento implements Orcavel {
    @Getter
    private BigDecimal valor;
}
