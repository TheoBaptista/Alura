package br.com.alura.loja.pedido.acoes;

import br.com.alura.loja.pedido.Pedido;

public class EnviarEmailPedido implements ActionToExecute {

    @Override
    public void execute(Pedido pedido) {
        System.out.println("Enviar e-mail para o cliente" + pedido.getCliente());
    }
}
