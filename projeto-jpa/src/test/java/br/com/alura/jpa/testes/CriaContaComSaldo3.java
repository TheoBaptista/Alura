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
		conta.setTitular("Maria do ros�rio");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(100.0);

		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		em.close();

//	        conta.setSaldo(500.0);

		/*
		 * N�o acontecer� nenhuma atualiza��o rodando este c�digo, pois aplicamos o
		 * em.close() e o Hibernate apenas inserir� a nova conta.
		 */

		/*
		 * Portanto, nenhuma atualiza��o acontece depois que fechamos com em.close();
		 * todas as contas que antes estavam em estado Managed pelo pr�prio o
		 * EntityManager passam a ser Detached quando este � fechado.
		 */
		/*
		 * Sua principal caracter�stica � n�o permitir a sincroniza��o autom�tica quando
		 * h� altera��o no modelo, e a Conta s� possui um Id porque foi Managed
		 * anteriormente.
		 */
		/*
		 * Nosso objetivo � transformar as entidades para o estado Managed sempre que
		 * poss�vel quando trabalhamos com JPA, para justamente podermos usufruir da
		 * sincroniza��o autom�tica.
		 */
		/*
		 * 
		 */

		EntityManager em2 = emf.createEntityManager();
		System.out.println("ID da Conta da M�rcia:" + conta.getId());
		conta.setSaldo(500.0);

		em2.getTransaction().begin();

		em2.merge(conta);

		em2.getTransaction().commit();

		/*
		 * Rodando este c�digo, veremos que o programa cria uma Conta e a altera depois.
		 * O select � usado para pegar o elemento do banco e comparar com a altera��o no
		 * c�digo.
		 * 
		 * N�o teremos mais os dados do primeiro EntityManager salvos na mem�ria, pois
		 * fizemos outro em2 com mudan�as nas informa��es que ser�o comparados pelo
		 * select.
		 * 
		 * � muito comum escutarmos que o persist() serve para inserir e o merge() para
		 * o update, mas isso nem sempre � verdade; vimos um caso em que o select �
		 * feito antes da atualiza��o aqui.
		 * 
		 * Essa analogia usada para facilitar o aprendizado n�o cabe muito bem nos
		 * trabalhos com JPA, e deveremos sempre ter em mente a transi��o dos estados e
		 * as suas consequentes querys.
		 */
	}

}
