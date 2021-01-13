package br.com.alura.loja.orcamento;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.http.HttpAdapter;

import java.util.Map;

public class RegistroOrcamento {

    private HttpAdapter http;

    public RegistroOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento){
        if(!orcamento.isFinalizado()){
            throw new DomainException("O orcamento deve estar finalizado");
        }
        //chamada Http para uma API externa
        // Url Connection
        // Http Client
        //Lib rest
        // abstrair esse conceito para uma outra classe que lidara com a infra, sobretudo independente de implementações.
        //varias maneiras dessa comunicacao
        String url = "http://api.externa/orcamento";
        Map<String,Object> dados = Map.of(
          "valor", orcamento.getValor(), "quantidadeDeItens" , orcamento.getItens().size()
        );
        http.post(url, dados);

    }
}
