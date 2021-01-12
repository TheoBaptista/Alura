package br.com.alura.loja.pedido;

public class PedidoRepository {
    public void salvar(Pedido pedido){
        System.out.println("Salvar pedido no banco de dados do cliente" + pedido.getCliente());
    }
}
