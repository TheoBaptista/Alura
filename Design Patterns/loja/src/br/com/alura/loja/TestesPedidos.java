package br.com.alura.loja;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.Pedido;
import br.com.alura.loja.pedido.acoes.ActionToExecute;
import br.com.alura.loja.pedido.acoes.EnviarEmailPedido;
import br.com.alura.loja.pedido.acoes.LogDePedido;
import br.com.alura.loja.pedido.acoes.PedidoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestesPedidos {
    public static void main(String[] args) {




        String cliente = "Patricia";
        BigDecimal valorOrcamento = new BigDecimal("500");
        int quantidadeItens = 4;
        GeraPedido gerador = new GeraPedido(cliente,valorOrcamento,quantidadeItens);
        List<ActionToExecute> acoes = Arrays.asList(new EnviarEmailPedido(),new PedidoRepository(), new LogDePedido());
        GeraPedidoHandler handler = new GeraPedidoHandler(acoes);
        handler.executar(gerador);
    }

}
