package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;

import java.time.LocalDate;

public class GeraPedidoHandler {

    //Construtor com injeção de dependendencias: repository, service, etc.

    public void executar(GeraPedido dados){
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(),dados.getQuantidadeDeItens());
        Pedido pedido = new Pedido(dados.getCliente(), LocalDate.now(),orcamento);
         EnviarEmailPedido email = new EnviarEmailPedido();
         PedidoRepository repository = new PedidoRepository();
         email.enviarEmail(pedido);
         repository.salvar(pedido);
    }

}
