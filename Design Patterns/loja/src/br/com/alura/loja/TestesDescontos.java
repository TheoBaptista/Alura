package br.com.alura.loja;

import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.situacao.Situacao;

import java.math.BigDecimal;

public class TestesDescontos {
    public static void main(String[] args) {


        Orcamento orcamento = new Orcamento();
        Orcamento orcamento2 = new Orcamento();

        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
        orcamento2.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));



        CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
        System.out.println(calculadora.calcular(orcamento2));
        System.out.println(calculadora.calcular(orcamento));
    }
}
