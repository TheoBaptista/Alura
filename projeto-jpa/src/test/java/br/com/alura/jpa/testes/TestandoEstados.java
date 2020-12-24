package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		// Transient
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setNumero(321321);
		conta.setAgencia(123123);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		// Transient -> Managed
		em.persist(conta);

		// Managed -> Removed
		em.remove(conta);

		em.getTransaction().commit();

		/*
		 * a JPA tem o estado Transient para designar este tipo de objeto desvinculado.
		 * Sua característica é uma conta que existe na memória, possui informações e
		 * não tem Id nenhum, mas pode se tornar Managed futuramente.
		 * 
		 * Para fazer esta transformação, bastará termos um EntityManager para
		 * inserirmos persist() passando a conta.
		 * 
		 * Quando executarmos a persistência com este método, estaremos transformando um
		 * objeto Transient em Managed, cuja característica é a sincronização automática
		 * com o banco de dados.
		 * 
		 * Como consequência dessa transição de estados, a JPA perceberá que a conta
		 * Transient acabou de ser criada, e portanto precisará inseri-la no database.
		 * 
		 * As ações que a JPA executará dentro do banco e as querys que digitará e
		 * disparará contra o banco são consequências de transições de estados dentro
		 * das entidades, como já vimos.
		 * 
		 * Caso queiramos remover a conta Managed, poderemos usar o método remove()
		 * passando uma conta que será deletada de seu contexto JPA, o que gerará a
		 * sincronização e aplicará um delete no banco de dados, transformando-a em um
		 * estado Removed.
		 * 
		 * Para executarmos o código, executaremos uma transação com get.Transaction() e
		 * begin() conforme é necessário para a mudança de estado. Por fim, usaremos
		 * commit().
		 */
		/*
		 * Como resultado, veremos que a Conta é criada e logo em seguida é deletada.
		 * Digitando select * from conta;, visualizaremos a tabela sem a última conta do
		 * Almiro, pois fora removida.
		 * 
		 * Portanto, tudo é consequência da transição de estados.
		 * 
		 * Como já aprendemos todos os estados possíveis de entidades trabalhando com
		 * JPA, saberemos que, como desenvolvedores, nosso objetivo é sempre
		 * transformá-las em Managed; afinal, poderemos usufruir da sincronização
		 * automática com as querys necessárias.
		 * 
		 * Também sabemos que analogias geralmente feitas em estudos nem sempre são
		 * verdadeiras, e deveremos ter em mente que as querys são resultantes da
		 * transição de estados.
		 */
	}

}
