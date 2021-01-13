package br.com.alura.loja.pedido.acoes;

import br.com.alura.loja.pedido.Pedido;

public class LogDePedido implements  ActionToExecute {
    @Override
    public void execute(Pedido pedido) {
        System.out.println("Pedido foi gerado");
    }
}
