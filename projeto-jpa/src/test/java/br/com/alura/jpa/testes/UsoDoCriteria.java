package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.Movimentacao;

public class UsoDoCriteria {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);// classe do retorno da nossa query

		// passamos a classe entidade
		// o from vai retornar o root da nossa query
		Root<Movimentacao> root = query.from(Movimentacao.class);
		/*
		 * Execução da nossa expressao
		 */
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		query.select(sum);
		
		TypedQuery<BigDecimal> typedQuery =em.createQuery(query);
		
		
		System.out.println("A Soma das movimentacoes é :" + typedQuery.getSingleResult());

	}

}
