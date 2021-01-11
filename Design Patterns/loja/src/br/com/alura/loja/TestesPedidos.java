package br.com.alura.loja;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.Pedido;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestesPedidos {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("600"),4);
        Pedido pedido1 = new Pedido("Ana Silva", LocalDate.now(),orcamento);
        System.out.println("Salvar pedido no banco de dados");
        System.out.println("Enviar e-mail com banco de dados");
    }

}
