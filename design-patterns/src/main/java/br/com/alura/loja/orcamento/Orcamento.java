package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Orcamento implements Orcavel {

    private BigDecimal valor = BigDecimal.ZERO;

    private List<Orcavel> itens = new ArrayList<>();

    @Getter
    @Setter
    private SituacaoOrcamento situacao = new EmAnalise();

    public int getQuantidadeItens() {
        return this.itens.size();
    }

    public void adicionarItem(Orcavel itemOrcamento) {
        this.valor = this.valor.add(itemOrcamento.getValor());
        this.itens.add(itemOrcamento);
    }

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

    public boolean isFinalizado() {
        return this.situacao instanceof Finalizado;
    }


    @Override
    public BigDecimal getValor() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.valor;
    }
}
