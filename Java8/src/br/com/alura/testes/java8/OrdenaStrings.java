package br.com.alura.testes.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {
public static void main(String[] args) {
	
	List<String> palavras = new ArrayList<>();
	
	palavras.add("Theo");
	palavras.add("Jiboia");
	palavras.add("Degolono");
	palavras.add("Abulano");
	
	//palavras.sort((s1,s2)-> s1.length() -  s2.length());
	
	//comparing é uma factory que constroi comparator 
	palavras.sort(Comparator.comparing( palavra -> palavra.length() ));
	
	palavras.forEach( palavra -> System.out.println(palavra));
	

}


}
