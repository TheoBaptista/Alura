package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {
	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setAgencia(123456);
		conta.setNumero(123456);
		conta.setTitular("Rodrigo Lombardi");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		/*
		 * todo o comando de mudança de estado que executamos na JPA para fazer um
		 * insert, alterar ou remover algo em nosso banco, será necessário que esteja
		 * obrigatoriamente dentro de uma transação.
		 */

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();

		/*
		 * A transação é um escopo de tarefas que serão executadas de uma forma única ou
		 * atômica. Caso alguma das operações apresentar algum problema, bastará voltar
		 * ao estado anterior chamado de rollback.
		 */

		/*
		 * No JDBC também há este conceito, mas por padrão usaremos sempre o AutoCommit,
		 * o que significará que qualquer comando SQL que for executado gerará, iniciará
		 * e finalizará uma transação automaticamente para este.
		 */
	}
}
