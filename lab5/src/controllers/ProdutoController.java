package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Produto;
import repositorys.ProdutoRepository;

/**
 * Controller de Produto.
 * @author Paulo Hernane Fontes e Silva.
 *
 */
public class ProdutoController {
	
	/**
	 * Repositório de Profutos.
	 */
	private ProdutoRepository produtosRepo;
	
	/**
	 * Contrói um Controller dos Produtos.
	 */
	public ProdutoController() {
		this.produtosRepo = new ProdutoRepository();
	}
	
	//Create
	/**
	 * Cadastra um novo Produto ao sistema.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param preco Preço do Produto.
	 */
	public void cadastraProduto(String nome, String descricao, Double preco) {
		this.produtosRepo.cadastraProduto(nome, descricao, preco);
	}
	
	//Read
	/**
	 * Retorna as Informações do Produto.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @return A representação em String do Produto.
	 */
	public String getInfoProduto(String nome, String descricao) {
		return this.produtosRepo.getInfoProduto(nome, descricao);
	}

	/**
	 * Retorna uma lista ordenada de todos os Produtos cadastrados.
	 * @return Lista com os Produtos cadastrados.
	 */
	public List<Produto> getAllProdutos() {
		List<Produto> produtos = new ArrayList<Produto>(this.produtosRepo.getAllProdutos());
		Collections.sort(produtos);
		return produtos;
	}
	
	public Double getPrecoProduto(String nome, String descricao) {
		return this.produtosRepo.getPrecoProduto(nome, descricao);
	}
	
	/**
	 * Verifica se exite um Produto no Sistema com dado Nome e Descricao.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @return true se existir, false se não.
	 */
	public boolean temProduto(String nome, String descricao) {
		return this.produtosRepo.temProduto(nome, descricao);
	}
	
	//Update
	/**
	 * Altera o preço de um Produto.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param novoPreco Novo Preço do Produto.
	 */
	public void editaProduto(String nome, String descricao, Double novoPreco) {
		this.produtosRepo.editaProduto(nome, descricao, novoPreco);
	}
	
	//Delete
	/**
	 * Remove um produto do Sistema.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 */
	public void removeProduto(String nome, String descricao) {
		this.produtosRepo.removeProduto(nome, descricao);
	}

}
