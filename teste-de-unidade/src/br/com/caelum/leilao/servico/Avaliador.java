package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {


  private	double maiorDeTodos = Double.NEGATIVE_INFINITY ;
  private 	double menorDeTodos = Double.POSITIVE_INFINITY;
  private List<Lance> maiores;
  private List<Lance> mediaDosLances;
 
	
	public double getMaiorDeTodos() {
	return maiorDeTodos;
}

public double getMenorDeTodos() {
	return menorDeTodos;
}

	public void avalia(Leilao leilao) {
		
		
		
		for(Lance lance : leilao.getLances()) {
			
			
			if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
			
			if(lance.getValor() <  menorDeTodos) menorDeTodos = lance.getValor();
			
		}
		
		 pegaOsMaioresNo(leilao);
		 mediaDosLances = new ArrayList<Lance>(leilao.getLances());
	}
	
	
	 private void pegaOsMaioresNo(Leilao leilao) {
	        maiores = new ArrayList<Lance>(leilao.getLances());
	        maiores.sort(Comparator.comparing(Lance::getValor));
	        
	        maiores = maiores.subList(0, maiores.size() 
	        		> 3 ? 3 : maiores.size());
	    }
	

	public List<Lance> getTresMaiores() {
		return maiores;
	}

	public double getMediaLances( ) {	
			double media =  mediaDosLances.stream().mapToDouble(Lance::getValor).average().orElse(0.0);
	
	return media;
	}
	
	
	
}
