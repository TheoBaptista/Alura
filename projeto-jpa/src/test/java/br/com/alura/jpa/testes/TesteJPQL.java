package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {
	public static void main(String[] args) {

		/*
		 * Para isso, faremos um select na classe Movimentacao e não mais na tabela
		 * movimentacao, e bastará mudar a primeira letra para maiúsculo para indicar.
		 * 
		 * Quando criarmos objetos no mundo Java, os atribuiremos a variáveis para
		 * podermos manipulá-los. Então chamaremos a Movimentacao de m no lugar de *,
		 * para dizer que queremos buscar estas movimentações.
		 * 
		 * No que diz respeito ao relacionamento, buscaremos as movimentações que estão
		 * associadas à conta com identificação 2. Consultando a classe Movimentacao
		 * novamente, já teremos acesso aos relacionamentos entre nossos objetos, e
		 * veremos a anotação @ManyToOne no atributo Conta.
		 * 
		 * Portanto, ao invés de passarmos a conta_id, passaremos a m.conta dentro da
		 * Movimentacao e compararemos o .id. Feito isso, teremos uma JPQL pronta para
		 * ser executada.
		 */

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setId(2L);
		String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";

		TypedQuery<Movimentacao> query = em.createQuery(jpql,Movimentacao.class);
		query.setParameter("pConta", conta);
		List<Movimentacao> resultList = query.getResultList();

		/*
		 * Para dizermos à JPA que a conta é um parâmetro, bastará inserirmos : na
		 * frente de seu nome e transformarmos a primeira letra em maiúscula. Por
		 * convenção, a comunidade usuária da JPA costuma adicionar também um p entre :
		 * e Conta nessa mesma linha, indicando mais claramente de que se trata de um
		 * parâmetro, substituindo o nome "conta" por "pConta" em setParameter().
		 */

		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
			System.out.println("Tipo: " + movimentacao.getValor());
		}

		/*
		 * Fizemos uma query orientada a objetos, e isso indica sua proximidade com este
		 * mundo. Em alguns casos específicos, continuaremos trabalhando com Id e
		 * relacionamento, mas na maioria deles poderemos nos afastar do mundo
		 * relacional para trabalharmos com este mapeamento-objeto-relacional realizado
		 * pela JPA.
		 */

	}
}
