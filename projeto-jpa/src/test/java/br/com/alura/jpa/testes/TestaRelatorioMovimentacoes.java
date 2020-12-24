package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatorioMovimentacoes {

	/*
	 * Todo relacionamento ToMany é carregado de forma lazy preguicoso, para alterar isso devemos indicar isso no atributo da classe.
	 */
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";

		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);

		List<Conta> contas = query.getResultList();

		for (Conta conta : contas) {

			System.out.println("Titular :" + conta.getTitular());
			System.out.println("Agencia :" + conta.getAgencia());
			System.out.println("Numero conta :" + conta.getNumero());
			System.out.println("Movimentacoes :" + conta.getMovimentacoes());
			System.out.println( );
		}
	}

}
