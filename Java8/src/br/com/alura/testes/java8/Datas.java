package br.com.alura.testes.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Datas {
public static void main(String[] args) {
	
	 LocalDate hoje = LocalDate.now();
     System.out.println(hoje);
     
     LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
     
     int anos = olimpiadasRio.getYear() - hoje.getYear();
     System.out.println(anos);
     
     
     Period periodo = Period.between(hoje, olimpiadasRio);
     System.out.println(periodo);
     
     Period periodo1 = Period.between(hoje, olimpiadasRio);
     System.out.println(periodo1.getYears());
     System.out.println(periodo1.getMonths());
     System.out.println(periodo1.getDays());
	
     System.out.println(hoje.minusYears(1));
     System.out.println(hoje.minusMonths(4));
     System.out.println(hoje.minusDays(2));

     System.out.println(hoje.plusYears(1));
     System.out.println(hoje.plusMonths(4));
     System.out.println(hoje.plusDays(2));
     
//     Da mesma forma que as novas API's, como o Stream, os métodos da API de datas sempre vão retornar uma nova instancia da sua data. Portanto precisamos fazer algo como
//     
     LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
     System.out.println(proximasOlimpiadas);
//     Ou seja, toda a API de datas é imutável. Ela nunca vai alterar a data original.
	
	

	
//     Para formatar nossas datas podemos utilizar o DateTimeFormatter. Existem diversos já prontos, mas há ainda a alternativa de você criar o seu próprio formatador no padrão já conhecido de dd/MM/yyyy.
//     
     
     DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     
//     Agora podemos a partir da nossa data, neste caso proximasOlimpiadas, chamar o método format passando esse formatador:
//
     
     String valorFormatado = proximasOlimpiadas.format(formatador);
     System.out.println(valorFormatado);
     
     DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
     LocalDateTime agora = LocalDateTime.now();
     System.out.println(agora.format(formatadorComHoras));
     
//     É muito comum ignorarmos valores quando precisamos apenas de algumas medidas de tempo, como por exemplo ano e mês. Nessa caso no lugar de criarmos um LocalDate ou algo assim e ignorar o seu valor de dia, podemos trabalhar com os modelos mais específicos da nova API.

     YearMonth anoEMes = YearMonth.of(2015, Month.JANUARY);

//     Outro exemplo, para trabalharmos apenas com tempo podemos utilizar o LocalTime. Representar o horario do nosso intervalo de almoço, por exemplo, poderia ser feito com:

     
     LocalTime intervalo = LocalTime.of(12, 30);
     System.out.println(intervalo);
     
     
}
}
