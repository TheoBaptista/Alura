package br.com.alura.leilao.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.utilo.builder.UsuarioBuilder;

class UsuarioDaoTest {

	private UsuarioDao dao;
	private EntityManager em;

	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new UsuarioDao(em);
		em.getTransaction().begin();
	}

	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();

	}

	@Test
	void DeveriaEncontrarUsuarioCadastrado() {
		Usuario usuario = criarUsuario("fulano","fulano@email.com","123456");
		this.dao.buscarPorUsername(usuario.getNome());
		Assert.assertNotNull(usuario);
	}

	@Test
	void NaoDeveriaEncontrarUsuarioCadastrado() {
		criarUsuario("fulano","fulano@email.com","123456");
		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("beltrano"));

	}
	
	@Test
	public void deveriaRemoverUmUsuario() {
		Usuario usuario = criarUsuario("fulano","fulano@email.com","123456");
		dao.deletar(usuario);
		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername(usuario.getNome()));

	}

	private Usuario criarUsuario(String nome, String email, String senha) {
		Usuario usuario = new UsuarioBuilder().comNome(nome).comEmail(email).comSenha(senha).build();
		em.persist(usuario);
		return usuario;
	}

}
