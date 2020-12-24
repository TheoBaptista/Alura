package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.MovimentacaoDao;

public class TestaSomaMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();


		BigDecimal dao = new MovimentacaoDao(em).getSomaDasMovimentacoes();

		System.out.println("A Soma das movimentacoes é :" + dao);

	}

}
