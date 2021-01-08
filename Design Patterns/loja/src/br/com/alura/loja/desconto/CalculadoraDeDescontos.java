package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;
///Nessa classe tambem teremos um crescimento, pois ao adicionarmos novas regras é necessario sua implementacao
// mas mesmo tendo if não iremos aplicar o padrao strategy

public class CalculadoraDeDescontos {
    public BigDecimal calcular(Orcamento orcamento){
        if (orcamento.getQuantidadeDeItens() > 5){
            return orcamento.getValor().multiply(new BigDecimal("0.1"));
        }
        if(orcamento.getValor().compareTo(new BigDecimal("500"))>0){
            return orcamento.getValor().multiply(new BigDecimal("0.1"));
        }
        return BigDecimal.ZERO;
    }
}
