package br.com.alura.testes.java8;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestaAlunos {

	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<>();
		
		cursos.add(new Curso("Python",45));
		cursos.add(new Curso("Ruby",345));
		cursos.add(new Curso("JS",145));
		cursos.add(new Curso("Node",225));
		cursos.add(new Curso("Angular",320));
		cursos.add(new Curso("Vue",150));
		cursos.add(new Curso("Flutter",50));
		cursos.add(new Curso("Java",113));
		cursos.add(new Curso("C",1450));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		cursos.stream().filter(c -> c.getAlunos() > 50).forEach(c -> System.out.println(c.getAlunos()));;
		
		Stream<String> nomes = cursos.stream().map(Curso::getNome);
		
		nomes.forEach(System.out::println);
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .map(c -> c.getAlunos())
		   .forEach(x -> System.out.println(x));
	
		
		
		
//		Streams primitivos
//		Trabalhar com Streams vai ser frequente no seu dia a dia. Há um cuidado a ser tomado: com os tipos primitivos. Quando fizemos o map(Curso::getAlunos), recebemos de volta um Stream<Integer>, que acaba fazendo o autoboxing dos ints. Isto é, utilizará mais recursos da JVM. Claro que, se sua coleção é pequena, o impacto será irrisório. Mas é possível trabalhar só com ints, invocando o método mapToInt:
//		
//		
		int soma = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos)
				   .sum();
		
//		Em uma única linha de código, pegamos todos os cursos, filtramos os que tem mais de 100 e somamos todos os alunos.
//		Há também versões para double e long de Streams primitivos. Até mesmo o Comparator.comparing possui versões como Comparator.comparingInt, que recebe uma IntFunction e não necessita do boxing. Em outras palavras, todas as interfaces funcionais do novo pacote java.util.functions possuem versões desses tipos primitivos.
//
//		Stream não é uma List, não é uma Collection. E se quisermos obter uma coleção depois do processamento de um Stream?
//	
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny();
		
		Optional<Curso> optional = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .findAny();
		
		Curso curso = optional.get();
		
		Curso curso1 = optional.orElse(null);
		
		
		optional.ifPresent(c -> System.out.println(c.getNome()));
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny()
		   .ifPresent(c -> System.out.println(c.getNome()));
		
//		Tentar fazer List<Curso> novaLista = lista.stream().filter(...) não compila, pois um Stream não é uma coleção. Para fazer algo parecido com isso, utilizamos o método collect, que coleta elementos de um Stream para produzir um outro objeto, como uma coleção.
//
//				O método Collect recebe um Collector, uma interface não tão trivial de se implementar. Podemos usar a classe Collectors (repare o s no final), cheio de factory methods que ajudam na criação de coletores. Um dos coletores mais utilizados é o retornado por Collectors.toList():
//		
		
		List<Curso> resultados = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .collect(Collectors.toList());
		
		cursos = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .collect(Collectors.toList());
		
		
//		Um exemplo mais complicado? Podemos gerar mapas! Queremos um mapa que, dado o nome do curso, o valor atrelado é a quantidade alunos. Um Map<String, Integer>. Utilizamos o Collectors.toMap. Ele recebe duas Functions. A primeira indica o que vai ser a chave, e a segunda o que será o valor:
//		
		
		Map mapa = cursos 
				.stream() 
				.filter(c -> c.getAlunos() > 100) 
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
	}

}
