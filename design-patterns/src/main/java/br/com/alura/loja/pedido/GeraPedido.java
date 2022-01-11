package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.ItemOrcamento;
import lombok.AllArgsConstructor;
import java.util.List;

import lombok.Getter;

@AllArgsConstructor
public class GeraPedido {
    @Getter
    private String cliente;
    @Getter
    private List<ItemOrcamento> itens;
}
