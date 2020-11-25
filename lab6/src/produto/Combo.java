package produto;

/**
 * Representação de um Combo de produtos.
 * Um Combo também é um Produto.
 * @author paulo
 *
 */
public class Combo extends Produto {
	
	/**
	 * Fator de desconto no preço total dos produtos.
	 */
	private double fator;

	/**
	 * Constroi um novo Combo de produtos.
	 * @param nome Nome do Combo.
	 * @param descricao Descrição do Combo.
	 * @param preco Preço do Combo.
	 * @param fator Fator de desconto do Combo.
	 */
	public Combo(String nome, String descricao, Double preco, Double fator) {
		super(nome, descricao, preco);
		this.fator = fator;
	}

	/**
	 * Retorna o Fator de desconto do Combo.
	 * @return o fator de desconto.
	 */
	public double getFator() {
		return fator;
	}
	
	/**
	 * Altera o Fator de desconto do Combo.
	 * @param fator Novo Fator de desconto.
	 */
	public void setFator(double fator) {
		this.fator = fator;
	}
}
