package br.com.alura.loja.pedido.acoes;

import br.com.alura.loja.pedido.Pedido;

public class PedidoRepository implements ActionToExecute {

    @Override
    public void execute(Pedido pedido) {
        System.out.println("Salvar pedido no banco de dados do cliente" + pedido.getCliente());
    }
}
