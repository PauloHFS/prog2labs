package models;

/**
 * Representação de Aluno.
 * @author paulo
 *
 */
public class Aluno {

	/**
	 * Nome do Aluno.
	 */
	private String nome;
	
	/**
	 * Curso do Aluno.
	 */
	private String curso;
	
	/**
	 * Constrói um Aluno a partir de seu nome e seu curso.
	 * @param nome Nome do Aluno.
	 * @param curso Curso do Aluno.
	 */
	public Aluno(String nome, String curso) {
		if (nome == null) {
			throw new NullPointerException("Nome não pode ser nulo.");
		} else if (curso == null) {
			throw new NullPointerException("Curso não pode ser nulo.");
		} else {			
			this.nome = nome;
			this.curso = curso;
		}
	}
	
	/**
	 * Gera o HashCode do Aluno.
	 * @return o HashCode do Aluno.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.nome.hashCode() + this.curso.hashCode();
	}
	
	/**
	 * Verifica se um Aluno é igual a outro Objeto.
	 * @return true se os alunos tiverem o mesmo nome e o mesmo curso, false se não.
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
		
		return this.nome == other.nome && this.curso == other.curso;
	}
	
	/**
	 * Retorna a representação em String do Aluno.
	 * @return a representação em String do Aluno.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.curso;
	}
}
