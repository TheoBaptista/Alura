package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaLeonardo {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		Conta contaDoLeonardo = em.find(Conta.class, 1L);

		/*
		 * qualquer altera��o de estado necessitar� uma transa��o para trabalharmos com
		 * JPA. Portanto, escreveremos em.getTransaction() com begin() e depois com
		 * commit().
		 */

		em.getTransaction().begin();

		contaDoLeonardo.setSaldo(20.0);

		/*
		 * Estranhamente, n�o estamos chamando nenhum m�todo da JPA para fazer a
		 * altera��o de estado. A �nica a��o que estamos fazendo neste c�digo � alterar
		 * o estado no modelo, passando um novo saldo da mesma conta.
		 */

		em.getTransaction().commit();

		/*
		 * Portanto, houve uma sincroniza��o pelo simples fato de termos alterado o
		 * estado do modelo. A seguir, entenderemos melhor como isso se acontece.
		 */

		/*
		 * Entenderemos o porqu� da JPA ter alterado o estado da conta sem precisarmos
		 * notificar sobre a altera��o no modelo.
		 * 
		 * Quando fazemos um find() no EntityManager, a JPA e o Hibernate buscar�o no
		 * banco e criar�o um objeto tipo Conta para ser devolvido, representando o
		 * registro buscado no database.
		 * 
		 * Essa Conta devolvida ainda mant�m uma refer�ncia, ent�o a JPA ainda a conhece
		 * mesmo ap�s a devolu��o. Sendo assim, costuma-se dizer que esta entidade Conta
		 * se encontra no estado Managed, ou seja, gerenciado pela JPA.
		 * 
		 * Portanto, como os dados originais do banco s�o conhecidos, quando fizermos
		 * qualquer altera��o dentro dessa entidade e commitarmos a transa��o, haver� a
		 * sincroniza��o autom�tica.
		 * 
		 *  Este estado Managed tamb�m � alcan��vel quando fazemos um persist() al�m de find().
		 * 
		 */
	}

}
