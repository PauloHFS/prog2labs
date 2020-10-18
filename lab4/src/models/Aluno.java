package models;

/**
 * Representação de Aluno.
 * 
 * @author Paulo Hernane Fontes e Silva
 */
public class Aluno {
	/**
	 * Matricula do Aluno.
	 */
	private int matricula;
	
	/**
	 * Nome do Aluno.
	 */
	private String nome;
	
	/**
	 * Curso do Aluno.
	 */
	private String curso;
	
	/**
	 * Constrói um novo Aluno.
	 * @param matricula Matricula do Aluno.
	 * @param nome Nome do Aluno.
	 * @param curso Curso do Aluno.
	 */
	public Aluno(int matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * Verifica se os Objetos são iguais.
	 * @param o Objeto a ser verificado igualdade.
	 * @return true se esse objeto possuir a mesma {@link #matricula} que outro objeto.
	 * @see java.lang.Object#equals(Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof Aluno)) {
			return false;
		}
		
		Aluno other = (Aluno) o;
		
		return this.matricula == other.matricula;
	}
	
	/**
	 * Gera o HashCode do Aluno.
	 * @return hashCode do Aluno.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = this.matricula;
		return hashCode;
	}
	
}
