package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acoes.ActionToExecute;

import java.time.LocalDate;
import java.util.List;

public class GeraPedidoHandler {


    private final List<ActionToExecute> acoes;

    public GeraPedidoHandler(List<ActionToExecute> acoes) {
        this.acoes = acoes;
    }
    //Construtor com injeção de dependendencias: repository, service, etc.


    public void executar(GeraPedido dados) {
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeDeItens());
        Pedido pedido = new Pedido(dados.getCliente(), LocalDate.now(), orcamento);
        acoes.forEach(a -> a.execute(pedido));
    }
}
