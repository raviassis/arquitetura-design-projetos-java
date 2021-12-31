package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
public class Orcamento {
    @Getter
    private BigDecimal valor;
    @Getter
    private int quantidadeItens;

    @Getter
    @Setter
    private SituacaoOrcamento situacao = new EmAnalise();

    public void aplicarDescontoExtra(){
        var valorDescontoExtra = this.situacao.calcularDescontoExtra(this);
        this.valor = this.valor.subtract(valorDescontoExtra);
    }

    public void aprovar() {
        this.situacao.aprovar(this);
    }

    public void reprovar() {
        this.situacao.reprovar(this);
    }

    public void finalizar() {
        this.situacao.finalizar(this);
    }
}
