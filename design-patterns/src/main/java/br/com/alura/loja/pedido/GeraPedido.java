package br.com.alura.loja.pedido;

import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.alura.loja.orcamento.Orcamento;
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
