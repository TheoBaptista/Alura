package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class PopulaMovimentacaoComCategoria {

	public static void main(String[] args) {// T
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		
		Conta conta = em.find(Conta.class, 2L);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(LocalDateTime.now());
		movimentacao1.setDescricao("Viagem à SP");
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal(100.0));
		movimentacao1.setCategorias(Arrays.asList(categoria1,categoria2));
		
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(LocalDateTime.now().plusDays(1));
		movimentacao2.setDescricao("Viagem ao RJ");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal(300.0));
		movimentacao2.setCategorias(Arrays.asList(categoria2));
	
		movimentacao2.setConta(conta);
		
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(categoria2);
		
		em.persist(movimentacao1);	
		em.persist(movimentacao2);
		
		
		em.getTransaction().commit();
		
	}

}
