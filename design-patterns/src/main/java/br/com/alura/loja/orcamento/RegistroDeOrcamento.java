package br.com.alura.loja.orcamento;

import br.com.alura.loja.http.HttpAdapter;
import br.com.alura.loja.DomainException;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class RegistroDeOrcamento {
    private HttpAdapter http;

    public void registrar(Orcamento orcamento) {
        if (!orcamento.isFinalizado()) {
            throw new DomainException("Orcamento não finalizado");
        }
        Map<String, Object> dados = Map.of(
            "valor", orcamento.getValor(),
            "quantidadeItens", orcamento.getQuantidadeItens()
        );
        this.http.post("http://api.externa/orcamento", dados);
    }
}
