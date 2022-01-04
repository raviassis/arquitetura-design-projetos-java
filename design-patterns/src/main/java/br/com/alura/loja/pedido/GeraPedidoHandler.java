package br.com.alura.loja.pedido;

import java.time.LocalDateTime;
import br.com.alura.loja.orcamento.Orcamento;

public class GeraPedidoHandler {
    // construtor com injeção de dependência: repository, service, etc.

    public void executa(GeraPedido command) {
        var orcamento = new Orcamento(command.getValorOrcamento(), command.getQuantidadeItens());
        var pedido = new Pedido(command.getCliente(), LocalDateTime.now(), orcamento);
        System.out.println("Salvar pedidod no banco de dados");
        System.out.println("Enviar email com dados do novo pedido");
    }
}
