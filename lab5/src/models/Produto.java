package models;

/**
 * Representação de Produto.
 * @author Paulo Hernane Fontes e Silva
 *
 */
public class Produto implements Comparable<Produto> {
	
	/**
	 * Nome do Produto.
	 */
	private String nome;
	
	/**
	 * Descrição do Produto.
	 */
	private String descricao;
	
	/**
	 * Preço do Produto.
	 */
	private Double preco;
	
	/**
	 * Constrói um Produto.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param preco Preço do Produto.
	 */
	public Produto(String nome, String descricao, Double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	/**
	 * Altera o Preço do Produto.
	 * @param preco Novo Preço do Produto.
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	/**
	 * Retorna o HashCode do Produto.
	 * @return O HashCode do Produto.
	 */
	@Override
	public int hashCode() {
		return this.nome.hashCode() + this.descricao.hashCode();
	}
	
	/**
	 * Verifica se o Produto é igual a outro Objeto.
	 * @return true se tiverem o Nome e a Descrição iguais, false se não.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (!(obj instanceof Produto)) {
			return false;
		}
		
		Produto other = (Produto) obj;
		
		return this.nome.equals(other.nome) && this.descricao.equals(other.descricao); 
		
	}
	
	/**
	 * Retorna a representação em String de Produto.
	 * @return a representação em String de Produto.
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + String.format("%,.2f", this.preco).replace('.', ',');
	}

	/**
	 * Compara esse Objeto com outro Objeto do tipo Produto.
	 * @return n < 0 se esse objeto for menor que o outro,
	 * 		   n = 0 se esse objeto for igual ao outro,
	 *         n > 0 se esse objeto for maior que o outro.
	 */
	@Override
	public int compareTo(Produto o) {
		return this.nome.compareTo(o.nome);
	}

}
