package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(500.0);

		em.getTransaction().begin();

		em.persist(conta);

		conta.setSaldo(1000.0);

		em.getTransaction().commit();

		/*
		 * Executando este c�digo, veremos no log que ocorre um search() seguido da
		 * verifica��o da mudan�a, visto que a conta j� est� Managed, disparando um
		 * uptade para sincronizar a altera��o com o banco de dados. Al�m disso, a conta
		 * ganha um Id automaticamente quando a transformamos em Managed.
		 * 
		 * Por�m, setamos apenas o titular, o n�mero da conta, a ag�ncia e o saldo, sem
		 * o Id. Este foi setado para que o valor de GenerateValue() seja gerado de
		 * forma autom�tica.
		 * 
		 * Logo, quando a conta se torna Managed, a JPA seta o Id para esta
		 * automaticamente. Deveremos tomar certo cuidado, pois nem toda conta com Id �
		 * necessariamente Managed.
		 */

	}

}
