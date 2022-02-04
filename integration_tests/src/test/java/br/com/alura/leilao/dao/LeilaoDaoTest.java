package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.time.LocalDate;

class LeilaoDaoTest {

	private LeilaoDao dao;
	private EntityManager em;

	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new LeilaoDao(em);
		this.em.getTransaction().begin();
	}

	@AfterEach
	public void afterEach() {
		this.em.getTransaction().rollback();
	}

	@Test
	void deveriaCadastrarUmLeilao() {
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
		Leilao leilao = new Leilao("Mochila", new BigDecimal("70"), LocalDate.now(), usuario);
		this.em.persist(usuario);
		leilao = dao.salvar(leilao);

		leilao.setNome("Celular");
		leilao.setValorInicial(new BigDecimal("400"));

		leilao = this.dao.salvar(leilao);

		Leilao salvo = this.dao.buscarPorId(leilao.getId());
		Assert.assertNotNull(salvo);
		Assert.assertEquals(new BigDecimal("400"), salvo.getValorInicial());
		Assert.assertEquals("Celular", salvo.getNome());
	}

}
