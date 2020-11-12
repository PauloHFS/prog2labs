package models;

import java.util.List;

import controllers.ProdutoController;

public class Fornecedor implements Comparable<Fornecedor> {
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
	
	private ProdutoController produtosController;
	
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
		this.produtosController = new ProdutoController();
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
	
	public void cadastraProduto(String nome, String descricao, Double preco) {
		this.produtosController.cadastraProduto(nome, descricao, preco);
	}
	
	public String getInfoProduto(String nome, String descricao) {
		return this.produtosController.getInfoProduto(nome, descricao);
	}
	
	public String getInfoAllProdutos() {
		List<Produto> produtos = this.produtosController.getAllProdutos();
		String infoAllProdutos = "";
		if (produtos.isEmpty()) {
			return this.nome + " -";
		}
		for (int i = 0; i < produtos.size(); i++) {
			infoAllProdutos += this.nome + " - " + produtos.get(i);
			if (i != produtos.size() - 1) {
				infoAllProdutos += " | ";
			}
		}
		return infoAllProdutos;
	}
	
	public void editaProduto(String nome, String descricao, Double novoPreco) {
		this.produtosController.editaProduto(nome, descricao, novoPreco);
	}
	
	public void removeProduto(String nome, String descricao) {
		this.produtosController.removeProduto(nome, descricao);
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

	@Override
	public int compareTo(Fornecedor o) {
		return this.nome.compareTo(o.nome);
	}
	
}
