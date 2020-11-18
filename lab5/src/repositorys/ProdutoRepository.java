package repositorys;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import models.Produto;

/**
 * Repositório de Produto.
 * @author Paulo Hernane Fontes e Silva
 *
 */
public class ProdutoRepository {

	/**
	 * Mapa do HashCode de Nome e Descrição e seu respectivo Produto.
	 */
	private Map<Integer, Produto> produtos;
	
	/**
	 * Constrói o repositório de Produto.
	 */
	public ProdutoRepository() {
		this.produtos = new HashMap<Integer, Produto>();
	}

	//Create
	/**
	 * Cadastra um Produto.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param preco Preço do Produto.
	 */
	public void cadastraProduto(String nome, String descricao, Double preco) throws IllegalArgumentException {
		Produto novoProduto = new Produto(nome, descricao, preco);
		if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		} else if (preco == null || preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		} else if (this.produtos.containsKey(novoProduto.hashCode())) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		} else {
			
			this.produtos.put(novoProduto.hashCode(), novoProduto);
		}
	}
	
	//Read
	public String getInfoProduto(String nome, String descricao) throws IllegalArgumentException, NullPointerException {
		if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		} else if (!this.produtos.containsKey(nome.hashCode() + descricao.hashCode())) {
			throw new NullPointerException("Erro na exibicao de produto: produto nao existe.");
		}
		return this.produtos.get(nome.hashCode() + descricao.hashCode()).toString();
	}
	
	public Collection<Produto> getAllProdutos() {
		return this.produtos.values();
	}
	
	public boolean temProduto(String nome, String descricao) {
		if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro ao verificar existencia de Produto: nome nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(descricao)) {
			throw new IllegalArgumentException("Erro ao verificar existencia de Produto: descricao nao pode ser vazio ou nulo.");
		} else if (this.produtos.containsKey(nome.hashCode() + descricao.hashCode())) {
			return true;
		} 		
		return false;
	}
	
	//Update
	public void editaProduto(String nome, String descricao, Double novoPreco) {
		if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(descricao)) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		} else if (novoPreco == null || novoPreco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		} else if (!this.produtos.containsKey(nome.hashCode() + descricao.hashCode())) {
			throw new NullPointerException("Erro na edicao de produto: produto nao existe.");
		} 
		this.produtos.get(nome.hashCode() + descricao.hashCode()).setPreco(novoPreco);
	}
	
	//Delete
	public void removeProduto(String nome, String descricao) {
		if (!this.validaAtributo(nome)) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		} else if (!this.validaAtributo(descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		} else if (!this.produtos.containsKey(nome.hashCode() + descricao.hashCode())) {
			throw new NullPointerException("Erro na remocao de produto: produto nao existe.");
		}
		this.produtos.remove(nome.hashCode() + descricao.hashCode());
	}
	
	/**
	 * Valida o um Atributo.
	 * Um Atributo é valido se não for nulo ou vazio.
	 * @param atributo Atributo a ser validado.
	 * @return true se for valido, false se não.
	 */
	private boolean validaAtributo(String atributo) {
		return !(atributo == null || atributo.isBlank() || atributo.isEmpty());
	}
	
}
