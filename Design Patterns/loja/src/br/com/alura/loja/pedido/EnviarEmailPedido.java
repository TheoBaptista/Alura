package br.com.alura.loja.pedido;

public class EnviarEmailPedido {
    public void enviarEmail(Pedido pedido){
        System.out.println("Enviar e-mail para o cliente" + pedido.getCliente());
    }
}
