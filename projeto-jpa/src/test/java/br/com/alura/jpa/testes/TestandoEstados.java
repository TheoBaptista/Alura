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
		 * Sua caracter�stica � uma conta que existe na mem�ria, possui informa��es e
		 * n�o tem Id nenhum, mas pode se tornar Managed futuramente.
		 * 
		 * Para fazer esta transforma��o, bastar� termos um EntityManager para
		 * inserirmos persist() passando a conta.
		 * 
		 * Quando executarmos a persist�ncia com este m�todo, estaremos transformando um
		 * objeto Transient em Managed, cuja caracter�stica � a sincroniza��o autom�tica
		 * com o banco de dados.
		 * 
		 * Como consequ�ncia dessa transi��o de estados, a JPA perceber� que a conta
		 * Transient acabou de ser criada, e portanto precisar� inseri-la no database.
		 * 
		 * As a��es que a JPA executar� dentro do banco e as querys que digitar� e
		 * disparar� contra o banco s�o consequ�ncias de transi��es de estados dentro
		 * das entidades, como j� vimos.
		 * 
		 * Caso queiramos remover a conta Managed, poderemos usar o m�todo remove()
		 * passando uma conta que ser� deletada de seu contexto JPA, o que gerar� a
		 * sincroniza��o e aplicar� um delete no banco de dados, transformando-a em um
		 * estado Removed.
		 * 
		 * Para executarmos o c�digo, executaremos uma transa��o com get.Transaction() e
		 * begin() conforme � necess�rio para a mudan�a de estado. Por fim, usaremos
		 * commit().
		 */
		/*
		 * Como resultado, veremos que a Conta � criada e logo em seguida � deletada.
		 * Digitando select * from conta;, visualizaremos a tabela sem a �ltima conta do
		 * Almiro, pois fora removida.
		 * 
		 * Portanto, tudo � consequ�ncia da transi��o de estados.
		 * 
		 * Como j� aprendemos todos os estados poss�veis de entidades trabalhando com
		 * JPA, saberemos que, como desenvolvedores, nosso objetivo � sempre
		 * transform�-las em Managed; afinal, poderemos usufruir da sincroniza��o
		 * autom�tica com as querys necess�rias.
		 * 
		 * Tamb�m sabemos que analogias geralmente feitas em estudos nem sempre s�o
		 * verdadeiras, e deveremos ter em mente que as querys s�o resultantes da
		 * transi��o de estados.
		 */
	}

}
