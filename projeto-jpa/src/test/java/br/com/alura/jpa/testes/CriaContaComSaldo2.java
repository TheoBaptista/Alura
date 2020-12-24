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
		 * Executando este código, veremos no log que ocorre um search() seguido da
		 * verificação da mudança, visto que a conta já está Managed, disparando um
		 * uptade para sincronizar a alteração com o banco de dados. Além disso, a conta
		 * ganha um Id automaticamente quando a transformamos em Managed.
		 * 
		 * Porém, setamos apenas o titular, o número da conta, a agência e o saldo, sem
		 * o Id. Este foi setado para que o valor de GenerateValue() seja gerado de
		 * forma automática.
		 * 
		 * Logo, quando a conta se torna Managed, a JPA seta o Id para esta
		 * automaticamente. Deveremos tomar certo cuidado, pois nem toda conta com Id é
		 * necessariamente Managed.
		 */

	}

}
