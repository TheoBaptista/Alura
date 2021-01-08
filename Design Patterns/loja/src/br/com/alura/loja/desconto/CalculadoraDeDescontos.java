package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;
///Nessa classe tambem teremos um crescimento, pois ao adicionarmos novas regras é necessario sua implementacao
// mas mesmo tendo ifs não iremos aplicar o padrao strategy pois os ifs são necessarios no codigo para que seja definido desconto
// Aplicamos então o padrão chain of responsibility

public class CalculadoraDeDescontos {
    public BigDecimal calcular(Orcamento orcamento){
      Desconto cadeiaDeDesconto = new DescentParaOrnamentComMaiaDeCincoTens(
              new DescontoParaOrcamentoMarioQueQuinhentos(
                      new SemDesconto()
              )
      );

       return cadeiaDeDesconto.calcular(orcamento);
    }
}
