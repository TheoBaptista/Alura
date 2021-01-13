package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

public class OrcamentoProxy extends Orcamento {


    private Orcamento oracemento;
    private BigDecimal valor;

    public OrcamentoProxy(Orcamento oracemento) {

        this.oracemento = oracemento;
    }

    @Override
    public BigDecimal getValor() {
       if(valor == null){
           this.valor = oracemento.getValor();
       }
       return this.valor;
    }
}
