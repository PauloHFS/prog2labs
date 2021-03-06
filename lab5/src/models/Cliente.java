package models;

import controllers.ContaController;

/**
 * Representação de Cliente.
 * @author Paulo Hernane Fontes e Silva
 *
 */
public class Cliente implements Comparable<Cliente> {
	/**
	 * CPF do Cliente.
	 */
	private String cpf;
	
	/**
	 * Nome do Cliente.
	 */
	private String nome;
	
	/**
	 * Localização do Cliente.
	 */
	private String localizacao;
	
	/**
	 * E-mail do Cliente.
	 */
	private String email;
	
	private ContaController contas;
	
	/**
	 * Constrói um Cliente com base em seus dados.
	 * @param cpf CPF do Cliente. 
	 * @param nome Nome do Cliente.
	 * @param localizacao Localização do Cliente.
	 * @param email E-mail do Cliente.
	 */
	public Cliente(String cpf, String nome, String localizacao, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.localizacao = localizacao;
		this.email = email;
		this.contas = new ContaController();
	}
	
	/**
	 * Altera o Nome do Cliente.
	 * @param nome Nome do Cliente.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Altera a Localização do Cliente.
	 * @param localizacao Localizacao do Cliente.
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	/**
	 * Altera o E-mail do Cliente.
	 * @param email E-mail do Cliente.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	//ContaController
	public void adicionaConta(String fornecedor, String nome_prod, String data, Double preco) {
		this.contas.adicionaConta(fornecedor, nome_prod, data, preco);
	}
	
	public Double getDebito(String fornecedor) {
		return this.contas.getDebito(fornecedor);	
	}
	
	public String getInfoContaOfFornecedor(String fornecedor) {
		return "Cliente: " + this.nome + " | " + this.contas.getInfoContaOfFornecedor(fornecedor);
	}
	
	public String getInfoAllContasOfAllFornecedores() {
		return this.contas.getInfoAllContasOfAllFornecedores();
	}
	
	/**
	 * Gera o HashCode do Cliente.
	 * @return o HashCode do Cliente.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.cpf.hashCode();
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
		
		return this.cpf.equals(other.cpf);
	}

	/**
	 * Retorna a representação em String do Cliente.
	 * @return a representação em String do Cliente.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	@Override
	public int compareTo(Cliente o) {
		return this.nome.compareTo(o.nome);
	}
}
