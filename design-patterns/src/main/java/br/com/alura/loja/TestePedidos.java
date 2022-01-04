package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;

public class TestePedidos {
    public static void main(String[] args) {
        var geraPedido = new GeraPedido("cliente", new BigDecimal("600"), 10);
        var geraPedidoHandler = new GeraPedidoHandler();
        geraPedidoHandler.executa(geraPedido);

    }
}
