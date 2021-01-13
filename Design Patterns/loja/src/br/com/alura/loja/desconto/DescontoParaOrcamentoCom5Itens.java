package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

class DescentParaOrnamentComMaiaDeCincoTens extends Desconto {

    public DescentParaOrnamentComMaiaDeCincoTens(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal efetuarCalculo(Orcamento orcamento){
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }

    @Override
    protected Boolean deveAplicar(Orcamento orcamento) {
        return orcamento.getItens().size() >5;
    }
}
