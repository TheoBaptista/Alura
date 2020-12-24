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
		 * qualquer alteração de estado necessitará uma transação para trabalharmos com
		 * JPA. Portanto, escreveremos em.getTransaction() com begin() e depois com
		 * commit().
		 */

		em.getTransaction().begin();

		contaDoLeonardo.setSaldo(20.0);

		/*
		 * Estranhamente, não estamos chamando nenhum método da JPA para fazer a
		 * alteração de estado. A única ação que estamos fazendo neste código é alterar
		 * o estado no modelo, passando um novo saldo da mesma conta.
		 */

		em.getTransaction().commit();

		/*
		 * Portanto, houve uma sincronização pelo simples fato de termos alterado o
		 * estado do modelo. A seguir, entenderemos melhor como isso se acontece.
		 */

		/*
		 * Entenderemos o porquê da JPA ter alterado o estado da conta sem precisarmos
		 * notificar sobre a alteração no modelo.
		 * 
		 * Quando fazemos um find() no EntityManager, a JPA e o Hibernate buscarão no
		 * banco e criarão um objeto tipo Conta para ser devolvido, representando o
		 * registro buscado no database.
		 * 
		 * Essa Conta devolvida ainda mantém uma referência, então a JPA ainda a conhece
		 * mesmo após a devolução. Sendo assim, costuma-se dizer que esta entidade Conta
		 * se encontra no estado Managed, ou seja, gerenciado pela JPA.
		 * 
		 * Portanto, como os dados originais do banco são conhecidos, quando fizermos
		 * qualquer alteração dentro dessa entidade e commitarmos a transação, haverá a
		 * sincronização automática.
		 * 
		 *  Este estado Managed também é alcançável quando fazemos um persist() além de find().
		 * 
		 */
	}

}
