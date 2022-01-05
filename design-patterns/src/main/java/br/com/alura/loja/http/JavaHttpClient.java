package br.com.alura.loja.http;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

public class JavaHttpClient implements HttpAdapter {
    @Override
    public void post(String url, Map<String, Object> dados) {
        try {
            URI.create(url).toURL().openConnection().connect();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao enviar requisição HTTP", e);
        }
    }
}
