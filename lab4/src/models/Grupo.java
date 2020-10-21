package models;

import models.Aluno;
import java.util.HashMap;
import java.util.Set;

/**
 * Representação de Grupo.
 * @author paulo
 *
 */
public class Grupo {
	
	/**
	 * Nome do Grupo.
	 */
	private String nome;
	
	/**
	 * Mapa que armazena Matricula/Aluno.
	 */
	private HashMap<Integer, Aluno> alunos;
	
	/**
	 * Constroi um novo grupo com base no seu nome.
	 * @param nome Nome do Grupo.
	 */
	public Grupo(String nome) {
		if (nome == null) {
			throw new NullPointerException("Nome não pode ser nulo.");
		} else {
			this.nome = nome;
			this.alunos = new HashMap<Integer, Aluno>();
		}
	}
	
	/**
	 * Aloca um novo aluno no Grupo.
	 * @param matricula Matricula do Aluno.
	 * @param alunoAlocado Aluno a ser alocado no Grupo.
	 */
	public void alocarAluno(int matricula, Aluno alunoAlocado) {
		if (alunoAlocado == null) {
			throw new NullPointerException("Aluno não pode ser nulo.");
		} else {
			this.alunos.put(matricula, alunoAlocado);			
		}
	}
	
	/**
	 * Retorna a representação em String do Grupo.
	 * @return a representação em String do Grupo.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String grupoString = "Alunos no grupo " + this.nome + ":\n";
		Set<Integer> matriculas = this.alunos.keySet();
		for (Integer matricula: matriculas) {
			grupoString += "* " + matricula + " - " + this.alunos.get(matricula) + "\n";
		}
		
		return grupoString;
		
	}
}
