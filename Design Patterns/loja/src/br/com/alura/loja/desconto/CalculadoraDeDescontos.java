package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;
///Nessa classe tambem teremos um crescimento, pois ao adicionarmos novas regras é necessario sua implementacao
// mas mesmo tendo ifs não iremos aplicar o padrao strategy pois os ifs são necessarios no codigo para que seja definido desconto
//

public class CalculadoraDeDescontos {
    public BigDecimal calcular(Orcamento orcamento){
       BigDecimal desconto = new DescontoParaOrcamentoComMaisDeCincoItens().calcular(orcamento);
       if(desconto == BigDecimal.ZERO){
           desconto = new DescontoParaOrcamentoMarioQueQuinhentos().calcular(orcamento);
       }
       return desconto;
    }
}
