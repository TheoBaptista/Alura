package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidaçãoPeriodicidadeEntreReajustes implements ValidacaoReajuste {
    public void validar(Funcionario funcionario, BigDecimal aumento){
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste,dataAtual);
        if (mesesDesdeUltimoReajuste < 6){
            throw new ValidacaoException("Intervalo de Reajuste deve ser no minimo de seis meses");
        }

    }
}
