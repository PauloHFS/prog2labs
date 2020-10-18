package repositorys;

import java.util.HashMap;
import models.Aluno;

public class AlunoRepository {
	
	/**
	 * 
	 */
	private HashMap<Integer, Aluno> mapaMatriculaAluno;
	
	/**
	 * 
	 */
	public AlunoRepository() {
		this.mapaMatriculaAluno = new HashMap<Integer, Aluno>();
	}
	
	/**
	 * 
	 * @param matricula
	 * @param nome
	 * @param curso
	 */
	public void cadastrarAluno(int matricula, String nome, String curso) {
		this.mapaMatriculaAluno.put(matricula, new Aluno(matricula, nome, curso));
	}
	
	/**
	 * 
	 * @param matricula
	 * @return
	 */
	public Aluno getAluno(int matricula) {
		return this.mapaMatriculaAluno.get(matricula);
	}
}
