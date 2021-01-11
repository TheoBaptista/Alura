package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

public class Orcamento {

    private BigDecimal valor;

    private String situação;

    private int quantidadeDeItens;

    public Orcamento(BigDecimal valor, int quantidadeDeItens) {
        this.valor = valor;
        this.quantidadeDeItens = quantidadeDeItens;
        
    }



    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getQuantidadeDeItens() {
        return quantidadeDeItens;
    }

    public void setQuantidadeDeItens(int quantidadeDeItens) {
        this.quantidadeDeItens = quantidadeDeItens;
    }

    public void aplicarDescontoExtra(){
        BigDecimal valorDoDescontoExtra = BigDecimal.ZERO;
                if(situação.equals("ANALISE")){
                    valorDoDescontoExtra = new BigDecimal("0.05");
                }else if(situação.equals("APROVADO")){
                    valorDoDescontoExtra = new BigDecimal("0.02");
                }
                this.valor = this.valor.subtract(valorDoDescontoExtra);
    }
}
