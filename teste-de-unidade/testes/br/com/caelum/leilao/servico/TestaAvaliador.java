package br.com.caelum.leilao.servico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class TestaAvaliador {
	
	
	   private Avaliador leiloeiro;

	    @Before
	    public void setUp() {
	        this.leiloeiro = new Avaliador();
	    }

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		
		// criando cenario = 3 lances em ordem crescente 
		
		Usuario joao   = new Usuario("joao");
		Usuario jose	= new Usuario("jose");	
	    Usuario maria = new Usuario("maria");
		
	    Leilao leilao = new Leilao("Playstation 4 novo");
		
	    leilao.propoe(new Lance(maria,250.0));
	    leilao.propoe(new Lance(joao,300.0));
	    leilao.propoe(new Lance(jose,450.0));
	
	    // executando a acao 
	    
	    
	    leiloeiro.avalia(leilao);
	    
	    // comparando a saida com o esperado 
	    double maiorEsperado = 450;
	    double menorEsperado = 250;
	    
	    Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.0001);	    
	    Assert.assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.0001);
	}
	
	@Test
	public void devolveValorMedioDosLances() {
		
		// criando cenario = 3 lances em ordem crescente 
		
				Usuario joao   = new Usuario("joao");
				Usuario jose	= new Usuario("jose");	
			    Usuario maria = new Usuario("maria");
				
			    Leilao leilao = new Leilao("Playstation 4 novo");
				
			    leilao.propoe(new Lance(maria,250.0));
			    leilao.propoe(new Lance(joao,300.0));
			    leilao.propoe(new Lance(jose,450.0));
			    leilao.propoe(new Lance(maria,200.0));
			    
			    // executando a acao 
			    
			    leiloeiro.avalia(leilao);
			    
			    // validacao do resultado
			    
			    double mediaDosLances =(250 + 300 + 450 + 200) /4 ;
			    
			    Assert.assertEquals(mediaDosLances, leiloeiro.getMediaLances(),  0.00001);
		
		
	}
	
	@Test
	public void leilaoApenasComUmLance() {
		
		//criando cenario =  apenas um usuario e um lance
		Usuario joao   = new Usuario("joao");
		Leilao leilao = new Leilao("Abajour novo");
		leilao.propoe(new Lance(joao,300.0));
		
		// executando a acao
		
		
		leiloeiro.avalia(leilao);
		
		// validacao do resultado
		
		double umlanceEperado = 300;
	
		
		 Assert.assertEquals(umlanceEperado, leiloeiro.getMaiorDeTodos(),  0.00001);
		
		 Assert.assertEquals(umlanceEperado, leiloeiro.getMenorDeTodos(),  0.00001);
	}
	
	 @Test
	    public void deveEntenderLeilaoComLancesEmOrdemRandomica() {
	        Usuario joao = new Usuario("Joao"); 
	        Usuario maria = new Usuario("Maria"); 
	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao,200.0));
	        leilao.propoe(new Lance(maria,450.0));
	        leilao.propoe(new Lance(joao,120.0));
	        leilao.propoe(new Lance(maria,700.0));
	        leilao.propoe(new Lance(joao,630.0));
	        leilao.propoe(new Lance(maria,230.0));

	        leiloeiro.avalia(leilao);

	        assertEquals(700.0, leiloeiro.getMaiorDeTodos(), 0.0001);
	        assertEquals(120.0, leiloeiro.getMenorDeTodos(), 0.0001);
	    }
	 
	 @Test
	    public void deveEntenderLeilaoComLancesEmOrdemDecrescente() {
	        Usuario joao = new Usuario("Joao"); 
	        Usuario maria = new Usuario("Maria"); 
	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao,400.0));
	        leilao.propoe(new Lance(maria,300.0));
	        leilao.propoe(new Lance(joao,200.0));
	        leilao.propoe(new Lance(maria,100.0));

	        leiloeiro.avalia(leilao);

	        assertEquals(400.0, leiloeiro.getMaiorDeTodos(), 0.0001);
	        assertEquals(100.0, leiloeiro.getMenorDeTodos(), 0.0001);
	    }
	 
	 @Test
	 public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		 
		 Usuario maria = new Usuario("Maria"); 
	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(maria,400.0));
	        leilao.propoe(new Lance(maria,300.0));
		 
	        
	        leiloeiro.avalia(leilao);
	        
	        assertEquals(1, leilao.getLances().size());
	        assertEquals(400, leilao.getLances().get(0).getValor(), 0.00001);
	 }
	 
	 @Test
	    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
	        Leilao leilao = new Leilao("Macbook Pro 15");
	        Usuario steveJobs = new Usuario("Steve Jobs");
	        Usuario billGates = new Usuario("Bill Gates");

	        leilao.propoe(new Lance(steveJobs, 2000));
	        leilao.propoe(new Lance(billGates, 3000));
	        leilao.propoe(new Lance(steveJobs, 3000));
	        leilao.propoe(new Lance(billGates, 3000));
	        leilao.propoe(new Lance(steveJobs, 4000));
	        leilao.propoe(new Lance(billGates, 3000));
	        leilao.propoe(new Lance(steveJobs, 5000));
	        leilao.propoe(new Lance(billGates, 3000));
	        leilao.propoe(new Lance(steveJobs, 6000));
	        leilao.propoe(new Lance(billGates, 999));
	        leilao.propoe(new Lance(steveJobs, 7000));

	        assertEquals(10, leilao.getLances().size());
	        int ultimo = leilao.getLances().size() - 1;
	        assertEquals(999, leilao.getLances().get(ultimo).getValor(), 0.00001);
	    }
	
}
