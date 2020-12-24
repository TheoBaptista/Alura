package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.MovimentacaoDao;

public class TestaFiltoMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
 
		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		for (Movimentacao movimentacao : dao.getMovimentacoesFiltradasPorData(null, null, 2020)) {
			System.out.println("Data movimentacao : " + movimentacao.getData() + "\nValor : " +  movimentacao.getValor() + "\nDescrição : "+  movimentacao.getDescricao());
		}

	}

}
