package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

class DescontoParaOrcamentoComMaisDeCincoItens {

    public BigDecimal calcular(Orcamento orcamento){
        if (orcamento.getQuantidadeDeItens() > 5){
            return orcamento.getValor().multiply(new BigDecimal("0.1"));
        }
        return BigDecimal.ZERO;
    }

}
