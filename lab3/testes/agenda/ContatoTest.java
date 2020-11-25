package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContatoTest {
	
	private Contato contatoBasico;
	
	@BeforeEach
	void criaContato() {
		String[] telefones = {"928376518", "172736456"};
		contatoBasico = new Contato("Paulo", "Silva", telefones, 1, 2);
	}
	
	@Test
	@DisplayName("Método equals()")
	void testEquals() {
		String[] telefones = {"97123566", "1234567890", "0987654321"};
		String[] telefones2 = {"0987654324", "1234567890", "5432167890"};

		Contato a = new Contato("Paulo", "Silva", telefones, 3, 2);
		Contato b = new Contato("Paulo", "Silva", telefones2, 2, 1);
		
		/*
		 * Testa se é reflexivo.
		 */
		assertTrue(this.contatoBasico.equals(this.contatoBasico));
		
		/*
		 * Testa se é simétrico.
		 */
		assertTrue(this.contatoBasico.equals(a));
		assertTrue(a.equals(this.contatoBasico));
		
		/*
		 * Testa se é transitivo.
		 */
		if (b.equals(a) && a.equals(this.contatoBasico)) {
			assertTrue(b.equals(this.contatoBasico));
		}
		
		/**
		 * Testa se é consistente.
		 */
		assertTrue(a.equals(b));
		assertTrue(a.equals(b));
		assertTrue(a.equals(b));
		assertTrue(a.equals(b));
		
		/**
		 * Testa para null.
		 */
		assertFalse(this.contatoBasico.equals(null));
	}

	@Test
	@DisplayName("Nome Nulo Exceção")
	void testNomeNull() {
		String[] tel = {"123123123"};
		try {
			@SuppressWarnings("unused")
			Contato contatoInvalido = new Contato(null, "Gaudencio", tel, 1, 1);
			fail("Era esperado exceção ao passar código nulo");
		} catch (NullPointerException npe) {
			System.err.println(npe);
		}	
	}
	
	@Test
	@DisplayName("Sobrenome Nulo Exceção")
	void testSobrenomeNulo() {
		String[] tel = {"123123123"};
		try {
			@SuppressWarnings("unused")
			Contato contatoInvalido = new Contato("Paulo", null, tel, 1, 1);
			fail("Era esperado exceção ao passar código nulo");
		} catch (NullPointerException npe) {
			System.err.println(npe);
		}	
	}
	
	@Test
	@DisplayName("Telefones Nulos Exceção")
	void testTelefonesNulo() {
		try {
			@SuppressWarnings("unused")
			Contato contatoInvalido = new Contato("Paulo", "Silva", null, 1, 1);
			fail("Era esperado exceção ao passar código nulo");
		} catch (NullPointerException npe) {
			System.err.println(npe);
		}	
	}
	
	@Test
	@DisplayName("Nome Vazio Exceção")
	void testNomeVazio() {
		String[] tel = {"123123123"};
		try {
			@SuppressWarnings("unused")
			Contato contatoInvalido = new Contato("", "Silva", tel, 1, 1);
			fail("Era esperado exceção ao passar código nulo");
		} catch (IllegalArgumentException iae) {
			System.err.println(iae);
		}	
	}
	
	@Test
	@DisplayName("Nome Vazio Exceção")
	void testSobrenomeVazio() {
		String[] tel = {"123123123"};
		try {
			@SuppressWarnings("unused")
			Contato contatoInvalido = new Contato("Paulo", "", tel, 1, 1);
			fail("Era esperado exceção ao passar código nulo");
		} catch (IllegalArgumentException iae) {
			System.err.println(iae);
		}	
	}
	
}
