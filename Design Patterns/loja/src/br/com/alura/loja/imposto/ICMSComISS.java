package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class ICMSComISS implements TipoIposto {
    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        BigDecimal icms = new ISS().calcular(orcamento);
        BigDecimal iss = new ICMS().calcular(orcamento);
        return icms.add(iss);
    }
}
