package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setAgencia(123456);
		conta.setNumero(5465656);
		conta.setTitular("China Veia");
		conta.setSaldo(1250.50);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();


	}

}
