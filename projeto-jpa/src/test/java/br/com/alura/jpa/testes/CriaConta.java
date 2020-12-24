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
		 * todo o comando de mudan�a de estado que executamos na JPA para fazer um
		 * insert, alterar ou remover algo em nosso banco, ser� necess�rio que esteja
		 * obrigatoriamente dentro de uma transa��o.
		 */

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();

		/*
		 * A transa��o � um escopo de tarefas que ser�o executadas de uma forma �nica ou
		 * at�mica. Caso alguma das opera��es apresentar algum problema, bastar� voltar
		 * ao estado anterior chamado de rollback.
		 */

		/*
		 * No JDBC tamb�m h� este conceito, mas por padr�o usaremos sempre o AutoCommit,
		 * o que significar� que qualquer comando SQL que for executado gerar�, iniciar�
		 * e finalizar� uma transa��o automaticamente para este.
		 */
	}
}
