package br.com.alura.loja;

import br.com.alura.loja.http.JavaHttpClient;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.RegistroOrcamento;

import java.math.BigDecimal;

public class TestesAdapter {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(BigDecimal.TEN,1);
        orcamento.aprovar();
        orcamento.finalizar();

        RegistroOrcamento registro = new RegistroOrcamento(new JavaHttpClient());
        registro.registrar(orcamento);
    }
}
