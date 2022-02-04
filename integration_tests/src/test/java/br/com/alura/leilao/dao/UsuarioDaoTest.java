package br.com.alura.leilao.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;

class UsuarioDaoTest {

	private UsuarioDao dao;
	private EntityManager em;

	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new UsuarioDao(em);
		this.em.getTransaction().begin();
	}

	@AfterEach
	public void afterEach() {
		this.em.getTransaction().rollback();
	}

	@Test
	void deveriaEncontrarUsuarioCadastrado() {
		
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");

		em.persist(usuario);
		
		Usuario encontrado = this.dao.buscarPorUsername(usuario.getNome());

		Assert.assertNotNull(encontrado);
	}

	@Test
	void naoDeveriaEncontrarUsuarioCadastrado() {

		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("fulano"));
	}

	@Test
	void deveriaRemoverUsuario() {
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
		em.persist(usuario);
		this.dao.deletar(usuario);
		Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername(usuario.getNome()));
	}

}
