package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.Situacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Orcamento implements Orcavel {

    private BigDecimal valor;

    private Situacao situacao;

    private List<Orcavel> itens;

    public Orcamento() {
        this.valor = BigDecimal.ZERO;
        this.itens = new ArrayList<>();
        this.situacao = new EmAnalise();

    }

    public List<Orcavel> getItens() {
        return itens;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }


    public void aplicarDescontoExtra(){
        BigDecimal valorDoDescontoExtra = this.situacao.calcularValorDoDescontoExtra(this);
                this.valor = this.valor.subtract(valorDoDescontoExtra);
    }
    public void aprovar(){
        this.situacao.aprovar(this);
    }
    public void reprovar(){
        this.situacao.reprovar(this);
    }
    public void finalizar(){
        this.situacao.finalizar(this);
    }

    public boolean isFinalizado() {
        return this.situacao instanceof Finalizado;
    }
    public void adicionarItem(Orcavel item){
        this.valor = valor.add(item.getValor());
        this.itens.add(item);
    }
}
