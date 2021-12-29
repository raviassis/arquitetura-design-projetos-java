package br.com.alura.loja.orcamento;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
public class Orcamento {
    @Getter
    private BigDecimal valor;
}
