package br.com.alura.leilao.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.utilo.builder.LeilaoBuilder;
import br.com.alura.leilao.utilo.builder.UsuarioBuilder;

class LeilaoDaoTest {

	private LeilaoDao dao;
	private EntityManager em;

	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new LeilaoDao(em);
		em.getTransaction().begin();
	}

	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();

	}

	@Test
	void deveriaCadastrarUmLeilao() {
		Usuario usuario = criarUsuario();
		Leilao leilao = criaLeilao("Mochila", "70", LocalDate.now(), usuario);
		leilao = dao.salvar(leilao);
		Leilao salvo = dao.buscarPorId(leilao.getId());
		Assert.assertNotNull(salvo);

	}

	@Test
	void deveriaAtualizarUmLeilao() {
		Usuario usuario = criarUsuario();
		Leilao leilao = criaLeilao("Mochila", "70", LocalDate.now(), usuario);
		leilao = dao.salvar(leilao);
		leilao.setNome("Celular");
		leilao.setValorInicial(new BigDecimal("400"));
		Leilao salvo = dao.buscarPorId(leilao.getId());
		Assert.assertEquals("Celular", salvo.getNome());
		Assert.assertEquals(new BigDecimal("400"), salvo.getValorInicial());

	}

	private Usuario criarUsuario() {
		Usuario usuario = new UsuarioBuilder().comNome("Fulano").comEmail("fulano@email.com").comSenha("123456")
				.build();
		em.persist(usuario);
		return usuario;
	}

	private Leilao criaLeilao(String nome, String valorInicial, LocalDate data, Usuario usuario) {
		return new LeilaoBuilder().comNome(nome).comValorInicial(valorInicial).comData(data).comUsuario(usuario)
				.build();
	}

//	Não faz muito sentido testar os metodos salvar, atualizar, deletar. Pois a lógica é delegada para a JPA.
//  É interessante fazer teste em métodos de consulta, pois tem uma lógica escrita nas queries que podem haver erros.

}
