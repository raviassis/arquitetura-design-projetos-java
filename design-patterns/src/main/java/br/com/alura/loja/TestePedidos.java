package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class TestePedidos {
    public static void main(String[] args) {
        var geraPedido = new GeraPedido("cliente", new BigDecimal("600"), 10);
        var geraPedidoHandler = new GeraPedidoHandler(
            Arrays.asList(
                new EnviarEmailPedido(),
                new SalvarPedidoNoBancoDeDados()
            )
        );
        geraPedidoHandler.executa(geraPedido);

    }
}
