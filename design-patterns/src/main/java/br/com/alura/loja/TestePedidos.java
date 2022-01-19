package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.LogDePedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class TestePedidos {
    public static void main(String[] args) {
        var geraPedido = new GeraPedido(
            "cliente",
            Arrays.asList(
                new ItemOrcamento(new BigDecimal("60")),
                new ItemOrcamento(new BigDecimal("60")),
                new ItemOrcamento(new BigDecimal("60")),
                new ItemOrcamento(new BigDecimal("60")),
                new ItemOrcamento(new BigDecimal("60")),
                new ItemOrcamento(new BigDecimal("60")),
                new ItemOrcamento(new BigDecimal("60")),
                new ItemOrcamento(new BigDecimal("60")),
                new ItemOrcamento(new BigDecimal("60")),
                new ItemOrcamento(new BigDecimal("60"))
            )
        );
        var geraPedidoHandler = new GeraPedidoHandler(
            Arrays.asList(
                new EnviarEmailPedido(),
                new SalvarPedidoNoBancoDeDados(),
                new LogDePedido()
            )
        );
        geraPedidoHandler.executa(geraPedido);

    }
}
