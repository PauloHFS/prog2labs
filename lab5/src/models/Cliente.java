package models;

/**
 * Representação de Cliente.
 * @author Paulo Hernane Fontes e Silva
 *
 */
public class Cliente {
	/**
	 * CPF do Cliente.
	 */
	private int cpf;
	
	/**
	 * Nome do Cliente.
	 */
	private String nome;
	
	/**
	 * Local de Trabalho do Cliente.
	 */
	private String localDeTrabalho;
	
	/**
	 * E-mail do Cliente.
	 */
	private String email;
	
	/**
	 * Constrói um Cliente com base em seus dados.
	 * @param cpf CPF do Cliente. 
	 * @param nome Nome do Cliente.
	 * @param localDeTrabalho Local de Trabalho do Cliente.
	 * @param email E-mail do Cliente.
	 */
	public Cliente(int cpf, String nome, String localDeTrabalho, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.localDeTrabalho = localDeTrabalho;
		this.email = email;
	}
	
	/**
	 * Altera o Nome do Cliente.
	 * @param nome Nome do Cliente.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Altera o Local de Trabalho do Cliente.
	 * @param localDeTrabalho Local de Trabalho do Cliente.
	 */
	public void setLocalDeTrabalho(String localDeTrabalho) {
		this.localDeTrabalho = localDeTrabalho;
	}
	
	/**
	 * Altera o E-mail do Cliente.
	 * @param email E-mail do Cliente.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gera o HashCode do Cliente.
	 * @return o HashCode do Cliente.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 31 * 7 + (int) this.cpf;
	}
	
	/**
	 * Verifica se um Cliente é igual a outro Objeto.
	 * @return true se os Clientes tiverem o mesmo CPF, false se não.
	 * @see java.lang.Object#equals(Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof Cliente)) {
			return false;
		}
		
		Cliente other = (Cliente) o;
		
		return this.cpf == other.cpf;
	}

	/**
	 * Retorna a representação em String do Cliente.
	 * @return a representação em String do Cliente.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.localDeTrabalho + " - " + this.email;
	}
}
