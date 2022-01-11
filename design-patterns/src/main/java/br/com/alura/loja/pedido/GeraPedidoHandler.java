package br.com.alura.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GeraPedidoHandler {
    private List<AcaoAposGerarPedido> acoes;

    public void executa(GeraPedido command) {
        var orcamento = new Orcamento();
        command.getItens().forEach(i -> orcamento.adicionarItem(i));
        var pedido = new Pedido(command.getCliente(), LocalDateTime.now(), orcamento);
        for (var acao: acoes) {
            acao.executar(pedido);
        };
    }
}
