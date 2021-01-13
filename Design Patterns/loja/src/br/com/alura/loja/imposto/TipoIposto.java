package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class TipoIposto {

    private TipoIposto outroImposto;

    public TipoIposto(TipoIposto outroImposto) {
        this.outroImposto = outroImposto;
    }

    protected abstract BigDecimal calcular(Orcamento orcamento);

    public BigDecimal RealizarCalculo(Orcamento orcamento){
        BigDecimal valorImposto = calcular(orcamento);
        BigDecimal valorDoOutroImposto = BigDecimal.ZERO;
        if (outroImposto != null){
            valorDoOutroImposto = outroImposto.calcular(orcamento);
        }
        return valorImposto.add(valorDoOutroImposto);
    }

}
