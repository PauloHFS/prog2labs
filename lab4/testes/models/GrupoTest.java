package models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GrupoTest {

	private Grupo grupoTeste;
	
	@BeforeEach
	void criaGrupo() {
		this.grupoTeste = new Grupo("Grupo_de_Teste");
	}
	
	@Test
	@DisplayName("Alocar Aluno")
	void alocarAluno() {
		this.grupoTeste.alocarAluno(Integer.valueOf(119210311), new Aluno("Paulo", "Computação"));
	}

	@Test
	@DisplayName("Alocar Aluno Duplicado")
	void alunoDuplo() {
		this.grupoTeste.alocarAluno(Integer.valueOf(119210311), new Aluno("Paulo", "Computação"));
		this.grupoTeste.alocarAluno(Integer.valueOf(119210311), new Aluno("Paulo", "Computação"));
		assertEquals("Alunos no grupo Grupo_de_Teste:\n" + 
				"* 119210311 - Paulo - Computação\n", this.grupoTeste.toString());
	}
}
