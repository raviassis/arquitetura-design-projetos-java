package br.com.alura.loja.pedido;

import lombok.AllArgsConstructor;
import java.math.BigDecimal;

import lombok.Getter;

@AllArgsConstructor
public class GeraPedido {
    @Getter
    private String cliente;
    @Getter
    private BigDecimal valorOrcamento;
    @Getter
    private int quantidadeItens;
}
