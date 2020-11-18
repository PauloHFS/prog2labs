package models;

import java.util.ArrayList;
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
	
	private ProdutoController produtos;
	
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
		this.produtos = new ProdutoController();
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
	
	//ProdutoController
	/**
	 * Cadastra um novo Produto ao sistema.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param preco Preço do Produto.
	 */
	public void cadastraProduto(String nome, String descricao, Double preco) {
		this.produtos.cadastraProduto(nome, descricao, preco);
	}
	
	/**
	 * Retorna as Informações do Produto.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @return A representação em String do Produto.
	 */
	public String getInfoProduto(String nome, String descricao) {
		return this.produtos.getInfoProduto(nome, descricao);
	}
	
	/**
	 * Retorna a representação de String da lista ordenada de todos os Produtos cadastrados.
	 * @return Representação de String da lista com os Produtos cadastrados.
	 */
	public String getInfoAllProdutos() {
		List<Produto> produtos = new ArrayList<Produto>(this.produtos.getAllProdutos());
		String infoAllProdutos = "";
		if (produtos.size() != 0) {
			for (int i = 0; i < produtos.size(); i++) {
				infoAllProdutos += this.nome + " - " + produtos.get(i);				
				if (i != produtos.size()-1) {
					infoAllProdutos += " | ";			
				}
			}
		} else {
			return this.nome + " -";
		}
		return infoAllProdutos;	
	}
	
	/**
	 * Verifica se exite um Produto no Sistema com dado Nome e Descricao.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @return true se existir, false se não.
	 */
	public boolean temProduto(String nome, String descricao) {
		return this.produtos.temProduto(nome, descricao);
	}
	
	/**
	 * Altera o preço de um Produto.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param novoPreco Novo Preço do Produto.
	 */
	public void editaProduto(String nome, String descricao, Double novoPreco) {
		this.produtos.editaProduto(nome, descricao, novoPreco);
	}
	
	/**
	 * Remove um produto do Sistema.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 */
	public void removeProduto(String nome, String descricao) {
		this.produtos.removeProduto(nome, descricao);
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
