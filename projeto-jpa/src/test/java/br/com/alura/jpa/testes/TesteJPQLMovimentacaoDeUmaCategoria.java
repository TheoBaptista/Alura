package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		String sql = "select m from Movimentacao m join m.categorias c  where c = :pCategoria";

		Categoria categoria = new Categoria();
		categoria.setId(2L);

		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);

		List<Movimentacao> movimentacoes = query.getResultList();
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Descrição: " + movimentacao.getCategorias());
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}

	}

	/*
	 * Essas categorias não estão armazenadas na tabela Movimentacao, e sim na
	 * Categoria. Também existe uma de relacionamento que faz a correlação entre
	 * chaves estrangeiras.
	 * 
	 * Portanto, precisaremos juntar essas duas últimas tabelas citadas para fazer
	 * esta busca. Utilizaremos uma palavra-chave chamada join, a qual é responsável
	 * pela junção com m.categorias nomeada como c quando trabalhamos com tabela de
	 * relacionamento.
	 * 
	 * Em seguida, faremos o filtro quando o c for igual ao parâmetro :pCategoria,
	 * substituindo em setParameter() também.
	 * 
	 * 
	 */
	/*
	 * Em persistence.xml, mudaremos para false a propriedade hibernate.show_sql que
	 * mostra as querys, facilitando a leitura do retorno da execução, mas poderemos
	 * retornar ao true depois.
	 * 
	 * De volta ao nosso teste TesteJPQLMovimentacaoDeUmaCategoria, rodaremos o
	 * código novamente.
	 * 
	 * Teremos as duas movimentações no retorno, ambas atreladas às categorias de
	 * identificação 1 e 2.
	 * 
	 * Portanto, conseguimos fazer uma query em relacionamentos @ManyToMany através
	 * de join, unindo as duas tabelas em questão.
	 */

}
