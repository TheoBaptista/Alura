package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeImpostos {

//    problema comum e bem recorrente, escrever if/elses ou switch cases para definir algo
//    a classe sempre ira crescer fazendo com que a manutencao do codigo seja problematica
//    para resolver esse problema aplicamos o padrão de projetos strategy
//    ao contrario dessa inforamção ser uma string ou enum essa info pode ser a propria classe
//    depois usamos o polimorfismo ou classes abstratas para que cada uma tenha sua implementação

    public BigDecimal calcular (Orcamento orcamento, TipoIposto tipoImposto){
        return tipoImposto.calcular(orcamento);
    }

}
