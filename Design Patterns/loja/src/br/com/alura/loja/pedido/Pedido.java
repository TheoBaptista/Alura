package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;

import java.time.LocalDate;

public class Pedido {

    private String Cliente;
    private LocalDate date;
    private Orcamento orcamento;

    public Pedido(String cliente, LocalDate date, Orcamento orcamento) {
        Cliente = cliente;
        this.date = date;
        this.orcamento = orcamento;
    }

    public String getCliente() {
        return Cliente;
    }

    public LocalDate getDate() {
        return date;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }
}
