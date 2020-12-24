package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Maria do rosário");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(100.0);

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		em.close();

//	        conta.setSaldo(500.0);

		/*
		 * Não acontecerá nenhuma atualização rodando este código, pois aplicamos o
		 * em.close() e o Hibernate apenas inserirá a nova conta.
		 */

		/*
		 * Portanto, nenhuma atualização acontece depois que fechamos com em.close();
		 * todas as contas que antes estavam em estado Managed pelo próprio o
		 * EntityManager passam a ser Detached quando este é fechado.
		 */
		/*
		 * Sua principal característica é não permitir a sincronização automática quando
		 * há alteração no modelo, e a Conta só possui um Id porque foi Managed
		 * anteriormente.
		 */
		/*
		 * Nosso objetivo é transformar as entidades para o estado Managed sempre que
		 * possível quando trabalhamos com JPA, para justamente podermos usufruir da
		 * sincronização automática.
		 */
		/*
		 * 
		 */

		EntityManager em2 = emf.createEntityManager();
		System.out.println("ID da Conta da Márcia:" + conta.getId());
		conta.setSaldo(500.0);

		em2.getTransaction().begin();

		em2.merge(conta);

		em2.getTransaction().commit();

		/*
		 * Rodando este código, veremos que o programa cria uma Conta e a altera depois.
		 * O select é usado para pegar o elemento do banco e comparar com a alteração no
		 * código.
		 * 
		 * Não teremos mais os dados do primeiro EntityManager salvos na memória, pois
		 * fizemos outro em2 com mudanças nas informações que serão comparados pelo
		 * select.
		 * 
		 * É muito comum escutarmos que o persist() serve para inserir e o merge() para
		 * o update, mas isso nem sempre é verdade; vimos um caso em que o select é
		 * feito antes da atualização aqui.
		 * 
		 * Essa analogia usada para facilitar o aprendizado não cabe muito bem nos
		 * trabalhos com JPA, e deveremos sempre ter em mente a transição dos estados e
		 * as suas consequentes querys.
		 */
	}

}
