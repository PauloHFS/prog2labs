package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AgendaTest {

	private Agenda agenda;
	
	@BeforeEach
	void criaContato() {
		this.agenda = new Agenda();
		
		String[] numerosTelefone = {"12313213", "12312312"};
		this.agenda.cadastraContato(1, "Paulo", "Silva", numerosTelefone, 1, 2);
		this.agenda.cadastraContato(100, "Paulo", "Silva", numerosTelefone, 1, 2);
	}
	
	@Test
	@DisplayName("Get Contato na posicao 0")
	void testGetContatoLimiteInferiorFora() {
		try {
			this.agenda.getContato(0);
			fail("Era esperado exceção ao passar posição invalida");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	@Test
	@DisplayName("Get Contato na posicao 1")
	void testGetContatoLimiteInferiorDentro() {
		try {
			this.agenda.getContato(1);
		} catch (Exception e) {
			fail("Não era para acontecer um erro! - "+ e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Get Contato na posicao 100")
	void testGetContatoLimiteSuperiorDentro() {
		try {
			this.agenda.getContato(100);
		} catch (Exception e) {
			fail("Não era para acontecer um erro! - "+ e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Get Contato na posicao 101")
	void testGetContatoLimiteSuperiorFora() {
		try {
			this.agenda.getContato(101);
			fail("Era esperado exceção ao passar posição invalida");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	@Test
	@DisplayName("Get Contato")
	void testGetContato() {
		Contato contato = null;
		try {
			contato = this.agenda.getContato(1);
			String[] tel = {"12313"};
			assertEquals(new Contato("Paulo", "Silva", tel, 1, 1), contato);
		} catch (Exception e) {
			fail("Não era suposto ocorrer um erro! - "+ e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Cadastrar Contato na posição 0")
	void testCadastrarContatoLimiteInferiorFora() {
		try {
			String[] tel = {"12313"};
			this.agenda.cadastraContato(0, "Paulo", "Silva", tel, 1, 1);
			fail("Era esperado exceção ao passar posição invalida");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	@Test
	@DisplayName("Cadastrar Contato na posição 1")
	void testCadastrarContatoLimiteInferiorDentro() {
		try {
			String[] tel = {"12313"};
			this.agenda.cadastraContato(1, "Paulo", "Silva", tel, 1, 1);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Cadastrar Contato na posição 100")
	void testCadastrarContatoLimiteSuperiorDentro() {
		try {
			String[] tel = {"12313"};
			this.agenda.cadastraContato(100, "Paulo", "Silva", tel, 1, 1);
		} catch (Exception e) {
			fail(e.getMessage());
			
		}
	}
	
	@Test
	@DisplayName("Cadastrar Contato na posição 101")
	void testCadastrarContatoLimiteSuperiorFora() {
		try {
			String[] tel = {"12313"};
			this.agenda.cadastraContato(101, "Paulo", "Silva", tel, 1, 1);
			fail("Era esperado exceção ao passar posição invalida");
		} catch (Exception e) {
			System.err.println(e);
			
		}
	}
}
