package br.com.alura.jpa.testes;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestaMediaMovimentacoes2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		String jpql = "Select avg(m.valor) as Total_Valor, day(m.data), month(m.data) "
				+ "from Movimentacao m group by day(m.data), month(m.data)";

		Query query = em.createQuery(jpql);
		List<Object[]> mediaDasMovimentacoes = query.getResultList();

		for (Object[] resultado : mediaDasMovimentacoes) {
			System.out.println("A media das movimentacoes do dia " + resultado[1] +  "/" + resultado[2] + " é :" + resultado[0] );
		}

	}

}
