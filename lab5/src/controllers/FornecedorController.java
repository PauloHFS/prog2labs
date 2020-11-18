package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Fornecedor;
import repositorys.FornecedorRepository;

/**
 * Controller de Fornecedor.
 * @author Paulo Hernane Fontes e Silva
 *
 */
public class FornecedorController {

	/**
	 * Repositório dos Fornecedores.
	 * @see repositorys.FornecedorRepository
	 */
	private FornecedorRepository fornecedores;
	
	/**
	 * Constrói um Controller de Fornecedor.
	 */
	public FornecedorController() {
		this.fornecedores = new FornecedorRepository();
	}
	
	//Create
	/**
	 * Cadastra um novo Fornecedor no Sistema.
	 * @param nome Nome do Fornecedor.
	 * @param email Email do Fornecedor.
	 * @param telefone Telefone do Fornecedor.
	 * @return Nome do Fornecedor cadastrado.
	 * @see repositorys.FornecedorRepository#cadastraFornecedor(String, String, String)
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		return this.fornecedores.cadastraFornecedor(nome, email, telefone);
	}
	
	//Read
	/**
	 * Retorna as informações de Fornecedor com o nome desejado.
	 * @param nome Nome do Fornecedor.
	 * @return A representação em String do Fornecedor.
	 * @see repositorys.FornecedorRepository#getFornecedor(String)
	 * @see models.Fornecedor#toString()
	 */
	public String getInfoFornecedor(String nome) {
		return this.fornecedores.getFornecedor(nome).toString();
	}
	
	/**
	 * Retorna as informações de todos os Fornecedores cadastrados.
	 * @return A representação em String de todos os fornecedores.
	 */
	public String getInfoAllFornecedores() {
		String infoAllFornecedores = "";
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>(this.fornecedores.getAllFornecedores());
		Collections.sort(fornecedores);
		for (int i = 0; i < fornecedores.size(); i++) {
			infoAllFornecedores += fornecedores.get(i);
			if (i != fornecedores.size()-1) {
				infoAllFornecedores += " | ";
			}
		}
		return infoAllFornecedores;
	}
	
	/**
	 * Verifica se um Fornecedor de dado nome está cadastrado no sistema.
	 * @param nome Nome do Fornecedor.
	 * @return true se existe, false se não.
	 */
	public boolean temFornecedor(String nome) {
		return this.fornecedores.temFornecedor(nome);
	}
	
	//Update
	/**
	 * Altera algum atributo do Fornecedor com o Nome passado por parametro.
	 * @param nome Nome do Fornecedor
	 * @param atributo Atributo que deseja ser alterado.
	 * @param novoValor Novo valor para o atributo.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.fornecedores.editaFornecedor(nome, atributo, novoValor);
	}
	
	//Detele
	/**
	 * Remove o Fornecedor do Sistema.
	 * @param nome Nome do Fornecedor.
	 */
	public void removeFornecedor(String nome) {
		this.fornecedores.removeFornecedor(nome);
	}
	
	//ProdutoController
	/**
	 * Cadastra um novo Produto ao sistema.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param preco Preço do Produto.
	 */
	public void cadastraProduto(String fornecedor, String nome, String descricao, Double preco) {
		this.fornecedores.cadastraProduto(fornecedor, nome, descricao, preco);
	}
	
	/**
	 * Retorna as Informações do Produto.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @return A representação em String do Produto.
	 */
	public String getInfoProduto(String fornecedor, String nome, String descricao) {
		return this.fornecedores.getInfoProduto(fornecedor, nome, descricao);
	}
	
	public Double getPrecoProduto(String fornecedor, String nome, String descricao) {
		return this.fornecedores.getPrecoProduto(fornecedor, nome, descricao);
	}
	
	/**
	 * Retorna uma lista ordenada de todos os Produtos cadastrados.
	 * @return Lista com os Produtos cadastrados.
	 */
	public String getAllProdutos(String fornecedor) {
		return this.fornecedores.getAllProdutos(fornecedor);
	}
	
	/**
	 * Verifica se exite um Produto no Sistema com dado Nome e Descricao.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @return true se existir, false se não.
	 */
	public boolean temProduto(String fornecedor, String nome, String descricao) {
		return this.fornecedores.temProduto(fornecedor, nome, descricao);
	}
	
	/**
	 * Altera o preço de um Produto.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 * @param novoPreco Novo Preço do Produto.
	 */
	public void editaProduto(String fornecedor, String nome, String descricao, Double novoPreco) {
		this.fornecedores.editaProduto(fornecedor, nome, descricao, novoPreco);
	}
	
	/**
	 * Remove um produto do Sistema.
	 * @param nome Nome do Produto.
	 * @param descricao Descrição do Produto.
	 */
	public void removeProduto(String fornecedor, String nome, String descricao) {
		this.fornecedores.removeProduto(fornecedor, nome, descricao);
	}

	/**
	 * Retorna todas as informações de todos os Produtos de todos os Fornecedores.
	 * @return A representação em String de todos os produtos de todos os fornecedores.
	 */
	public String getInfoAllProdutosOfAllFornecedores() {
		return this.fornecedores.getInfoAllProdutosOfAllFornecedores();
	}
	
}
