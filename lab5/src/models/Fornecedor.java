package models;

public class Fornecedor {
	/**
	 * Nome do Fornecedor.
	 */
	private String nome;
	
	/**
	 * Email do Fornecedor.
	 */
	private String email;
	
	/**
	 * Telefone do Fornecedor.
	 */
	private String telefone;
	
	/**
	 * Contrói um Fornecedor com base em seus dados.
	 * @param nome Nome do Fornecedor.
	 * @param local Local do Fornecedor.
	 * @param email Email do Fornecedor.
	 * @param telefone Telefone do Fornecedor.
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	/**
	 * Altera o Email do Fornecedor.
	 * @param email Novo Email do Fornecedor.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Altera o Telefone do Fornecedor.
	 * @param telefone Telefone do Fornecedor.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * Gera o HashCode do Fornecedor.
	 * @return o HashCode do Fornecedor.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}
	
	/**
	 * Verifica se um Fornecedor é igual a outro Objeto.
	 * @return true se os Fornecedores tiverem o mesmo nome, false se não.
	 * @see java.lang.Object#equals(Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof Fornecedor)) {
			return false;
		}
		
		Fornecedor other = (Fornecedor) o;
		
		return this.nome == other.nome;
	}
	
	/**
	 * Retorna a representação em String do Fornecedor.
	 * @return a representação em String do Fornecedor.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}
	
}
