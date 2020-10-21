package repositorys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import models.Aluno;

class GrupoRepositoryTest {

	private GrupoRepository grupos;
	
	@BeforeEach
	void criaRepositorio() {
		this.grupos = new GrupoRepository();
	}
	
	@Test
	@DisplayName("Cadastrar Grupo")
	void cadastrarGrupo() {
		this.grupos.cadastrarGrupo("Grupo_de_Test");
	}
	
	@Test
	@DisplayName("Alocar Aluno")
	void alocarAluno() {
		this.grupos.cadastrarGrupo("Grupo_de_Test");
		this.grupos.alocarAluno("Grupo_de_Test", 119210311, new Aluno("Paulo", "Computação"));
	}
	
	@Test
	@DisplayName("Alocar Aluno Duplo")
	void alocarAlunoDuplo() {
		this.grupos.cadastrarGrupo("Grupo_de_Test");
		this.grupos.alocarAluno("Grupo_de_Test", 119210311, new Aluno("Paulo", "Computação"));
		this.grupos.alocarAluno("Grupo_de_Test", 119210311, new Aluno("Paulo", "Computação"));
		assertEquals("Alunos no grupo Grupo_de_Test:\n* 119210311 - Paulo - Computação\n", this.grupos.grupoToString("Grupo_de_Test"));
	}
}
